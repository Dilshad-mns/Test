package com.example.Test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="student")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(name="name")
	@NonNull
	private String name;
	@Column(name="email")
	@NonNull
	private String email;
}
