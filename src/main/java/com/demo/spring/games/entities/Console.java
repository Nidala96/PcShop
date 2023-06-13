package com.demo.spring.games.entities;

public class Console extends Entity
{
	private String nome;
	private String produttore;
	private String nazione;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getProduttore() 
	{
		return produttore;
	}
	
	public void setProduttore(String produttore) 
	{
		this.produttore = produttore;
	}
	
	public String getNazione() 
	{
		return nazione;
	}
	
	public void setNazione(String nazione) 
	{
		this.nazione = nazione;
	}
	
	public String toString()
	{
		return super.toString() + 
				"\nNome: " 			+ 		nome 			+
				"\nProduttore: " 	+ 		produttore 		+
				"\nNazione: " 		+ 		nazione 		+ "\n--------\n";
	}
}