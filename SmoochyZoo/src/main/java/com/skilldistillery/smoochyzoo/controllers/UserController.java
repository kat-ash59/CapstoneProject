package com.skilldistillery.smoochyzoo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jpasmoochyzoo.entities.Animal;
import com.skilldistillery.jpasmoochyzoo.entities.User;
import com.skilldistillery.smoochyzoo.data.AnimalDAO;
import com.skilldistillery.smoochyzoo.data.UserDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private UserDAO userDAO;
	private AnimalDAO animalDAO;

	// Constructor injection for DAO
	public UserController(UserDAO userDAO, AnimalDAO animalDAO) {
		this.userDAO = userDAO;
		this.animalDAO = animalDAO;
	}

	// Homepage with Login Form and Animal Info
	@RequestMapping("index.do")
	public String getHomePage(HttpSession session, Model model) {
		// Check if the user is already logged in, if so, redirect to the home page
		if (session.getAttribute("loggedInUser") != null) {
			return "redirect:index.do";
		}

		// Fetch animals from the DAO
		List<Animal> animals = animalDAO.findAllAnimals(); // Method to get all animals

		// Add the animals to the model
		model.addAttribute("animals", animals);

		// Return the home page
		return "index";
	}

	// Method to handle the login attempt
	@PostMapping("login.do")
	public String attemptLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, Model model) {

		// Find the user by username and password
		User validUser = userDAO.getUserByUserNameAndPassword(username, password);

		// If the user is found and enabled, proceed
		if (validUser != null && validUser.getEnabled()) {
			session.setAttribute("loggedInUser", validUser); // Store the user in the session

			// Redirect based on user type (staff or member)
			if ("keeper".equals(validUser.getRoles())) {
				return "redirect:staffHome.do"; // Redirect to the staff home page
			} else if ("member".equals(validUser.getRoles())) {
				return "redirect:memberHome.do"; // Redirect to the member home page
			}
		}

		// If login fails, add an error message and return to login page
		model.addAttribute("errorMessage", "Invalid username or password.");
		return "index";
	}

	// Logout method
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser"); // Remove the user from the session
		return "redirect:index.do"; // Redirect to the index or login page after logout

	}
}
