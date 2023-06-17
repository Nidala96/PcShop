package com.demo.spring.games;

import com.demo.spring.games.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Context 
{
	@Bean
	public ConsoleService consoleService()
	{
		return new ConsoleService();
	}
	
	@Bean
	public VideogameService videogamesService()
	{
		return new VideogameService();
	}

	@Bean
	public ProcessoreService processoreService()
	{
		return new ProcessoreService();
	}

	@Bean
	public GpuService gpuService()
	{
		return new GpuService();
	}

	@Bean
	public SchedaMadreService schedaMadreService()
	{
		return new SchedaMadreService();
	}

	@Bean
	public  CasePcService casePcService()
	{
		return new CasePcService();
	}

	@Bean
	public  PcService pcService()
	{
		return new PcService();
	}

	@Bean
	public RamService ramService() { return new RamService(); }

	@Bean
	public HardDiskService hardDiskService() { return new HardDiskService(); }

	@Bean
	public CarrelloService carrelloService() { return new CarrelloService(); }


}
