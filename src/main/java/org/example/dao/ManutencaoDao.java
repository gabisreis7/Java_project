package org.example.dao;

import org.example.entities.Manutencao;

import java.sql.SQLException;
import java.util.List;

public interface ManutencaoDao {

    void create(Manutencao manutencao) throws SQLException;

    List<Manutencao> read() throws SQLException;

    void update(Manutencao manutencao) throws SQLException;

    void delete(int id) throws SQLException;

    Manutencao findId(int id) throws SQLException;
}
