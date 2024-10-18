package org.example.entities;

public class Problema {

    private int id;
    private String tipoProblema;
    private String descricaoProblema;
    private int gravidadeProblema;


    public Problema(int id, String tipoProblema, String descricaoProblema, int gravidadeProblema) {
        this.id = id;
        this.tipoProblema = tipoProblema;
        this.descricaoProblema = descricaoProblema;
        this.gravidadeProblema = gravidadeProblema;
    }

    public Problema() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public int getGravidadeProblema() {
        return gravidadeProblema;
    }

    public void setGravidadeProblema(int gravidadeProblema) {

        if (gravidadeProblema >= 0 && gravidadeProblema <=5){
            this.gravidadeProblema = gravidadeProblema;
        } else {
            throw new IllegalArgumentException("Erro. A gravidade deve ser classificada de 0 a 5");
        }

    }


}
