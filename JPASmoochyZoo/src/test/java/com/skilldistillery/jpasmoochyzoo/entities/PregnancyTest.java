package com.skilldistillery.jpasmoochyzoo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpasmoochyzoo.entities.Pregnancy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PregnancyTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Pregnancy pregnancy;

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

		pregnancy = em.find(Pregnancy.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		pregnancy = null;
	}

	@Test
	void test_PregnancyTable_basic_mappings() {
		assertNotNull(pregnancy);
		assertEquals(1, pregnancy.getId());
		assertEquals(Date.valueOf("2025-02-01"), pregnancy.getExpectedArrival());
		assertEquals(3, pregnancy.getNumberOfExpectedOffspring());
	}

}
