package uk.gov.companieshouse.moviefinder.api.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.gov.companieshouse.moviefinder.api.deserialize.JsonFileDeserializer;
import uk.gov.companieshouse.moviefinder.api.model.Movies;

@Component
public class MovieDao {

    private static final Logger logger = LogManager.getLogger(MovieDao.class);

    private static final String MOVIES_FILE_PATH = "movies.json";

    @Autowired
    private JsonFileDeserializer jsonFileDeserializer;

    private Movies cachedMovies;

    /**
     * Fetches details of all movies listed in the 'movies.json' file.
     *
     * On first execution, no movie data will be cached so the file will be read and cached. Thereafter,
     * a cached {@link Movies} instance will be returned.
     *
     * @return details of {@link Movies} listed in the 'movies.json' file
     */
    public Movies getMovies() {

        if (cachedMovies != null) {

            logger.info("Fetching cached movie data");
            return cachedMovies;
        }

        logger.info("No movie data cached; fetching data from movies.json file");

        cachedMovies = jsonFileDeserializer.deserializeFileToObject(MOVIES_FILE_PATH, Movies.class);

        return cachedMovies;
    }
}
