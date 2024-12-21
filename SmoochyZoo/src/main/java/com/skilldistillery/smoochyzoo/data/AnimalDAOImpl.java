package com.skilldistillery.smoochyzoo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;
import com.skilldistillery.jpasmoochyzoo.entities.Category;
import com.skilldistillery.jpasmoochyzoo.entities.Species;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AnimalDAOImpl implements AnimalDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Animal findAnimalById(int id) {
		Animal animal = null;

		animal = em.find(Animal.class, id);

		return animal;

	}

	@Override
	public List<Animal> findAllAnimals() {
		List<Animal> animalList = new ArrayList<>();
		String jpql = "Select animals from Animal animals";

		animalList = em.createQuery(jpql, Animal.class).getResultList();

		int size = animalList.size();

		return animalList;
	}

	@Override
	public List<Animal> findAnimalsByCategory(int id) {
		Category cat = em.find(Category.class, id);

		List<Animal> animalList = cat.getAnimalList();

		int size = animalList.size();

		return animalList;
	}

	@Override
	public List<Animal> findAnimalsBySpecies(int id) {
		Species spec = em.find(Species.class, id);

		List<Animal> animalList = spec.getAnimalList();

		int size = animalList.size();

		return animalList;
	}

	@Override
	public List<Animal> findAnimalsByName(String nameRequested) {
		List<Animal> animalList = null;

		String jpql = "Select animals from Animal animals where name = :nameRequested";
		animalList = em.createQuery(jpql, Animal.class).setParameter("nameRequested", nameRequested).getResultList();

		int size = animalList.size();

		return animalList;
	}

	@Override
	public Animal addAnimal(Animal animal) {

		animal.setActive(true);

		em.persist(animal);

		return em.find(Animal.class, animal.getId());

	} // end add animal

	@Override
	public Animal updateAnimal(Animal animal) {
		Animal updatedAnimal = null;

		if (animal == null) {
			return null;
		}

		updatedAnimal = em.find(Animal.class, animal.getId());

		if ((!animal.getName().isEmpty()) && (!animal.getName().isBlank()) && (!animal.getName().equals(null))) {
			updatedAnimal.setName(animal.getName());
		}

		if (animal.getCategory() != null) {
			updatedAnimal.setCategory(animal.getCategory());
		}

		if (animal.getSpecies() != null) {
			updatedAnimal.setSpecies(animal.getSpecies());
		}

		if (animal.getMom() != null) {
			updatedAnimal.setMom(animal.getMom());
		}

		if (animal.getDad() != null) {
			updatedAnimal.setDad(animal.getDad());
		}

		if (animal.isActive() == true) {
			updatedAnimal.setActive(true);
		} else {
			updatedAnimal.setActive(false);
		}

		em.persist(updatedAnimal);

		// return the updated Animal object
		// System.out.println("\nUpdated Animal = " + updatedAnimal.toString());

		return updatedAnimal;

	} // end update animal

	@Override
	public int deleteAnimal(Animal animal) {

		int rowsDeleted = 0;

		if (animal != null) {

			animal.setActive(false);

			em.persist(animal);

			rowsDeleted = 1;
		}

		return rowsDeleted;

	} // end delete animal
}
