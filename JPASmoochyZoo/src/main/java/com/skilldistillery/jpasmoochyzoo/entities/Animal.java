package com.skilldistillery.jpasmoochyzoo.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Animal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private LocalDate birthday;
	
	private String gender;
	
	@Column(name="isactive")
	private Boolean active = false;
	

	@ManyToOne
	@JoinColumn(name="mom_Id")
	private Animal mom;
	
	
	@ManyToOne
	@JoinColumn(name="dad_Id")
	private Animal dad;

	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="species_id")
	private Species species;

	@OneToMany(mappedBy="animal")
	private List<Event> eventList;

	
	public Animal()
	{
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


	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}




	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}







	public Animal getMom() {
		return mom;
	}




	public void setMom(Animal mom) {
		this.mom = mom;
	}




	public Animal getDad() {
		return dad;
	}




	public void setDad(Animal dad) {
		this.dad = dad;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public Species getSpecies() {
		return species;
	}




	public void setSpecies(Species species) {
		this.species = species;
	}



	public List<Event> getEventList() {
		return eventList;
	}




	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
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
		Animal other = (Animal) obj;
		return id == other.id;
	}


	
	
} // end class Animal
