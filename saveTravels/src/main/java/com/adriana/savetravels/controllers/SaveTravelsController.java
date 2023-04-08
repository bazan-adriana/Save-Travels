package com.adriana.savetravels.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adriana.savetravels.models.SaveTravels;
import com.adriana.savetravels.services.SaveTravelsService;

@Controller
@RequestMapping("/savetravels")
public class SaveTravelsController {
    private final SaveTravelsService saveTravelsService;

    public SaveTravelsController(SaveTravelsService saveTravelsService) {
        this.saveTravelsService = saveTravelsService;
    }

    @RequestMapping("/home")
    public String index(Model model) {
        Iterable<SaveTravels> saveTravels = saveTravelsService.allSaveTravels();
        model.addAttribute("saveTravels", saveTravels);
        return "index.jsp";
    }

    @PostMapping( "/create")
    public String createProcess(@Valid @ModelAttribute("saveTravels") SaveTravels st, BindingResult result) {
    	if(result.hasErrors()) {
    		return "New.jsp";
    	}
         saveTravelsService.createSaveTravels(st);
         return "redirect:/savetravels/home";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        SaveTravels saveTravels = saveTravelsService.findSaveTravels(id);
        model.addAttribute("saveTravels", saveTravels);
        return "show.jsp";
    }
    
    @GetMapping("/new")
    public String newSaveTravels(@ModelAttribute("saveTravels") SaveTravels saveTravels) {
        return "New.jsp";
    }

    @PostMapping("/savetravels")
    public String create(@Valid @ModelAttribute("savetravels") SaveTravels saveTravels, BindingResult result) {
        if (result.hasErrors()) {
            return "New.jsp";
        } else {
        	saveTravelsService.createSaveTravels(saveTravels);
            return "redirect:/savetravels";
        }
    }
    
	@GetMapping("/{id}/edit")
	public String editsaveTravels(@PathVariable("id") Long id, Model model) {
		SaveTravels savetravelsToBeUpdated = saveTravelsService.findSaveTravels(id);
		model.addAttribute("saveTravels", savetravelsToBeUpdated);
		
		return "edit.jsp";
	}
    
    @PutMapping("/create/{id}")
    public String processEditsaveTravels(@Valid @ModelAttribute("saveTravels") SaveTravels st, BindingResult result) {
        if(result.hasErrors()) {
            return "edit.jsp";
        }
        saveTravelsService.update(st);
        return "redirect:/savetravels/home";
    }

	@DeleteMapping("/delete/{id}")
	public String deleteSaveTravels(@PathVariable("id") Long id) {
		saveTravelsService.delete(id);
		return "redirect:/savetravels/home";
	}
  
}




