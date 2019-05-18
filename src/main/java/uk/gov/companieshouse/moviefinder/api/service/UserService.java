package uk.gov.companieshouse.moviefinder.api.service;

import uk.gov.companieshouse.moviefinder.api.model.User;

public interface UserService {

    /**
     * Fetches the user with the most comments
     *
     * @return the {@link User} with most comments
     */
    User getUserWithMostComments();
}
