package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.models.ProductModel;



public interface BasketDao {
	
	void addToCart(String name,int pid);

	List<ProductModel> openBasket();

}
