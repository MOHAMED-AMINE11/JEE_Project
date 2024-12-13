package com.GestionSurveillance.JEE.repositories;

import com.GestionSurveillance.JEE.entities.Local;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{
	
	List<Local> findByNomContainingIgnoreCase(String nom);
    List<Local> findByEstDisponible(boolean estDisponible);    
}
