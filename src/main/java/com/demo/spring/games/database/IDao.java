package com.demo.spring.games.database;

import java.util.*;

public interface IDao 
{
	void add(Map<String, String> map);
	List<Map<String,String>> read();
	void update(Map<String, String> map);
	void delete(int id);

    void delete(int pc_id, int utente_id);

	void deleteAll(int utente_id);

	List<Map<String, String>> read(int id);
}
