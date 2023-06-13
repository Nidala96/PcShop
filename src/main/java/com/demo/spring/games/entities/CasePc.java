package com.demo.spring.games.entities;


public class CasePc extends Entity
{
	private int id;
	private String nome;
	private double prezzo;
	private String descrizione;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "CasePc [toString()=" + super.toString() + ", id=" + id + ", nome=" + nome + ", prezzo=" + prezzo
				+ ", descrizione=" + descrizione + "]";
	}
	
}
