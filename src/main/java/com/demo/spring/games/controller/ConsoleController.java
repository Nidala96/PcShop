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

import jakarta.servlet.http.HttpSession;

@Controller
public class ConsoleController 
{
	@Autowired
	private ConsoleService consoleService;
	
	@RequestMapping(path = "/console", method = RequestMethod.GET)
	public String listConsole(Model model, HttpSession session)
	{
		System.out.println(consoleService.getConsole());
		
		//verifico il ruolo dell'utente 
		Utente utente = (Utente)session.getAttribute("utente");
		String ruolo = (utente != null) ? utente.getRuolo() : "";
		model.addAttribute("ruolo", ruolo);
		
		model.addAttribute("listaConsole", consoleService.getConsole());
		return "console.html";
	}
	
	@RequestMapping(path = "/modConsole", method = RequestMethod.GET)
	public String modConsole(@RequestParam Map<String,String> params)
	{
		consoleService.updateConsole(params);
		return "redirect:/console";
	}
	
	@RequestMapping(path = "/delConsole", method = RequestMethod.GET)
	public String delConsole(@RequestParam("id") int id)
	{
		consoleService.deleteConsole(id);
		return "redirect:/console";
	}
	
	@RequestMapping(path = "/addConsole", method = RequestMethod.GET)
	public String addConsole(@RequestParam Map<String,String> params)
	{
		consoleService.addConsole(params);
		return "redirect:/console";
	}
}
