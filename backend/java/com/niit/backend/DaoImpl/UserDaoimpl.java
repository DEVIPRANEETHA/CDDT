package com.niit.backend.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.backend.DAO.UserDao;
import com.niit.backend.models.UserModel;



public class UserDaoimpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public UserDaoimpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void storeData(UserModel usermodel) {
		Session session=sessionFactory.getCurrentSession();
		session.save(usermodel);
    }
	 @Transactional
       public UserModel findUser(String username) {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select * from userdetails where username="+username);
		UserModel user=(UserModel)query.uniqueResult();
		user.getGender();
		return user;
	}

}
