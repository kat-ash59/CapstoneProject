package com.skilldistillery.smoochyzoo.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	// anything you 
	public UserDAOImpl(EntityManager em) {
	    this.em = em;
	}
	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {
	    String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
	    System.out.println("JPQL Query: " + jpql);
	    try {
	        User user = em.createQuery(jpql, User.class)
	                      .setParameter("username", userName)
	                      .setParameter("password", password)
	                      .getSingleResult();
	        System.out.println("User found: " + user);  // Print the result
	        return user;
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public User findUserByid(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User updateUser(int userId, User user) {
		User existingUser = em.find(User.class, userId);

		if (existingUser != null) {
			existingUser.setPassword(user.getPassword());
			existingUser.setUsername(user.getUsername());
		}
		return null;
	}

}
