package cs.mum.edu.extraCredit.control;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import cs.mum.edu.extraCredit.dao.ArtistDAO;
import cs.mum.edu.extraCredit.dao.DirectorDAO;
import cs.mum.edu.extraCredit.dao.MovieDAO;
import cs.mum.edu.extraCredit.domain.Artist;
import cs.mum.edu.extraCredit.domain.Director;
import cs.mum.edu.extraCredit.domain.Genre;
import cs.mum.edu.extraCredit.domain.Movie;
import cs.mum.edu.extraCredit.domain.Rating;

public class Application {

	
	public static void main(String[] args) throws Exception {
		
		populateDirectors();
		populateArtists();
		populateMovies();
		

		
	}
	
	private static void populateDirectors(){
		
	}
	
	private static void populateArtists()
	{
		
	}
	
	private static void populateMovies() throws Exception{
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 

		
		Director director = new Director();
		director.setFirstName("James");
		director.setLastName("Cameron");
		
		Artist leo = new Artist();
		leo.setFirstName("Leonardo");
		leo.setLastName("DiCaprio");
		leo.setPlaceOfBirth("LA, CAlifornia, USA");
		leo.setBiography("Few actors in the world have had a career quite as diverse as Leonardo DiCaprio's. DiCaprio has gone from relatively humble beginnings, as a supporting cast member of the sitcom Growing Pains (1985) and low budget horror movies, such as Critters 3 (1991), to a major teenage heartthrob in the 1990s");
		
		leo.setDob(ft.parse("1974-11-11"));
		
		String pathURL = Thread.currentThread().getContextClassLoader().getResource("\\images\\leo.jpg").getPath();
		
		System.out.println(pathURL.substring(1));
		
		Path p = FileSystems.getDefault().getPath("F:/Masters/Enterprise Architecture/Hibernate/HibernateImdb/src/main/resources/images/leo.jpg");
		leo.setImage(Files.readAllBytes(p));
		
		Movie titanic  = new Movie();
		titanic.setTitle("Titanic");
		titanic.setRating(Rating.EXCELLENT);
		titanic.setSummary("A seventeen-year-old aristocrat falls in love with a kind, but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.");
		titanic.setGenres(Arrays.asList(Genre.DRAMA, Genre.ROMANCE));
		titanic.setComments(Arrays.asList("Very good movie", "loved the performance of Leo"));
		titanic.setYear(1997);
		
		titanic.getArtists().add(leo);
		titanic.getDirectors().add(director);
		
		MovieDAO movieDao = new MovieDAO();
		movieDao.createMovie(titanic);
		
		
		
	}

	private static  void printInfo(){
		
		
	}
	
}
