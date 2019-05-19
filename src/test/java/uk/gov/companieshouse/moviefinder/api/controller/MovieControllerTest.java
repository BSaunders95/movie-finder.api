package uk.gov.companieshouse.moviefinder.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uk.gov.companieshouse.moviefinder.api.model.Movie;
import uk.gov.companieshouse.moviefinder.api.model.Movies;
import uk.gov.companieshouse.moviefinder.api.service.MovieService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @Mock
    private Movies movies;

    @Mock
    private Movie movie;

    @Test
    @DisplayName("Get full movies list")
    void getFullMovieList() {

        when(movieService.getFullMovieList()).thenReturn(movies);

        ResponseEntity<Movies> response = movieController.getFullMovieList();

        assertEquals(movies, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Get the movie with the most likes")
    void getMovieWithMostLikes() {

        when(movieService.getMovieWithMostLikes()).thenReturn(movie);

        ResponseEntity<Movie> response = movieController.getMovieWithMostLikes();

        assertEquals(movie, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
