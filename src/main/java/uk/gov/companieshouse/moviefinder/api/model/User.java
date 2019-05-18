package uk.gov.companieshouse.moviefinder.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    public User(String userName, int totalNumberOfComments) {
        this.userName = userName;
        this.totalNumberOfComments = totalNumberOfComments;
    }

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("total_number_of_comments")
    private int totalNumberOfComments;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalNumberOfComments() {
        return totalNumberOfComments;
    }

    public void setTotalNumberOfComments(int totalNumberOfComments) {
        this.totalNumberOfComments = totalNumberOfComments;
    }
}
