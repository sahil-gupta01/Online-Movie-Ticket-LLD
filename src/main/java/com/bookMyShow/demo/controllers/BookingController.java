package com.bookMyShow.demo.controllers;

import com.bookMyShow.demo.dtos.BookingRequestDto;
import com.bookMyShow.demo.dtos.BookingResponseDto;
import com.bookMyShow.demo.dtos.ResponseStatus;
import com.bookMyShow.demo.exceptions.SeatNotAvailable;
import com.bookMyShow.demo.exceptions.ShowNotValidException;
import com.bookMyShow.demo.exceptions.UserNotValidException;
import com.bookMyShow.demo.models.Booking;
import com.bookMyShow.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    private static final String INVALID_USER = "User is not valid";
    private static final String SUCCESS_BOOKING = "Booked successfully";
    private static final String INVALID_SHOW = "Show is not valid";
    private static final String INVALID_SEAT = "Something went wrong";
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingResponseDto bookShow(BookingRequestDto request){
        try {
            Booking booking = bookingService.bookShow(request);
            return new BookingResponseDto(booking.getId(), booking.getAmount(), ResponseStatus.SUCCESS, SUCCESS_BOOKING);
        } catch (UserNotValidException e) {
            return new BookingResponseDto(null, 0, ResponseStatus.FAILURE, INVALID_USER);
        } catch (ShowNotValidException e) {
            return new BookingResponseDto(null, 0, ResponseStatus.FAILURE, INVALID_SHOW);
        } catch (SeatNotAvailable e) {
            return new BookingResponseDto(null, 0, ResponseStatus.FAILURE, INVALID_SEAT);
        }
    }
}
