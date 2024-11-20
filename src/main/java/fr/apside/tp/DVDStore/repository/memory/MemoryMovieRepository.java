package fr.apside.tp.DVDStore.repository.memory;

import fr.apside.tp.DVDStore.entity.Movie;
import fr.apside.tp.DVDStore.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

	private List<Movie> movies=new ArrayList<>();

	public void add(Movie movie){
		movies.add(movie);
		System.out.println("MemoryMovieRepository : The movie "+movie.getTitle()+" has been added.");
	}
}
