package uk.gov.companieshouse.moviefinder.api.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.companieshouse.moviefinder.api.dao.MovieDao;
import uk.gov.companieshouse.moviefinder.api.model.Comment;
import uk.gov.companieshouse.moviefinder.api.model.Movies;
import uk.gov.companieshouse.moviefinder.api.model.User;
import uk.gov.companieshouse.moviefinder.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MovieDao movieDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserWithMostComments() {

        Map<String, List<Comment>> commentsGroupedByUser = getCommentsGroupedByUser(movieDao.getMovies());

        String userName = Collections.max(
                commentsGroupedByUser.entrySet(),
                Comparator.comparingInt(entry -> entry.getValue().size()))
                .getKey();

        int totalNumberOfComments = commentsGroupedByUser.get(userName).size();

        return new User(userName, totalNumberOfComments);
    }

    /**
     * Collects {@link Comment} data from a provided {@link Movies} object and collates it into a {@link Map}
     * of users and their comments.
     *
     * @param movies The movies from which to collate users' comments
     * @return a map keyed by users with a list of their comments
     */
    private Map<String, List<Comment>> getCommentsGroupedByUser(Movies movies) {

        return movies.getMovieList()
                .stream()
                .flatMap(movie -> movie.getComments().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Comment::getUser));
    }
}
