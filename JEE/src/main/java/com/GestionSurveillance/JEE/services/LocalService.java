package com.GestionSurveillance.JEE.services;

import com.GestionSurveillance.JEE.entities.Local;
import com.GestionSurveillance.JEE.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalService {
	
	@Autowired 
	LocalRepository localRepository;
	
	public List<Local> getLocaux(){
		return localRepository.findAll();
	}
	
	public Local getLocalById(Long id ) {
		return localRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Local introuvable"));
	}
	
	public Local createLocal(Local local) {
		return localRepository.save(local);
	}
	
	public void deleteLocal(Long id) {
        Local local = getLocalById(id); 
        localRepository.delete(local); 
    }
	
	public Local updateLocal(Long id, Local localDetails) {
		Local local = getLocalById(id);
		local.setNom(localDetails.getNom());
        local.setCapacite(localDetails.getCapacite());
        local.setEstDisponible(localDetails.isEstDisponible());
        local.setNbSurveillance(localDetails.getNbSurveillance());
        return localRepository.save(local); 
	}
	
	public List<Local> getAvailableLocaux() {
        return localRepository.findByEstDisponible(true);
    }
	public List<Local> findLocauxByNom(String nom) {
        return localRepository.findByNomContainingIgnoreCase(nom);
    }

}
