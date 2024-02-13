package com.bookMyShow.demo.repository;

import com.bookMyShow.demo.models.ShowSeat;
import com.bookMyShow.demo.models.ShowSeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
}
