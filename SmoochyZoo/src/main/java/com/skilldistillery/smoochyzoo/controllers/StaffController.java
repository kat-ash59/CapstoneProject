package com.skilldistillery.smoochyzoo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	public class StaffController {

	  private final ZooService zooService;
	  private final AnimalService animalService;
	  private final ExpectingBoardService expectingBoardService;

	  // Constructor-based autowiring
	  public StaffController(ZooService zooService, AnimalService animalService, ExpectingBoardService expectingBoardService) {
	    this.zooService = zooService;
	    this.animalService = animalService;
	    this.expectingBoardService = expectingBoardService;
	  }

	  // Method to update personal information
	  @RequestMapping("updatePersonalInfo.do")
	  public String updatePersonalInfo(@RequestParam String name, @RequestParam String email) {
	    // Logic to update the staff's personal information
	    // For example, calling a service method to update personal info
	    zooService.updateStaffPersonalInfo(name, email);
	    return "redirect:/staffHome.jsp";  // After processing, redirect to the home page
	  }

	  // Method to add an animal
	  @RequestMapping("addAnimal.do")
	  public String addAnimal(@RequestParam String animalName, @RequestParam String species, @RequestParam String category) {
	    // Logic to add an animal
	    animalService.addAnimal(animalName, species, category);
	    return "redirect:/staffHome.jsp";
	  }

	  // Method to update an animal
	  @RequestMapping("updateAnimal.do")
	  public String updateAnimal(@RequestParam int animalId, @RequestParam String newName, @RequestParam String newSpecies) {
	    // Logic to update an animal's details
	    animalService.updateAnimal(animalId, newName, newSpecies);
	    return "redirect:/staffHome.jsp";
	  }

	  // Method to delete an animal
	  @RequestMapping("deleteAnimal.do")
	  public String deleteAnimal(@RequestParam int animalId) {
	    // Logic to delete an animal
	    animalService.deleteAnimal(animalId);
	    return "redirect:/staffHome.jsp";
	  }

	  // Method to add an expecting board entry
	  @RequestMapping("addExpectingBoardEntry.do")
	  public String addExpectingBoardEntry(@RequestParam String animalName, @RequestParam String expectedDate) {
	    // Logic to add an expecting board entry
	    expectingBoardService.addExpectingEntry(animalName, expectedDate);
	    return "redirect:/staffHome.jsp";
	  }

	  // Method to delete an expecting board entry
	  @RequestMapping("deleteExpectingBoardEntry.do")
	  public String deleteExpectingBoardEntry(@RequestParam int entryId) {
	    // Logic to delete an expecting board entry
	    expectingBoardService.deleteExpectingEntry(entryId);
	    return "redirect:/staffHome.jsp";
	  }

	  // Method to update zoo information
	  @RequestMapping("updateZooInfo.do")
	  public String updateZooInfo(@RequestParam String zooName, @RequestParam String about) {
	    // Logic to update zoo information
	    zooService.updateZooInfo(zooName, about);
	    return "redirect:/staffHome.jsp";
	  }

	  // Method to delete zoo information
	  @RequestMapping("deleteZooInfo.do")
	  public String deleteZooInfo() {
	    // Logic to delete zoo information
	    zooService.deleteZooInfo();
	    return "redirect:/staffHome.jsp";
	  }

	  // Logout method
	  @RequestMapping("logout.do")
	  public String logout() {
	    // Logic to log out the staff member
	    return "redirect:/login.jsp";  // Redirect to login page after logout
	  }
	}
