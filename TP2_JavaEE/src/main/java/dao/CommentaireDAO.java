package dao;

import org.hibernate.Session;

import entities.Commentaire;
import util.HibernateUtil;

public class CommentaireDAO implements DAO<Commentaire> {

	@Override
	public Commentaire find(Long id) {
		Session sess = null;
		Commentaire commentaire = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			commentaire = sess.get(Commentaire.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		}

		return commentaire;
	}

	@Override
	public void create(Commentaire obj) {
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
	public void update(Commentaire obj) {
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
	public void delete(Commentaire obj) {
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
