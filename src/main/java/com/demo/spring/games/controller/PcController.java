package com.demo.spring.games.controller;

import java.util.Map;

import com.demo.spring.games.entities.Utente;
import com.demo.spring.games.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpSession;
@Controller
public class PcController {
	
	@Autowired
	private PcService pcService;
	
	@Autowired
	private ProcessoreService processoreService;
	
	@Autowired
	private GpuService gpuService;
	
	@Autowired
	private SchedaMadreService schedamadreService;
	
	@Autowired
	private CasePcService casepcService;

	@Autowired
	private HardDiskService hardDiskService;

	@Autowired RamService ramService;
	
	@RequestMapping(path = "/pc", method = RequestMethod.GET) 
	public String listPc(Model model, HttpSession session) {
		boolean isAdmin = false;
		Object utenteObj = session.getAttribute("utente");
		if(utenteObj instanceof Utente){
			Utente utente = (Utente) utenteObj;
			if(utente.getRuolo().equals("amministratore")){
				isAdmin = true;
			}
		}
		model.addAttribute("isAdmin", isAdmin);
		System.out.println(pcService.getPcs());
		model.addAttribute("listPc", pcService.getPcs());
		model.addAttribute("listProcessori", processoreService.getProcessori());
		model.addAttribute("listGpu", gpuService.getGpus());
		model.addAttribute("listSchedeMadre", schedamadreService.getSchedeMadre());
		model.addAttribute("listCasePc", casepcService.getCasePc());
		model.addAttribute("listRam", ramService.getRams());
		model.addAttribute("listHardDisk", hardDiskService.getHardDisk());
		System.out.println(ramService.getRams());
		return "pc.html";
	}
	
	@RequestMapping(path="/modPC", method = RequestMethod.GET)
	public String updatePc(@RequestParam Map<String, String> params) {
		pcService.updatePC(params);
		return "redirect:/pc";
	}
	
	@RequestMapping(path="/delPc", method = RequestMethod.GET)
	public String deletePc(@RequestParam("id") int id) {
		pcService.deletePC(id);
		return "redirect:/pc";
	}
	
	@RequestMapping(path="/addPC", method = RequestMethod.GET)
	public String addPC(@RequestParam Map<String, String> params) {
		pcService.addPC(params);
		return "redirect:/pc";
	}
}
