package com.niit.backend.DAO;

import com.niit.backend.models.UserModel;

public interface UserDao {
	void storeData(UserModel usermodel);
	UserModel findUser(String username);
}
