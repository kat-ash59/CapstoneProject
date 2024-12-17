package com.skilldistillery.jpasmoochyzoo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpasmoochyzoo.entities.Address;
import com.skilldistillery.jpasmoochyzoo.entities.Event;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Event event;

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

		event = em.find(Event.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		event = null;
	}

	@Test
	void test_Event_basic_mappings() {
		assertNotNull(event);
		assertEquals("Fred's Birthday Celebration", event.getName());
		assertEquals(Timestamp.valueOf("2024-12-25 00:00:00"), event.getEventDate());
		assertEquals(1, event.getAnimal().getId());
		assertEquals(1, event.getZoo().getId());
	}
}
