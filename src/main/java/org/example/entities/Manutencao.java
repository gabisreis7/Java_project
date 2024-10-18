package org.example.entities;

import java.time.LocalDate;

public class Manutencao {

    private int id;
    private String dataAgendamentoManutencao;
    private int horarioAgendamentoManutencao;
    private String enderecoCentroAutomotivo;

    public Manutencao(int id, String dataAgendamentoManutencao, int horarioAgendamentoManutencao, String enderecoCentroAutomotivo) {
        this.id = id;
        this.dataAgendamentoManutencao = dataAgendamentoManutencao;
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
    }

    public Manutencao() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataAgendamentoManutencao() {
        return dataAgendamentoManutencao;
    }

    public void setDataAgendamentoManutencao(String dataAgendamentoManutencao) {
            this.dataAgendamentoManutencao = dataAgendamentoManutencao;

    }


    public String getEnderecoCentroAutomotivo() {
        return enderecoCentroAutomotivo;
    }

    public void setEnderecoCentroAutomotivo(String enderecoCentroAutomotivo) {
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
    }

    public int getHorarioAgendamentoManutencao() {
        return horarioAgendamentoManutencao;
    }

    public void setHorarioAgendamentoManutencao(int horarioAgendamentoManutencao) {
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
    }

    public void mostrarAgendamento(){
        System.out.println("Confirmação de agendamento: ");
        System.out.println("Centro Automotivo: " + getEnderecoCentroAutomotivo());
        System.out.println("Data de agendamento: " + getDataAgendamentoManutencao());
        System.out.println("Horário de agendamento: " + getHorarioAgendamentoManutencao());
    }




}
