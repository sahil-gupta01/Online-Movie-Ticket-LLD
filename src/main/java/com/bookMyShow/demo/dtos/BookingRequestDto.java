package com.bookMyShow.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDto {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}
