package org.example.service;

import org.example.dao.ClienteDao;
import org.example.entities.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteServiceImpl implements ClienteService{
    private final ClienteDao clienteDao;

    public ClienteServiceImpl(ClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }


    @Override
    public void cadastrarCliente(Cliente cliente) throws SQLException {
        this.clienteDao.create(cliente);
    }

    @Override
    public List<Cliente> listarClientes() throws SQLException {
        return this.clienteDao.read();
    }

    @Override
    public void atualizarCliente(Cliente cliente) throws SQLException {
        Cliente clienteAtualizado = this.clienteDao.findId(cliente.getId());
        clienteAtualizado.setNome(cliente.getNome());
        this.clienteDao.update(cliente);

    }

    @Override
    public void deletarCliente(int id) throws SQLException {
        Cliente clienteAchado = clienteDao.findId(id);
        clienteDao.delete(clienteAchado.getId());

    }
}

