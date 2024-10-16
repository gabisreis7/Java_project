package org.example.entities;

import java.time.LocalDate;

public class Manutencao {

    private int id;
    private String tipoManutencao;
    private String descricao;
    private String dataAgendamentoManutencao;
    private int horarioAgendamentoManutencao;
    private String enderecoCentroAutomotivo;

    public Manutencao(int id, String tipoManutencao, String descricao, String dataAgendamentoManutencao, int horarioAgendamentoManutencao, String enderecoCentroAutomotivo) {
        this.id = id;
        this.tipoManutencao = tipoManutencao;
        this.descricao = descricao;
        this.dataAgendamentoManutencao = dataAgendamentoManutencao;
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }

    public void validarAgendamento() throws Exception {
        LocalDate hoje = LocalDate.now();
        LocalDate dataAgendada = LocalDate.parse(getDataAgendamentoManutencao());

        if (dataAgendada.isBefore(hoje.plusDays(7))){
            throw new Exception("A manutenção deve ser agendado em um prazo de 7 dias");
        }
        }
}
