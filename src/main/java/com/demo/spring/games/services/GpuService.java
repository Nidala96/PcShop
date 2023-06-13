package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.spring.games.entities.Gpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.GpuDao;


public class GpuService {
    @Autowired
    private GpuDao gpuDao;
    
    @Autowired
    private ApplicationContext context;
    
    public List<Gpu> getGpus(){
        List<Gpu> gpuList = new ArrayList<>();
        
        for(Map<String, String> params : gpuDao.read()) {
            gpuList.add(context.getBean(Gpu.class, params));
        }
        return gpuList;
    }
    
    public void updateGpu(Map<String, String> params) {
        gpuDao.update(context.getBean(Gpu.class, params).toMap());
    }
    
    public void deleteGpu(int id) {
        gpuDao.delete(id);
    }
    
    public void addGpu(Map<String, String> params) {
        gpuDao.add(context.getBean(Gpu.class, params).toMap());
    }
}
