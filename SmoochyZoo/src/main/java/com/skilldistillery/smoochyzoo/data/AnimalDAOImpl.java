package com.skilldistillery.smoochyzoo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AnimalDAOImpl implements AnimalDAO
{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Animal findAnimalById(int id)
	{
		Animal animal = null;
		
		animal = em.find(Animal.class, id);
		
		return animal;
		
	}
	
	@Override
	public List<Animal> findAllAnimals()
	{
		List<Animal> animalList = new ArrayList<>();
		String jpql = "Select animals from Animal animals";
		
		animalList = em.createQuery(jpql, Animal.class).getResultList();
		
		return animalList;
	}
	
	
	@Override
	public Animal addAnimal(Animal animal)
	{
		
		animal.setIsActive(true);
		
		em.persist(animal);


		// return the Animal object
		System.out.println(animal.toString());
		
		return animal;
		
	} // end add animal
	
	@Override
	public Animal updateAnimal(Animal animal)
	{
		Animal updatedAnimal = null;
		
		if (animal == null)
		{
			return null;
		}
		
		updatedAnimal = em.find(Animal.class, animal.getId());
		
		if ((!animal.getName().isEmpty()) && (!animal.getName().isBlank()) && (!animal.getName().equals(null)))
		{
				updatedAnimal.setName(animal.getName());
		}
		
		if (animal.getCategory() != null)
		{
			updatedAnimal.setCategory(animal.getCategory());
		}
		
		if (animal.getSpecies() != null)
		{
			updatedAnimal.setSpecies(animal.getSpecies());
		}
		
		if (animal.getMom() != null)
		{
			updatedAnimal.setMom(animal.getMom());
		}
		
		if (animal.getDad() != null)
		{
			updatedAnimal.setDad(animal.getDad());
		}
		
		if (animal.getIsActive() == true)
		{
			updatedAnimal.setIsActive(true);
		}
		else
		{
			updatedAnimal.setIsActive(false);
		}
		
		em.persist(updatedAnimal);

		
		// return the updated Animal object
		System.out.println("\nUpdated Animal = " + updatedAnimal.toString());
		
		return updatedAnimal;
		
	} // end update animal
	
	
	@Override
	public int deleteAnimal(Animal animal)
	{
	
		int rowsDeleted = 0;
		
		if (animal != null)
		{

			animal.setIsActive(false);
			
			em.persist(animal);
			
			rowsDeleted = 1;
		}
		
		return rowsDeleted;
		
	} // end delete animal
}
