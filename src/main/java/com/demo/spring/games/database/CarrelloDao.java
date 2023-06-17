package com.demo.spring.games.database;

import com.demo.spring.games.entities.Carrello;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarrelloDao implements IDao {
    @Autowired
    private Database db;
    
    private String insert = 
            "insert into carrello (pc_id, utente_id, quantitaPc) values (?, ?, ?)";
    
    private String read = 
            "select * from carrello";
    
    private String update = 
            "update carrello set pc_id = ?, utente_id = ?, quantitaPc = ?  where id = ?";
    
    private String delete = 
            "delete from carrello where id = ?";

    private String readCarrello = "SELECT pc.*\n" +
            "FROM pc\n" +
            "JOIN carrello ON pc.id = carrello.pc_id\n" +
            "WHERE carrello.utente_id = ?;";
        
    @Override
    public void add(Map<String, String> map) {
        db.update(insert, 
                    map.get("pc_id"),
                    map.get("utente_id"),
                    map.get("quantitaPc"));
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
                    map.get("quantitaPc"),
                    map.get("id"));
    }

    @Override
    public void delete(int id) {
        db.update(delete,
                    String.valueOf(id));
    }

    @Override
    public List<Map<String, String>> read(int id) {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(readCarrello, String.valueOf(id));
        return lista;
    }
}
