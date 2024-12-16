package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;

public interface AnimalDAO 
{
	public Animal findAnimalById(int id);
	
	public List<Animal> findAllAnimals();
	
	public Animal addAnimal(Animal animal);
	
	public Animal updateAnimal(Animal animal);

	public int deleteAnimal(Animal animal);

}
