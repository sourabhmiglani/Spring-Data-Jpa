package com.personal.Spring.data.jpa.tutorial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.Spring.data.jpa.tutorial.entity.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long>{

}
