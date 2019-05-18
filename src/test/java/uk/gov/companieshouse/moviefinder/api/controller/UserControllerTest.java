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
import uk.gov.companieshouse.moviefinder.api.model.User;
import uk.gov.companieshouse.moviefinder.api.service.UserService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Mock
    private User user;

    @Test
    @DisplayName("Get the user with the most comments")
    void getUserWithMostComments() {

        when(userService.getUserWithMostComments()).thenReturn(user);

        ResponseEntity<User> response = userController.getUserWithMostComments();

        assertEquals(user, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
