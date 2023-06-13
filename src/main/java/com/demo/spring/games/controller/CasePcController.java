package com.demo.spring.games.controller;

import java.util.Map;


import com.demo.spring.games.entities.Utente;
import com.demo.spring.games.services.CasePcService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CasePcController {
	
	@Autowired
	private CasePcService casePcService;
	
	@RequestMapping(path="/casePc", method = RequestMethod.GET)
	public String listCasePc(Model model, HttpSession session) {
		System.out.println(casePcService.getCasePc());
		// Verifico il ruolo dell'utente
		Utente utente = (Utente) session.getAttribute("utente");
		String ruolo = (utente != null) ? utente.getRuolo() : "";
		model.addAttribute("ruolo", ruolo);
		model.addAttribute("listCasePc", casePcService.getCasePc());
		return "casePc.html";
	}
	
	@RequestMapping(path="/modCasePc", method = RequestMethod.GET)
	public String modCasePc(@RequestParam Map<String, String> params) {
		casePcService.updateCasePc(params);
		return "redirect:/casePc";
	}
	
	@RequestMapping(path="/delCasePc", method = RequestMethod.GET)
	public String delCasePc(@RequestParam("id") int id) {
		casePcService.deleteCasePc(id);
		return "redirect:/casePc";
	}
	
	@RequestMapping(path="/addCasePc", method = RequestMethod.GET)
	public String addCasePc(@RequestParam Map<String, String> params) {
		casePcService.addCasePc(params);
		return "redirect:/casePc";
	}
}
