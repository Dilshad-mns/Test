package com.example.Test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Repository.StudentRepository;
import com.example.Test.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository  studentRepository;
	
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach((Student student)-> students.add(student));
		return students;
	}
	
	public void removeAll() {
		studentRepository.deleteAll();
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public boolean removeById(Long id) {
		Optional<Student> student = getStudentById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
