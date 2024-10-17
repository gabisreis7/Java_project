package org.example.service;

import org.example.entities.Automovel;

import java.sql.SQLException;
import java.util.List;

public interface AutomovelService {

    void salvarAutomovel(Automovel automovel) throws SQLException;

    List<Automovel> listarAutomoveis() throws SQLException;

    void atualizarAutomovel(Automovel automovel) throws SQLException;

    void deletarAutomovel(int id) throws SQLException;
}
