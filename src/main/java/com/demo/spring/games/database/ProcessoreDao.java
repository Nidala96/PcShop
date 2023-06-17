package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class ProcessoreDao implements IDao {
    @Autowired
    private Database db;

    private String readOne =
            "select * from processore where id = ?";
    private String insert = 
            "insert into processore (nome, marca, prezzo, descrizione) values (?, ?, ?, ?)";
    
    private String read = 
            "select * from processore";
    
    private String update = 
            "update processore set nome = ?, marca = ?, prezzo = ?, descrizione = ? where id = ?";
    
    private String delete = 
            "delete from processore where id = ?";
        
    @Override
    public void add(Map<String, String> map) {
        db.update(insert, 
                    map.get("nome"),
                    map.get("marca"),
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
                    map.get("marca"),
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

    public List<Map<String, String>> read(int id) {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(readOne,
                String.valueOf(id));
        return lista;
    }
}
