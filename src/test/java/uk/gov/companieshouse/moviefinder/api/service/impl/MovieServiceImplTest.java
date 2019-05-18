package uk.gov.companieshouse.moviefinder.api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.companieshouse.moviefinder.api.dao.MovieDao;
import uk.gov.companieshouse.moviefinder.api.model.Movie;
import uk.gov.companieshouse.moviefinder.api.model.Movies;
import uk.gov.companieshouse.moviefinder.api.service.MovieService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieServiceImplTest {

    @Mock
    private MovieDao movieDao;

    @InjectMocks
    private MovieService movieService = new MovieServiceImpl();

    @Mock
    private Movies movies;

    @BeforeEach
    void setUp() {

        when(movieDao.getMovies()).thenReturn(movies);
    }

    @Test
    @DisplayName("Get all movies")
    void getAllMovies() {

        Movies returnedMovies = movieService.getFullMovieList();

        assertEquals(movies, returnedMovies);
    }

    @Test
    @DisplayName("Get the movie with the most likes")
    void getMovieWithMostLikes() {

        Movie movieOne = new Movie();
        movieOne.setLikes(3);

        Movie movieTwo = new Movie();
        movieTwo.setLikes(2);

        Movie movieThree = new Movie();
        movieThree.setLikes(1);

        List<Movie> movieList = Arrays.asList(movieOne, movieTwo, movieThree);

        when(movies.getMovieList()).thenReturn(movieList);

        assertEquals(movieOne, movieService.getMovieWithMostLikes());
    }
}
