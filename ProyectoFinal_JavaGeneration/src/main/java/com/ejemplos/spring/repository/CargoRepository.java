package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
