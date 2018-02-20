package com.niit.backend.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.backend.DAO.AdminDao;
import com.niit.backend.models.AdminModel;



public class AdminDaoimpl implements AdminDao {
	@Autowired
	SessionFactory sessionFactory;
	public AdminDaoimpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
	public void storeData(AdminModel adminmodel) {
		Session session =sessionFactory.getCurrentSession();
		session.save(adminmodel);
	}

}
