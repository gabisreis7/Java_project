package org.example.dao;

import org.example.entities.Problema;

import java.sql.SQLException;
import java.util.List;

public interface ProblemaDao {

    void create(Problema problema) throws SQLException;

    List<Problema> read() throws SQLException;

    void update(Problema problema) throws SQLException;

    void delete(int id) throws SQLException;

    Problema findId(int id) throws SQLException;
}
