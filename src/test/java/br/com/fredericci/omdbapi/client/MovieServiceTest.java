package br.com.fredericci.omdbapi.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    public static final String MOVIE_ID = "tt1285016";
    @Mock
    private OpenMovieDatabaseClient openMovieDatabaseClient;

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private MovieService movieService;

    @Test
    void shouldReturnValidMovie() {

        OpenMovieResponse response = OpenMovieResponseFixture.create();

        when(openMovieDatabaseClient.getMovie(MOVIE_ID)).thenReturn(response);
        when(movieMapper.map(response)).thenReturn(MovieFixture.create());

        Movie movie = movieService.findMovieById(MOVIE_ID);

        assertThat(movie).isNotNull();
    }

    @Test
    void shouldThrowExceptionForInvalidResponse() {
        when(openMovieDatabaseClient.getMovie(MOVIE_ID)).thenReturn(OpenMovieResponseFixture.createInvalid());

        assertThatThrownBy(() -> movieService.findMovieById(MOVIE_ID))
                .isInstanceOf(MovieServiceException.class)
                .hasMessage("Random error...");
    }


}