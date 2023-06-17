package com.demo.spring.games;

import com.demo.spring.games.database.*;
import com.demo.spring.games.entities.SchedaMadre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseContext 
{
	@Bean
	public Database db()
	{
		return new Database();
	}
	
	@Bean
	public ConsoleDao consoleDao()
	{
		return new ConsoleDao();
	}
	
	@Bean
	public VideogameDao videogamesDao()
	{
		return new VideogameDao();
	}

	@Bean
	public ProcessoreDao processoreDao()
	{
		return new ProcessoreDao();
	}

	@Bean
	public GpuDao gpuDao()
	{
		return new GpuDao();
	}

	@Bean
	public SchedaMadreDao schedaMadreDao()
	{
		return new SchedaMadreDao();
	}

	@Bean
	public CasePcDao casePcDao()
	{
		return new CasePcDao();
	}

	@Bean
	public PcDao pcDao()
	{
		return new PcDao();
	}


	@Bean
	public UtenteDao du()
	{
		return new UtenteDao();
	}

	@Bean
	public RamDao ramDao() { return new RamDao();}

	@Bean
	public HardDiskDao hardDiskDao() { return new HardDiskDao();}

	@Bean
	CarrelloDao carreloDao() { return new CarrelloDao(); }
}
