package com.imaginnovate.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.test.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
