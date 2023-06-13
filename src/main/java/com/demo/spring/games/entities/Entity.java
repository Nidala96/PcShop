package com.demo.spring.games.entities;

public abstract class Entity implements IMapp
{
	private int id;
	
	public Entity()
	{
		
	}
	
	public Entity(int id)
	{
		this.id = id;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String toString()
	{
		return "\nID: " + id;
	}	
}