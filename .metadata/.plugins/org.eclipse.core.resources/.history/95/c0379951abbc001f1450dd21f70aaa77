package com.skilldistillery.jpasmoochyzoo.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpasmoochyzoo.entities.SuggestedName;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SuggestedNameTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private SuggestedName suggestedName;

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

		suggestedName = em.find(SuggestedName.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		suggestedName = null;
	}

	@Test
	void test_SuggestedNameTable_basic_mappings() {
		assertNotNull(suggestedName);
		assertEquals(1, suggestedName.getId());
		assertEquals("Bob", suggestedName.getName());
		
		
		
	}
}
