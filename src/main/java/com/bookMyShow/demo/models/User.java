package com.bookMyShow.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    @OneToMany
    private List<Booking> bookings;
}
