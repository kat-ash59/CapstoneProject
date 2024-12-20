package com.skilldistillery.smoochyzoo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		User loggedInUser = (User) session.getAttribute("loggedInUser");
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
		return "index";
	}

	@RequestMapping("login.do")
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

		// If the user is found and enabled, proceed
		if (validUser != null && validUser.getEnabled()) {
			session.setAttribute("loggedInUser", validUser); // Store the user in the session

			// Check user role and redirect accordingly
			if (validUser.getRoles().stream().anyMatch(r -> r.getName().equals("keeper"))) {
				return "redirect:staffHome.do"; // Redirect to the staff home page
			} else if (validUser.getRoles().stream().anyMatch(r -> r.getName().equals("member"))) {
				return "redirect:memberHome.do"; // Redirect to the member home page
			}
		}

		// If login fails, add an error message and return to login page
		model.addAttribute("errorMessage", "Invalid username or password.");
		return "index"; // Return to the login page
	}

	@RequestMapping("staffHome.do")
	public String staffHome(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null || loggedInUser.getRoles().stream().noneMatch(r -> r.getName().equals("keeper"))) {
            return "redirect:index.do"; // Redirect to homepage if not logged in or not staff
        }

        return "staffHome"; // Return staff home JSP
	}

	@RequestMapping("memberHome.do")
	public String memberHome(HttpSession session, Model model) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null || loggedInUser.getRoles().stream().noneMatch(r -> r.getName().equals("member"))) {
            return "redirect:index.do"; // Redirect to homepage if not logged in or not member
        }

        return "memberHome"; // Return member home JSP
	}

	// Logout method
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser"); // Remove the user from the session
		return "redirect:index.do"; // Redirect to the index or login page after logout

	}
}
