package com.skilldistillery.smoochyzoo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.SuggestedName;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SuggestedNameDAOImpl implements SuggestedNameDAO
{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public SuggestedName findSuggestedNameById(int id)
	{
		SuggestedName suggestedName = null;
		
		suggestedName = em.find(SuggestedName.class, id);
		
		return suggestedName;
		
	}
	
	@Override
	public List<SuggestedName> findAllCategories()
	{
		List<SuggestedName> suggestedNameList = new ArrayList<>();
		String jpql = "Select suggestedNames from SuggestedName suggestedNames";
		
		suggestedNameList = em.createQuery(jpql, SuggestedName.class).getResultList();
		
		return suggestedNameList;
	}
	
	
	@Override
	public SuggestedName addSuggestedName(SuggestedName suggestedName)
	{
		suggestedName.setIsActive(true);
		em.persist(suggestedName);


		// return the SuggestedName object
		System.out.println(suggestedName.toString());
		
		return suggestedName;
		
	} // end add suggestedName
	
	@Override
	public SuggestedName updateSuggestedName(SuggestedName suggestedName)
	{
		SuggestedName updatedSuggestedName = null;
		
		if (suggestedName == null)
		{
			return null;
		}
		
		updatedSuggestedName = em.find(SuggestedName.class, suggestedName.getId());
		
		if ((!suggestedName.getName().isEmpty()) && (!suggestedName.getName().isBlank()) && (!suggestedName.getName().equals(null)))
		{
				updatedSuggestedName.setName(suggestedName.getName());
		}
		
		if (suggestedName.getIsActive() == true)
		{
			updatedSuggestedName.setIsActive(true);
		}
		else
		{
			updatedSuggestedName.setIsActive(false);
		}
		
		em.persist(updatedSuggestedName);

		
		// return the updated SuggestedName object
		System.out.println("\nUpdated SuggestedName = " + updatedSuggestedName.toString());
		
		return updatedSuggestedName;
		
	} // end update suggestedName
	
	
	@Override
	public int deleteSuggestedName(SuggestedName suggestedName)
	{
		int rowsDeleted = 0;
		
		if (suggestedName != null)
		{			
			suggestedName.setIsActive(false);
			em.persist(suggestedName);
			
			rowsDeleted = 1;
		}
		
		return rowsDeleted;
		
	} // end delete suggestedName
}
