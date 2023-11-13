package com.personal.Spring.data.jpa.tutorial.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.Spring.data.jpa.tutorial.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFirstName(String firstName);
	public List<Student> findByFirstNameContaining(String Name);
	
	
	// JPQL query
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public String findByemailId(String emailId);
	// for complex operation jpa also support native SQL queries
	// Nativve Query with named param
	@Query(value  = "SELECT * FROM tbl_student s where s.email_address = :emailId",nativeQuery = true )   
	Student getStudentByEmailIdNative(@Param("emailId") String emailId);
	
	
	
	//Modifying existing data using modifying and transactional annotation
	
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = :name where email_address = :mail",nativeQuery = true)
	int changeNamebyEmailIdGiven(@Param("name") String name, @Param("mail") String emailId);
	
}
