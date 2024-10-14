package org.example.entities;

public class Manutencao {

    private Long id;
    private String dataAgendamentoManutencao;
    private int horarioAgendamentoManutencao;
    private String enderecoCentroAutomotivo;





    public Manutencao() {

    }


    public Manutencao(String dataAgendamentoManutencao, String enderecoCentroAutomotivo, int horarioAgendamentoManutencao, Long id) {
        this.dataAgendamentoManutencao = dataAgendamentoManutencao;
        this.enderecoCentroAutomotivo = enderecoCentroAutomotivo;
        this.horarioAgendamentoManutencao = horarioAgendamentoManutencao;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void agendarManutencao() {
        System.out.println("Dia da semana escolhido para a realização da manutenção: " + getDataAgendamentoManutencao());
    }

    public void agendarHorario() {
        System.out.println("Horário escolhido: " + getHorarioAgendamentoManutencao());
    }

    public void verificarCentroAutomotivo() {
        System.out.println("Centro Automotivo selecionado: " + getEnderecoCentroAutomotivo());
    }


}




