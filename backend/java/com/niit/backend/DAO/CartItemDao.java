package com.niit.backend.DAO;

import com.niit.backend.models.CartItemModel;

public interface CartItemDao {

	void saveCartItem(CartItemModel cart);

	void deleteCartItem(int id);
	void deleteAllCartItems(int id);

}
