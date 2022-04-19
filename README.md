# Spring Boot OMDb API Client 

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a client library to consume OMDb API using Spring Boot in a really simple way.

## Getting Started in 3 Steps

1. Add the library to your Spring Boot project

```
<dependency>
    <groupId>br.com.fredericci.omdbapi</groupId>
    <artifactId>spring-boot-omdbapi-client-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

2. The only mandatory configuration is your API Key. If you don't have one, you can request it [here](https://www.omdbapi.com/apikey.aspx)

| Property               | Default Value | Mandatory |
|------------------------|---------------|-----------|
| omdbapi.key            |               | Yes       |
| omdbapi.connectTimeout | 2000          | No        |
| omdbapi.readTimeout    | 2000          | No        |
| omdbapi.url            | 2000          | No        |


3. Spring Boot will magically find the auto-configuration, and the MovieService will be available to be injected. 

```
@Autowired
MovieService movieSetvice;

Movie movie = movieSetvice.findMovieById("tt1285016");
```

## Contributing

In general, we follow the "fork-and-pull" Git workflow.

1. Fork the repo on GitHub
2. Clone the project to your own machine
3. Commit changes to your own branch
4. Push your work back up to your fork
5. Submit a Pull request so that we can review your changes

NOTE: Be sure to merge the latest from "upstream" before making a pull request!

If you have any questions or wanna talk about Software Development, please, reach me on  [Twitter](https://twitter.com/fredericci) and [Linkedin](https://www.linkedin.com/in/dennysfredericci/)