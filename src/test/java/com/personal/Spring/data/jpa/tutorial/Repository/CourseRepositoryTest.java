package com.personal.Spring.data.jpa.tutorial.Repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.personal.Spring.data.jpa.tutorial.entity.Course;
import com.personal.Spring.data.jpa.tutorial.entity.Teacher;
@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> lstCourses = courseRepository.findAll();
		System.out.println(lstCourses);
	}
	
	@Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
	 @Test
	    public void findAllPagination(){
	        Pageable firstPagewithThreeRecords =
	                PageRequest.of(0, 3);
	        Pageable secondPageWithTwoRecords = 
	                PageRequest.of(1,2);
	        
	        List<Course> courses =
	                courseRepository.findAll(secondPageWithTwoRecords)
	                        .getContent();

	        long totalElements =
	                courseRepository.findAll(secondPageWithTwoRecords)
	                .getTotalElements();

	        long totalPages =
	                courseRepository.findAll(secondPageWithTwoRecords)
	                .getTotalPages();

	        System.out.println("totalPages = " + totalPages);
	        
	        System.out.println("totalElements = " + totalElements);

	        System.out.println("courses = " + courses);
	    }
	 @Test
	    public void findAllSorting() {
	        Pageable sortByTitle =
	                PageRequest.of(
	                        0,
	                        2,
	                        Sort.by("title")
	                        );
	        Pageable sortByCreditDesc =
	                PageRequest.of(
	                        0,
	                        2,
	                        Sort.by("credit").descending()
	                );

	        Pageable sortByTitleAndCreditDesc =
	                PageRequest.of(
	                        0,
	                        2,
	                        Sort.by("title")
	                        .descending()
	                        .and(Sort.by("credit"))
	                );
	        
	        List<Course> courses
	                = courseRepository.findAll(sortByTitle).getContent();

	        System.out.println("courses = " + courses);
	    }
	

}
