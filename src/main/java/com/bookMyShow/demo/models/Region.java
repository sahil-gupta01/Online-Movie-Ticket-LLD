package com.bookMyShow.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String name;
    //1 r -> n t
    // 1r  <- 1 t
    //1:m
    @OneToMany
    private List<Theatre> theatres;
}
