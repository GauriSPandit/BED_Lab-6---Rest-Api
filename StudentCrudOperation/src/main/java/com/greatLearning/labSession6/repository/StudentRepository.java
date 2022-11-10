package com.greatLearning.labSession6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.labSession6.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
