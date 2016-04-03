package cs.mum.edu.extraCredit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.mum.edu.extraCredit.domain.Movie;

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
	
	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByName(String name) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query movieQuery = session.createQuery("FROM Movie m WHERE m.name = :name");
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

}
