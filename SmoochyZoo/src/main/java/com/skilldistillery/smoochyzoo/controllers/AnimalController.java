package com.skilldistillery.smoochyzoo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;
import com.skilldistillery.jpasmoochyzoo.entities.Category;
import com.skilldistillery.jpasmoochyzoo.entities.Species;
import com.skilldistillery.smoochyzoo.data.AnimalDAO;
import com.skilldistillery.smoochyzoo.data.CategoryDAO;



@Controller
public class AnimalController 
{
	private final AnimalDAO animalDAO;
	
	
	public AnimalController(AnimalDAO dao)
	{
		this.animalDAO = dao;
	}
	
	@GetMapping("getAllAnimals.do")
	public ModelAndView findAllAnimals() {
		ModelAndView mv = new ModelAndView();
		List<Animal> animalList = new ArrayList<>();
		animalList = animalDAO.findAllAnimals();
		
		mv.addObject("animalList", animalList);
		mv.setViewName("showallanimals");
		
		return mv;
	}
	
	@GetMapping("getAnimalById.do")
	public ModelAndView getAnimalById(@RequestParam("animalId" ) int id   ) {
		ModelAndView mv = new ModelAndView();
		Animal theAnimal = animalDAO.findAnimalById(id);
		mv.addObject("animal", theAnimal);
		mv.setViewName("showanimalinfo");
		
		return mv;
	}
	
	@GetMapping("getAllAnimalsByName.do")
	public ModelAndView findAllAnimals1() {
		ModelAndView mv = new ModelAndView();
		List<Animal> animalList = new ArrayList<>();
		animalList = animalDAO.findAllAnimals();
		
		mv.addObject("animalList", animalList);
		mv.setViewName("showallanimals");
		
		return mv;
	}
	
	@GetMapping("getAllAnimalsByCategory.do")
	public ModelAndView findAnimalsByCategory(@RequestParam("categoryId" ) int id   ) {
		ModelAndView mv = new ModelAndView();
		List<Animal> animalList = animalDAO.findAnimalsByCategory(id);
		System.out.println("Animal list by category " + animalList.toString());
		mv.addObject("animalList", animalList);
		mv.setViewName("showallanimals");
		
		return mv;
	}
	
	@GetMapping("getAllAnimalsBySpecies.do")
	public ModelAndView findAnimalsBySpecies(@RequestParam("speciesId" ) int id   ) {
		ModelAndView mv = new ModelAndView();
		List<Animal> animalList =  animalDAO.findAnimalsBySpecies(id);
		
		mv.addObject("animalList", animalList);
		mv.setViewName("showallanimals");
		
		return mv;
	}
	
	@GetMapping(path="addAnimal.do")
	public ModelAndView addAnimal(Animal theAnimal)
	{
		ModelAndView mv = new ModelAndView();
		Animal animal = new Animal();
		
		try
		{

			
			if ((theAnimal.getName() != null) && (!theAnimal.getName().isEmpty()) && (!theAnimal.getName().isBlank()))
			{
				animal.setName(theAnimal.getName() );
			}
			
			if (theAnimal.getBirthday() != null)
			{
				animal.setBirthday(theAnimal.getBirthday());
			}
			
			if(theAnimal.getCategory() != null)
			{
				animal.setCategory(theAnimal.getCategory());
			}
			
			if ((theAnimal.getSpecies() != null))
			{
				animal.setSpecies(theAnimal.getSpecies());
			}
			
			if (theAnimal.getMom() != null)
			{
				animal.setMom(theAnimal.getMom());
			}
			
			if (theAnimal.getDad() != null)
			{
				animal.setMom(theAnimal.getDad());
			}
	/*		
			if ((theAnimal.getGender() != null) && (!theAnimal.getName().getGender()) && (!theAnimal.getGender().isBlank()))
			{
				animal.setGender(theAnimal.getGender());
			}
			
			if(theAnimal.isActive())
			{
				animal.setActive(theAnimal.isActive());
			}
			
			
			//System.out.println("the needle is " + needle.toString());
			theNewAnimal = animalDAO.addAnimal(animal);
			System.out.println("the new animal is " + theNewAnimal.toString());
			mv.addObject("animal", theNewAnimal);
			mv.setViewName("confirmAnimalInsert");
			
		*/	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
		return mv;
	}  // end add needle, hook or cable to database
	
	
	
}
