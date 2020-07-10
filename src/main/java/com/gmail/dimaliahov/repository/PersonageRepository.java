package com.gmail.dimaliahov.repository;

import com.gmail.dimaliahov.model.Personage;
import org.springframework.data.repository.CrudRepository;

public interface PersonageRepository extends CrudRepository <Personage, Long> {
}
