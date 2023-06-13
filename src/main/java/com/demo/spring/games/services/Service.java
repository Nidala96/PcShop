package com.demo.spring.games.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.spring.games.database.ConsoleDao;
import com.demo.spring.games.database.VideogameDao;

public class Service 
{
	@Autowired
	private ConsoleDao consoleDao;
	
	@Autowired
	private VideogameDao videogamesDao;
}
