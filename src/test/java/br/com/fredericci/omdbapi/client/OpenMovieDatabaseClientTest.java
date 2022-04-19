package br.com.fredericci.omdbapi.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.nio.charset.Charset.defaultCharset;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.StreamUtils.copyToString;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "omdbapi.url=http://localhost:9561/",
        "feign.client.config.open-movie-client.default-query-parameters.apikey=12345678"
})
class OpenMovieDatabaseClientTest {

    @Autowired
    public OpenMovieDatabaseClient openMovieDatabaseClient;

    @Autowired
    public ObjectMapper jsonMapper;

    private final WireMockServer mockServer = new WireMockServer(9561);

    @BeforeEach
    public void setUp() {
        mockServer.start();
    }

    @AfterEach
    public void tearDown() {
        mockServer.stop();
    }

    @Test
    public void shouldReturnValidMovie() throws IOException {

        mockServer.stubFor(get(urlEqualTo("/?i=tt0000001&apikey=12345678"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(file("shouldReturnValidMovie.json"))));


        OpenMovieResponse movie = openMovieDatabaseClient.getMovie("tt0000001");

        assertThat(movie.getImdbID()).isEqualTo("tt0000001");
        assertThat(movie.getTitle()).isEqualTo("Carmencita");
        assertThat(movie.getGenre()).isEqualTo("Documentary, Short");
        assertThat(movie.getImdbVotes()).isEqualTo("1,868");
        assertThat(movie.getImdbRating()).isEqualTo("5.7");
    }

    @Test
    public void shouldReturnNonExistingMovie() throws IOException {

        mockServer.stubFor(get(urlEqualTo("/?i=tt9999999&apikey=12345678"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(file("shouldReturnNonExistingMovie.json"))));

        OpenMovieResponse movie = openMovieDatabaseClient.getMovie("tt9999999");

        assertThat(movie.getResponse()).isEqualTo("False");
        assertThat(movie.getError()).isEqualTo("Error fetching movie");
    }

    private String file(String filename) throws IOException {
        return copyToString(this.getClass().getClassLoader().getResourceAsStream(filename), defaultCharset());
    }

    @TestConfiguration
    @EnableAutoConfiguration(exclude = MovieApiConfiguration.class)
    @EnableFeignClients(clients = OpenMovieDatabaseClient.class)
    public static class FeignConfig {
    }

}