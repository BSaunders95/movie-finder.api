package uk.gov.companieshouse.moviefinder.api.service;

import uk.gov.companieshouse.moviefinder.api.model.Movie;
import uk.gov.companieshouse.moviefinder.api.model.Movies;

public interface MovieService {

    /**
     * Fetches all movies
     *
     * @return a {@link Movies} resource containing a full list of movies
     */
    Movies getFullMovieList();

    /**
     * Fetches the movie with the most likes
     *
     * @return the {@link Movie} with the most likes
     */
    Movie getMovieWithMostLikes();
}
