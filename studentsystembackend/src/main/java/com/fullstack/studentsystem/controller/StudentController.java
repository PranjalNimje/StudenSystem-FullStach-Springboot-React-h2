package com.fullstack.studentsystem.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.studentsystem.model.Student;
import com.fullstack.studentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public boolean add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return true;
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Student> getStudentById(@PathVariable int id){
		Optional<Student> student = studentService.getStudentById(id);
		return student; 
	}
	
	 @DeleteMapping("/delete/{id}")
	    public String deleteStudent(@PathVariable int id) {
		 Optional<Student> student = studentService.getStudentById(id);
	        if(student.isPresent()) {
	            studentService.deleteStudent(id);
	            return "Student with ID " + id + " is deleted";
	        } else {
	            return "Student not found!";
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	 public String updateStudent(@PathVariable int id, @RequestBody Student student) {
		 System.out.println("Received Student: " + student);
		    Optional<Student> existingStudent = studentService.getStudentById(id);
		    if (existingStudent.isPresent()) {
		        student.setId(id);  // Ensure the student ID remains unchanged
		        studentService.saveStudent(student);  // Save or update the student
		        return "Student with ID " + id + " is updated";
		    } else {
		        return "Student not found!";
		    }
		}
}
