package com.personal.Spring.data.jpa.tutorial.Repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.personal.Spring.data.jpa.tutorial.entity.Guardian;
import com.personal.Spring.data.jpa.tutorial.entity.Student;


@SpringBootTest
class StudentRepositoryTest {
       
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Guardian guardiann = Guardian.builder()
				           .name("Nik")
				           .email("Nik@1")
				           .mobile("990909")
				           .build();
		Student student = Student.builder()
				          .emailId("sourabh@12")
				          .firstName("Sourabh")
				          .lastName("Miglani")
//				          .guardianName("Sourabh")
//				          .guardianEmail("Sourabh@12")
//				          .guardianMobile("9999")
				          .guardian(guardiann)
				          .build();
				   studentRepository.save(student);
				   Guardian guardian1 = Guardian.builder()
				           .name("Nik")
				           .email("Nik@1")
				           .mobile("990909")
				           .build();
		Student student1 = Student.builder()
				          .emailId("shivam@12")
				          .firstName("Shivam")
				          .lastName("Singh")
//				          .guardianName("Sourabh")
//				          .guardianEmail("Sourabh@12")
//				          .guardianMobile("9999")
				          .guardian(guardian1)
				          .build();
		 studentRepository.save(student1);
	}
    @Test
    public void getStudents(){
    	List<Student> lst = new ArrayList<>();
    	lst = studentRepository.findAll();
    	System.out.println(lst);
    }
    @Test
    public void findStudentByfirstName() {
     List<Student> st =  new ArrayList<>();
     st = studentRepository.findByFirstName("Sourabh");
     System.out.println("Student: " + st);
    }
    @Test
    public void findStudentByfirstNameContaining() {
     List<Student> st =  new ArrayList<>();
     st = studentRepository.findByFirstNameContaining("S");
     System.out.println("Student" + st);
    }
    @Test
    public void findStudentbyMail() {
    	String string = studentRepository.findByemailId("Sourabh@12");
    	System.out.println("Output First Name " + string);
    }
    @Test
    public void getStudentByEmailbyNativeTest() {
    	 Student student = studentRepository.getStudentByEmailIdNative("Sourabh@12");
    	 System.out.println(student);
    }
    @Test
    public void changeNameByEmailId() {
    int	val = studentRepository.changeNamebyEmailIdGiven("Shivaum", "Shivam@12");
    	System.out.println(val);
    }
}
