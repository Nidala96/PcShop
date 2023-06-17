package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class RamDao implements IDao
{
	 @Autowired
	    private Database db;

	    private String insert =
	            "insert into ram (nome, tipo, quantita, prezzo, descrizione, frequenza) values (?, ?, ?, ?, ?, ?)";

	    private String readOne =
	            "select * from ram where id = ?";

	    private String read =
	            "select * from ram";

	    private String update =
	            "update ram set nome = ?, tipo = ?, quantita = ?, prezzo = ?, descrizione = ?, frequenza = ? where id = ?";

	    private String delete =
	            "delete from ram where id = ?";

	    @Override
	    public void add(Map<String, String> map) 
	    {
	        db.update(insert,
	                map.get("nome"),
	                map.get("tipo"),
	                map.get("quantita"),
	                map.get("prezzo"),
	        		map.get("descrizione"),
	        		map.get("frequenza"));
	    }

	    @Override
	    public List<Map<String, String>> read() 
	    {
	        List<Map<String, String>> lista = new ArrayList<>();
	        lista = db.execute(read);
	        return lista;
	    }

	    public List<Map<String, String>> read(int id) 
	    {
	        List<Map<String, String>> lista = new ArrayList<>();
	        lista = db.execute(readOne,
	                String.valueOf(id));
	        return lista;
	    }

	    @Override
	    public void update(Map<String, String> map) 
	    {
	        db.update(update, map.get("nome"),
	                		  map.get("tipo"),
	                		  map.get("quantita"),
	                		  map.get("prezzo"),
	                		  map.get("descrizione"),
	                		  map.get("frequenza"),
	                		  map.get("id"));
	    }

	    @Override
	    public void delete(int id) 
	    {
	        db.update(delete, String.valueOf(id));
	    }

	@Override
	public void delete(int pc_id, int utente_id) {

	}
}