package com.bookMyShow.demo.repository;

import com.bookMyShow.demo.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
