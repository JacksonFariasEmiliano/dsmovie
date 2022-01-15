package com.jfalves.devsuperior.dsmovie.controller;

import com.jfalves.devsuperior.dsmovie.entity.Movie;
import com.jfalves.devsuperior.dsmovie.entity.dto.MovieDTO;
import com.jfalves.devsuperior.dsmovie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable){
       return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public MovieDTO fidById(@PathVariable Long id){
        return service.findById(id);
    }
}
