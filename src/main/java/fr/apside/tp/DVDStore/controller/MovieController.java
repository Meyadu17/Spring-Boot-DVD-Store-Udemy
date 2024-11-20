package fr.apside.tp.DVDStore.controller;

import fr.apside.tp.DVDStore.entity.Movie;
import fr.apside.tp.DVDStore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MovieController {

	private final MovieServiceInterface movieService;

	public MovieController(MovieServiceInterface movieService) {
		this.movieService = movieService;
	}

	public void addUsingConsole() {
		System.out.println( "Saisir le titre du film ?" );
		Scanner scanner=new Scanner(System.in);
		String title=scanner.nextLine();

		System.out.println( "Saisir le genre du film?" );
		String genre=scanner.nextLine();

		Movie movie=new Movie();
		movie.setTitle(title);
		movie.setGenre(genre);

		movieService.registerMovie(movie);
	}
}
