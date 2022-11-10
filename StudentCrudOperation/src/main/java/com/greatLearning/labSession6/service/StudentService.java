package com.greatLearning.labSession6.service;

import java.util.List;
import java.util.Optional;

import com.greatLearning.labSession6.entity.Student;

public interface StudentService {

	List<Student> findAllStudents();

	Optional<Student> findStudentById(int id);

	Student saveStudent(Student student);

	void deleteStudent(int id);

}
