package com.skilldistillery.jpasmoochyzoo.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpasmoochyzoo.entities.Role;
import com.skilldistillery.jpasmoochyzoo.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RoleTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private Role role;

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

		role = em.find(Role.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		role = null;
	}

	@Test
	void test_RoleTable_basic_mappings() {
		assertNotNull(role);
		assertEquals(1, role.getId());
		assertEquals("member", role.getName());

	}
}
