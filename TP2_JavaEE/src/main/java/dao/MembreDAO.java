package dao;

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
	public void create(Membre obj) {
		Session sess = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			sess.persist(obj);
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

	// private SessionFactory sess = HibernateUtil.getSessionFactory();

}
