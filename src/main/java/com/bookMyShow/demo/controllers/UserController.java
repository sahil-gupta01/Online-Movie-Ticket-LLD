package com.bookMyShow.demo.controllers;

import com.bookMyShow.demo.dtos.ResponseStatus;
import com.bookMyShow.demo.dtos.UserSignUpResponseDto;
import com.bookMyShow.demo.dtos.UserSingUpRequestDto;
import com.bookMyShow.demo.models.User;
import com.bookMyShow.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserSignUpResponseDto signUp(UserSingUpRequestDto request){
        User user = userService.signUP(request);
        return new UserSignUpResponseDto(user.getId(), ResponseStatus.SUCCESS);
    }

    public boolean login(String email, String password){
        return userService.login(email, password);
    }
}
