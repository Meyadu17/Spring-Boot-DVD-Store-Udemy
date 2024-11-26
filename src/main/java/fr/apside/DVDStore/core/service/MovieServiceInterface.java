package fr.apside.DVDStore.core.service;

import fr.apside.DVDStore.core.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {

	void registerMovie(Movie movie);

	List<Movie> getMovieList();
}
