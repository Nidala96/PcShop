package com.demo.spring.games.controller;

import java.util.Map;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.spring.games.database.UtenteDao;
import com.demo.spring.games.entities.Utente;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController 
{
	@Autowired
	private UtenteDao du;
	
	@Autowired
	ApplicationContext context;

//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public String home(Model model)
//	{
//		return "index.html";
//	}
	
	//httpsession memorizza i dati di quell'utente
	@GetMapping("/")
	public String home(HttpSession session)
	{
		if(session.getAttribute("loggato") == null)
		{
			return "redirect:formlogin";
		}
		else
		{
			return "pc";
		}
	}
	
	@GetMapping("/formlogin")
	public String formLogin()
	{
		return "formlogin.html";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String user,
						@RequestParam("password") String pass,
						HttpSession session)
	{
		/*
		 * Prendo i valori inseriti dall'utente tramite la form, quindi username e password, e li controllo
		 * cioè verifico che quello specifico username e la password associata a quello user saranno salvati nel db 
		 * e che i valori coincidano con quelli registrati
		 * Se i valori sono corretti significa che l'utente può vedere i dati del sito
		 * Se invece lo user o la password o entrambi non sono corretti
		 * rimando l'utente alla pagina di login.
		 * */
		
		//verifico che username e password siano salvati nel db e che i valori coincidano
		Map<String,String> utenteLoggato = du.autentica(user, pass);
		Utente utente = null;
		String ris = "";
		
		//verifico il valore della mappa utenteLoggato
		//se la mappa è null significa che i valori sono sbagliati
		//non c'è un utente con quello user e password salvati nel db
		if(utenteLoggato == null)
		{
			ris = "redirect:formlogin";
		}
		else
		{
			//in questo caso l'utente ha inserito i valori corretti
			//quindi in utenteLoggato ci sarà una mappa con i suoi dati
			//creo una istanza di utente sfruttando i Bean
			utente = context.getBean(Utente.class, utenteLoggato);
			
			//aggiungo un attributo nella session, dando nome dell'attributo e un valore
			//cioè se arriviamo ad eseguire il codice vuol dire che l'utente è effettivamente loggato
			//quindi setto il valore dell'attributo "loggato" a "ok"
			session.setAttribute("loggato", "ok");
			
			//imposto un attributo che chiamo "utente" e passo come valore
			//l'istanza di utente cioè salvo nella session una chiave "utente" e l'utente ad esso associato
			session.setAttribute("utente", utente);
			String ruolo = utente.getRuolo();
			switch(ruolo.toLowerCase())
			{
			case "amministratore":
				ris = "redirect:/pc";
				break;
			case "visitatore":
				ris = "redirect:/pc";
				break;
			default:
				session.setAttribute("loggato", null);
				ris = "redirect:/";
				break;
			}
		}
		return ris;
	}
	
	//creo un metodo che consenta all'utente di fare logout della session
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		//setto nuovamente il valore dell'attributo loggato a null
		//setto anche il valore dell'istanza utente a null in modo da togliere quei dati dalla session
		
		session.setAttribute("loggato", null);
		session.setAttribute("utente", null);
		return "redirect:formlogin";
	}

	//creo un metodo che consenta all'utente di loggare come ospite, quindi non può modificare o acquistare
	@PostMapping("/guest")
	public String guest(HttpSession session)
	{
		return "redirect:/pc";
	}

	@RequestMapping("/carrello")
	public String carrelloPage() {
		return "carrello";
	}

	@RequestMapping("/recuperopassword")
	public String recuperoPassw() {
		return "recuperopassword";
	}
}
