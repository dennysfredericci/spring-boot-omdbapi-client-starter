package io.github.dennysfredericci.omdbapi.client;

import java.util.Objects;

public class Movie {
    private String imdbID;
    private String title;
    private String genre;
    private String plot;
    private String language;
    private String poster;
    private String actors;
    private Double imdbRating;
    private Integer imdbVotes;

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(Integer imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getImdbID(), movie.getImdbID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImdbID());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", poster='" + poster + '\'' +
                ", actors='" + actors + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                '}';
    }
}
