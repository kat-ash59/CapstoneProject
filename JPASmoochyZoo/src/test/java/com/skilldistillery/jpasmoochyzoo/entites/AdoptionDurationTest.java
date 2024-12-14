package com.skilldistillery.jpasmoochyzoo.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.skilldistillery.jpasmoochyzoo.entities.AdoptionDuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AdoptionDurationTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private AdoptionDuration adoptionDuration;

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

		adoptionDuration = em.find(AdoptionDuration.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		adoptionDuration = null;
	}

	@Test
	void test_ZooTable_basic_mappings() {
		assertNotNull(adoptionDuration);
		assertEquals(1, adoptionDuration.getId());
		assertEquals("Month", adoptionDuration.getDuration());
		
		
		
	}
}
