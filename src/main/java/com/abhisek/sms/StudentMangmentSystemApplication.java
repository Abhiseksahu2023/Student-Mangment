package com.abhisek.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abhisek.sms.entity.Student;
import com.abhisek.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentMangmentSystemApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(StudentMangmentSystemApplication.class, args);
	}
@Autowired
private StudentRepository  studentRepository;
	@Override
	public void run(String... args) throws Exception {
		Student s1= new Student("Abhisek","sahu","abhisek@gmail.com");
		studentRepository.save(s1);
		Student s2= new Student("Sonali","choudhury","sonali@gmail.com");
		studentRepository.save(s2);
		Student s3= new Student("Sambeet","sahu","sambeet@gmail.com");
		studentRepository.save(s3);
		Student s4= new Student("Anil","kumar","anil@gmail.com");
		studentRepository.save(s4);
		Student s5= new Student("sindhu","apple","sindhu@gmail.com");
		studentRepository.save(s5);
	
	}

}
