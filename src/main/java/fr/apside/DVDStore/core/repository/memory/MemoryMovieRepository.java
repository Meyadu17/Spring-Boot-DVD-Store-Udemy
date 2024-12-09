package fr.apside.DVDStore.core.repository.memory;

import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.repository.MovieRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

	private final List<Movie> movieList = new ArrayList<>();

	public void add(Movie movie){
		movieList.add(movie);
		System.out.println("The movie "+movie.getTitle()+" has been added.");
	}

	@Override
	public List<Movie> list() {

		Movie movie1 = new Movie();
		movie1.setId(1L);
		movie1.setTitle("Toys Story 3");
		movie1.setGenre("ANIMATION");
		movie1.setDescription("Les créateurs des très populaires films Toy Story ouvrent à nouveau le coffre à jouets et invitent les spectateurs à retrouver le monde délicieusement magique de Woody et Buzz au moment où Andy s'apprête à partir pour l'université.");

		System.out.println("id : " + movie1.getId()
						   + " title : " + movie1.getTitle()
						   + " genre : " + movie1.getGenre()
						   + " description : " + movie1.getDescription());

		Movie movie2 = new Movie();
		movie2.setId(2L);
		movie2.setTitle("Rasta Rocket");
		movie2.setGenre("COMEDIE");
		movie2.setDescription("Comment une équipe de la Jamaïque, après de multiples aventures, va participer à l'épreuve de bobsleigh à quatre aux Jeux Olympiques d'hiver de Calgary.");

		System.out.println("id : " + movie2.getId()
						   + " title : " + movie2.getTitle()
						   + " genre : " + movie2.getGenre()
						   + " description : " + movie2.getDescription());

		Movie movie3 = new Movie();
		movie3.setId(3L);
		movie3.setTitle("Braveheart");
		movie3.setGenre("DRAME");
		movie3.setDescription("Edouard Ier, roi d'Angleterre, s'empare du trône après avoir réglé un conflit avec le personnage fantoche qu'il y avait auparavant placé. William Wallace prend la tête d'une révolte paysanne.");

		System.out.println("id : " + movie3.getId()
						   + " title : " + movie3.getTitle()
						   + " genre : " + movie3.getGenre()
						   + " description : " + movie3.getDescription());

		Movie movie4 = new Movie();
		movie4.setId(4L);
		movie4.setTitle("Moonraker");
		movie4.setGenre("THRILLER");
		movie4.setDescription("L'agent secret britannique James Bond enquête sur la disparition d'une navette spatiale americaine, Moonraker, confiee au gouvernement britannique. 007 se rend aux Etats-Unis pour interroger le responsable de la construction de la navette, Sir Hugo Drax.");

		System.out.println("id : " + movie4.getId()
						   + " title : " + movie4.getTitle()
						   + " genre : " + movie4.getGenre()
						   + " description : " + movie4.getDescription());

		return List.of(movie1, movie2, movie3, movie4);

	}

	@Override
	public Movie getById(long id) {

		List<Movie> movieList = list();
		for (Movie movie : movieList) {
			if (movie.getId() == id) {
				return movie;
			}
		}

		return null;
	}
}
