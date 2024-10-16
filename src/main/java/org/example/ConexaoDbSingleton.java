package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDbSingleton {
    private static ConexaoDbSingleton instance;
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USUARIO = "rm558830";
    private static final String SENHA = "070306";
    private Connection connection;

    public ConexaoDbSingleton(){

    }

    public static ConexaoDbSingleton getInstance(){
        if (instance == null){
            synchronized (ConexaoDbSingleton.class){
                if (instance == null){
                    instance = new ConexaoDbSingleton();
                }
            }
        }
        return instance;
    }



    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        return connection;
    }


}
