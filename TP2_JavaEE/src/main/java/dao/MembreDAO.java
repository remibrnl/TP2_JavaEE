package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.sun.istack.Nullable;

import entities.Membre;
import util.HibernateUtil;

/**
 * Cette classe est le DAO de la table Membre
 */
public class MembreDAO implements DAO<Membre> {

	@Override
	@Nullable public Membre find(int id) throws Exception {
		Session sess = null;
		Membre membre = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			membre = sess.get(Membre.class, id);

		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}

		return membre;
	}
	
	@Override
	public List<Membre> findAll() throws Exception {
		Session sess = null;
		List<Membre> membresList = new ArrayList<Membre>();
		
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			
			membresList = sess.createQuery("FROM Membre ORDER BY idMembre", Membre.class).getResultList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
		
		return membresList;
	}

	@Override
	public void create(Membre obj) throws Exception {
		Session sess = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			sess.save(obj);
		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
	}

	@Override
	public void update(Membre obj) throws Exception {
		Session sess = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			sess.update(obj);
		} catch (Exception e) {
			throw e;
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
	}

	@Override
	public void delete(Membre obj) throws Exception {
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
