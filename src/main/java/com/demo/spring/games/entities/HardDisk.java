package com.demo.spring.games.entities;

public class HardDisk extends Entity
{
	private String nome;
	private String tipo;
	private int quantitaMem;
	private String descrizione;
	private double prezzo;

	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getTipo() 
	{
		return tipo;
	}
	
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	
	public int getQuantitaMem() 
	{
		return quantitaMem;
	}
	
	public void setQuantitaMem(int quantitaMem) 
	{
		this.quantitaMem = quantitaMem;
	}

	public String getDescrizione() 
	{
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}
	
	public double getPrezzo() 
	{
		return prezzo;
	}

	public void setPrezzo(double prezzo) 
	{
		this.prezzo = prezzo;
	}
	

	public String toString()
	{
		return super.toString() + 
				"\nNome: " + nome +
				"\nTipo: " + tipo +
				"\nQuantità: " + quantitaMem +
				"\nDescrizione: " + descrizione +
				"\nPrezzo: " + prezzo + "\n-------\n";
	}	
}
