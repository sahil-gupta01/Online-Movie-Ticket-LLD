package com.bookMyShow.demo.services;

import com.bookMyShow.demo.dtos.BookingRequestDto;
import com.bookMyShow.demo.exceptions.SeatNotAvailable;
import com.bookMyShow.demo.exceptions.ShowNotValidException;
import com.bookMyShow.demo.exceptions.UserNotValidException;
import com.bookMyShow.demo.models.*;
import com.bookMyShow.demo.repository.BookingRepository;
import com.bookMyShow.demo.repository.ShowRepository;
import com.bookMyShow.demo.repository.ShowSeatRepository;
import com.bookMyShow.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    public Booking bookShow(BookingRequestDto request) throws UserNotValidException, ShowNotValidException, SeatNotAvailable {
        Optional<User> user = userRepository.findById(request.getUserId());
        if(!user.isPresent()){
            throw new UserNotValidException();
        }

        Optional<Show> show = showRepository.findById(request.getShowId());
        if(!show.isPresent()){
            throw new ShowNotValidException();
        }

        List<ShowSeat> showSeatList = reserveShowSeats(request.getShowSeatIds());

        return reserveBooking(request, user, showSeatList);
    }

    private Booking reserveBooking(BookingRequestDto request, Optional<User> user, List<ShowSeat> showSeatList) {
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPayments(new ArrayList<>());
        booking.setAmount(calculateAmount(request.getShowId(), request.getShowSeatIds()));
        booking.setUser(user.get());
        booking.setShowSeatList(showSeatList);

        bookingRepository.save(booking);
        return new Booking();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> reserveShowSeats(List<Long> showSeatIds) throws SeatNotAvailable {
        List<ShowSeat> showSeatList = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeatList){
            if(seatNotAvailableForBooking(showSeat)){
                throw new SeatNotAvailable();
            }
        }
        List<ShowSeat> reservedSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeatList){
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            reservedSeats.add(showSeatRepository.save(showSeat));
        }
        return reservedSeats;
    }

    private boolean seatNotAvailableForBooking(ShowSeat showSeat) {
        return !ShowSeatStatus.AVAILABLE.equals(showSeat.getStatus()) ||
                (ShowSeatStatus.LOCKED.equals(showSeat.getStatus())
                        && Duration.between(showSeat.getLockedAt().toInstant(), new Date().toInstant()).toMinutes() < 10);
    }

    private int calculateAmount(Long showId, List<Long> showSeatIds) {
        /*
            find the show
            find all the seat
            for seat ids find the seat type
            for the pair(showId, seatType) -> calc Amount
            sum it for all the seats

         */

        return 0;
    }
}
