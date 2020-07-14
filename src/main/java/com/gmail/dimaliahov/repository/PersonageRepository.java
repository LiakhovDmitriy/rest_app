package com.gmail.dimaliahov.repository;

import com.gmail.dimaliahov.model.Personage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonageRepository extends JpaRepository<Personage, Long> {
}
