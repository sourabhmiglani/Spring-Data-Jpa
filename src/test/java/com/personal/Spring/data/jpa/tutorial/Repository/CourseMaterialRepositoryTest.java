package com.personal.Spring.data.jpa.tutorial.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.personal.Spring.data.jpa.tutorial.entity.Course;
import com.personal.Spring.data.jpa.tutorial.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void saveCourseMaterial() {
		Course course = Course.builder()
				         .title("DSA")
				         .credit(6)
				         .build();
		CourseMaterial courseMaterial = CourseMaterial.builder()
				                        .url("www.gogogle.com")
				                        .course(course) // mandatory
				                        .build();
		courseMaterialRepository.save(courseMaterial);
	}
	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> csmt = courseMaterialRepository.findAll();
		System.out.println(csmt);
	}
}
