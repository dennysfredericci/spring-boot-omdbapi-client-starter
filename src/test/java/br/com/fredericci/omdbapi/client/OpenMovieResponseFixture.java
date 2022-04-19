package br.com.fredericci.omdbapi.client;

class OpenMovieResponseFixture {

    static OpenMovieResponse create() {
        OpenMovieResponse response = new OpenMovieResponse();
        response.setImdbID("tt1285016");
        response.setTitle("The Social Network");
        response.setActors("Jesse Eisenberg, Andrew Garfield, Justin Timberlake");
        response.setGenre("Biography, Drama");
        response.setImdbRating("7.8");
        response.setImdbVotes("678,386");
        response.setLanguage("English, French");
        response.setPlot("As Harvard student Mark Zuckerberg creates the social networking site that would become known as Facebook, he is sued by the twins who claimed he stole their idea, and by the co-founder who was later squeezed out of the business.");
        response.setPoster("https://m.media-amazon.com/images/M/MV5BOGUyZDUxZjEtMmIzMC00MzlmLTg4MGItZWJmMzBhZjE0Mjc1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        response.setResponse("True");
        return response;
    }

    static OpenMovieResponse createInvalid() {
        OpenMovieResponse response = new OpenMovieResponse();
        response.setResponse("False");
        response.setError("Random error...");
        return response;
    }
}
