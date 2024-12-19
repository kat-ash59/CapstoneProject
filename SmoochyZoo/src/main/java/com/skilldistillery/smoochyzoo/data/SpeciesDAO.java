package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import com.skilldistillery.jpasmoochyzoo.entities.Species;

public interface SpeciesDAO 
{

	public Species findSpeciesById(int id);

	public List<Species> findAllSpecies();

	public Species addSpecies(Species species);

	public Species updateSpecies(Species species);

	int deleteSpecies(Species species);

	

}
