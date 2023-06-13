package com.demo.spring.games.controller;

import java.util.Map;

import com.demo.spring.games.entities.Utente;
import com.demo.spring.games.services.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpSession;

@Controller
public class GpuController {
	
	@Autowired
	private GpuService gpuService;
	
	@RequestMapping(path="/gpu", method = RequestMethod.GET)
	public String listGpus(Model model, HttpSession session) {
		System.out.println(gpuService.getGpus());
		// Verifico il ruolo dell'utente
		Utente utente = (Utente) session.getAttribute("utente");
		String ruolo = (utente != null) ? utente.getRuolo() : "";
		model.addAttribute("ruolo", ruolo);
		model.addAttribute("listGpus", gpuService.getGpus());
		return "gpu.html";
	}
	
	@RequestMapping(path="/modGpu", method = RequestMethod.GET)
	public String modGpu(@RequestParam Map<String, String> params) {
		gpuService.updateGpu(params);
		return "redirect:/gpu";
	}
	
	@RequestMapping(path="/delGpu", method = RequestMethod.GET)
	public String delGpu(@RequestParam("id") int id) {
		gpuService.deleteGpu(id);
		return "redirect:/gpu";
	}
	
	@RequestMapping(path="/addGpu", method = RequestMethod.GET)
	public String addGpu(@RequestParam Map<String, String> params) {
		gpuService.addGpu(params);
		return "redirect:/gpu";
	}
}
