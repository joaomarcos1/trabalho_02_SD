/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_sd_trabalho02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nupasd-ufpi
 */
public class MakeConnection {
    
    private static String db_url = "jdbc:mysql://localhost/sd";
    private static Connection con = null;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(db_url, "root", "root");

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver mysql nao encontrado");
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar conectar ao mysql");
        }
        return con;
    }
    
    public static PreparedStatement getPreparedStatement(String sql){
        if(con == null){
            con = getConnection();
        }
        try{
            return con.prepareStatement(sql);
        }catch(SQLException error){
            System.out.println("Erro de sql: " + error.getMessage());
        }
        return null;
    }
    
}
