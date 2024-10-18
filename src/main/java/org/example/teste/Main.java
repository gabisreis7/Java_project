package org.example.teste;

import org.example.ConexaoDbSingleton;
import org.example.dao.*;
import org.example.entities.*;
import org.example.service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan;


        Connection connection = ConexaoDbSingleton.getInstance().getConnection();
        ClienteDao clienteDao = new ClienteDaoImplementado(connection);
        ClienteService clienteService = new ClienteServiceImpl(clienteDao);

        Cliente cliente = new Cliente();
//
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

        SeguroDao seguroDao = new SeguroDaoImplementado(connection);
        SeguroService seguroService = new SeguroServiceImpl(seguroDao);

        Seguro seguro = new Seguro();
        Long numeroApolice;
        String vigencia;

        do {
            System.out.println("Informe o número da apólice de sua seguradora: ");
            try {
                 numeroApolice= scan.nextLong();
                seguro.setNumeroApolice(numeroApolice);
                scan.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Por favor, tente novamente...");
            }
        } while (true);

        System.out.println("Identifique a data de vigência do plano com a seguradora: ");
        vigencia = scan.nextLine();
        seguro.setVigencia(vigencia);

        seguroService.cadastrarSeguro(seguro);





        //PROBLEMA

        ProblemaDao problemaDao = new ProblemaDaoImplementado(connection);
        ProblemaServiceFactory serviceFactoryProb = new ProblemaServiceFactory(problemaDao);
        ProblemaService problemaService = serviceFactoryProb.criarProblemaService();

        Problema problema = new Problema();
        String tipoProblema, descricaoProblema;
        int gravidadeProblema;


        System.out.println("Parabéns! Seu cadastro foi 100% concluído");
        System.out.println("Bom, agora você poderá realizar sua consulta de manutenção automotiva!");

        System.out.println("Para podermos te ajudar você precisa informar o problema mecânico do seu automóvel e assim marcaremos a manutenção e revisão.");

        System.out.println("Qual é o tipo de problema que está ameaçando a saúde automotiva de seu veículo? ");
        tipoProblema = scan.nextLine();
        problema.setTipoProblema(tipoProblema);

        System.out.println("Descreva com mais detalhes como isso começou e como se desenvolveu: ");
        descricaoProblema = scan.nextLine();
        problema.setDescricaoProblema(descricaoProblema);

        do {
            System.out.println("Classifique entre 0 e 5 em relação a gravidade do problema, de acordo com sua opinião: ");
            try {
                gravidadeProblema = scan.nextInt();
                problema.setGravidadeProblema(gravidadeProblema);
                scan.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Por favor, tente novamente...");
            }
        } while (true);


        problemaService.cadastrarProblema(problema);



        System.out.println("Sentimos muito que esteja passando por esse problema mecânico...");

        System.out.println("Porém, temos a solução aplicável a esse problema: marcar o serviço de manutenção presencial no Centro Automotivo de sua escolha!");



        ManutencaoDao manutencaoDao = ManutencaoDaoImplSingleton.getInstance(connection);

        ManutencaoServiceFactory serviceFactory = new ManutencaoServiceFactory(manutencaoDao);
        ManutencaoService manutencaoService = serviceFactory.criarManutencaoService();

        Manutencao manutencao = new Manutencao();
        String dataAgendamentoManutencao, enderecoCentroAutomotivo;
        int horarioAgendamentoManutencao;

        System.out.println("Esses são os Centros Automotivos disponíveis na cidade de São Paulo: ");
        System.out.println("");
        System.out.println("CENTRO AUTOMOTIVO - JARDINS AV BRIGADEIRO LUIZ ANTONIO, 3383 - JARDIM PAULISTANO - SÃO PAULO");
        System.out.println("CENTRO AUTOMOTIVO - RIO BRANCO AV RIO BRANCO, 1448 - CAMPOS ELISEOS - SÃO PAULO");
        System.out.println("CENTRO AUTOMOTIVO - BELA VISTA - RUA PEDROSO R PEDROSO, 394 - BELA VISTA - SÃO PAULO");

        System.out.println("Informe o centro automotivo em que prefere realizar sua manutenção: ");
        enderecoCentroAutomotivo = scan.nextLine();
        manutencao.setEnderecoCentroAutomotivo(enderecoCentroAutomotivo);

        System.out.println("Informe a data de agendamento para o agendamento: ");
        dataAgendamentoManutencao = scan.nextLine();
        manutencao.setDataAgendamentoManutencao(dataAgendamentoManutencao);
        manutencao.validarAgendamento();

        System.out.println("Informe o horário da manutenção (dentro do horário comercial 9-18hrs: ");
        horarioAgendamentoManutencao = scan.nextInt();
        manutencao.setHorarioAgendamentoManutencao(horarioAgendamentoManutencao);

        manutencaoService.agendarManutencao(manutencao);



    }

}
