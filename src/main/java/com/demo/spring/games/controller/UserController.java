package com.demo.spring.games.controller;


import com.demo.spring.games.database.UtenteDao;
import com.demo.spring.games.entities.Utente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController
{
    @Autowired
    private UtenteDao du;

    @Autowired
    ApplicationContext context;

    @GetMapping("/formregistrazione")
    public String formRegistrazione(Model model){
        Utente utente = context.getBean("utenteVuoto", Utente.class);
        model.addAttribute("utente",utente);
        return "formregistrazione.html";
    }


    /*Nel metodo registerUser, il parametro @ModelAttribute("registrazioneUtente")
     svolge la funzione di legare i dati inviati dal form di registrazione all'oggetto utente */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute Utente utente,
                               HttpSession session, Model model,
                               @RequestParam("confirmPassword") String confirmPassword){


        // Verifica se l'utente esiste già nel sistema
        if (du.isUserExists(utente.getUsername())) {
            model.addAttribute("error", "Username già in uso");
            return "formregistrazione.html";
        }
        System.out.println("password model: " + utente.getPassword());
        // Verifica se le password coincidono
        if (!utente.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Le password non coincidono");
            return "formregistrazione.html";
        }

        // Salva l'utente nel database o esegui altre operazioni necessarie

        // Imposta l'utente nella sessione
        session.setAttribute("utente", utente);
        du.create(utente.toMap());

        // Reindirizza l'utente alla pagina di successo o di login
        return "confermaregistrazione";
    }

}
