package org.example.service;

import org.example.entities.Manutencao;

import java.util.List;

public interface ManutencaoService {

    void agendarManutencao(Manutencao manutencao);

    List<Manutencao> listarManutencoes();

    void atualizarManutencao(Manutencao manutencao);

    void deletarManutencao(int id);
}
