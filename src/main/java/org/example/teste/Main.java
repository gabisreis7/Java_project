package org.example.teste;

import org.example.ConexaoDbSingleton;
import org.example.dao.*;
import org.example.entities.Automovel;
import org.example.entities.Cliente;
import org.example.entities.Manutencao;
import org.example.service.*;

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
        System.out.println("Bem-vindo(a) à Mecânica Segura! O seu serviço exclusivo de agendamento mecânico");
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
        endereco = scan.nextLine();
        cliente.setEndereco(endereco);


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
            cliente.mostrarRegistroDados();



        AutomovelDao automovelDao = new AutomovelDaoImplementado(connection);
        AutomovelService automovelService = new AutomovelServiceImpl(automovelDao);

        Automovel automovel = new Automovel();
        String placaAutomovel, marcaAutomovel, modeloAutomovel, porteAutomovel;
        long numeroChassi, codigoRenavam;
        int anoAutomovel;



        System.out.println("Cadastro do automóvel: ");
        System.out.println("Nessa etapa você precisa fornecer os dados do seu automóvel!");

        System.out.println("");
        do {
            System.out.println("Informe a placa do veículo: ");
            try {
                placaAutomovel = scan.nextLine();
                automovel.setPlacaAutomovel(placaAutomovel);
                scan.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Por favor, tente novamente...");
            }
        } while (true);


        System.out.println("Informe a marca montadora: ");
        marcaAutomovel = scan.nextLine();
        automovel.setMarcaAutomovel(marcaAutomovel);
        System.out.println("Informe o modelo: ");
        modeloAutomovel = scan.nextLine();
        automovel.setModeloAutomovel(modeloAutomovel);
        System.out.println("Forneça o número de Chassi do automóvel: ");
        numeroChassi = scan.nextLong();
        automovel.setNumeroChassi(numeroChassi);
        do {
            System.out.println("Informe o código Renavam: ");
            try {
                codigoRenavam = scan.nextLong();
                automovel.setCodigoRenavam(codigoRenavam);
                scan.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Por favor, tente novamente...");
            }
        } while (true);

        System.out.println("Informe o ano de fabricação: ");
        anoAutomovel = scan.nextInt();
        automovel.setAnoAutomovel(anoAutomovel);
        System.out.println("Informe o porte do automóvel: ");
        porteAutomovel = scan.nextLine();
        automovel.setPorteAutomovel(porteAutomovel);


        automovelService.salvarAutomovel(automovel);
        automovel.mostrarCadastroAutomovel();

        System.out.println("Perfeito, seu cadastro foi realizado com sucesso!");
        System.out.println("Agora, precisamos que você forneça os dados do Seguro para que realizemos o serviço mecânico:");

        //SEGURO

        //PROBLEMA

        ManutencaoDao manutencaoDao = ManutencaoDaoImplSingleton.getInstance(connection);

        ManutencaoServiceFactory serviceFactory = new ManutencaoServiceFactory(manutencaoDao);
        ManutencaoService manutencaoService = serviceFactory.criarManutencaoService();

        System.out.println();

    }

}
