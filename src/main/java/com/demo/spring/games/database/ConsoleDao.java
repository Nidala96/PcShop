package com.demo.spring.games.database;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

public class ConsoleDao implements IDao
{
	    @Autowired
	    private Database db;

	    private String insert =
	            "insert into console (nome, produttore, nazione) values (?, ?, ?)";

	    private String readOne =
	            "select * from console where id = ?";

	    private String read =
	            "select * from console";

	    private String update =
	            "update console set nome = ?,produttore = ?, nazione = ? where id = ?";

	    private String delete =
	            "delete from console where id = ?";

	    @Override
	    public void add(Map<String, String> map) 
	    {
	        db.update(insert,
	                map.get("nome"),
	                map.get("produttore"),
	                map.get("nazione"));
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
	        db.update(update, map.get("nome")
	                    , map.get("produttore"),
	                        map.get("nazione"),
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