package com.demo.spring.games.entities;

public class Ram extends Entity
{
	private String nome;
	private String tipo;
	private int quantita;
	private double prezzo;
	private String descrizione;
	private String frequenza;

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
	
	public int getQuantita() 
	{
		return quantita;
	}
	
	public void setQuantita(int quantita) 
	{
		this.quantita = quantita;
	}
	
	public double getPrezzo() 
	{
		return prezzo;
	}

	public void setPrezzo(double prezzo) 
	{
		this.prezzo = prezzo;
	}

	public String getDescrizione() 
	{
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}
	
	public String getFrequenza() 
	{
		return frequenza;
	}
	
	public void setFrequenza(String frequenza) 
	{
		this.frequenza = frequenza;
	}

	public String toString()
	{
		return super.toString() + 
				"\nNome: " + nome +
				"\nTipo: " + tipo +
				"\nQuantità: " + quantita +
				"\nPrezzo: " + prezzo +
				"\nDescrizione: " + descrizione +
				"\nFrequenza: " + frequenza + "\n-------\n";
	}	
}