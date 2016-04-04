package cs.mum.edu.extraCredit.domain;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import java.util.*;

@Entity
@SecondaryTable(name = "MoviePoster")
public class Movie {

	@Id @GeneratedValue
	private int id;
	
	private int year;
	
	private String title;
	
	@Lob
	@Column(table = "MoviePoster")
	private byte[] poster;
	
	private String summary;
	
	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@ElementCollection
	@OrderColumn(name = "position")
	@Enumerated(EnumType.STRING)
	private List<Genre> genres = new ArrayList<>();
	
	@ElementCollection
	@OrderColumn(name = "position")
	private List<String> comments = new ArrayList<>();
	
	
	@ManyToMany
	@Cascade(value = {org.hibernate.annotations.CascadeType.DELETE })
	@JoinTable(name = "MovieDirector")
	private List<Director> directors = new ArrayList<>();
	
	@ManyToMany
	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL })
	@JoinTable(name = "MovieArtist")
	private List<Artist> artists = new ArrayList<>();

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	
	public int getId() {
		return id;
	}
	
}
