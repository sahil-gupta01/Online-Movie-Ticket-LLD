package com.bookMyShow.demo.services;

import com.bookMyShow.demo.dtos.UserSingUpRequestDto;
import com.bookMyShow.demo.models.User;
import com.bookMyShow.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User signUP(UserSingUpRequestDto request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isPresent()){
            throw new RuntimeException();
        }

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        String password = request.getPassword();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(password));

        return userRepository.save(newUser);
    }

    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()){
            throw new RuntimeException();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, user.get().getPassword());
    }
}
