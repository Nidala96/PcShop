package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.entities.Utente;

public class UtenteDao 
{

	@Autowired
	private Database db;
	
	@Autowired
	ApplicationContext context;
	
	 public List<Map<String,String>> read(String query, String... params)
	    {
	        return db.execute(query, params);
	    }

	 public List<Utente> readUtenti()
	    {
	        Utente u = null;
	        List<Utente> ris = new ArrayList<>();
	        for(Map<String,String> m : leggiTutti()) 
	        {
	            u = context.getBean(Utente.class, m);
	            ris.add(u);
	        }

	        return ris;
	    }
	 
	    public List<Map<String,String>> leggiTutti()
	    {
	        return db.execute("select * from utenti");
	    }

	    public void delete(int id)
	    {
	        String query = "delete from utenti where id = ?";
	        db.update(query, id + "");
	    }

	    public void create(Map<String,String> m)
	    {
	        String query = "insert into utenti (nome,cognome,username,password,ruolo) values (?,?,?,?,?)";
	        db.update(query, m.get("nome"), m.get("cognome"), m.get("username"), m.get("password"), m.get("ruolo"));
	    }

	    public void update(Map<String,String> m)
	    {
	        String query = "update utenti set nome = ?, cognome = ?, username = ?, password = ?, ruolo = ? where id = ?";
	        db.update(query, m.get("nome"), m.get("cognome"), m.get("username"), m.get("password"), m.get("ruolo"), m.get("id"));
	    }

	    public Map<String, String> cercaPerId(int id)
	    {
	        String query = "select * from utenti where id = ?";
	        return db.execute(query, id + "").get(0);
	    }
	
	public Map<String,String> autentica(String username, String password)
	{
		String query = "select * from utenti where username = ? && password = ?";
		List<Map<String,String>> result = db.execute(query, username, password);
		if(result.size()>0)
		{
			return result.get(0);
		}
		return null;
	}
}
