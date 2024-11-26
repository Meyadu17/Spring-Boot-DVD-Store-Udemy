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
		System.out.println("MemoryMovieRepository : The movie "+movie.getTitle()+" has been added.");
	}

	@Override
	public List<Movie> List() {
		Movie movie1 = new Movie();
		movie1.setTitle("OSS 117");
		movie1.setGenre("Comédie");
		Movie movie2 = new Movie();
		movie2.setTitle("Demolition Man");
		movie2.setGenre("Action");
		Movie movie3 = new Movie();
		movie3.setTitle("Interstellar");
		movie3.setGenre("SF");
		Movie movie4 = new Movie();
		movie4.setTitle("La grande vadrouille");
		movie4.setGenre("Comédie");
		Movie movie5 = new Movie();
		movie5.setTitle("Rencontre du 3ième type");
		movie5.setGenre("SF");

		return List.of(movie1,movie2,movie3,movie4,movie5);
	}
}
