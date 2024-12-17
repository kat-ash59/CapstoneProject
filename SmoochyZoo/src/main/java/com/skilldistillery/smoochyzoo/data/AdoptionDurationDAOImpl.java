package com.skilldistillery.smoochyzoo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.AdoptionDuration;
import com.skilldistillery.jpasmoochyzoo.entities.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdoptionDurationDAOImpl implements AdoptionDurationDAO
{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public AdoptionDuration findAdoptionDurationById(int id)
	{
		AdoptionDuration adoptionDuration = null;
		
		adoptionDuration = em.find(AdoptionDuration.class, id);
		
		return adoptionDuration;
		
	}
	
	@Override
	public List<AdoptionDuration> findAllAdoptionDurations()
	{
		List<AdoptionDuration> adoptionDurationList = new ArrayList<>();
		String jpql = "Select adoptionDurations from AdoptionDuration adoptionDurations";
		
		adoptionDurationList = em.createQuery(jpql, AdoptionDuration.class).getResultList();
		
		return adoptionDurationList;
	}
	
	
	@Override
	public AdoptionDuration addAdoptionDuration(AdoptionDuration adoptionDuration)
	{
		adoptionDuration.setIsActive(true);
		
		em.persist(adoptionDuration);


		// return the AdoptionDuration object
		System.out.println(adoptionDuration.toString());
		
		return adoptionDuration;
		
	} // end add adoptionDuration
	
	@Override
	public AdoptionDuration updateAdoptionDuration(AdoptionDuration adoptionDuration)
	{
		AdoptionDuration updatedAdoptionDuration = null;
		
		if (adoptionDuration == null)
		{
			return null;
		}
		
		updatedAdoptionDuration = em.find(AdoptionDuration.class, adoptionDuration.getId());
		
		if ((!adoptionDuration.getDuration().isEmpty()) && (!adoptionDuration.getDuration().isBlank()) && (!adoptionDuration.getDuration().equals(null)))
		{
				updatedAdoptionDuration.setDuration(adoptionDuration.getDuration());
		}
		
		if (adoptionDuration.getIsActive() == true)
		{
			updatedAdoptionDuration.setIsActive(true);
		}
		else
		{
			updatedAdoptionDuration.setIsActive(false);
		}
		
		
		
		em.persist(updatedAdoptionDuration);

		
		// return the updated AdoptionDuration object
		System.out.println("\nUpdated AdoptionDuration = " + updatedAdoptionDuration.toString());
		
		return updatedAdoptionDuration;
		
	} // end update adoptionDuration
	
	
	@Override
	public int deleteAdoptionDuration(AdoptionDuration adoptionDuration)
	{
	
		int rowsDeleted = 0;
		
		if (adoptionDuration != null)
		{			
			adoptionDuration.setIsActive(false);
			
			em.persist(adoptionDuration);
			
			rowsDeleted = 1;
		}
		
		return rowsDeleted;
		
	} // end delete adoptionDuration


}