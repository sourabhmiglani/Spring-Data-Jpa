package com.personal.Spring.data.jpa.tutorial.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.personal.Spring.data.jpa.tutorial.entity.Course;
import com.personal.Spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
    TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course courseDBA = Course.builder() 
				        .title("DBA")  
				        .credit(5)  
				        .build();
		Course courseJava= Course.builder() 
		        .title("Java")  
		        .credit(6)  
		        .build();
 		Teacher teacher = Teacher.builder()
				                    .firstName("Sourabh")
				                    .lastName("Miglani")
//				                    .courses(List.of(courseDBA,courseJava))
				                    .build();
 		teacherRepository.save(teacher);
	}
}
