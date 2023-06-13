package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.ConsoleDao;
import com.demo.spring.games.database.VideogameDao;
import com.demo.spring.games.entities.Console;
import com.demo.spring.games.entities.Videogame;

public class VideogameService 
{
	@Autowired
	private VideogameDao videogameDao;
	
	@Autowired
	private ConsoleDao consoleDao;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Videogame> getVideogame()
	{
		List<Videogame> listaVideogame = new ArrayList<>();
		
		for(Map<String, String> params : videogameDao.read()) 
		{
			Map<String, String> map = consoleDao.read(Integer.parseInt(params.get("console_id"))).get(0);
			Console console = context.getBean(Console.class, map);
			Videogame videogame = context.getBean(Videogame.class, params);
			videogame.setConsole(console);
			listaVideogame.add(videogame);
		}
		return listaVideogame;
	}
	
	public void updateVideogame(Map<String, String> params) 
	{
		Videogame videogame = context.getBean(Videogame.class, params);
		Map<String, String> map = videogame.toMap();
		map.put("console_id", params.get("console_id"));
		videogameDao.update(map);
	}
	
	public void deleteVideogame(int id) 
	{
		videogameDao.delete(id);
	}
	
	public void addVideogame(Map<String, String> params) 
	{
		Videogame videogame = context.getBean(Videogame.class, params);
		Map<String, String> map = videogame.toMap();
		map.put("console_id", params.get("console_id"));
		videogameDao.add(map);
	}
}
