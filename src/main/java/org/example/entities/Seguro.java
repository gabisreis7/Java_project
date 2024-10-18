package org.example.entities;

import java.util.Date;

public class Seguro {

    private int id;
    private Long numeroApolice;
    private String vigencia;

    public Seguro(int id, Long numeroApolice, String vigencia) {
        this.id = id;
        this.numeroApolice = numeroApolice;
        this.vigencia = vigencia;
    }

    public Seguro() {

    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(Long numeroApolice) {
        String apolicestr = String.valueOf(numeroApolice);
        if (apolicestr.length() != 10){
            throw new IllegalArgumentException("O número de apólice deve ter 10 digítos compostos por números e letras.");
        }
        this.numeroApolice = numeroApolice;
    }



}
