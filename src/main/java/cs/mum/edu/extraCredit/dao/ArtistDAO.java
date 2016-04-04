package cs.mum.edu.extraCredit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.mum.edu.extraCredit.domain.Artist;

public class ArtistDAO {

	public void createArtist(Artist artist) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = session.beginTransaction();
			session.persist(artist);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}
	
	public Artist getArtist(int id) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = session.beginTransaction();
			Artist artist = session.get(Artist.class, id);  //eager fetch
			tx.commit();
			return artist;
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> getArtistByName(String name) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Artist> artists = new ArrayList<>();
		
		try {
			
			tx = session.beginTransaction();
			Query artistQuery = session.createQuery("FROM Artist m WHERE m.name = :name");
			artistQuery.setParameter("name", name);
			
			artists = artistQuery.list();
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
		return artists;
		
	}
	
	public void updateArtist(Artist artist) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			
			session.merge(artist);
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
			
		}
		
	}
	
	public void deleteArtist(Artist artist)throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			
			session.delete(artist);
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
			
		}
	}
}
