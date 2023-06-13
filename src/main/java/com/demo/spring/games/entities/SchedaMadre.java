package com.demo.spring.games.entities;

public class SchedaMadre extends Entity{
    private String nome;
    private String supporto;
    private double prezzo;
    private String descrizione;

    // Setter e getter per l'attributo "nome"
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Setter e getter per l'attributo "supporto"
    public void setSupporto(String supporto) {
        this.supporto = supporto;
    }

    public String getSupporto() {
        return supporto;
    }

    // Setter e getter per l'attributo "prezzo"
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    // Setter e getter per l'attributo "descrizione"
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    // Metodo toString per ottenere una rappresentazione testuale dell'oggetto SchedaMadre
    @Override
    public String toString() {
        return "SchedaMadre{" +
                "nome='" + nome + '\'' +
                ", supporto='" + supporto + '\'' +
                ", prezzo=" + prezzo +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
