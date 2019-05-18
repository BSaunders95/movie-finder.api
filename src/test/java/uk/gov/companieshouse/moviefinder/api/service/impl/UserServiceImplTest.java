package uk.gov.companieshouse.moviefinder.api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.companieshouse.moviefinder.api.dao.MovieDao;
import uk.gov.companieshouse.moviefinder.api.model.Comment;
import uk.gov.companieshouse.moviefinder.api.model.Movie;
import uk.gov.companieshouse.moviefinder.api.model.Movies;
import uk.gov.companieshouse.moviefinder.api.model.User;
import uk.gov.companieshouse.moviefinder.api.service.UserService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    @Mock
    private MovieDao movieDao;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private Movies movies;

    private static final String USER_NAME_ONE = "userNameOne";
    private static final String USER_NAME_TWO = "userNameTwo";
    private static final String USER_NAME_THREE = "userNameThree";

    @Test
    @DisplayName("Get the user with the most comments")
    void getUserWithMostComments() {

        when(movieDao.getMovies()).thenReturn(movies);

        Movie movieOne = new Movie();
        movieOne.setComments(createListOfComments(USER_NAME_ONE, USER_NAME_TWO, USER_NAME_THREE));

        Movie movieTwo = new Movie();
        movieTwo.setComments(createListOfComments(USER_NAME_ONE, USER_NAME_TWO));

        Movie movieThree = new Movie();
        movieThree.setComments(createListOfComments(USER_NAME_ONE));

        List<Movie> movieList = Arrays.asList(movieOne, movieTwo, movieThree);

        when(movies.getMovieList()).thenReturn(movieList);

        User user = userService.getUserWithMostComments();

        assertEquals(USER_NAME_ONE, user.getUserName());
        assertEquals(3, user.getTotalNumberOfComments());
    }

    /**
     * Creates a {@link List} of {@link Comment}'s, with a comment for each user in {@code userNames}
     *
     * @param userNames An array of user names for which to add a comment to the comment list
     * @return a {@link List} of {@link Comment}'s, with a comment for each user in {@code userNames}
     */
    private List<Comment> createListOfComments(String... userNames) {

        List<Comment> commentList = new ArrayList<>();

        for (String userName : userNames) {
            Comment comment = new Comment();
            comment.setUser(userName);
            commentList.add(comment);
        }

        return commentList;
    }
}
