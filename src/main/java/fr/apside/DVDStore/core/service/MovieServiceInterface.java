package fr.apside.DVDStore.core.service;

import fr.apside.DVDStore.core.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {

	Movie addMovie(Movie movie);

	List<Movie> getMovieList();

	Movie getMovieById(long id);
}
