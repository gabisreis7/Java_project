package org.example.service;

import org.example.entities.Seguro;

import java.sql.SQLException;
import java.util.List;

public interface SeguroService {

    void cadastrarSeguro(Seguro seguro) throws SQLException;

    List<Seguro> listarSeguros() throws SQLException;

    void atualizarSeguro(Seguro seguro) throws SQLException;

    void deletarSeguro(int id) throws SQLException;
}
