package fr.apside.DVDStore.core.service;

import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface{

	@Autowired
	private MovieRepositoryInterface movieRepositoryInterface;

	public MovieRepositoryInterface getMovieRepositoryInterface() {
		return movieRepositoryInterface;
	}

	public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
		this.movieRepositoryInterface = movieRepositoryInterface;
	}

	public Movie addMovie(Movie movie){

		movieRepositoryInterface.add(movie);

		return movie;
	}

	@Override
	public List<Movie> getMovieList() {
		return movieRepositoryInterface.list();
	}

	@Override
	public Movie getMovieById(long id) {
		return movieRepositoryInterface.getById(id);
	}
}
