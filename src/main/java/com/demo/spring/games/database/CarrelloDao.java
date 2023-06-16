package com.demo.spring.games.database;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarrelloDao implements IDao {
    @Autowired
    private Database db;
    
    private String insert = 
            "insert into carrello (pc_id, utente_id) values (?, ?)";
    
    private String read = 
            "select * from carrello";
    
    private String update = 
            "update carrello set pc_id = ?, utente_id = ?  where id = ?";
    
    private String delete = 
            "delete from carrello where id = ?";
        
    @Override
    public void add(Map<String, String> map) {
        db.update(insert, 
                    map.get("pc_id"),
                    map.get("utente_id"));
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
                    map.get("pc_id"),
                    map.get("utente_id"),
                    map.get("id"));
    }

    @Override
    public void delete(int id) {
        db.update(delete,
                    String.valueOf(id));
    }
}
