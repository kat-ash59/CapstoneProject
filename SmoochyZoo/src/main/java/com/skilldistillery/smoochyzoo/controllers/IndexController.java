package com.skilldistillery.smoochyzoo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skilldistillery.jpasmoochyzoo.entities.Category;
import com.skilldistillery.jpasmoochyzoo.entities.Species;
import com.skilldistillery.smoochyzoo.data.AnimalDAO;
import com.skilldistillery.smoochyzoo.data.CategoryDAO;
import com.skilldistillery.smoochyzoo.data.SpeciesDAO;



@Controller
public class IndexController 
{
	private final SpeciesDAO speciesDAO;
	private final CategoryDAO categoryDAO;

	public IndexController(SpeciesDAO speciesDAO, CategoryDAO categoryDAO)
	{
		this.speciesDAO = speciesDAO;
		this.categoryDAO = categoryDAO;
	}
	
		
		@GetMapping(path={"/","index.do"})
		public String index(Model model) 
		{
			List<Category> categoryList = categoryDAO.findAllCategories();
			List<Species> speciesList = speciesDAO.findAllSpecies();
			model.addAttribute("speciesList", speciesList);
			model.addAttribute("categoryList", categoryList);
			return "index";
		}
		
}
