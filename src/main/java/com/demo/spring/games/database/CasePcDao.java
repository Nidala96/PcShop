package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class CasePcDao implements IDao {
    @Autowired
    private Database db;
    
    private String insert = 
            "insert into casePc (nome, prezzo, descrizione) values (?, ?, ?)";
    
    private String read = 
            "select * from casePc";
    
    private String update = 
            "update casePc set nome = ?, prezzo = ?, descrizione = ?, immagineCase = ? where id = ?";

    private String readOne =
            "select * from casePc where id = ?";
    private String delete = 
            "delete from casePc where id = ?";
        
    @Override
    public void add(Map<String, String> map) {
        db.update(insert, 
                    map.get("nome"),
                    map.get("prezzo"),
                    map.get("descrizione"),
                    map.get("immaginecase"));
    }

    public List<Map<String, String>> read(int id) {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(readOne,
                String.valueOf(id));
        return lista;
    }

    @Override
    public List<Map<String, String>> read() {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(read);
        return lista;
    }
    
    @Override
    public void update(Map<String, String> map) {
        db.update(update, 
                    map.get("nome"),
                    map.get("prezzo"),
                    map.get("descrizione"),
                    map.get("id"));
    }

    @Override
    public void delete(int id) {
        db.update(delete,
                    String.valueOf(id));
    }

    @Override
    public void delete(int pc_id, int utente_id) {

    }

    @Override
    public void deleteAll(int utente_id)
    {

    }
}
