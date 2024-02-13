package com.bookMyShow.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSingUpRequestDto {
    private String email;
    private String password;
    private String name;
}
