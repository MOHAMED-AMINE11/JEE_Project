package com.GestionSurveillance.JEE.controllers;

import com.GestionSurveillance.JEE.entities.Local;
import com.GestionSurveillance.JEE.services.LocalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locaux")
@CrossOrigin(origins = "http://localhost:5173") // Permet les requêtes CORS depuis le frontend
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping("/available")
    public ResponseEntity<List<Local>> getAvailableLocaux() {
        List<Local> locauxDisponibles = localService.getAvailableLocaux();
        return ResponseEntity.ok(locauxDisponibles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> getLocalById(@PathVariable Long id) {
        try {
            Local local = localService.getLocalById(id);
            return ResponseEntity.ok(local);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Local> createLocal(@RequestBody Local local) {
        Local newLocal = localService.createLocal(local);
        return ResponseEntity.ok(newLocal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> updateLocal(@PathVariable Long id, @RequestBody Local updatedLocal) {
        try {
            Local local = localService.updateLocal(id, updatedLocal);
            return ResponseEntity.ok(local);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocal(@PathVariable Long id) {
        try {
            localService.deleteLocal(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Local>> searchLocauxByNom(@RequestParam String nom) {
        List<Local> locaux = localService.findLocauxByNom(nom);
        return ResponseEntity.ok(locaux);
    }
}
