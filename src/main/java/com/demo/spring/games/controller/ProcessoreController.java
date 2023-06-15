package com.demo.spring.games.controller;

import java.util.Map;

import com.demo.spring.games.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.spring.games.entities.Utente;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProcessoreController {
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

    @RequestMapping(path = "/pcbuilder", method = RequestMethod.GET)
    public String listProcessori(Model model, HttpSession session) {
        System.out.println(processoreService.getProcessori());

        // Verifica il ruolo dell'utente
        Utente utente = (Utente)session.getAttribute("utente");
        String ruolo = (utente != null) ? utente.getRuolo() : "";
        model.addAttribute("ruolo", ruolo);

        model.addAttribute("listaProcessori", processoreService.getProcessori());
        model.addAttribute("listGpu", gpuService.getGpus());
        model.addAttribute("listSchedeMadre", schedamadreService.getSchedeMadre());
        model.addAttribute("listCasePc", casepcService.getCasePc());
        model.addAttribute("listRam", ramService.getRams());
        model.addAttribute("listHardDisk", hardDiskService.getHardDisk());
        System.out.println(ramService.getRams());
        return "pcbuilder.html";
    }

    @RequestMapping(path = "/modProcessore", method = RequestMethod.GET)
    public String modProcessore(@RequestParam Map<String, String> params) {
        processoreService.updateProcessore(params);
        return "redirect:/processore";
    }

    @RequestMapping(path = "/delProcessore", method = RequestMethod.GET)
    public String delProcessore(@RequestParam("id") int id) {
        processoreService.deleteProcessore(id);
        return "redirect:/processore";
    }

    @RequestMapping(path = "/addProcessore", method = RequestMethod.GET)
    public String addProcessore(@RequestParam Map<String, String> params) {
        processoreService.addProcessore(params);
        return "redirect:/processore";
    }
}


