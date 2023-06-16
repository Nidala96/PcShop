package com.demo.spring.games.entities;

public class Carrello extends Entity {

    private Pc pc;
    private Utente utente;


    public Pc getPc()
    {
        return pc;
    }

    public void setPc(Pc pc)
    {
        this.pc = pc;
    }

    public Utente getUtente()
    {
        return utente;
    }

    public void setUtente(Utente utente)
    {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Carrello" +
                "\npc= " + pc +
                "\nutente= " + utente;
    }
}

