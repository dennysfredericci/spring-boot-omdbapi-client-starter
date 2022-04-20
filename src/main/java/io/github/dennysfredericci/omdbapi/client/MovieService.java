package io.github.dennysfredericci.omdbapi.client;

public class MovieService {

    private final OpenMovieDatabaseClient openMovieDatabaseClient;
    private final MovieMapper mapToMovie;

    public MovieService(OpenMovieDatabaseClient openMovieDatabaseClient, MovieMapper mapToMovie) {
        this.openMovieDatabaseClient = openMovieDatabaseClient;
        this.mapToMovie = mapToMovie;
    }

    public Movie findMovieById(String imdbId) throws MovieServiceException {
        OpenMovieResponse response = this.openMovieDatabaseClient.getMovie(imdbId);

        if ("False".equals(response.getResponse())) {
            throw new MovieServiceException(response.getError());
        }

        return mapToMovie.map(response);
    }

}
