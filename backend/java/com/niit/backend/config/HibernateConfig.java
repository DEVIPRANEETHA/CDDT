package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.DAO.UserDao;
import com.niit.backend.DAO.CartItemDao;
import com.niit.backend.DaoImpl.AdminDaoimpl;
import com.niit.backend.DaoImpl.ProductDaoimpl;
import com.niit.backend.DaoImpl.UserDaoimpl;
import com.niit.backend.models.AdminModel;
import com.niit.backend.models.ProductModel;
import com.niit.backend.models.UserModel;
import com.niit.backend.models.CartItemModel;
import com.niit.backend.models.BasketModel;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Autowired
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(UserModel.class);
		sessionBuilder.addAnnotatedClass(AdminModel.class);
		sessionBuilder.addAnnotatedClass(ProductModel.class);
		sessionBuilder.addAnnotatedClass(CartItemModel.class);
		sessionBuilder.addAnnotatedClass(BasketModel.class);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="datasource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
	    return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.format_sql", "true");
	    properties.put("hibernate.hbm2ddl.auto", "update");
	    properties.put("hibernate.connection.autocommit", true);
	    //properties.put("hibernate.temp.use_jdbc_metadata_defaults",false);
	     return properties;
	}
	
	@Bean
	@Autowired
	  public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	@Autowired
	 public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoimpl(sessionFactory);
	}
	
	@Bean
	@Autowired
	 public AdminDaoimpl getAdminDao(SessionFactory sessionFactory) {
		return new AdminDaoimpl(sessionFactory);
	}
	
	@Bean
	@Autowired
	 public ProductDaoimpl getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoimpl(sessionFactory);
	}
	 @Bean
     @Autowired
     public CartItemDao getCartdao(SessionFactory sessionFactory)
     {
    	 
    	 return new CartItemDaoImpl(sessionFactory);
     }
     
	public HibernateConfig() 
	{}
}
