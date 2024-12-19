package com.skilldistillery.jpasmoochyzoo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SuggestedNameTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private SuggestedName suggstedName;

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

		suggstedName = em.find(SuggestedName.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		suggstedName = null;
	}

	@Test
	void test_SuggestedNameTable_basic_mappings() {
		assertNotNull(suggstedName);
		assertEquals(1, suggstedName.getId());
		assertEquals("Bob", suggstedName.getName());
		assertEquals(null,suggstedName.getActive());

	}
}
