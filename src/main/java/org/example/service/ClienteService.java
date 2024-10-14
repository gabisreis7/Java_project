package org.example.service;

import org.example.dao.ClienteDao;
import org.example.entities.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteService implements ClienteDao {

    private final ClienteDao clienteDao;

    public ClienteService(ClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    @Override
    public void create(Cliente cliente){
        validarCliente(cliente);
        try {
            clienteDao.create(cliente);
        } catch (SQLException e){
            throw new RuntimeException("Erro ao criar cliente " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> read(){
        try{
            return clienteDao.read();

        } catch (SQLException e){
            throw new RuntimeException("Erro ao listar clientes " + e.getMessage());
        }
    }


    @Override
    public void update(Cliente cliente){
        validarCliente(cliente);
        try {
            clienteDao.update(cliente);
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar cliente " + e.getMessage());
        }

    }

    @Override
    public void delete(Long id, String nome, int idade, String email, String senha, Long numeroCpf, Long numeroRg, String endereco, Long numeroCnh){
        try{
            clienteDao.delete(id, nome, idade, email, senha, numeroCpf, numeroRg, endereco, numeroCnh);
        } catch (SQLException e){
            throw new RuntimeException("Erro ao deletar cliente " + e.getMessage());
        }
    }



    private void validarIdade(int idade){
        if (idade < 18){
            throw new IllegalArgumentException("Cliente deve ser maior de idade");
        }
    }

    public void validarCliente(Cliente cliente){
        validarIdade(cliente.getIdade());
        validarCpf(cliente.getNumeroCpf());
        validarRg(cliente.getNumeroRg());
        validarCnh(cliente.getNumeroCnh());
    }

    public void validarCpf(Long numeroCpf){
        String cpfstr = String.valueOf(numeroCpf);
        if (cpfstr.length() != 11){
            throw new IllegalArgumentException("CPF deve ter 11 digítos númericos");
        }
    }

    public void validarRg(Long numeroRg){
        String rgstr = String.valueOf(numeroRg);
        if (rgstr.length() != 9){
            throw new IllegalArgumentException("RG deve ter 9 dígitos numéricos");
        }
    }

    public void validarCnh(Long numeroCnh){
        String cnhstr = String.valueOf(numeroCnh);
        if (cnhstr.length() != 11){
            throw new IllegalArgumentException("CNH deve ter 11 dígitos numéricos");
        }
    }
}
