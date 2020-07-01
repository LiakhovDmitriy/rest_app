package com.gmail.dimaliahov.repository;

import com.gmail.dimaliahov.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
