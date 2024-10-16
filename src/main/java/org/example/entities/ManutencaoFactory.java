package org.example.entities;

public interface ManutencaoFactory {

        Manutencao criarManutencao(String tipo, String descricao, String dataAgendamentoManutencao, int horarioAgendamentoManutencao, String enderecoCentroAutomotivo);


    }
