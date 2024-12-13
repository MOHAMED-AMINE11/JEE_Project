package com.GestionSurveillance.JEE.services;

import com.GestionSurveillance.JEE.entities.Departement;
import com.GestionSurveillance.JEE.entities.Enseignant;
import com.GestionSurveillance.JEE.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartementService {
	
	@Autowired
    private DepartementRepository departementRepository;
	
	public List<Departement> getAllDepartements(){
	return departementRepository.findAll();
	}
	
	public Departement getDepartementById(Long id) {
		return departementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Département introuvable"));
	}

	
	public Departement createDepartement(Departement departement) {

		return this.departementRepository.save(departement);
	}

	public void deleteDepartement(Long id) {
		Departement departement = departementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Département non trouvé"));
		departementRepository.delete(departement);
	}

	public Departement updateDepartement(Long id, String nouveauNom) {
        Departement departement = departementRepository.findById(id).orElseThrow(() -> new RuntimeException("Département non trouvé"));
        departement.setNom(nouveauNom);
        return departementRepository.save(departement);
    }

	public List<Enseignant> getEnseignantsByDepartementId(Long departementId) {
        Departement departement = departementRepository.findById(departementId)
                .orElseThrow(() -> new RuntimeException("Département introuvable"));
        return departement.getEnseignants();
    }
}
