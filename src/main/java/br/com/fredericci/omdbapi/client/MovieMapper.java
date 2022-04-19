package br.com.fredericci.omdbapi.client;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static java.lang.Double.parseDouble;
import static java.util.Objects.isNull;
public class MovieMapper {

    private final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance(Locale.ENGLISH);

    public Movie map(OpenMovieResponse openMovieResponse) {
        Movie movie = new Movie();
        movie.setActors(notAvailableToNull(openMovieResponse.getActors()));
        movie.setGenre(notAvailableToNull(openMovieResponse.getGenre()));
        movie.setImdbID(openMovieResponse.getImdbID());
        movie.setLanguage(notAvailableToNull(openMovieResponse.getLanguage()));
        movie.setPlot(notAvailableToNull(openMovieResponse.getPlot()));
        movie.setPoster(notAvailableToNull(openMovieResponse.getPoster()));
        movie.setTitle(notAvailableToNull(openMovieResponse.getTitle()));
        movie.setImdbRating(notAvailableToDouble(openMovieResponse.getImdbRating()));
        movie.setImdbVotes(notAvailableToInteger(openMovieResponse.getImdbVotes()));
        return movie;
    }

    private String notAvailableToNull(String value) {
        return "N/A".equals(value) ? null : value;
    }

    private Double notAvailableToDouble(String value) {
        return isNull(value) || "N/A".equals(value) ? 1d : parseDouble(value);
    }

    private Integer notAvailableToInteger(String value) {
        return isNull(value) || "N/A".equals(value) ? 1 : toInt(value);
    }

    private Integer toInt(String value) {
        try {
            return NUMBER_FORMAT.parse(value).intValue();
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Error converting %s to integer", value));
        }
    }

}
