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
import uk.gov.companieshouse.moviefinder.api.model.User;
import uk.gov.companieshouse.moviefinder.api.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/most-comments")
    public ResponseEntity<User> getUserWithMostComments() {

        logger.info("Fetching user with the most comments");
        return new ResponseEntity<>(userService.getUserWithMostComments(), HttpStatus.OK);
    }
}
