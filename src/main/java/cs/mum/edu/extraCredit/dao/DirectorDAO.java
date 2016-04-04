package cs.mum.edu.extraCredit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.mum.edu.extraCredit.domain.Director;

public class DirectorDAO {

	public void createDirector(Director director) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = session.beginTransaction();
			session.persist(director);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public Director getDirector(int id) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = session.beginTransaction();
			Director director = session.get(Director.class, id);  //eager fetch
			tx.commit();
			return director;
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Director> getDirectorByName(String firstName, String lastName) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Director> directors = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query directorQuery = session.createQuery("FROM Director m WHERE m.firstName = :firstName AND m.lastName = :lastName");
			directorQuery.setParameter("firstName", firstName);
			directorQuery.setParameter("lastName", lastName);
			
			directors = directorQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return directors;
		
	}
	
	public void updateDirector(Director director) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			
			session.merge(director);
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
			
		}
		
	}
	
	public void deleteDirector(Director director)throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			
			session.delete(director);
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
			
		}
	}

}
