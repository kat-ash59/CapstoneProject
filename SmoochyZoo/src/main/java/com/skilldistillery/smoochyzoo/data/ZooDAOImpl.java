package com.skilldistillery.smoochyzoo.data;


import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.Zoo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ZooDAOImpl implements ZooDAO
{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Zoo findZooById(int id)
	{
		Zoo zoo = null;
		
		zoo = em.find(Zoo.class, id);
		
		return zoo;
		
	}
	

	@Override
	public List<Zoo> findZoosByName(String nameRequested)
	{
		List<Zoo> zooList = null;
		
		String jpql = "Select zoos from Zoo zoos where name = :nameRequested";
		zooList = em.createQuery(jpql,Zoo.class)
				.setParameter("nameRequested",nameRequested).getResultList();
		
		zooList.size();
		
		return zooList;
	}
	
	
	@Override
	public Zoo addZoo(Zoo zoo)
	{
		zoo.setActive(true);
		
		em.persist(zoo);


		// return the Zoo object
		System.out.println(zoo.toString());
		
		return zoo;
		
	} // end add zoo
	
	@Override
	public Zoo updateZoo(Zoo zoo)
	{
		Zoo updatedZoo = null;
		
		if (zoo == null)
		{
			return null;
		}
		
		updatedZoo = em.find(Zoo.class, zoo.getId());
		
		if ((!zoo.getName().isEmpty()) && (!zoo.getName().isBlank()) && (!zoo.getName().equals(null)))
		{
				updatedZoo.setName(zoo.getName());
		}
		
		if ((!zoo.getAbout().isEmpty()) && (!zoo.getAbout().isBlank()) && (!zoo.getAbout().equals(null)))
		{
				updatedZoo.setAbout(zoo.getAbout());
		}
		
		if (zoo.getActive() == true)
		{
			zoo.setActive(true);
		}
		else
		{
			zoo.setActive(false);
		}
		
		em.persist(updatedZoo);

		
		// return the updated Zoo object
		System.out.println("\nUpdated Zoo = " + updatedZoo.toString());
		
		return updatedZoo;
		
	} // end update zoo
	
	
	@Override
	public int deleteZoo(Zoo zoo)
	{
	
		int rowsDeleted = 0;
		
		if (zoo != null)
		{
			zoo.setActive(false);
			
			em.persist(zoo);
			
			rowsDeleted = 1;
		}
		
		return rowsDeleted;
		
	} // end delete zoo


} // end class Zoo
