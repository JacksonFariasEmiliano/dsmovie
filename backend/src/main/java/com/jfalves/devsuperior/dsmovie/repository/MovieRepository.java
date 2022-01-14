package com.jfalves.devsuperior.dsmovie.repository;

import com.jfalves.devsuperior.dsmovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
