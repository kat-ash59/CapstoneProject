package com.skilldistillery.jpasmoochyzoo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Species 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="isActive")
	private Boolean active = false;
	
	@OneToMany(mappedBy="species")
	private List<Animal> animalList;

	public void addAnimalList(Animal animal) {
		if (animalList == null) {
			animalList =  new ArrayList<>();
		}
		
		if (!animalList.contains(animal)) {
			animalList.add(animal);
		}
	}
	
	public void removeAnimalList(Animal animal) {
		if ((animalList != null) && (animalList.contains(animal))) {
			animalList.remove(animal);
			animal.setActive(false);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}
	
	

	@Override
	public String toString() {
		return "Species [id=" + id + ", name=" + name + ", description=" + description + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Species other = (Species) obj;
		return id == other.id;
	}
	
	
	
} // end class Species
