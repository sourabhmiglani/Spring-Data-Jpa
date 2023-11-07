package com.personal.Spring.data.jpa.tutorial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.Spring.data.jpa.tutorial.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	
	
}
