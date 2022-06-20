package com.example.Test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;

import com.example.Test.entity.Student;
import com.example.Test.service.StudentService;


@RestController
@RequestMapping(path="/student")
public class StudentsController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/hello")
	public String getWelcomeMessage() {
		return "Hello There";
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		Optional<Student> student = studentService.getStudentById(id);
		
		return student.map(s->ResponseEntity.ok().body(s)).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll(){
		studentService.removeAll();
		return ResponseEntity.ok().body("All Entries Deleted Successfully");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		boolean isDeleted = studentService.removeById(id);
		if(isDeleted) {
			return ResponseEntity.ok().body("Entry deleted Syccessfully");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = studentService.getAllStudents();
		if(students.size()!=0) {
			return ResponseEntity.ok().body(students);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student s = studentService.addStudent(student);
		return ResponseEntity.ok().body(s);
	}
	
	
}
