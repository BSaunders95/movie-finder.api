# Movie Finder API
An application to source movie data from a 'movies.json' file.

## Requirements
In order to run the API locally you'll need the following installed on your machine:

- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Getting started

### Building the app
To compile the application without executing unit tests, simply run `make` at the root of the 
application directory.

To clean out the workspace, removing the compiled jar file and '/target' directory, run `make clean` 
at the root of the application directory.

To execute unit tests, run `make test` at the root of the application directory.

### Starting the app
Once built, execute the `start.sh` script to run the application. The application will boot at port 8080.

## Making requests
Once started, the app will be listening on port 8080.

To request all movies, curl `http://localhost:8080/movies`.

To retrieve the movie with the most likes, curl `http://localhost:8080/movies/most-likes`.

To find the user with the most comments, curl `http://localhost:8080/users/most-comments`.

#### Please note
This application is designed to run with the provided `movies.json` file at the root of the
app directory. If the file is moved, all requests will yield a 'Not found' response.