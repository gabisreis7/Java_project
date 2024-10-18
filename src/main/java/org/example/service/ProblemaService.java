package org.example.service;

import org.example.entities.Problema;

import java.sql.SQLException;
import java.util.List;

public interface ProblemaService {

    void cadastrarProblema(Problema problema) throws SQLException;

    List<Problema> listarProblemas() throws SQLException;

    void atualizarProblema(Problema problema) throws Exception;

    void deletarProblema(int id) throws SQLException;
}
