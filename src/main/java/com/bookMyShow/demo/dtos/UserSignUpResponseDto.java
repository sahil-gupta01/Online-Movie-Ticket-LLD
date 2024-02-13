package com.bookMyShow.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserSignUpResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
