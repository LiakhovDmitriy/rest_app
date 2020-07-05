package com.gmail.dimaliahov.repository;

import com.gmail.dimaliahov.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
