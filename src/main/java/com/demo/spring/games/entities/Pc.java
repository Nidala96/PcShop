package com.demo.spring.games.entities;

public class Pc extends Entity {
    private String nome;
    private double prezzo;
    private double percentualeSconto;
    private String tipo;
    private Processore processore;
    private Gpu gpu;
    private SchedaMadre schedaMadre;
    private CasePc casePc;

    private Ram ram;
    private HardDisk hardDisk;

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPercentualeSconto() {
        return percentualeSconto;
    }

    public void setPercentualeSconto(double percentualeSconto) {
        this.percentualeSconto = percentualeSconto;
    }

    public double calcolaPrezzoTotale()
    {
        double prezzoTotale = 0.0;
        if (processore != null)
        {
            prezzoTotale += processore.getPrezzo();
        }
        if (gpu != null)
        {
            prezzoTotale += gpu.getPrezzo();
        }
        if (schedaMadre != null)
        {
            prezzoTotale += schedaMadre.getPrezzo();
        }
        if (casePc != null)
        {
            prezzoTotale += casePc.getPrezzo();
        }
        if (ram != null)
        {
            prezzoTotale += ram.getPrezzo();
        }
        if (hardDisk != null)
        {
            prezzoTotale += hardDisk.getPrezzo();
        }
        return prezzoTotale;
    }

    // Setter e getter per l'attributo "nome"
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Setter e getter per l'attributo "prezzo"
    public void setPrezzo() {

        this.prezzo = calcolaPrezzoTotale();
    }

    public double getPrezzo() {
        return calcolaPrezzoTotale();
    }

    // Setter e getter per l'attributo "tipo"
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    // Setter e getter per l'attributo "processore"
    public void setProcessore(Processore processore) {
        this.processore = processore;
    }

    public Processore getProcessore() {
        return processore;
    }

    // Setter e getter per l'attributo "gpu"
    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public Gpu getGpu() {
        return gpu;
    }

    // Setter e getter per l'attributo "schedaMadre"
    public void setSchedaMadre(SchedaMadre schedaMadre) {
        this.schedaMadre = schedaMadre;
    }

    public SchedaMadre getSchedaMadre() {
        return schedaMadre;
    }

    // Setter e getter per l'attributo "casePc"
    public void setCasePc(CasePc casePc) {
        this.casePc = casePc;
    }




    public CasePc getCasePc() {
        return casePc;
    }

    // Metodo toString per ottenere una rappresentazione testuale dell'oggetto PC
    @Override
    public String toString() {
        return "PC{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", tipo='" + tipo + '\'' +
                ", processore=" + processore +
                ", gpu=" + gpu +
                ", schedaMadre=" + schedaMadre +
                ", casePc=" + casePc +
                '}';
    }
}

