package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.ProcessoreDao;
import com.demo.spring.games.entities.Processore;

public class ProcessoreService {
    @Autowired
    private ProcessoreDao processoreDao;

    @Autowired
    private ApplicationContext context;

    public List<Processore> getProcessori() {
        List<Processore> listaProcessori = new ArrayList<>();

        for (Map<String, String> params : processoreDao.read()) {
            listaProcessori.add(context.getBean(Processore.class, params));
        }

        return listaProcessori;
    }

    public void updateProcessore(Map<String, String> params) {
        processoreDao.update(context.getBean(Processore.class, params).toMap());
    }

    public void deleteProcessore(int id) {
        processoreDao.delete(id);
    }

    public void addProcessore(Map<String, String> params) {
        processoreDao.add(context.getBean(Processore.class, params).toMap());
    }
}

