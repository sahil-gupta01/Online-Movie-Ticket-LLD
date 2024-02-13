package com.bookMyShow.demo.repository;

import com.bookMyShow.demo.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
