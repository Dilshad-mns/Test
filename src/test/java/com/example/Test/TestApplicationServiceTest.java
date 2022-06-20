package com.example.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.Test.Repository.StudentRepository;
import com.example.Test.entity.Student;
import com.example.Test.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class TestApplicationServiceTest {
	
	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentService studentService;
	
	private Student student;
	
	@BeforeEach
	public void setup() {
		student = Student.builder()
				.id(1L)
				.email("mohammaddilshad753@gmail.com")
				.name("Mohammad Dilshad")
				.build();
	}
	
	@Test
	public void id_not_null() {
		assertThat(student.getId()).isNotNull();
	}
	
	@Test
	public void givenSaveStudentReturnSavedStudent() {
//		given(studentRepository.findById(student.getId())).willReturn(Optional.empty());
		given(studentRepository.save(student)).willReturn(student);
		
		Student savedStudent = studentService.addStudent(student);
		System.out.println(savedStudent.toString());
		assertThat(savedStudent).isNotNull();
		verify(studentRepository).save(student);
	}
	
	@Test
	public void givenStudent_deleteStudent_returnEmptyList() {
		studentService.removeAll();
		
		assertThat(studentRepository.findAll()).isEmpty();
		verify(studentRepository).deleteAll();
	}
	
	@Test
	public void givenStudent_deleteStudentById_findById_returnEmpty() {
		studentService.removeById(1L);
		
		assertThat(studentRepository.findById(1L)).isEmpty();
		verify(studentRepository).deleteById(1L);
	}
	
//	@Test
//	public 
}
