package com.demo.spring.games.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.demo.spring.games.entities.Gpu;
import com.demo.spring.games.entities.Pc;
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
	public String listPc(Model model, HttpSession session, @RequestParam(name = "filtroGpu", required = false) String filtroGpu,
						 @RequestParam(name = "filtroCpu", required = false) String filtroCpu,
						 @RequestParam(name = "filtroRam", required = false) String filtroRam,
						 @RequestParam(name = "filtroHardDisk", required = false) String filtroHardDisk,
						 @RequestParam(name = "filtroPrezzo", required = false) Double filtroPrezzo) {
		boolean isAdmin = false;
		Object utenteObj = session.getAttribute("utente");
		if (utenteObj instanceof Utente) {
			Utente utente = (Utente) utenteObj;
			if (utente.getRuolo().equals("amministratore")) {
				isAdmin = true;
			}
		}
		model.addAttribute("isAdmin", isAdmin);
		List<Pc> pcsFiltrati = new ArrayList<>();

		List<Pc> unfilteredPcs = pcService.getPcs();
		if (filtroGpu == null && filtroCpu == null && filtroRam == null && filtroHardDisk == null && filtroPrezzo == null) {
			pcsFiltrati = unfilteredPcs;
		} else {
			for (Pc pc : unfilteredPcs) {
				if ((filtroGpu == null || filtroGpu.isEmpty() || pc.getGpu().getNome().equals(filtroGpu))
						&& (filtroCpu == null || filtroCpu.isEmpty() || pc.getProcessore().getNome().equals(filtroCpu))
						&& (filtroRam == null || filtroRam.isEmpty() || pc.getRam().getNome().equals(filtroRam))
						&& (filtroHardDisk == null || filtroHardDisk.isEmpty() || pc.getHardDisk().getNome().equals(filtroHardDisk))
						&&  (filtroPrezzo == null || filtroPrezzo == 0 || pc.getPrezzo() <= filtroPrezzo)) {
					pcsFiltrati.add(pc);
				}
			}
		}

			System.out.println(filtroPrezzo);
			System.out.println(filtroGpu);
			System.out.println(pcsFiltrati);
			System.out.println(pcService.getPcs());
			model.addAttribute("listPc", pcsFiltrati);
			model.addAttribute("maxPcPrice", unfilteredPcs.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Pc::getPrezzo))).get().getPrezzo());
			model.addAttribute("minPcPrice", unfilteredPcs.stream().collect(Collectors.minBy(Comparator.comparingDouble(Pc::getPrezzo))).get().getPrezzo());
			model.addAttribute("filtroCpu", filtroCpu);
			model.addAttribute("filtroGpu", filtroGpu);
			model.addAttribute("filtroRam", filtroRam);
			model.addAttribute("filtroHardDisk", filtroHardDisk);
			model.addAttribute("filtroPrezzo", filtroPrezzo);
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
