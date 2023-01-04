package com.abhisek.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisek.sms.entity.Student;
import com.abhisek.sms.repository.StudentRepository;
import com.abhisek.sms.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
private StudentRepository studentRepository;
public StudentServiceImpl(StudentRepository studentRepository) {
	super();
	this.studentRepository = studentRepository;
}

	@Override
	public List<Student> getAllStudents() {
		
	return studentRepository.findAll();
	
}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}
	
}