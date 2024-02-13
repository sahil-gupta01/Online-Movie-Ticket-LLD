package com.bookMyShow.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    //1 show has 1 movie
    // n show <- 1 movie
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
}
