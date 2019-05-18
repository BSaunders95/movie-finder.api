package uk.gov.companieshouse.moviefinder.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.companieshouse.moviefinder.api.model.Movie;
import uk.gov.companieshouse.moviefinder.api.model.Movies;
import uk.gov.companieshouse.moviefinder.api.service.MovieService;

@RestController
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private static final Logger logger = LogManager.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Movies> getFullMovieList() {

        logger.info("Fetching all movies");
        return new ResponseEntity<>(movieService.getFullMovieList(), HttpStatus.OK);
    }

    @GetMapping("/most-likes")
    public ResponseEntity<Movie> getMovieWithMostLikes() {

        logger.info("Fetching the movie with the highest total number of likes");
        return new ResponseEntity<>(movieService.getMovieWithMostLikes(), HttpStatus.OK);
    }
}
