package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;



public class VideogameDao implements IDao{
	@Autowired
	private Database db;
	
	private String insert = 
			"insert into videogames (titolo, supporto, anno, completato, voto, console_id) values (? ,?, ?, ?, ?, ?)";
	
	private String read = 
			"select * from videogames";
	
	private String update = 
			"update videogames set titolo = ?, supporto = ?, anno = ?, completato = ?, voto = ?, console_id = ? where id = ?";
	
	private String delete = 
			"delete from videogames where id = ?";
		
	@Override
	public void add(Map<String, String> map) {
		db.update(insert, 
					map.get("titolo"),
					map.get("supporto"),
					map.get("anno"),
					(map.get("completato").equals("true")?"1":"0"),
					map.get("voto"),
					map.get("console_id"));
		
	}

	@Override
	public List<Map<String, String>> read() {
		List<Map<String,String>> lista = new ArrayList<>();
		lista = db.execute(read);
		return lista;
	}
	
	@Override
	public void update(Map<String, String> map) {
		db.update(update, 
					map.get("titolo"),
					map.get("supporto"),
					map.get("anno"),
					(map.get("completato").equals("true")?"1":"0"),
					map.get("voto"),
					map.get("console_id"),
					map.get("id"));
	}

	@Override
	public void delete(int id) {
		db.update(delete,
					String.valueOf(id));
	}
	
}