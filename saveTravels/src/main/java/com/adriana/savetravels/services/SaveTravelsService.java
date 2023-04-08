package com.adriana.savetravels.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.adriana.savetravels.models.SaveTravels;
import com.adriana.savetravels.repositories.SaveTravelsRepository;

@Service
public class SaveTravelsService {
	
	// adding the SaveTravels repository as a dependency
	private final SaveTravelsRepository saveTravelsRepository;
	
    public SaveTravelsService(SaveTravelsRepository saveTravelsRepository) {
        this.saveTravelsRepository = saveTravelsRepository;
    }
    // returns all the SaveTravels
    public Iterable<SaveTravels> allSaveTravels() {
        return saveTravelsRepository.findAll();
    }
    // creates a SaveTravels
    public SaveTravels createSaveTravels(SaveTravels b) {
        return saveTravelsRepository.save(b);
    }
    // retrieves a SaveTravels
    public SaveTravels findSaveTravels(Long id) {
        Optional<SaveTravels> optionalSaveTravels = saveTravelsRepository.findById(id);
        if(optionalSaveTravels.isPresent()) {
            return optionalSaveTravels.get();
        } else {
            return null;
        }
    }
    // updates a SaveTravels
    public void update(@Valid SaveTravels st) {
        saveTravelsRepository.save(st);
    }
    // deletes a SaveTravels
    public void delete(Long id) {
        saveTravelsRepository.deleteById(id);
    }
}
