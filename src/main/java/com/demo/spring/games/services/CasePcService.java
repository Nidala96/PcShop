package com.demo.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.spring.games.entities.CasePc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.demo.spring.games.database.CasePcDao;


public class CasePcService {
    @Autowired
    private CasePcDao casePcDao;
    
    @Autowired
    private ApplicationContext context;
    
    public List<CasePc> getCasePc(){
        List<CasePc> casePcList = new ArrayList<>();
        
        for(Map<String, String> params : casePcDao.read()) {
            casePcList.add(context.getBean(CasePc.class, params));
        }
        return casePcList;
    }
    
    public void updateCasePc(Map<String, String> params) {
        casePcDao.update(context.getBean(CasePc.class, params).toMap());
    }
    
    public void deleteCasePc(int id) {
        casePcDao.delete(id);
    }
    
    public void addCasePc(Map<String, String> params) {
        casePcDao.add(context.getBean(CasePc.class, params).toMap());
    }
}
