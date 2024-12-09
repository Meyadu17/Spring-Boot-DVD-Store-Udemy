package fr.apside.DVDStore.core.repository.fileMovie;

import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

	@Value("${movies.file.location}")
	private File file;

	public void add(Movie movie){

		long lastId=list().stream().map(Movie::getId).max(Long::compare).orElse(0L);
		movie.setId(lastId+1);

		FileWriter writer;
		try{
			writer=new FileWriter(file,true);
			writer.write(movie.getId()+";"+movie.getTitle()+";"+movie.getGenre()+";"+movie.getDescription()+"\n");
			writer.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("Le film "+movie.getTitle()+" à été ajouté.");
	}

	@Override
	public List<Movie> list() {

		List<Movie> movies=new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			for(String line; (line = br.readLine()) != null; ) {
				final Movie movie=new Movie();
				final String[] allProperties = line.split("\\;");
				movie.setId(Long.parseLong(allProperties[0]));
				movie.setTitle(allProperties[1]);
				movie.setGenre(allProperties[2]);
				movies.add(movie);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("A movie from the file does not have a proper id");
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public Movie getById(long id) {
		final Movie movie = new Movie();
		movie.setId(id);
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			for(String line; (line = br.readLine()) != null; ) {

				final String[] allProperties = line.split("\\;");
				final long nextMovieId=Long.parseLong(allProperties[0]);
				if (nextMovieId==id) {
					movie.setTitle(allProperties[1]);
					movie.setGenre(allProperties[2]);
					movie.setDescription(allProperties[3]);
					return movie;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("A movie from the file does not have a proper id");
			e.printStackTrace();
		}
		movie.setTitle("UNKNOWN");
		movie.setGenre("UNKNOWN");
		movie.setDescription("UNKNOWN");
		return movie;
	}
}
