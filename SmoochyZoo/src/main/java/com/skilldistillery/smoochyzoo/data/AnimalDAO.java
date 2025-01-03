package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;
import com.skilldistillery.jpasmoochyzoo.entities.Category;
import com.skilldistillery.jpasmoochyzoo.entities.Species;

public interface AnimalDAO 
{
	public Animal findAnimalById(int id);
	
	public List<Animal> findAllAnimals();
	
	public Animal addAnimal(Animal animal);
	
	public Animal updateAnimal(Animal animal);

	public int deleteAnimal(Animal animal);

	public List<Animal> findAnimalsByCategory(int id);

	public List<Animal> findAnimalsBySpecies(int id);

	public List<Animal> findAnimalsByName(String nameRequested);

}
