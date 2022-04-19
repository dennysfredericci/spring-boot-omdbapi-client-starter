package br.com.fredericci.omdbapi.client;

import com.fasterxml.jackson.annotation.JsonProperty;

class OpenMovieResponse {

    private String imdbID;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;

    private String imdbRating;

    private String imdbVotes;

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

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    @Override
    public String toString() {
        return "OpenMovieResponse{" +
                "imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", poster='" + poster + '\'' +
                ", actors='" + actors + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                '}';
    }
}
