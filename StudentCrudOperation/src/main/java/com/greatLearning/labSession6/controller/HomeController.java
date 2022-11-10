package com.greatLearning.labSession6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.labSession6.repository.StudentRepository;
import com.greatLearning.labSession6.service.StudentService;

import org.springframework.ui.Model;

@Controller
public class HomeController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/")
	public String home(Model model) {

		model.addAttribute("students", studentService.findAllStudents());
		return "Hello";
	}
}
