package com.demo.spring.games.database;

import java.util.*;

public interface IDao 
{
	void add(Map<String, String> map);
	List<Map<String,String>> read();
	void update(Map<String, String> map);
	void delete(int id);

	List<Map<String, String>> read(int id);
}