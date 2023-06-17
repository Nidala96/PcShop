package com.demo.spring.games.services;

import com.demo.spring.games.database.*;
import com.demo.spring.games.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarrelloService {
    @Autowired
    private CarrelloDao carrelloDao;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private PcDao pcDao;

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


    public List<Carrello> getCarrello()
    {
        List<Carrello> carrelloList = new ArrayList<>();

        for(Map<String, String> params : carrelloDao.read()) {
            carrelloList.add(context.getBean( Carrello.class, params));
        }
        return carrelloList;
    }

    public List<Pc> getCarrello(int utenteId) {
        List<Pc> carrelloList = new ArrayList<>();

        for (Map<String, String> params : carrelloDao.read(utenteId)) {
            Processore cpu = context.getBean(Processore.class, processoreDao.read(Integer.parseInt(params.get("processore_id"))).get(0));
            CasePc casePc = context.getBean(CasePc.class, casePcDao.read(Integer.parseInt(params.get("casePc_id"))).get(0));
            SchedaMadre schedaMadre = context.getBean(SchedaMadre.class, schedaMadreDao.read(Integer.parseInt(params.get("schedaMadre_id"))).get(0));
            Gpu gpu = context.getBean(Gpu.class, gpuDao.read(Integer.parseInt(params.get("gpu_id"))).get(0));
            Ram ram = context.getBean(Ram.class, ramDao.read(Integer.parseInt(params.get("ram_id"))).get(0));
            HardDisk hardDisk = context.getBean(HardDisk.class, hardDiskDao.read(Integer.parseInt(params.get("hardDisk_id"))).get(0));

            Pc pc = context.getBean(Pc.class, params);
            pc.setProcessore(cpu);
            pc.setCasePc(casePc);
            pc.setSchedaMadre(schedaMadre);
            pc.setGpu(gpu);
            pc.setRam(ram);
            pc.setHardDisk(hardDisk);

            carrelloList.add(pc);
        }

        return carrelloList;
    }

    public void updateCarrello(Map<String, String> params)
    {
        carrelloDao.update(context.getBean(Carrello.class, params).toMap());
    }

    public void deleteCarrello(int id)
    {
        carrelloDao.delete(id);
    }

    public void addCarrello(Map<String, String> params)
    {
        carrelloDao.add(params);
    }
}
