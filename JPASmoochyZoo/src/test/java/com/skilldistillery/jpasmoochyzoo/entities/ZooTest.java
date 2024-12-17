package com.skilldistillery.jpasmoochyzoo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpasmoochyzoo.entities.Zoo;
import com.skilldistillery.jpasmoochyzoo.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ZooTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Zoo zoo;

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

		zoo = em.find(Zoo.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		zoo = null;
	}

	@Test
	void test_ZooTable_basic_mappings() {
		assertNotNull(zoo);
		assertEquals(1, zoo.getId());
		assertEquals("Smoochy Zoo", zoo.getName());
		assertEquals("The happy zoo of smoochy land", zoo.getAbout());
		assertEquals("Denver",zoo.getAddress().getCity());
		assertEquals("Smoochy's Zoo Anniversary ",zoo.getEventList().get(1).getName());
		
		
	}
}
