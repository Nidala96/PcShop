package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.spring.games.entities.SchedaMadre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.SchedaMadreDao;


public class SchedaMadreService {
    @Autowired
    private SchedaMadreDao schedaMadreDao;
    
    @Autowired
    private ApplicationContext context;
    
    public List<SchedaMadre> getSchedeMadre(){
        List<SchedaMadre> schedaMadreList = new ArrayList<>();
        
        for(Map<String, String> params : schedaMadreDao.read()) {
            schedaMadreList.add(context.getBean(SchedaMadre.class, params));
        }
        return schedaMadreList;
    }
    
    public void updateSchedaMadre(Map<String, String> params) {
        schedaMadreDao.update(context.getBean(SchedaMadre.class, params).toMap());
    }
    
    public void deleteSchedaMadre(int id) {
        schedaMadreDao.delete(id);
    }
    
    public void addSchedaMadre(Map<String, String> params) {
        schedaMadreDao.add(context.getBean(SchedaMadre.class, params).toMap());
    }
}
