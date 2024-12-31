package com.skilldistillery.smoochyzoo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;
import com.skilldistillery.jpasmoochyzoo.entities.Category;
import com.skilldistillery.jpasmoochyzoo.entities.Species;
import com.skilldistillery.jpasmoochyzoo.entities.User;
import com.skilldistillery.smoochyzoo.data.AnimalDAO;
import com.skilldistillery.smoochyzoo.data.CategoryDAO;
import com.skilldistillery.smoochyzoo.data.SpeciesDAO;
import com.skilldistillery.smoochyzoo.data.UserDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private UserDAO userDAO;
	private AnimalDAO animalDAO;

	private final SpeciesDAO speciesDAO;
	private final CategoryDAO categoryDAO;
	
	// Constructor injection for DAO
	public UserController(UserDAO userDAO, AnimalDAO animalDAO, SpeciesDAO speciesDAO, CategoryDAO categoryDAO ) {
		this.userDAO = userDAO;
		this.animalDAO = animalDAO;
		this.speciesDAO = speciesDAO; 
		this.categoryDAO = categoryDAO; 
	}

	// Homepage with Login Form and Animal Info
	@RequestMapping("index.do")
	public String getHomePage(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		List<Category> categoryList = categoryDAO.findAllCategories();
		List<Species> speciesList = speciesDAO.findAllSpecies();
		model.addAttribute("speciesList", speciesList);
		model.addAttribute("categoryList", categoryList);
		
	    if (loggedInUser != null) {
	        // Redirect to the correct page based on the user's role
	        if (loggedInUser.getRoles().stream().anyMatch(r -> r.getName().equals("keeper"))) {
	        	
	            return "redirect:staffHome.do";
	        } else if (loggedInUser.getRoles().stream().anyMatch(r -> r.getName().equals("member"))) {
	        	
	            return "redirect:memberHome.do";
	        }
	    }

		List<Animal> animals = animalDAO.findAllAnimals(); // Method to get all animals
		model.addAttribute("animals", animals);

		// Return the home page
		return "redirect:index.do";
	}

	
	@GetMapping("login.do")
	public String showLoginPage(@RequestParam("role") String role, Model model) {
		model.addAttribute("role", role);
		return "login";
	}

	// Method to handle the login attempt
	@PostMapping("login.do")
	public String attemptLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("role") String role, HttpSession session, Model model) {

		// Find the user by username and password
		User validUser = userDAO.getUserByUserNameAndPassword(username, password);

		List<Category> categoryList = categoryDAO.findAllCategories();
		List<Species> speciesList = speciesDAO.findAllSpecies();
		model.addAttribute("speciesList", speciesList);
		model.addAttribute("categoryList", categoryList);
		
		// If the user is found and enabled, proceed
		if (validUser != null && validUser.getEnabled()) {
			session.setAttribute("loggedInUser", validUser); // Store the user in the session

			// Check user role and redirect accordingly
			if (validUser.getRoles().stream().anyMatch(r -> r.getName().equals("keeper"))) {
				categoryList = categoryDAO.findAllCategories();
				speciesList = speciesDAO.findAllSpecies();
				model.addAttribute("speciesList", speciesList);
				model.addAttribute("categoryList", categoryList);
				return "redirect:staffHome.do"; // Redirect to the staff home page
			} else if (validUser.getRoles().stream().anyMatch(r -> r.getName().equals("member"))) {
				categoryList = categoryDAO.findAllCategories();
				speciesList = speciesDAO.findAllSpecies();
				model.addAttribute("speciesList", speciesList);
				model.addAttribute("categoryList", categoryList);
				return "redirect:memberHome.do"; // Redirect to the member home page
			}
		}

		// If login fails, add an error message and return to login page
		model.addAttribute("errorMessage", "Invalid username or password.");

		return "redirect:index.do"; // Return to the login page

	}

	@RequestMapping("staffHome.do")
	public String staffHome(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null || loggedInUser.getRoles().stream().noneMatch(r -> r.getName().equals("keeper"))) {
            return "redirect:index.do"; // Redirect to homepage if not logged in or not staff
        }

		List<Category> categoryList = categoryDAO.findAllCategories();
		List<Species> speciesList = speciesDAO.findAllSpecies();
		model.addAttribute("speciesList", speciesList);
		model.addAttribute("categoryList", categoryList);
        return "staffHome"; // Return staff home JSP
	}

	@RequestMapping("memberHome.do")
	public String memberHome(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null || loggedInUser.getRoles().stream().noneMatch(r -> r.getName().equals("member"))) {
            return "redirect:index.do"; // Redirect to homepage if not logged in or not member
        }

        List<Category> categoryList = categoryDAO.findAllCategories();
		List<Species> speciesList = speciesDAO.findAllSpecies();
		model.addAttribute("speciesList", speciesList);
		model.addAttribute("categoryList", categoryList);
        return "memberHome"; // Return member home JSP
	}

	// Logout method
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser"); // Remove the user from the session
		return "redirect:index.do"; // Redirect to the index or login page after logout

	}
}