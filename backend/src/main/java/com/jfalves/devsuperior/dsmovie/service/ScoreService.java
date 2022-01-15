package com.jfalves.devsuperior.dsmovie.service;

import com.jfalves.devsuperior.dsmovie.entity.Movie;
import com.jfalves.devsuperior.dsmovie.entity.Score;
import com.jfalves.devsuperior.dsmovie.entity.User;
import com.jfalves.devsuperior.dsmovie.entity.dto.MovieDTO;
import com.jfalves.devsuperior.dsmovie.entity.dto.ScoreDTO;
import com.jfalves.devsuperior.dsmovie.repository.MovieRepository;
import com.jfalves.devsuperior.dsmovie.repository.ScoreRepository;
import com.jfalves.devsuperior.dsmovie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final MovieRepository movieRepository;

    private final UserRepository userRepository;

    private final ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()){
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
