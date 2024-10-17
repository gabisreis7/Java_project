package org.example.dao;

import org.example.entities.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {

    void create(Cliente cliente) throws SQLException;

    List<Cliente> read() throws SQLException;

    void update(Cliente cliente) throws SQLException;

    void delete(int id) throws SQLException;

    Cliente findId(int id) throws SQLException;
}
