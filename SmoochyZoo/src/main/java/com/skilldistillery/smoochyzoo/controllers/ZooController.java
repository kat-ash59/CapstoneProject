package com.skilldistillery.smoochyzoo.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpasmoochyzoo.entities.Address;
import com.skilldistillery.jpasmoochyzoo.entities.Zoo;
import com.skilldistillery.smoochyzoo.data.AnimalDAO;
import com.skilldistillery.smoochyzoo.data.UserDAO;
import com.skilldistillery.smoochyzoo.data.ZooDAO;

import org.springframework.ui.Model;

@Controller
public class ZooController {

	private ZooDAO zoodao;

	public ZooController(ZooDAO zooDAO) {
		this.zoodao = zooDAO;
	}

	@RequestMapping("zooInfo")
	public String showInfo() {
		return "zooInfo";
	}

}
