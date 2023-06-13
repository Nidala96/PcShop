package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class HardDiskDao implements IDao
{
	@Autowired
    private Database db;

    private String insert =
            "insert into hardDisk (nome, tipo, quantitaMem, descrizione, prezzo) values (?, ?, ?, ?, ?)";

    private String readOne =
            "select * from hardDisk where id = ?";

    private String read =
            "select * from hardDisk";

    private String update =
            "update hardDisk set nome = ?, tipo = ?, quantitaMem = ?, descrizione = ?, prezzo = ? where id = ?";

    private String delete =
            "delete from hardDisk where id = ?";

    @Override
    public void add(Map<String, String> map) 
    {
        db.update(insert,
                map.get("nome"),
                map.get("tipo"),
                map.get("quantitaMem"),
        		map.get("descrizione"),
        		map.get("prezzo"));
    }

    @Override
    public List<Map<String, String>> read() 
    {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(read);
        return lista;
    }

    public List<Map<String, String>> read(int id) 
    {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(readOne,
                String.valueOf(id));
        return lista;
    }

    @Override
    public void update(Map<String, String> map) 
    {
        db.update(update, map.get("nome"),
                		  map.get("tipo"),
                		  map.get("quantitaMem"),
                		  map.get("descrizione"),
                		  map.get("prezzo"),
                		  map.get("id"));
    }

    @Override
    public void delete(int id) 
    {
        db.update(delete, String.valueOf(id));
    }
}