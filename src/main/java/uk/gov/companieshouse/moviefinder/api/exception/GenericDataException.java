package uk.gov.companieshouse.moviefinder.api.exception;

public class GenericDataException extends RuntimeException {

    public GenericDataException(Exception e) {
        super(e);
    }
}
