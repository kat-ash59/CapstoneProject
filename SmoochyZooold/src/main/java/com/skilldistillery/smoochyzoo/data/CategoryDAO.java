package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import com.skilldistillery.jpasmoochyzoo.entities.Category;

public interface CategoryDAO 
{

	public int deleteCategory(Category category);

	public Category updateCategory(Category category);

	public Category addCategory(Category category);

	public List<Category> findAllCategories();

	public Category findCategoryById(int id);
	

}
