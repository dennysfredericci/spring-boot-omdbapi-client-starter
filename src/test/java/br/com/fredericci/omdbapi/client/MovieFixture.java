package br.com.fredericci.omdbapi.client;

class MovieFixture {
    static Movie create() {
        Movie movie = new Movie();
        movie.setImdbID("tt1285016");
        movie.setTitle("The Social Network");
        movie.setActors("Jesse Eisenberg, Andrew Garfield, Justin Timberlake");
        movie.setGenre("Biography, Drama");
        movie.setImdbRating(7.8);
        movie.setImdbVotes(678386);
        movie.setLanguage("English, French");
        movie.setPlot("As Harvard student Mark Zuckerberg creates the social networking site that would become known as Facebook, he is sued by the twins who claimed he stole their idea, and by the co-founder who was later squeezed out of the business.");
        movie.setPoster("https://m.media-amazon.com/images/M/MV5BOGUyZDUxZjEtMmIzMC00MzlmLTg4MGItZWJmMzBhZjE0Mjc1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg");
        return movie;
    }
}
