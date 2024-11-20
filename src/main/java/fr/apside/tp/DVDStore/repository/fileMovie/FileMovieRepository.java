package fr.apside.tp.DVDStore.repository.fileMovie;

import fr.apside.tp.DVDStore.entity.Movie;
import fr.apside.tp.DVDStore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

	@Value( "${movies.file.location}")
	private File file;
	private static List<Movie> movies = new ArrayList<Movie>();

	public void add(Movie movie){
		FileWriter writer;
		try{
			writer=new FileWriter(file,true);
			writer.write(movie.getTitle()+";"+movie.getGenre()+"\n");
			writer.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("The movie "+movie.getTitle()+" has been added.");
	}

	// Ajout des getter et setter de file pour y faire appel dans applicationContext.xml

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
