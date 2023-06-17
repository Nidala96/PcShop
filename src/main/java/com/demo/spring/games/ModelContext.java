package com.demo.spring.games;

import java.util.Map;

import com.demo.spring.games.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelContext 
{
	@Bean
	@Scope("prototype")
	public Console console(Map<String,String> params)
	{
		Console console = new Console();
		console.fromMap(params);
		return console;
	}
	
	@Bean
	@Scope("prototype")
	public Videogame videogame(Map<String, String> params)
	{
		Videogame videogame = new Videogame();
		videogame.fromMap(params);
		return videogame;
	}
	
	@Bean
	@Scope("prototype")
	@Primary
	public Utente utente(Map<String,String> map)
	{
		Utente u = new Utente();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public Utente utenteVuoto(){
		Utente u = new Utente();
		return u;
	}

	@Bean
	@Scope("prototype")
	public Processore processore(Map<String,String> map)
	{
		Processore u = new Processore();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public Gpu gpu(Map<String,String> map)
	{
		Gpu u = new Gpu();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public SchedaMadre schedaMadre(Map<String,String> map)
	{
		SchedaMadre u = new SchedaMadre();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public CasePc casePc(Map<String,String> map)
	{
		CasePc u = new CasePc();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public Pc pc(Map<String,String> map)
	{
		Pc u = new Pc();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public Ram ram(Map<String,String> map)
	{
		Ram u = new Ram();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public HardDisk hardDisk(Map<String,String> map)
	{
		HardDisk u = new HardDisk();
		u.fromMap(map);
		return u;
	}

	@Bean
	@Scope("prototype")
	public Carrello carrello(Map<String,String> map)
	{
		Carrello u = new Carrello();
		u.fromMap(map);
		return u;
	}
}
