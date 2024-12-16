package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;
import com.skilldistillery.jpasmoochyzoo.entities.Category;
import com.skilldistillery.jpasmoochyzoo.entities.SuggestedName;

public interface SuggestedNameDAO 
{

	public SuggestedName findSuggestedNameById(int id);

	public List<SuggestedName> findAllCategories();

	public SuggestedName addSuggestedName(SuggestedName suggestedName);

	public SuggestedName updateSuggestedName(SuggestedName suggestedName);

	public int deleteSuggestedName(SuggestedName suggestedName);


}
