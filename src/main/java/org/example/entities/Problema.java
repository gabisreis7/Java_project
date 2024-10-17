package org.example.entities;

public class Problema {

    public int tipoProblema;
    public String descricaoProblema;
    public int gravidadeProblema;
    public Problema(int tipoProblema, String descricaoProblema, int gravidadeProblema) {
        this.tipoProblema = tipoProblema;
        this.descricaoProblema = descricaoProblema;
        this.gravidadeProblema = gravidadeProblema;
    }

    public void registrarProblema(int tipoProblema, String descricaoProblema) {
        this.tipoProblema = tipoProblema;
        this.descricaoProblema = descricaoProblema;
    }

    public void classificarGravidade(int gravidadeProblema) {
        try {
            if (gravidadeProblema >= 0 && gravidadeProblema <= 5) {
                this.gravidadeProblema = gravidadeProblema;
            } else {
                throw new Exception("Erro. Gravidade é classificada de 0 a 5");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
