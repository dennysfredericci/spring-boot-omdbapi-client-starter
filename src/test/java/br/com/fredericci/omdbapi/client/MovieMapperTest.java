package br.com.fredericci.omdbapi.client;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MovieMapperTest {

    private final MovieMapper movieMapper = new MovieMapper();

    @Test
    void shouldMapResponseToMovie() {
        Movie movie = movieMapper.map(OpenMovieResponseFixture.create());

        assertThat(movie.getImdbID()).isEqualTo("tt1285016");
        assertThat(movie.getTitle()).isEqualTo("The Social Network");
        assertThat(movie.getActors()).isEqualTo("Jesse Eisenberg, Andrew Garfield, Justin Timberlake");
        assertThat(movie.getGenre()).isEqualTo("Biography, Drama");
        assertThat(movie.getImdbRating()).isEqualTo(7.8);
        assertThat(movie.getImdbVotes()).isEqualTo(678386);
        assertThat(movie.getLanguage()).isEqualTo("English, French");
        assertThat(movie.getPlot()).isEqualTo("As Harvard student Mark Zuckerberg creates the social networking site that would become known as Facebook, he is sued by the twins who claimed he stole their idea, and by the co-founder who was later squeezed out of the business.");
        assertThat(movie.getPoster()).isEqualTo("https://m.media-amazon.com/images/M/MV5BOGUyZDUxZjEtMmIzMC00MzlmLTg4MGItZWJmMzBhZjE0Mjc1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
    }

}