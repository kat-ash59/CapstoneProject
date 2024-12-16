package com.skilldistillery.smoochyzoo.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpasmoochyzoo.entities.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Category findCategoryById(int id)
	{
		Category category = null;
		
		category = em.find(Category.class, id);
		
		return category;
		
	}
	
	@Override
	public List<Category> findAllCategories()
	{
		List<Category> categoryList = new ArrayList<>();
		String jpql = "Select categorys from Category categorys";
		
		categoryList = em.createQuery(jpql, Category.class).getResultList();
		
		return categoryList;
	}
	
	
	@Override
	public Category addCategory(Category category)
	{
		category.setIsActive(1);
		em.persist(category);


		// return the Category object
		System.out.println(category.toString());
		
		return category;
		
	} // end add category
	
	@Override
	public Category updateCategory(Category category)
	{
		Category updatedCategory = null;
		
		if (category == null)
		{
			return null;
		}
		
		updatedCategory = em.find(Category.class, category.getId());
		
		if ((!category.getName().isEmpty()) && (!category.getName().isBlank()) && (!category.getName().equals(null)))
		{
				updatedCategory.setName(category.getName());
		}
		
		if ((!category.getDescription().isEmpty()) && (!category.getDescription().isBlank()) && (!category.getDescription().equals(null)))
		{
				updatedCategory.setName(category.getDescription());
		}
		
		if (category.getIsActive() == 1)
		{
			updatedCategory.setIsActive(1);
		}
		else
		{
			updatedCategory.setIsActive(0);
		}
		
		em.persist(updatedCategory);

		
		// return the updated Category object
		System.out.println("\nUpdated Category = " + updatedCategory.toString());
		
		return updatedCategory;
		
	} // end update category
	
	
	@Override
	public int deleteCategory(Category category)
	{
	
		Category managedCategory = null;
		int rowsDeleted = 0;
		
		if (category != null)
		{
			
			category.setIsActive(0);
			em.persist(category);
			
			rowsDeleted = 1;
		}
		
		return rowsDeleted;
		
	} // end delete category
}
