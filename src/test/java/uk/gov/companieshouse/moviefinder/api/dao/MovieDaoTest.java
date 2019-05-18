package uk.gov.companieshouse.moviefinder.api.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import uk.gov.companieshouse.moviefinder.api.deserialize.JsonFileDeserializer;
import uk.gov.companieshouse.moviefinder.api.model.Movies;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovieDaoTest {

    @Mock
    private JsonFileDeserializer jsonFileDeserializer;

    @InjectMocks
    private MovieDao movieDao;

    @Mock
    private Movies movies;

    private static final String MOVIES_FILE_PATH = "movies.json";

    @Test
    @DisplayName("Get movies - no movies data cached")
    void getMoviesNoDataCached() {

        ReflectionTestUtils.setField(movieDao,"cachedMovies", null);

        when(jsonFileDeserializer.deserializeFileToObject(MOVIES_FILE_PATH, Movies.class))
                .thenReturn(movies);

        Movies returnedMovies = movieDao.getMovies();

        assertEquals(movies, returnedMovies);
    }

    @Test
    @DisplayName("Get movies - returns cached movies data")
    void getMoviesReturnsCachedData() {

        ReflectionTestUtils.setField(movieDao,"cachedMovies", movies);

        Movies returnedMovies = movieDao.getMovies();

        assertEquals(movies, returnedMovies);
        verify(jsonFileDeserializer, never()).deserializeFileToObject(MOVIES_FILE_PATH, Movies.class);
    }
}
