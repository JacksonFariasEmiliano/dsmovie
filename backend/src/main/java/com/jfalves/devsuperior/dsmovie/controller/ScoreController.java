package com.jfalves.devsuperior.dsmovie.controller;

import com.jfalves.devsuperior.dsmovie.entity.dto.MovieDTO;
import com.jfalves.devsuperior.dsmovie.entity.dto.ScoreDTO;
import com.jfalves.devsuperior.dsmovie.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/scores")
public class ScoreController {

    private final ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){

        MovieDTO movieDTO = service.saveScore(dto);

        return movieDTO;
    }
}
