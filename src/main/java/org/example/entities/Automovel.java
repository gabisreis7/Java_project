package org.example.entities;

public class Automovel {

    private String placaAutomovel;
    private String marcaAutomovel;
    private String modeloAutomovel;
    private long numeroChassi;
    private long codigoRenavam;
    private int anoAutomovel;
    private String porteAutomovel;


    public Automovel(String placaAutomovel, String marcaAutomovel, String modeloAutomovel, long numeroChassi, long codigoRenavam, int anoAutomovel, String porteAutomovel) {
        this.placaAutomovel = placaAutomovel;
        this.marcaAutomovel = marcaAutomovel;
        this.modeloAutomovel = modeloAutomovel;
        this.numeroChassi = numeroChassi;
        this.codigoRenavam = codigoRenavam;
        this.anoAutomovel = anoAutomovel;
        this.porteAutomovel = porteAutomovel;
    }

    public String getPlacaAutomovel() {

        return placaAutomovel;
    }




    public void setPlacaAutomovel(String placaAutomovel) {
        this.placaAutomovel = placaAutomovel;
    }




    public String getMarcaAutomovel() {

        return marcaAutomovel;
    }




    public void setMarcaAutomovel(String marcaAutomovel) {

        this.marcaAutomovel = marcaAutomovel;
    }




    public String getModeloAutomovel() {

        return modeloAutomovel;
    }




    public void setModeloAutomovel(String modeloAutomovel) {

        this.modeloAutomovel = modeloAutomovel;
    }




    public long getNumeroChassi() {

        return numeroChassi;
    }




    public void setNumeroChassi(long numeroChassi) {

        this.numeroChassi = numeroChassi;
    }




    public long getCodigoRenavam() {

        return codigoRenavam;
    }




    public void setCodigoRenavam(long codigoRenavam) {

        this.codigoRenavam = codigoRenavam;
    }




    public int getAnoAutomovel() {

        return anoAutomovel;
    }




    public void setAnoAutomovel(int anoAutomovel) {

        this.anoAutomovel = anoAutomovel;
    }




    public String getPorteAutomovel() {

        return porteAutomovel;
    }




    public void setPorteAutomovel(String porteAutomovel) {

        this.porteAutomovel = porteAutomovel;
    }




    public void mostrarCadastroAutomovel() {
        System.out.println("Dados do automóvel cadastrados!");
        System.out.println("");
        System.out.println("Informações do identificador do automóvel");
        System.out.println("Placa do automóvel: " + getPlacaAutomovel());
        System.out.println("Código RENAVAM: " + getCodigoRenavam());
        System.out.println("Número de Chassi: " + getNumeroChassi());
    }





}




