package com.bookMyShow.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class BookingResponseDto {
    private Long bookingId;
    private int amount;
    private ResponseStatus responseStatus;
    private String message;
}
