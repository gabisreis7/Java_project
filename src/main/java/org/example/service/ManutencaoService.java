package org.example.service;

import org.example.entities.Manutencao;

import java.sql.SQLException;
import java.util.List;

public interface ManutencaoService {

    void agendarManutencao(Manutencao manutencao) throws Exception;

    List<Manutencao> listarManutencoes() throws SQLException;

    void atualizarManutencao(Manutencao manutencao) throws SQLException;

    void deletarManutencao(int id) throws SQLException;
}
