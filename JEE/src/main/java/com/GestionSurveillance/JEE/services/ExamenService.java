package com.GestionSurveillance.JEE.services;

import com.GestionSurveillance.JEE.entities.Examen;
import com.GestionSurveillance.JEE.entities.Local;
import com.GestionSurveillance.JEE.repositories.ExamenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.GestionSurveillance.JEE.repositories.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamenService {

	@Autowired
	private ExamenRepository examenRepository;

	@Autowired
	private LocalRepository localRepository;

	public List<Examen> getExamens() {
		return examenRepository.findAll();
	}

	public Examen getExamenById(Long id) {
		return examenRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Examen introuvable"));
	}

	@Transactional
	public Examen createExamen(Examen examen) {
		// Récupérer les entités Local correspondantes aux id
		List<Local> locaux = new ArrayList<>();
		for (Local local : examen.getLocaux()) {
			Local localEntity = localRepository.findById(local.getId())
					.orElseThrow(() -> new RuntimeException("Local introuvable"));
			locaux.add(localEntity);
		}

		// Associer les locaux à l'examen
		examen.setLocaux(locaux);

		// Enregistrer l'examen dans la base de données
		return examenRepository.save(examen);
	}

	public void deleteExam(Long examenId) {
		Examen examen = examenRepository.findById(examenId)
				.orElseThrow(() -> new RuntimeException("Examen introuvable"));

		// Supprime explicitement les associations
		examen.getLocaux().clear();
		examenRepository.save(examen);

		// Supprime l'examen après avoir nettoyé les associations
		examenRepository.delete(examen);
	}
}
