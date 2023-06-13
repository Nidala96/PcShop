package com.demo.spring.games.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.spring.games.entities.Utente;
import com.demo.spring.games.services.ConsoleService;
import com.demo.spring.games.services.VideogameService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VideogameController 
{
	@Autowired
	private ConsoleService consoleService;
	
	@Autowired
	private VideogameService videogameService;
	
	@RequestMapping(path = "/videogame", method = RequestMethod.GET) 
	public String listaVideogame(Model model, HttpSession session) 
	{
		boolean isAdmin = false;
		Object utenteObj = session.getAttribute("utente");
		if(utenteObj instanceof Utente)
		{
			Utente utente = (Utente)utenteObj;
			if(utente.getRuolo().equals("amministratore"))
			{
				isAdmin = true;
			}
		}
		model.addAttribute("isAdmin", isAdmin);
		
		System.out.println(videogameService.getVideogame());
		model.addAttribute("listaVideogame", videogameService.getVideogame());
		model.addAttribute("listaConsole", consoleService.getConsole());
		return "videogame.html";
	}
	
	@RequestMapping(path="/modVideogame", method = RequestMethod.GET)
	public String updateVideogame(@RequestParam Map<String, String> params) 
	{
		videogameService.updateVideogame(params);
		return "redirect:/videogame";
	}
	
	@RequestMapping(path="/delVideogame", method = RequestMethod.GET)
	public String deleteVideogame(@RequestParam("id") int id) 
	{
		videogameService.deleteVideogame(id);
		return "redirect:/videogame";
	}
	
	@RequestMapping(path="/addVideogame", method = RequestMethod.GET)
	public String addVideogame(@RequestParam Map<String, String> params) 
	{
		videogameService.addVideogame(params);
		return "redirect:/videogame";
	}
}
