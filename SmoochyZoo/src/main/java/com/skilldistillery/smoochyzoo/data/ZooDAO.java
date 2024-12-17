package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import com.skilldistillery.jpasmoochyzoo.entities.Address;
import com.skilldistillery.jpasmoochyzoo.entities.Animal;
import com.skilldistillery.jpasmoochyzoo.entities.Category;
import com.skilldistillery.jpasmoochyzoo.entities.Species;
import com.skilldistillery.jpasmoochyzoo.entities.Zoo;

public interface ZooDAO 
{

	public Zoo updateZoo(Zoo zoo);

	public Zoo findZooById(int id);

	public Zoo addZoo(Zoo zoo);

	public int deleteZoo(Zoo zoo);

	public List<Zoo> findZoosByName(String nameRequested);

}