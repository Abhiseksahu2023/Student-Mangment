package com.abhisek.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abhisek.sms.entity.Student;
import com.abhisek.sms.service.StudentService;

@Controller
public class StudentController {
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@Autowired
	private StudentService studentService;

	
//handler method to handle list students and return mode and view

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	@GetMapping("/students/new")
	public String createStudentForm( Model model) {
		//create student object to hold student
		Student student= new Student();
		model.addAttribute("student",student);
		return "create_student";
	
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		return "redirect:/students";	
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable Long id ,@ModelAttribute("student")Student student,Model model) {
		
		//get student from database bt id
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEamil(student.getEamil());
		//save updated student obj
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	//handler methd to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
}
