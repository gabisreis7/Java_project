package org.example.entities;

public class ManutencaoFactoryImplementado implements ManutencaoFactory {


    public  Manutencao criarManutencao(String tipo, String descricao, String dataAgendamentoManutencao, int horarioAgendamentoManutencao, String enderecoCentroAutomotivo) {
        if (tipo.equalsIgnoreCase("Corretiva")){
            return new ManutencaoCorretiva(tipo, descricao, dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo);
        } else if (tipo.equalsIgnoreCase("Preventiva")) {
            return new ManutencaoPreventiva(tipo, descricao, dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo);
        }else {
            throw new IllegalArgumentException("Tipo de manutenção inválido: ");
        }
    }



    @Override
    public void agendarManutencao(String dataAgendamentoManutencao) {
        System.out.println("Dia da semana escolhido para o agendamento: " + dataAgendamentoManutencao);
    }

    @Override
    public void agendarHorario(String horarioAgendamentoManutencao) {
        System.out.println("Horário agendado: " + horarioAgendamentoManutencao);
    }

    @Override
    public void verificarCentroAutomotivo(String enderecoCentroAutomotivo) {
        System.out.println("Endereço do centro automotivo: " + enderecoCentroAutomotivo);
    }
}