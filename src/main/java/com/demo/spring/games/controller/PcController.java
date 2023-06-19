package com.demo.spring.games.controller;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.demo.spring.games.entities.CartInfo;
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
import org.springframework.web.bind.annotation.ResponseBody;

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

	@Autowired
	private CarrelloService carrelloService;

	@RequestMapping(path = "/pc", method = RequestMethod.GET)
	public String listPc(Model model, HttpSession session, @RequestParam(name = "filtroGpu", required = false) String filtroGpu,
						 @RequestParam(name = "filtroCpu", required = false) String filtroCpu,
						 @RequestParam(name = "filtroRam", required = false) String filtroRam,
						 @RequestParam(name = "filtroHardDisk", required = false) String filtroHardDisk,
						 @RequestParam(name = "filtroPrezzo", required = false) Double filtroPrezzo) {

		boolean isAdmin = false;
		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		String username = "";

		if (utenteObj instanceof Utente)
		{
			Utente utente = (Utente) utenteObj;
			System.out.println(utente.getId());
			System.out.println(utente.getUsername());

			if (utente.getRuolo().equals("amministratore"))
			{
				isAdmin = true;
			}

			username = utente.getUsername();
			model.addAttribute("username", username);
		}
		else
		{
			model.addAttribute("username", null);
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
			model.addAttribute("elementiCarrello", carrelloService.getCartElementCount(utenteOne != null ? utenteOne.getId() : null));
		return "pc.html";
	}

	@RequestMapping(path="/modPC", method = RequestMethod.GET)
	public String updatePc(@RequestParam Map<String, String> params) {
		System.out.println(params);
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

	@RequestMapping(path="/addCarrello", method = RequestMethod.GET)
	public String addCarrello(@RequestParam Map<String, String> params, HttpSession session) {
		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		if(utenteOne != null) {
			int utenteId = utenteOne.getId();
			int pcId = Integer.parseInt(params.get("pc_id"));
			int quantitaPc = Integer.parseInt(params.get("quantitaPc"));

			// Controlla se il PC esiste già nel carrello dell'utente
			boolean pcEsisteNelCarrello = carrelloService.pcEsisteNelCarrello(utenteId, pcId);

			if (pcEsisteNelCarrello) {
				// Aggiorna la quantità del PC esistente nel carrello
				carrelloService.aggiornaQuantitaPc(utenteId, pcId, quantitaPc);
			} else {
				// Aggiungi una nuova voce al carrello
				params.put("utente_id", String.valueOf(utenteId));
				carrelloService.addCarrello(params);
			}
		}
		return "redirect:/pc";
	}

	@RequestMapping(path="/carrello", method = RequestMethod.GET)
	public String listCarrello(Model model, HttpSession session) {
		DecimalFormat df = new DecimalFormat("#.##");
		Double prezzoSpedizione = 1D;
		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		String username = "";
		if(utenteOne != null)
		{
			int id = utenteOne.getId();
			CartInfo cartInfo = getCartInfo(id);

			model.addAttribute("quantitaPc", (cartInfo.getQuantitaElementiCarrello() != null) ? cartInfo.getQuantitaElementiCarrello() : 0);
			model.addAttribute("carrello", cartInfo.getElementiCarrello());
			model.addAttribute("subTotale", df.format(cartInfo.getSubTotale()));
			model.addAttribute("prezzoSpedizione", cartInfo.getPrezzoSpedizione());
			model.addAttribute("prezzoTotale", df.format(cartInfo.getPrezzoTotale()));
			model.addAttribute("elementiCarrello", carrelloService.getCartElementCount(utenteOne != null ? utenteOne.getId() : null));
		}

		if (utenteObj instanceof Utente)
		{
			Utente utente = (Utente) utenteObj;
			username = utente.getUsername();

			model.addAttribute("username", username);
		}
		else{
			model.addAttribute("username", null);
		}
		return "carrello.html";
	}

	@RequestMapping(path="/cartInfo", method = RequestMethod.GET)
	@ResponseBody
	public CartInfo cartInfo(HttpSession session) {
		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		return getCartInfo(utenteOne != null ? utenteOne.getId() : null);
	}

	private CartInfo getCartInfo(Integer id_utente)
	{
		DecimalFormat df = new DecimalFormat("#.##");
		CartInfo cartInfo = new CartInfo();

		if(id_utente != null)
		{
			int id = id_utente;
			cartInfo.setElementiCarrello(carrelloService.getCarrello(id));
			cartInfo.setQuantitaElementiCarrello(new ArrayList<>());
			for( Pc pc : cartInfo.getElementiCarrello()) {
				cartInfo.getQuantitaElementiCarrello().add(carrelloService.getQuantitaPc(id, pc.getId()));
			}
			Double subTotale = 0.0;
			for (int i = 0; i < cartInfo.getElementiCarrello().size(); i++) {
				Pc pc = cartInfo.getElementiCarrello().get(i);
				int quantity = cartInfo.getQuantitaElementiCarrello().get(i);
				double itemPrice = pc.getPrezzo() * quantity;
				subTotale += itemPrice;
			}
			cartInfo.setSubTotale(Double.parseDouble(df.format(subTotale)));
			return cartInfo;
		}
		else
		{
			return null;
		}
	}

	@RequestMapping(path="/deleteCarrello", method = RequestMethod.GET)
	public String deleteCarrello(@RequestParam("pc_id") int pcId, HttpSession session) {
		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		if (utenteOne != null) {
			int utenteId = utenteOne.getId();
			carrelloService.deleteCarrello(utenteId, pcId);
		}
		return "redirect:/carrello";
	}

	@RequestMapping(path="/modQuantita", method = RequestMethod.POST)
	public String modCarrello(@RequestParam Map<String, String> params, HttpSession session) {
		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		if(utenteOne != null) {
			int utenteId = utenteOne.getId();
			int pcId = Integer.parseInt(params.get("pc_id"));
			int quantitaPc = Integer.parseInt(params.get("quantitaPc"));
			// Controlla se il PC esiste già nel carrello dell'utente
			boolean pcEsisteNelCarrello = carrelloService.pcEsisteNelCarrello(utenteId, pcId);
			if (pcEsisteNelCarrello) {
				// Aggiorna la quantità del PC esistente nel carrello
				carrelloService.modificaQuantitaPc(utenteId, pcId, quantitaPc);
			}
		}
		return "redirect:/carrello";
	}

	@RequestMapping(path="/success", method = RequestMethod.GET)
	public String success(Model model, HttpSession session) {
		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		carrelloService.deleteAll(utenteOne.getId());
		model.addAttribute("username", utenteOne.getUsername());
		model.addAttribute("elementiCarrello", carrelloService.getCartElementCount(utenteOne.getId()));
		return "success.html";
	}

	@RequestMapping(path="/addBuild", method = RequestMethod.GET)
	public String addBuild(@RequestParam Map<String, String> params, HttpSession session) {

		Object utenteObj = session.getAttribute("utente");
		Utente utenteOne = (Utente) utenteObj;
		if(utenteOne != null) {
			pcService.addPC(params);
			int utenteId = utenteOne.getId();
			int pcId = pcService.getLastInsertedPCId();
			int quantitaPc = 1;
			Map<String, String> paremetriCarrello = new HashMap<>();
			// Controlla se il PC esiste già nel carrello dell'utente
				paremetriCarrello.put("utente_id", String.valueOf(utenteId));
				paremetriCarrello.put("pc_id", String.valueOf(pcId));
				paremetriCarrello.put("quantitaPc", String.valueOf(quantitaPc));
				carrelloService.addCarrello(paremetriCarrello);
		}
		return "redirect:/pcbuilder";
	}
}
