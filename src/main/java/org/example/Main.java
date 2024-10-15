package org.example;

import org.example.dao.ClienteDaoImplementado;
import org.example.service.ClienteService;
import org.example.service.ClienteServiceSingleton;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {


            ConexaoDb conexaoDb =  DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL");

            ClienteDaoImplementado clienteDao = new ClienteDaoImplementado(connection);

            ClienteService clienteService = ClienteServiceSingleton.getInstance(clienteDao);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Informe seu nome completo: ");
            String nome = scanner.nextLine();






        } catch (SQLException e) {
            e.printStackTrace();

        }

        }
}