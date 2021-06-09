package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sun.istack.Nullable;

import entities.Commentaire;
import util.HibernateUtil;

/**
 * Cette classe est le DAO de la table Commentaire
 */
public class CommentaireDAO implements DAO<Commentaire> {

	@Override
	@Nullable public Commentaire find(int id) throws Exception {
		Session sess = null;
		Commentaire commentaire = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			commentaire = sess.get(Commentaire.class, id);

		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}

		return commentaire;
	}

	@Override
	@Nullable 
	public List<Commentaire> findAll() throws Exception {
		Session sess = null;
		List<Commentaire> commentairesList = new ArrayList<Commentaire>();
		
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			
			commentairesList = sess.createQuery("FROM Commentaire ORDER BY Commentaire.idCommentaire", Commentaire.class).getResultList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
		
		return commentairesList;
	}
	
	public List<Commentaire> findAllOrderByLikes() throws Exception {
		Session sess = null;
		List<Commentaire> commentairesList = new ArrayList<Commentaire>();
		
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			
			commentairesList = sess.createQuery("FROM Commentaire ORDER BY nbLikes DESC", Commentaire.class).getResultList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
		
		return commentairesList;
	}

	@Override
	public void create(Commentaire obj) throws Exception {
		Session sess = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			sess.save(obj);
		} 
		
		catch (Exception e) 
		{
			throw e;
		}
		finally 
		{
			if (sess != null && sess.isOpen()) 
			{
				sess.close();
			}
		}
	}

	@Override
	public void update(Commentaire obj) throws Exception {
		Session sess = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			
			Transaction transac = sess.beginTransaction();

			Query query = sess.createQuery("UPDATE Commentaire SET nbLikes = :nblike WHERE idCommentaire = :idcom ");
			
			query.setParameter("nblike", obj.getNbLikes());
			query.setParameter("idcom", obj.getIdCommentaire());
			
			
			query.executeUpdate();
			
			transac.commit();
		} 
		catch (Exception e) 
		{
			throw e;
		} 
		finally 
		{
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
	}
	
	

	@Override
	public void delete(Commentaire obj) throws Exception {
		Session sess = null;
		
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			
			sess.remove(obj);
		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
	}

}
