package fr.apside.DVDStore.core.repository;

import fr.apside.DVDStore.core.entity.Movie;

import java.util.List;

public interface MovieRepositoryInterface {

	void add(Movie movie);

	List<Movie> List();

}
