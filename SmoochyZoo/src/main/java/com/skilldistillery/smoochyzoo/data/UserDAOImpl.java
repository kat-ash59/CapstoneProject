package com.skilldistillery.smoochyzoo.data;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDAOImpl implements UserDAO 
{

	@PersistenceContext
	private EntityManager em;
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
