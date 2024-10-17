package org.example.service;

import org.example.entities.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteService {

    void cadastrarCliente(Cliente cliente) throws SQLException;

    List<Cliente> listarClientes() throws SQLException;

    void atualizarCliente(Cliente cliente) throws SQLException;

    void deletarCliente(int id) throws SQLException;
}
