package org.example.entities;

public class Problema {

    private Long id;
    private int tipoProblema;
    private String descricaoProblema;
    private int gravidadeProblema;


    public Problema(String descricaoProblema, int gravidadeProblema, Long id, int tipoProblema) {
        this.descricaoProblema = descricaoProblema;
        this.gravidadeProblema = gravidadeProblema;
        this.id = id;
        this.tipoProblema = tipoProblema;
    }

    public Problema(int tipoProblema, String descricaoProblema, int gravidadeProblema) {
        this.tipoProblema = tipoProblema;
        this.descricaoProblema = descricaoProblema;
        this.gravidadeProblema = gravidadeProblema;
    }




    public Problema() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.gravidadeProblema = gravidadeProblema;
    }

    public int getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(int tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public void registrarProblema() {
        this.tipoProblema = getTipoProblema();
        this.descricaoProblema = getDescricaoProblema();
    }

    public void classificarGravidade() {
        try {
            if (getGravidadeProblema() >= 0 && getGravidadeProblema() <= 5) {
                this.gravidadeProblema = getGravidadeProblema();

            } else {
                throw new Exception("Erro. Gravidade é classificada de 0 a 5");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}




