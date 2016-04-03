package cs.mum.edu.extraCredit.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Director {
	
	@Id @GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "directors")
	private List<Movie> movies = new ArrayList<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public int getId() {
		return id;
	}
	
}
