package dao;

import org.hibernate.Session;

import bean.CommentaireBean;
import util.HibernateUtil;

public class CommentaireDAO implements DAO<CommentaireBean> {

	@Override
	public CommentaireBean find(Long id) {
		Session sess = null;
		CommentaireBean commentaire = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			commentaire = sess.get(CommentaireBean.class, id);

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
	public void create(CommentaireBean obj) {
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
	public void update(CommentaireBean obj) {
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
	public void delete(CommentaireBean obj) {
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
