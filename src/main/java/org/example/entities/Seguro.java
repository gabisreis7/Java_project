package org.example.entities;

import java.util.Date;

public class Seguro {

    private int id;
    private Long numeroApolice;
    private Date dataInicio;
    private Date dataFim;

    public Seguro(Date dataFim, Date dataInicio, int id, Long numeroApolice) {
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.id = id;
        this.numeroApolice = numeroApolice;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
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

    public void setNumeroApolice(String numeroApolice) {
        if (numeroApolice.length() != 10){
            throw new IllegalArgumentException("O número de apólice deve ter 10 digítos compostos por números e letras.");
        }
        this.numeroApolice = numeroApolice;
    }


    public void mostrarRegistroSeguro(){
        System.out.println("Apólice de Seguro: " + getNumeroApolice());
        System.out.println("Início de Seguro: " + getDataInicio());
        System.out.println("Fim de Seguro: " + getDataFim());
    }
}
