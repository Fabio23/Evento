/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabio.ribeiro
 */
public class DBConnector {

    public static String status = "Não conectou...";

    //Método de Conexão
    public static java.sql.Connection getConexaoDB() throws SQLException {
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = null;  //atributo do tipo Connection

        try {
            //********Conexão local***********///
            String serverName = "localhost"; // caminho do servidor do db
            String mydatabase = "basedados"; //nome do db
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;// Montagem da URL
            String username = "root"; //nome de um usuário do db      
            String password = "root"; //senha de acesso
            jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull
              
            //Conexão com servidor db
            connection = DriverManager.getConnection(url, username, password);
            
            //Testando a conexão 
            if (connection != null) 
                status = ("STATUS ---> Conectado com sucesso!");
             else
                status = ("STATUS ---> Não foi possivel realizar conexão!");
            
            return connection;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            
            System.err.println(e.getMessage());
            return null;
        }
    }

    //Método que retorna o status da conexão
    public static String statusConexao() {
        return status;
        
    }
    
    //Método que fecha a conexão
    public static boolean FecharConexao() {
        
        try {
            DBConnector.getConexaoDB().close();
            return true;
            
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia a conexão
    public static java.sql.Connection ReiniciarConexao() throws SQLException {
        FecharConexao();
        return DBConnector.getConexaoDB();
    }

}