package br.com.fredericci.omdbapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "open-movie-client", url = "${omdbapi.url:https://www.omdbapi.com/}")
interface OpenMovieDatabaseClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    OpenMovieResponse getMovie(@RequestParam(value = "i") String imdbId);
}
