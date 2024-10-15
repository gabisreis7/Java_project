package org.example.service;

import org.example.entities.Cliente;

import java.util.List;

public interface ClienteService {

    void criarCliente(Cliente cliente);

    List<Cliente> listarClientes();

    void atualizarCliente(Cliente cliente);

    void deletarCliente(Long id, String nome, int idade, String email, String senha, Long numeroCpf, Long numeroRg, String endereco, Long numeroCnh);
}
