package fr.apside.DVDStore.core.repository.memory;

import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

	private List<Movie> movies=new ArrayList<>();

	public void add(Movie movie){
		movies.add(movie);
		System.out.println("The movie "+movie.getTitle()+" has been added.");
	}

	@Override
	public List<Movie> list() {
		return movies;
	}

	@Override
	public Movie getById(long id) {
		return movies.stream().
				filter(m -> m.getId()==id).
				findFirst().get();
	}
}
