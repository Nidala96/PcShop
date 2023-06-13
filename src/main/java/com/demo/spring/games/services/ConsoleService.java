package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.ConsoleDao;
import com.demo.spring.games.entities.Console;

public class ConsoleService 
{
	@Autowired
	private ConsoleDao consoleDao;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Console> getConsole()
	{
		List<Console> listaConsole = new ArrayList<>();
		
		for(Map<String,String> params : consoleDao.read())
		{
			listaConsole.add(context.getBean(Console.class, params));
		}
		
		return listaConsole;
	}
	
	public void updateConsole(Map<String,String> params)
	{
		consoleDao.update(context.getBean(Console.class, params).toMap());
	}
	
	public void deleteConsole(int id)
	{
		consoleDao.delete(id);
	}
	
	public void addConsole(Map<String, String> params)
	{
		consoleDao.add(context.getBean(Console.class, params).toMap());
	}
}
