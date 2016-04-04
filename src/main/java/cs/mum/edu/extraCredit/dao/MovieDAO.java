package cs.mum.edu.extraCredit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.mum.edu.extraCredit.domain.Genre;
import cs.mum.edu.extraCredit.domain.Movie;
import cs.mum.edu.extraCredit.domain.Rating;

public class MovieDAO {

	public void createMovie(Movie movie) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = session.beginTransaction();
			session.persist(movie);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public Movie getMovie(int id) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = session.beginTransaction();
			Movie movie = session.get(Movie.class, id);  //eager fetch
			tx.commit();
			return movie;
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
		
	public void updateMovie(Movie movie) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			
			session.merge(movie);
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
			
		}
		
	}
	
	public void deleteMovie(Movie movie)throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			
			session.delete(movie);
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
			
		}
	}
	
	/** search by Name of the movie */
	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByName(String name) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query movieQuery = session.createQuery("FROM Movie m WHERE m.title = :name");
			movieQuery.setParameter("name", name);
			
			movies = movieQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return movies;
		
	}

	
	/**search by Genre of the movie*/
	public List<Movie> getMoviesByGenre (Genre genre)
			throws Exception{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query movieQuery = session.createQuery("FROM Movie m WHERE :genre in elements(m.genres)");
			movieQuery.setParameter("genre", genre);
			
			movies = movieQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return movies;
		
		
	}
	
	/**search by Rating of the movie

	 */
	public List<Movie> getMoviesByRating (Rating rating)
			throws Exception{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query movieQuery = session.createQuery("FROM Movie m WHERE m.rating = :rating");
			movieQuery.setParameter("rating", rating);
			
			movies = movieQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return movies;
		
		
	}
	
	/**search movie by Name of the artist

	 */
	@SuppressWarnings("unchecked")
	public List<Movie> getMoviesByArtistName(String firstName, String lastName)
			throws Exception{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query movieQuery = session.createQuery("SELECT m FROM Movie m JOIN m.artists a WHERE "
					+ "a.firstName = :firstName AND a.lastName = :lastName");
			movieQuery.setParameter("firstName", firstName);
			movieQuery.setParameter("lastName", lastName);
			
			movies = movieQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return movies;
		
		
	}
	
	/**search movie by Director of the movie

	 */
	public List<Movie> getMoviesByDirector(String firstName, String lastName)
			throws Exception{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query movieQuery = session.createQuery("FROM Movie m WHERE "
					+ "m.directors.firstName = :firstName AND m.directors.lastName = :lastName");
			movieQuery.setParameter("firstName", firstName);
			movieQuery.setParameter("lastName", lastName);
			
			
			movies = movieQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return movies;
		
		
	}
	
	/**search by Year of the movie

	 */
	public List<Movie> getMoviesByYear(int year)
			throws Exception{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query movieQuery = session.createQuery("FROM Movie m WHERE m.year = :year");
			movieQuery.setParameter("year", year);
			
			movies = movieQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return movies;
		
		
	}
	

}
