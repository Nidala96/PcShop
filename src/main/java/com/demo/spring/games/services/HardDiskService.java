package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.HardDiskDao;
import com.demo.spring.games.entities.HardDisk;

public class HardDiskService 
{
	@Autowired
    private HardDiskDao hardDiskDao;
    
    @Autowired
    private ApplicationContext context;
    
    public List<HardDisk> getHardDisk()
    {
        List<HardDisk> hardDiskList = new ArrayList<>();
        
        for(Map<String, String> params : hardDiskDao.read()) 
        {
            hardDiskList.add(context.getBean(HardDisk.class, params));
        }
        return hardDiskList;
    }
    
    public void updateHardDisk(Map<String, String> params) 
    {
        hardDiskDao.update(context.getBean(HardDisk.class, params).toMap());
    }
    
    public void deleteHardDisk(int id) 
    {
        hardDiskDao.delete(id);
    }
    
    public void addHardDisk(Map<String, String> params) 
    {
        hardDiskDao.add(context.getBean(HardDisk.class, params).toMap());
    }
}