package com.skilldistillery.jpasmoochyzoo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpasmoochyzoo.entities.Species;
import com.skilldistillery.jpasmoochyzoo.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SpeciesTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Species species;

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

		species = em.find(Species.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		species = null;
	}

	@Test
	void test_SpeciesTable_basic_mappings() {
		assertNotNull(species);
		assertEquals(1, species.getId());
		assertEquals("Lion", species.getName());
		assertEquals("Fred",species.getAnimalList().getFirst().getName());
		
		
	}
}
