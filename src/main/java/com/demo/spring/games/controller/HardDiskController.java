package com.demo.spring.games.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.spring.games.entities.Utente;
import com.demo.spring.games.services.HardDiskService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HardDiskController 
{
	@Autowired
	private HardDiskService hardDiskService;
	
	@RequestMapping(path="/hardDisk", method = RequestMethod.GET)
	public String listHardDisk(Model model, HttpSession session)
	{
		System.out.println(hardDiskService.getHardDisk());
		
		Utente utente = (Utente)session.getAttribute("utente");
		String ruolo = (utente != null) ? utente.getRuolo() : "";
		model.addAttribute("ruolo", ruolo);
		
		model.addAttribute("listHardDisk", hardDiskService.getHardDisk());
		return "hardDisk.html";
	}
	
	@RequestMapping(path="/modHardDisk", method = RequestMethod.GET)
	public String modHardDisk(@RequestParam Map<String,String> params)
	{
		hardDiskService.updateHardDisk(params);
		return "redirect:/hardDisk";
	}
	
	@RequestMapping(path="/delHardDisk", method = RequestMethod.GET)
	public String delHardDisk(@RequestParam("id") int id)
	{
		hardDiskService.deleteHardDisk(id);
		return "redirect:/hardDisk";
	}
	
	@RequestMapping(path="addHardDisk", method = RequestMethod.GET)
	public String addHardDisk(@RequestParam Map<String,String> params)
	{
		hardDiskService.addHardDisk(params);
		return "redirect:/hardDisk";
	}
}