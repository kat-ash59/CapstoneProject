package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.Species;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SpeciesDAOImpl implements SpeciesDAO
{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Species findSpeciesById(int id)
	{
		Species species = null;
		
		species = em.find(Species.class, id);
		
		return species;
		
	}
	
	@Override
	public List<Species> findAllSpecies()
	{
		List<Species> speciesList;
		String jpql = "Select species from Species species";
		
		speciesList = em.createQuery(jpql, Species.class).getResultList();
		
		return speciesList;
	}
	
	
	@Override
	public Species addSpecies(Species species)
	{
		species.setActive(true);
		
		em.persist(species);


		// return the Species object
		System.out.println(species.toString());
		
		return species;
		
	} // end add species
	
	@Override
	public Species updateSpecies(Species species)
	{
		Species updatedSpecies = null;
		
		if (species == null)
		{
			return null;
		}
		
		updatedSpecies = em.find(Species.class, species.getId());
		
		if ((!species.getName().isEmpty()) && (!species.getName().isBlank()) && (!species.getName().equals(null)))
		{
				updatedSpecies.setName(species.getName());
		}
		
		if ((!species.getDescription().isEmpty()) && (!species.getDescription().isBlank()) && (!species.getDescription().equals(null)))
		{
				updatedSpecies.setName(species.getDescription());
		}
		
		if (species.isActive() == true)
		{
			species.setActive(true);
		}
		else
		{
			species.setActive(false);
		}
		
		em.persist(updatedSpecies);

		
		// return the updated Species object
		System.out.println("\nUpdated Species = " + updatedSpecies.toString());
		
		return updatedSpecies;
		
	} // end update species
	
	
	@Override
	public int deleteSpecies(Species species)
	{
	
		int rowsDeleted = 0;
		
		if (species != null)
		{
			species.setActive(false);
			
			em.persist(species);
			
			rowsDeleted = 1;
		}
		
		return rowsDeleted;
		
	} // end delete species
}
