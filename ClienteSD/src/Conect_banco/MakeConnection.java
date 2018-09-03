/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conect_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tacio Moreira
 */
public class MakeConnection {
    
    /*
    CRIA CONECXAO COM BANCO DE DADOS PARA QUE A MANIPULAÇÃO DOS
    DADOS POSSAM SER MANIPULADOS
    */
    public static Connection getConnection(){
        String db_url = "jdbc:mysql://localhost/temas";
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(db_url,"root","tacio011");
        }catch(ClassNotFoundException ex){
            System.out.println("Driver mysql não encontrado!");
        }catch(SQLException ex){
            System.out.println("Erro ao tentar se conectar ao mysql");
        }
        
        return con;
    }
    
}
