package com.fullstack.studentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.studentsystem.model.Student;
import com.fullstack.studentsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		return Optional.of(studentRepository.getReferenceById(id));
	}

	@Override
	public String deleteStudent(int id) {
		 studentRepository.deleteById(id);
		 return "Deleted successfully";
	}

	


}
