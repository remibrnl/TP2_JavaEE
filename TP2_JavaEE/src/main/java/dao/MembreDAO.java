package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entities.Membre;
import util.HibernateUtil;

public class MembreDAO implements DAO<Membre> {

	@Override
	public Membre find(Long id) {
		Session sess = null;
		Membre membre = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			membre = sess.get(Membre.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}

		return membre;
	}
	
	@Override
	public List<Membre> findAll() {
		Session sess = null;
		List<Membre> membresList = new ArrayList<Membre>();
		
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			
			membresList = sess.createQuery("SELECT * FROM membre", Membre.class).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
		
		return membresList;
	}

	@Override
	public void create(Membre obj) {
		Session sess = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			sess.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
	}

	@Override
	public void update(Membre obj) {
		Session sess = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			sess.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
	}

	@Override
	public void delete(Membre obj) {
		Session sess = null;
		
		try {
			sess = HibernateUtil.getSessionFactory().openSession();
			
			sess.remove(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}
	}

}
