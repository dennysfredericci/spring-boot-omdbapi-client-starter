package io.github.dennysfredericci.omdbapi.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@ConditionalOnProperty(prefix = "omdbapi", name = "enabled", matchIfMissing = true)
public class MovieApiConfiguration {

    @Bean
    public MovieMapper movieMapper() {
        return new MovieMapper();
    }

    @Bean
    public MovieService movieService(OpenMovieDatabaseClient openMovieDatabaseClient, MovieMapper mapToMovie) {
        return new MovieService(openMovieDatabaseClient, mapToMovie);
    }
}
