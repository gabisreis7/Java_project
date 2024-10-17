package org.example.teste;

import org.example.ConexaoDbSingleton;
import org.example.dao.ClienteDao;
import org.example.dao.ClienteDaoImplementado;
import org.example.entities.Cliente;
import org.example.service.ClienteService;
import org.example.service.ClienteServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scan;


        Connection connection = ConexaoDbSingleton.getInstance().getConnection();
        ClienteDao clienteDao = new ClienteDaoImplementado(connection);
        ClienteService clienteService = new ClienteServiceImpl(clienteDao);

        Cliente cliente = new Cliente();

        scan = new Scanner(System.in);
        String nome, email, senha, endereco;
        long numeroCpf, numeroRg, numeroCnh;
        System.out.println("Bem-vindo(a) à Mecânica Segura!");
        System.out.println("O primeiro passo para usufrir dos nossos serviços é fazer seu cadastro!");
        System.out.println("");
        System.out.println("Cadastro Pessoal");
        System.out.println("Preencha seus dados pessoais");

        System.out.println("Informe seu nome completo: ");
        nome = scan.nextLine();
        cliente.setNome(nome);


        try {
            System.out.println("Informe sua idade: ");
            cliente.setIdade(scan.nextInt());
            scan.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Idade inválida: " + e.getMessage());
            System.out.println("Infelizmente o serviço não é disponível para menores de idade...");
            System.exit(0);
        }


        System.out.println("Informe seu email: ");
        email = scan.nextLine();
        cliente.setEmail(email);


        System.out.println("Crie uma senha de acesso: ");
        senha = scan.nextLine();
        cliente.setSenha(senha);


        do {
            System.out.println("Informe o número de CPF: ");
            try {
                numeroCpf = scan.nextLong();
                cliente.setNumeroCpf(numeroCpf);
                scan.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Por favor, tente novamente...");
            }
        } while (true);


        do {
            System.out.println("Informe o número de RG: ");
            try {
                numeroRg = scan.nextLong();
                cliente.setNumeroRg(numeroRg);
                scan.nextLine(); // Limpa a linha
                break;  // Sai do loop se o RG for válido
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Por favor, tente novamente...");
            }
        } while (true);


        System.out.println("Informe seu endereço completo: ");
        cliente.setEndereco(scan.nextLine());


        do {
            try {
                System.out.println("Informe sua CNH: ");
                numeroCnh = scan.nextLong();
                cliente.setNumeroCnh(numeroCnh);
                scan.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Por favor, tente novamente!");
            }
        } while (true);

            clienteService.cadastrarCliente(cliente);



    }

}
