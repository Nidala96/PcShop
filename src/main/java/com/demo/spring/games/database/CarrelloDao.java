package com.demo.spring.games.database;

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
            "update carrello set quantitaPc = ? where pc_id = ? and utente_id = ?";
    
    private String delete = 
            "DELETE FROM carrello\n" +
                    "WHERE utente_id = ? AND pc_id = ?;";

    private String readCarrello = "SELECT pc.*, carrello.pc_id ,carrello.quantitaPc\n" +
            "FROM pc\n" +
            "JOIN carrello ON pc.id = carrello.pc_id\n" +
            "WHERE carrello.utente_id = ? ;";

        
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
                    map.get("quantitaPc"),
                    map.get("pc_id"),
                    map.get("utente_id"));
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(int pc_id, int utente_id) {
        db.update(delete,
                    String.valueOf(pc_id),String.valueOf(utente_id));
    }

    @Override
    public List<Map<String, String>> read(int id) {
        List<Map<String, String>> lista = new ArrayList<>();
        lista = db.execute(readCarrello, String.valueOf(id));
        return lista;
    }
}
