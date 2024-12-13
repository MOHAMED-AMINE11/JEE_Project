package com.GestionSurveillance.JEE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionSurveillance.JEE.entities.Option;
import com.GestionSurveillance.JEE.repositories.OptionRepository;

import java.util.List;

@Service
public class OptionService {
	
	@Autowired
	OptionRepository optionRepository;
	
	public Option createOption(Option option) {
		return optionRepository.save(option);
	}
	
	public void deleteOption(Long id) {
		optionRepository.deleteById(id);
	}
	
	public Option getOptionById(Long id) {
		return optionRepository.getById(id);
	}
	
	public List<Option> getAllOptions(){
		return optionRepository.findAll();
	}
	
	public List<Option> getOptionsByDepartementId(Long id){
		return optionRepository.findByDepartementId(id);
	}
	
	public Option updateOption(Long id, Option newOption) {	
		Option option = getOptionById(id);
		if(option != null) {
			option.setNom(newOption.getNom());
			option.setDepartement(newOption.getDepartement());
			return option;
		}
		return null; 
	}
	

}
