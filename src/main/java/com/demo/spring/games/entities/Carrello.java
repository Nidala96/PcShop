package com.demo.spring.games.entities;

public class Carrello implements IMapp {

    private long pc_id;

    private long utente_id;

    private long quantitaPc;

    public long getPc_id() {
        return pc_id;
    }

    public void setPc_id(long pc_id) {
        this.pc_id = pc_id;
    }

    public long getUtente_id() {
        return utente_id;
    }

    public void setUtente_id(long utente_id) {
        this.utente_id = utente_id;
    }

    public long getQuantitaPc() {
        return quantitaPc;
    }

    public void setQuantitaPc(long quantitaPc) {
        this.quantitaPc = quantitaPc;
    }

}

