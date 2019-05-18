package uk.gov.companieshouse.moviefinder.api.exception;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(Exception e) {
        super(e);
    }
}
