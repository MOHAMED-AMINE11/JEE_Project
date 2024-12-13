package com.GestionSurveillance.JEE.controllers;

import com.GestionSurveillance.JEE.entities.Examen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.GestionSurveillance.JEE.services.ExamenService;

import java.util.List;

@RestController
@RequestMapping("/api/examens")
@CrossOrigin(origins = "http://localhost:5173")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping
    public ResponseEntity<List<Examen>> getExamens() {
        List<Examen> examens = examenService.getExamens();
        System.out.println("Examens récupérés dans le contrôleur: " + examens);
        return ResponseEntity.ok(examens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> getExamenById(@PathVariable Long id) {
        try {
            Examen examen = examenService.getExamenById(id);
            return ResponseEntity.ok(examen);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Examen> createExamen(@RequestBody Examen examen) {
        Examen createdExamen = examenService.createExamen(examen);
        return ResponseEntity.ok(createdExamen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        try {
            examenService.deleteExam(id);
            return ResponseEntity.noContent().build(); 
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); 
        }
    }
}
