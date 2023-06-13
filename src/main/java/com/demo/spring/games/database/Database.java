package com.demo.spring.games.database;

import java.sql.*;
import java.util.*;

public class Database 
{
	private String nomeDb;
	private String percorso;
	private String username;
	private String password;
	private Connection c;

	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

	public Database()
	{
		this.nomeDb = "negozioPc";
		this.username = "root";
		this.password = "root";
		setPercorso(nomeDb);
	}

	public String getPercorso() 
	{
		return percorso;
	}

	public void setPercorso(String nomeDb) 
	{
		String timeZone = "useUnicode="
				+ "true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode"
				+ "=false&serverTimezone=UTC";
		String jdbc = "jdbc:mysql://localhost:3306/";
		this.percorso = jdbc + nomeDb + "?" + timeZone;
	}

	public Connection getC() 
	{
		return c;
	}

	public void setC(Connection c) 
	{
		this.c = c;
	}

	public void apriConnessione()
	{
		try
		{
			Class.forName(DRIVER);
			c = DriverManager.getConnection(percorso,username,password);
		}
		catch(Exception e)
		{
			System.out.println("Controlla build path, username e password!");
			e.printStackTrace();
		}
	}

	public void chiudiConnessione()
	{
		try
		{
			c.close();
		}
		catch(Exception e)
		{
			System.out.println("Non e' stato possibile chiudere la connessione.");
		}
	}
	
	public List<Map<String,String>> execute(String query, String...params)
	{
		List<Map<String,String>> listaMappe = new ArrayList<>();
		PreparedStatement ps = null;
		apriConnessione();
		
		try
		{
			ps = c.prepareStatement(query);
			
			for (int i = 0; i < params.length; i++)
			{
				ps.setString(i + 1, params[i]);
			}
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					Map<String,String> m = new LinkedHashMap<>();
					int nColonne = rs.getMetaData().getColumnCount();
					for (int i = 1; i <= nColonne; i++)
					{
						m.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
					}
					listaMappe.add(m);
				}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
			{
				try
				{
					ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();;
				}
			}
			chiudiConnessione();
		}
		return listaMappe;
	}
	
	public void update(String query, String...params)
	{
		PreparedStatement ps = null;
		apriConnessione();
		
		try 
		{
			ps = c.prepareStatement(query);
			for(int i = 0; i < params.length; i++)
			{
				ps.setString(i + 1, params[i]);
			}
			ps.executeUpdate();
			System.out.println("Tutto ok!");
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("Questa operazione non e' consentita, mi dispiace!");
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (ps != null)
			{
				try
				{
					ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();;
				}
			}
			chiudiConnessione();
		}
	}
}