package com.GestionSurveillance.JEE.repositories;

import com.GestionSurveillance.JEE.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long>{

}
