package uk.gov.companieshouse.moviefinder.api.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import uk.gov.companieshouse.moviefinder.api.exception.DataNotFoundException;
import uk.gov.companieshouse.moviefinder.api.exception.GenericDataException;

@Component
public class JsonFileDeserializer {

    private static final Logger logger = LogManager.getLogger(JsonFileDeserializer.class);

    /**
     * Deserialize a file of a provided {@code fileName} to a class of a given {@code type}
     *
     * @param fileName The name of the file to be deserialized
     * @param type The type of object to return
     * @return an object of a given {@code type} containing data from a file of the {@code fileName} provided
     */
    public <T> T deserializeFileToObject(String fileName, Class<T> type) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            File file = new File(fileName);
            return mapper.readValue(file, type);

        } catch (FileNotFoundException e) {

            logger.error("The file with the following name: '" + fileName + "' could not be sourced!");
            throw new DataNotFoundException(e);
        } catch (IOException e) {

            logger.error("An exception has occurred while deserializing file '" + fileName + "' to an object of type " + type.toString());
            throw new GenericDataException(e);
        }
    }
}
