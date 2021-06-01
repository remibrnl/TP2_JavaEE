package dao;

import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import bean.MembreBean;
import util.HibernateUtil;

public class MembreDAO implements DAO<MembreBean> {

	@Override
	public MembreBean find(Long id) {
		Session sess = null;
		MembreBean membre = null;

		try {
			sess = HibernateUtil.getSessionFactory().openSession();

			membre = sess.get(MembreBean.class, id);

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
	public void create(MembreBean obj) {
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
	public void update(MembreBean obj) {
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
	public void delete(MembreBean obj) {
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
