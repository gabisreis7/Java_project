package org.example.entities;

public class ManutencaoPreventiva implements Manutencao {

    private String tipo;
    private String descricao;
    private String dataAgendamentoManutencao;
    private int horarioAgendamentoManutencao;
    private String enderecoCentroAutomotivo;

    public ManutencaoPreventiva(String tipo, String descricao, String dataAgendamentoManutencao, int horarioAgendamentoManutencao, String enderecoCentroAutomotivo) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataAgendamentoManutencao = dataAgendamentoManutencao;
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDataAgendamentoManutencao() {
        return dataAgendamentoManutencao;
    }

    public void setDataAgendamentoManutencao(String dataAgendamentoManutencao) {
        this.dataAgendamentoManutencao = dataAgendamentoManutencao;
    }

    @Override
    public int getHorarioAgendamentoManutencao() {
        return horarioAgendamentoManutencao;
    }

    public void setHorarioAgendamentoManutencao(int horarioAgendamentoManutencao) {
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
    }

    @Override
    public String getEnderecoCentroAutomotivo() {
        return enderecoCentroAutomotivo;
    }

    public void setEnderecoCentroAutomotivo(String enderecoCentroAutomotivo) {
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
    }
}
