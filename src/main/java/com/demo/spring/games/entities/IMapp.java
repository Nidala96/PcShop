package com.demo.spring.games.entities;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public interface IMapp 
{
	default void fromMap(Map<String, String> map) 
	{
		for(Method m: this.getClass().getMethods()) 
		{
			if(m.getName().startsWith("set") && m.getParameterCount() == 1) 
			{
				String nomeProp = m.getName().substring(3);
				nomeProp = Character.toLowerCase(nomeProp.charAt(0)) + nomeProp.substring(1);
				if(map.containsKey(nomeProp)) 
				{
					String valore = map.get(nomeProp);
					if(valore == null)
					{
						continue;
					}
					try 
					{
						String tipoParametro = m.getParameters()[0].getType().getSimpleName().toLowerCase();
						switch(tipoParametro) 
						{
						case "string":
							m.invoke(this, valore);
							break;
						case "int":
							m.invoke(this, Integer.parseInt(valore));
							break;
						case "double":
							m.invoke(this, Double.parseDouble(valore));
							break;
						case "boolean":
                            boolean booleanValue;
                            if (valore.equals("1")) 
                            {
                                booleanValue = true;
                            } else if (valore.equals("0")) 
                            {
                                booleanValue = false;
                            } else 
                            {
                                booleanValue = Boolean.parseBoolean(valore);
                            }
                            m.invoke(this, booleanValue);
                            break;
						}
					}catch (NumberFormatException e) 
					{
						e.printStackTrace();
						System.err.println("controlla i valori numerica");
					}catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
	}

	default Map<String,String> toMap()
	{
		Map<String,String> ris = new LinkedHashMap<String,String>();

		for(Method m : this.getClass().getMethods())
		{
			if ((m.getName().startsWith("get") || m.getName().startsWith("is")) 
					&& 
					!m.getName().equalsIgnoreCase("getClass") 
					&& 
					m.getParameterCount() == 0)
			{
				try
				{
					int partenza = m.getName().startsWith("get") ? 3 : 2;
					String nomeProp = m.getName().substring(partenza).toLowerCase();
					ris.put(nomeProp, m.invoke(this) + "");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
			}
		}
		return ris;
	}
}
