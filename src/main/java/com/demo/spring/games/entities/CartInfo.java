package com.demo.spring.games.entities;

import java.util.List;

public class CartInfo
{
	private List<Pc> elementiCarrello;
	private List<Integer> quantitaElementiCarrello;
	private Double subTotale;
	private Double prezzoSpedizione = 10D;

	public List<Pc> getElementiCarrello()
	{
		return elementiCarrello;
	}

	public void setElementiCarrello(List<Pc> elementiCarrello)
	{
		this.elementiCarrello = elementiCarrello;
	}

	public List<Integer> getQuantitaElementiCarrello()
	{
		return quantitaElementiCarrello;
	}

	public void setQuantitaElementiCarrello(List<Integer> quantitaElementiCarrello)
	{
		this.quantitaElementiCarrello = quantitaElementiCarrello;
	}

	public Double getSubTotale()
	{
		return subTotale;
	}

	public void setSubTotale(Double subTotale)
	{
		this.subTotale = subTotale;
	}

	public Double getPrezzoSpedizione()
	{
		return prezzoSpedizione;
	}

	public void setPrezzoSpedizione(Double prezzoSpedizione)
	{
		this.prezzoSpedizione = prezzoSpedizione;
	}

	public Double getPrezzoTotale()
	{
		return getSubTotale() + getPrezzoSpedizione();
	}
}
