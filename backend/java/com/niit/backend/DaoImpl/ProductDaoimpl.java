package com.niit.backend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.backend.DAO.ProductDao;
import com.niit.backend.models.ProductModel;



public class ProductDaoimpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	public ProductDaoimpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void product(ProductModel productmodel) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(productmodel);
		
	}
	@Transactional
	
	public List<ProductModel> allproducts() {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(ProductModel.class);
		List<ProductModel> productlist=criteria.list();
		return productlist;
	}
	@Transactional
	public List<ProductModel> allToys() {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("cat","TOYS"));
		List<ProductModel> toyslist=criteria.list();
		return toyslist;
	}
	@Transactional
	public List<ProductModel> allBooks() {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("cat","BOOKS"));
		List<ProductModel> bookslist=criteria.list();
		return bookslist;
	}
	@Transactional
	public List<ProductModel> adminallproducts() {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(ProductModel.class);
		List<ProductModel> adminproductlist=criteria.list();
		return adminproductlist;
	}
	@Transactional
	public List<ProductModel> adminAllToys() {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("cat","TOYS"));
		List<ProductModel> admintoyslist=criteria.list();
		return admintoyslist;
	}
	@Transactional
	public List<ProductModel> adminAllBooks() {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("cat","BOOKS"));
		List<ProductModel> adminbookslist=criteria.list();
		return adminbookslist;
	}
	@Transactional
	public void delete(int id) {
		Session session=sessionFactory.getCurrentSession();
		ProductModel productmodel=(ProductModel)session.load(ProductModel.class,new Integer(id));
		session.delete(productmodel);
	}
	@Transactional
	public ProductModel edit(int id) {
		Session session=sessionFactory.openSession();
		ProductModel productmodel=(ProductModel)session.load(ProductModel.class,id);
		return productmodel;
	} 
	@Transactional
public ProductModel getProduct(int id) {
		
		Session session=sessionFactory.openSession();
		ProductModel product=(ProductModel)session.load(ProductModel.class,id);
		return product;
				
	}
	
}
