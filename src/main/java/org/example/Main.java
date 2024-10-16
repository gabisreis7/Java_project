package org.example;

import org.example.dao.ManutencaoDaoImplementado;
import org.example.entities.*;
import org.example.service.ManutencaoServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    public static final String USER = "rm558830";
    public static final String PASS = "070306";



    public static void main(String[] args) throws SQLException {


        try {





            Scanner scanner = new Scanner(System.in);

//            System.out.println("Informe seu nome completo: ");
//            String nome = scanner.nextLine();
//
//            System.out.println("Informe sua idade: ");
//            int idade = scanner.nextInt();
//
//            System.out.println("Cadastre um email: ");
//            String email = scanner.nextLine();
//
//            System.out.println("Crie uma senha de acesso: ");
//            String senha = scanner.nextLine();
//
//            System.out.println("Informe seu número de CPF: ");
//            Long numeroCpf = scanner.nextLong();
//
//            System.out.println("Informe seu número de RG: ");
//            Long numeroRg = scanner.nextLong();
//
//            System.out.println("Cadastre seu endereço principal: ");
//            String endereco = scanner.nextLine();
//
//            System.out.println("Informe o número da CNH: ");
//            Long numeroCnh = scanner.nextLong();
//
//            Cliente cliente = Cliente.createCliente(nome, idade, email, senha, numeroCpf, numeroRg, endereco, numeroCnh);
//
//            clienteService.criarCliente(cliente);
//
//            cliente.mostrarRegistroDados();

            Manutencao manutencao;
            ManutencaoDaoImplementado manutencaoDao = new ManutencaoDaoImplementado(connection);
            ManutencaoServiceImpl manutencaoService = new ManutencaoServiceImpl(manutencaoDao);
            ManutencaoFactoryImplementado manutencaoFactoryImplementado = new ManutencaoFactoryImplementado();

            System.out.println("Qual tipo de manutenção você procura? (Corretiva/Preditiva)");
            String tipo = scanner.nextLine();

            System.out.println("Explique melhor sobre a manutenção e seus motivos para essa procura: ");
            String descricao = scanner.nextLine();

            System.out.println("Informe a data para agendar a manutenção: ");
            String dataAgendamentoManutencao = scanner.nextLine();

            System.out.println("Informe o horário desejado (em formato 24h): ");
            int horarioAgendamentoManutencao = scanner.nextInt();

            System.out.println("Digite o centro automotivo do seguro desejado: ");
            String enderecoCentroAutomotivo = scanner.nextLine();


            try {
                manutencao = manutencaoFactoryImplementado.criarManutencao(tipo, descricao, dataAgendamentoManutencao, horarioAgendamentoManutencao, enderecoCentroAutomotivo);
                manutencaoService.createManutencao(manutencao);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            } catch (Exception e) {
                System.out.println("Erro ao agendar manutenção: " + e.getMessage());
            }

        }







        }
