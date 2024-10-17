package org.example.dao;

import org.example.entities.Automovel;

import java.sql.SQLException;
import java.util.List;

public interface AutomovelDao {

    void create(Automovel automovel) throws SQLException;

    List<Automovel> read() throws SQLException;

    void update(Automovel automovel) throws SQLException;

    void delete(int id) throws SQLException;

    Automovel findId(int id) throws SQLException;
}
