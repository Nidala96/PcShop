package com.demo.spring.games.entities;

public class Videogame extends Entity 
{
	private String titolo;
	private String supporto;
	private int anno;
	private boolean completato;
	private int voto;
	private Console console;
	
	public String getTitolo() 
	{
		return titolo;
	}
	
	public void setTitolo(String titolo) 
	{
		this.titolo = titolo;
	}
	
	public String getSupporto() 
	{
		return supporto;
	}
	
	public void setSupporto(String supporto) 
	{
		this.supporto = supporto;
	}
	
	public int getAnno() 
	{
		return anno;
	}
	
	public void setAnno(int anno) 
	{
		this.anno = anno;
	}
	
	public boolean isCompletato() 
	{
		return completato;
	}
	
	public void setCompletato(boolean completato) 
	{
		this.completato = completato;
	}
	
	public int getVoto() 
	{
		return voto;
	}
	
	public void setVoto(int voto) 
	{
		this.voto = voto;
	}
	
	public Console getConsole() 
	{
		return console;
	}
	
	public void setConsole(Console console)
	{
		this.console = console;
	}
	
	@Override
	public String toString() 
	{
		return "Videogame [toString()=" + super.toString() + ", titolo=" + titolo + ", supporto=" + supporto + ", anno="
				+ anno + ", completato=" + completato + ", voto=" + voto + ", console=" + console + "]";
	}
	
}
