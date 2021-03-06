package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.models.ProductModel;



public interface ProductDao {
	void product(ProductModel productmodel);
	List<ProductModel> allproducts();
	List<ProductModel> allToys();
	List<ProductModel> allBooks();
	List<ProductModel> adminallproducts();
	List<ProductModel> adminAllToys();
	List<ProductModel> adminAllBooks();
	void delete(int id); 
	ProductModel edit(int id);
	ProductModel getProduct(int id);
}
