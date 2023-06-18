package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class SchedaMadreDao implements IDao {
    @Autowired
    private Database db;

    private String readOne =
            "select * from schedaMadre where id = ?";
    private String insert = 
            "insert into schedaMadre (nome, supporto, prezzo, descrizione) values (?, ?, ?, ?)";
    
    private String read = 
            "select * from schedaMadre";
    
    private String update = 
            "update schedaMadre set nome = ?, supporto = ?, prezzo = ?, descrizione = ? where id = ?";
    
    private String delete = 
            "delete from schedaMadre where id = ?";
        
    @Override
    public void add(Map<String, String> map) {
        db.update(insert, 
                    map.get("nome"),
                    map.get("supporto"),
                    map.get("prezzo"),
                    map.get("descrizione"));
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
                    map.get("supporto"),
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

    public List<Map<String, String>> read(int id) {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(readOne,
                String.valueOf(id));
        return lista;
    }
}

