package com.demo.spring.games.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class PcDao implements IDao {
    @Autowired
    private Database db;

    private String insert =
            "insert into pc (nome, tipo, percentualesconto, processore_id, gpu_id, schedaMadre_id, casePc_id,ram_id, hardDisk_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private String read =
            "select * from pc";

    private String update =
            "update pc set nome = ?, tipo = ?, percentualesconto = ?, processore_id = ?, gpu_id = ?, schedaMadre_id = ?, casePc_id = ?, ram_id = ?, hardDisk_id = ?  where id = ?";

    private String delete =
            "delete from pc where id = ?";

    private String readCarrello = "SELECT pc.*\n" +
            "FROM pc\n" +
            "JOIN carrello ON pc.id = carrello.pc_id\n" +
            "WHERE carrello.utente_id = ?;";

    @Override
    public void add(Map<String, String> map) {
        db.update(insert,
                map.get("nome"),
                map.get("tipo"),
                map.get("percentualeSconto"),
                map.get("processore_id"),
                map.get("gpu_id"),
                map.get("schedaMadre_id"),
                map.get("casePc_id"),
                map.get("ram_id"),
                map.get("hardDisk_id"));
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
                map.get("tipo"),
                map.get("percentualeSconto"),
                map.get("processore_id"),
                map.get("gpu_id"),
                map.get("schedaMadre_id"),
                map.get("casePc_id"),
                map.get("ram_id"),
                map.get("hardDisk_id"),
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