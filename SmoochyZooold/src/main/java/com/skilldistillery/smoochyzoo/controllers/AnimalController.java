package src.main.java.com.skilldistillery.smoochyzoo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AnimalController 
{
	private final AnimalDAO animalDAO;
	
	public AnimalController(AnimalDAO dao)
	{
		this.animalDAO = dao;
	}
	
	@GetMapping(path = { "/", "home.do", "index.do" })
	public String index(Model model) 
	{
		return "home";
	}
	
	@GetMapping("getAnimal.do")
	public ModelAndView getAnimalById(@RequestParam("animalId" ) int id   ) {
		ModelAndView mv = new ModelAndView();
		Animal theAnimal = animalDAO.findAnimalById(id);
		mv.addObject("film", theAnimal);
		mv.setViewName("showanimalinfo");
		
		return mv;
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
}
