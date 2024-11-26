package fr.apside.DVDStore.core.service;

import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface{

	private final MovieRepositoryInterface movieRepositoryInterface;

	public DefaultMovieService(MovieRepositoryInterface movieRepository) {
		this.movieRepositoryInterface = movieRepository;
	}

	public void registerMovie(Movie movie){
		movieRepositoryInterface.add(movie);
	}

	@Override
	public List<Movie> getMovieList() {
		return movieRepositoryInterface.List();
	}
}
