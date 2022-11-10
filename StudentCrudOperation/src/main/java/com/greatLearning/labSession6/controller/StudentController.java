package com.greatLearning.labSession6.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.greatLearning.labSession6.entity.Student;
import com.greatLearning.labSession6.service.StudentService;

@Controller
@RequestMapping(value = "/")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/editStudent")
	public String editStudent(@RequestParam("id") int id, Model model) {
		Student studentTemp = studentService.findStudentById(id).get();
		model.addAttribute("action", "Edit Student");
		model.addAttribute("student", studentTemp);
		return "add-update-form";
	}

	@RequestMapping("/addNewStudent")
	public String addNewStudent(Model model) {
		model.addAttribute("action", "Add New Student");
		return "add-update-form";
	}

	@PostMapping("/save")
	public String saveStudent(Model theModel, @RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		Student student = new Student();

		if (id != 0) { // checking wheather id is present, if yes customer is fetched and updated
						// accordingly
			Optional<Student> studentTemp = studentService.findStudentById(id);
			student = studentTemp.get();
		}
		student.setFirstName(firstName);// if id is not present data is added to new customer created
		student.setLastName(lastName);
		student.setCourse(course);
		student.setCountry(country);

		studentService.saveStudent(student);
		return "redirect:/";// redirecting to home page
	}

	@RequestMapping("/deleteStudents")

	public String deleteStudent(@RequestParam("id") int id, Model model) {

		Optional<Student> tempStudent = studentService.findStudentById(id);

		if (tempStudent == null) {
			throw new RuntimeException("Student id not found - " + id);
		}

		studentService.deleteStudent(id);

		return "redirect:/";
	}

}
