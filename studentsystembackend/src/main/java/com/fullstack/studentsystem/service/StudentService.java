package com.fullstack.studentsystem.service;

import java.util.List;
import java.util.Optional;

import com.fullstack.studentsystem.model.Student;

public interface StudentService {

	public Student saveStudent(Student student) ;
	public List<Student> getAllStudents();
	public Optional<Student> getStudentById(int id);
	public String deleteStudent(int id);
//	public String updateById(int id);
}
