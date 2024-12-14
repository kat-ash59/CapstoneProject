package com.skilldistillery.jpasmoochyzoo.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class AnimalTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	// entity under test
	private Animal animal = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("SmoochyZoo");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		animal = em.find(Animal.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		animal = null;
	}

	@Test
	void test_User_basic_mappings() {
		assertNotNull(animal);
		assertEquals("Fred", animal.getName());
	}

}
