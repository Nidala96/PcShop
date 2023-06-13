package com.demo.spring.games.services;

import com.demo.spring.games.database.*;
import com.demo.spring.games.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PcService {

    @Autowired
    private PcDao pcDao;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ProcessoreDao processoreDao;

    @Autowired
    private GpuDao gpuDao;

    @Autowired
    private SchedaMadreDao schedaMadreDao;

    @Autowired
    private CasePcDao casePcDao;

    @Autowired
    private HardDiskDao hardDiskDao;

    @Autowired
    private RamDao ramDao;

    public List<Pc> getPcs()
    {
        List<Pc> listaPc = new ArrayList<>();

        for(Map<String, String> params : pcDao.read())
        {
            Processore cpu = context.getBean(Processore.class, processoreDao.read(Integer.parseInt(params.get("processore_id"))).get(0));
            CasePc casePc = context.getBean(CasePc.class, casePcDao.read(Integer.parseInt(params.get("casePc_id"))).get(0));
            SchedaMadre schedaMadre = context.getBean(SchedaMadre.class, schedaMadreDao.read(Integer.parseInt(params.get("schedaMadre_id"))).get(0));
            Gpu gpu = context.getBean(Gpu.class, gpuDao.read(Integer.parseInt(params.get("gpu_id"))).get(0));
            Pc pc = context.getBean(Pc.class, params);
            Ram ram = context.getBean(Ram.class, ramDao.read(Integer.parseInt(params.get("ram_id"))).get(0));
            HardDisk hardDisk = context.getBean(HardDisk.class, hardDiskDao.read(Integer.parseInt(params.get("hardDisk_id"))).get(0));
            pc.setProcessore(cpu);
            pc.setCasePc(casePc);
            pc.setSchedaMadre(schedaMadre);
            pc.setGpu(gpu);
            pc.setRam(ram);
            pc.setHardDisk(hardDisk);
            listaPc.add(pc);
        }
        return listaPc;
    }


    public void updatePC(Map<String, String> params) {
        Pc pc = context.getBean(Pc.class, params);
        Map<String, String> map = pc.toMap();
        map.put("processore_id", params.get("processore_id"));
        map.put("gpu_id", params.get("gpu_id"));
        map.put("casePc_id", params.get("casePc_id"));
        map.put("schedaMadre_id", params.get("schedaMadre_id"));
        map.put("percentualeSconto", String.valueOf((Double.parseDouble(params.get("percentualeSconto") )/100)));
        map.put("ram_id", params.get("ram_id"));
        map.put("hardDisk_id", params.get("hardDisk_id"));
        pcDao.update(map);
    }

    public void deletePC(int id) {
        pcDao.delete(id);
    }

    public void addPC(Map<String, String> params) {
        Pc pc = context.getBean(Pc.class, params);
        Map<String, String> map = pc.toMap();
        map.put("processore_id", params.get("processore_id"));
        map.put("gpu_id", params.get("gpu_id"));
        map.put("casePc_id", params.get("casePc_id"));
        map.put("schedaMadre_id", params.get("schedaMadre_id"));
        map.put("percentualeSconto", params.get("percentualeSconto"));
        map.put("ram_id", params.get("ram_id"));
        map.put("hardDisk_id", params.get("hardDisk_id"));
        pcDao.add(map);
    }

}


