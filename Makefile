.PHONY: all
all: build

.PHONY: clean
clean:
	mvn clean
	rm -f ./movie-finder.api.jar

.PHONY: test
test:
	mvn test

.PHONY: build
build:
	mvn package -DskipTests=true
	cp ./target/movie-finder.api-0.0.1-SNAPSHOT.jar ./movie-finder.api.jar