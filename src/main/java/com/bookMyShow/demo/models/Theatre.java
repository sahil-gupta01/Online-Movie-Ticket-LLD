package com.bookMyShow.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    //1 th -> m screens
    //i th <- 1 screen

    @OneToMany
    private List<Screen> screens;
}
