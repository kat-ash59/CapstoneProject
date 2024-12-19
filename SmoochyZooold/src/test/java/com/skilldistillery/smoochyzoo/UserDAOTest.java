package com.skilldistillery.smoochyzoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.skilldistillery.jpasmoochyzoo.entities.User;
import com.skilldistillery.smoochyzoo.data.UserDAO;
import com.skilldistillery.smoochyzoo.data.UserDAOImpl;

public class UserDAOTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private UserDAO userDao;

    // BeforeEach for setting up the EntityManager
    @BeforeEach
    void setUp() throws Exception {
        emf = Persistence.createEntityManagerFactory("SmoochyZoo");
        em = emf.createEntityManager();
        
        // Instantiate UserDAOImpl with EntityManager injection
        userDao = new UserDAOImpl(em);  // Direct instantiation for testing purposes
    }

    // AfterEach to close the EntityManager after each test
    @AfterEach
    void tearDown() throws Exception {
        em.close();
    }

    @Test
    public void testGetUserByUserNameAndPassword() {
    	 // Begin a transaction to ensure everything works within a session context
        em.getTransaction().begin();

        // Fetch the user from the database directly (make sure user exists in DB)
        User user = userDao.getUserByUserNameAndPassword("keeper", "password");

        // Commit the transaction
        em.getTransaction().commit();

        // Assert that the user is not null (exists) and check relevant properties
        assertNotNull(user);
        assertEquals("keeper", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("zookeeper@smoochyzoo.com", user.getEmail());
    }
}

