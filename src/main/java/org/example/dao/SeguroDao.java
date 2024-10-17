package org.example.dao;

import org.example.entities.Seguro;

import java.sql.SQLException;
import java.util.List;

public interface SeguroDao {
    void create(Seguro seguro) throws SQLException;

    List<Seguro> read() throws SQLException;

    void update(Seguro seguro) throws SQLException;

    void delete(int id) throws SQLException;
}
