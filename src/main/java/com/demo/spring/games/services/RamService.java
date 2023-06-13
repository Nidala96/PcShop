package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.RamDao;
import com.demo.spring.games.entities.Ram;

public class RamService 
{
	@Autowired
    private RamDao ramDao;
    
    @Autowired
    private ApplicationContext context;
    
    public List<Ram> getRams()
    {
        List<Ram> ramList = new ArrayList<>();
        
        for(Map<String, String> params : ramDao.read()) {
            ramList.add(context.getBean(Ram.class, params));
        }
        return ramList;
    }
    
    public void updateRam(Map<String, String> params) 
    {
        ramDao.update(context.getBean(Ram.class, params).toMap());
    }
    
    public void deleteRam(int id) 
    {
        ramDao.delete(id);
    }
    
    public void addRam(Map<String, String> params) 
    {
        ramDao.add(context.getBean(Ram.class, params).toMap());
    }
}