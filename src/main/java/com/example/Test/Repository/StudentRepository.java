package com.example.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
