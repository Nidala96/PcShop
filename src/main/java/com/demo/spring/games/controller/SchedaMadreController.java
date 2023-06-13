package com.demo.spring.games.controller;

import java.util.Map;


import com.demo.spring.games.entities.Utente;
import com.demo.spring.games.services.SchedaMadreService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SchedaMadreController {
	
	@Autowired
	private SchedaMadreService schedaMadreService;
	
	@RequestMapping(path="/schedaMadre", method = RequestMethod.GET)
	public String listSchedeMadre(Model model, HttpSession session) {
		System.out.println(schedaMadreService.getSchedeMadre());
		// Verifico il ruolo dell'utente
		Utente utente = (Utente) session.getAttribute("utente");
		String ruolo = (utente != null) ? utente.getRuolo() : "";
		model.addAttribute("ruolo", ruolo);
		model.addAttribute("listSchedeMadre", schedaMadreService.getSchedeMadre());
		return "schedaMadre.html";
	}
	
	@RequestMapping(path="/modSchedaMadre", method = RequestMethod.GET)
	public String modSchedaMadre(@RequestParam Map<String, String> params) {
		schedaMadreService.updateSchedaMadre(params);
		return "redirect:/schedaMadre";
	}
	
	@RequestMapping(path="/delSchedaMadre", method = RequestMethod.GET)
	public String delSchedaMadre(@RequestParam("id") int id) {
		schedaMadreService.deleteSchedaMadre(id);
		return "redirect:/schedaMadre";
	}
	
	@RequestMapping(path="/addSchedaMadre", method = RequestMethod.GET)
	public String addSchedaMadre(@RequestParam Map<String, String> params) {
		schedaMadreService.addSchedaMadre(params);
		return "redirect:/schedaMadre";
	}
}
