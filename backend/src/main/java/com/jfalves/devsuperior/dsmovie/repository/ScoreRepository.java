package com.jfalves.devsuperior.dsmovie.repository;

import com.jfalves.devsuperior.dsmovie.entity.Score;
import com.jfalves.devsuperior.dsmovie.entity.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
