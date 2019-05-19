package uk.gov.companieshouse.moviefinder.api.service.impl;

import java.util.Collections;
import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.companieshouse.moviefinder.api.dao.MovieDao;
import uk.gov.companieshouse.moviefinder.api.model.Movie;
import uk.gov.companieshouse.moviefinder.api.model.Movies;
import uk.gov.companieshouse.moviefinder.api.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public Movies getFullMovieList() {

        return movieDao.getMovies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Movie getMovieWithMostLikes() {

        Movies movies = movieDao.getMovies();

        return Collections.max(
                movies.getMovieList(),
                Comparator.comparingInt(Movie::getLikes));
    }
}
