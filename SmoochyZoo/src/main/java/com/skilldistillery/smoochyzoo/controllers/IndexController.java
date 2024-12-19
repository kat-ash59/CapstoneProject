package com.skilldistillery.smoochyzoo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skilldistillery.jpasmoochyzoo.entities.Species;
import com.skilldistillery.smoochyzoo.data.AnimalDAO;
import com.skilldistillery.smoochyzoo.data.SpeciesDAO;



@Controller
public class IndexController 
{
	private final SpeciesDAO speciesDAO;

	public IndexController(SpeciesDAO speciesDAO)
	{
		this.speciesDAO = speciesDAO;
	}
	
		
		@GetMapping(path={"/","index.do"})
		public String index(Model model) 
		{
			List<Species> speciesList = speciesDAO.findAllSpecies();
			model.addAttribute("speciesList", speciesList);
			return "index";
		}
		
}
