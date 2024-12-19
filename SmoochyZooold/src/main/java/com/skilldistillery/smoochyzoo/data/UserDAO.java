package com.skilldistillery.smoochyzoo.data;

import com.skilldistillery.jpasmoochyzoo.entities.User;

public interface UserDAO {
	User getUserByUserNameAndPassword(String userName, String password);
	User findUserByid(int userId); 
	User updateUser(int userId, User user); 
}
