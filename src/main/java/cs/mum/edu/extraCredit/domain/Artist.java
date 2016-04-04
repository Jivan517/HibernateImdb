package cs.mum.edu.extraCredit.domain;

import java.util.*;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "ArtistImage")
public class Artist {
	
	@Id @GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	private String placeOfBirth;
	
	@Lob
	@Column
	private String biography;
	
	@Lob
	@Column(table = "ArtistImage")
	private byte[] image;

	@ManyToMany(mappedBy = "artists")
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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
