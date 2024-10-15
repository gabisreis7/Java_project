package org.example.factory;

import org.example.entities.Cliente;

public class ClienteFactory {

    public static Cliente createCliente(Long id, String nome, int idade, String email, String senha, Long numeroCpf, Long numeroRg, String endereco, Long numeroCnh){
        return new Cliente(id, nome, idade, email, senha, numeroCpf, numeroRg, endereco, numeroCnh);
    }
}
