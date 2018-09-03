/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_sd_trabalho02;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import server_sd_trabalho02.Paciente;
import server_sd_trabalho02.MakeConnection;

/**
 *
 * @author Helbert Monteiro
 */
public class PacienteDAO {
    
    private PreparedStatement pstatement;
    
    private boolean  retorno;
    private String   sql;
    private Paciente paciente;
    
    public boolean cadastraPaciente(Paciente paciente){
        sql = "INSERT INTO usuario(nome, cpf, idade, peso, altura) VALUES(?, ?, ?, ?, ?)";
        
        pstatement = MakeConnection.getPreparedStatement(sql);
        
        try{
            pstatement.setString(1, paciente.getNome());
            pstatement.setString(2, paciente.getCpf());
            pstatement.setString(3, paciente.getSexo());
            
            retorno = true;
        }catch(Exception error){
            System.out.println("Erro de cadastro: " + error.getMessage());
            retorno = false;
        }
        
        return retorno;
    }
    
    public Paciente buscaPaciente(String nome){
        sql = "SELECT * FROM usuario where nome="+nome;
        
        pstatement = MakeConnection.getPreparedStatement(sql);
        
        try{
            pstatement.setString(1, nome);
            ResultSet resultado = pstatement.executeQuery();
            
            if(resultado.next()){
                paciente = new Paciente();
                
                paciente.setId    (resultado.getInt   ("id"));
                paciente.setNome  (resultado.getString("nome"));
                paciente.setCpf   (resultado.getString("cpf"));
                paciente.setSexo    (resultado.getString(""));
            }else{
                paciente = null;
            }
            
        }catch(SQLException error){
            System.out.println("Erro de sql: " + error.getMessage());
        }
        
        return paciente;
    }
    
}