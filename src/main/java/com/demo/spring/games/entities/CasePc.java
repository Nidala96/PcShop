package com.demo.spring.games.entities;


public class CasePc extends Entity
{

	private String nome;
	private double prezzo;
	private String descrizione;

	private String immaginecase;

	public String getImmaginecase() {
		return immaginecase;
	}

	public void setImmaginecase(String immaginecase) {
		this.immaginecase = immaginecase;
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
		return "CasePc{" +
				"id=" +
				", nome='" + nome + '\'' +
				", prezzo=" + prezzo +
				", descrizione='" + descrizione + '\'' +
				", immagineCase='" + immaginecase + '\'' +
				"} " + super.toString();
	}
}
