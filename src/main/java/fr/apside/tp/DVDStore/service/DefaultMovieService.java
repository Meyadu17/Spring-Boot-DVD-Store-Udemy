package fr.apside.tp.DVDStore.service;

import fr.apside.tp.DVDStore.entity.Movie;
import fr.apside.tp.DVDStore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMovieService implements MovieServiceInterface{

	private final MovieRepositoryInterface movieRepository;

	public DefaultMovieService(MovieRepositoryInterface movieRepository) {
		this.movieRepository = movieRepository;
	}

	public void registerMovie(Movie movie){
		movieRepository.add(movie);
	}
}
