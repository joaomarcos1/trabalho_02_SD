/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_sd_trabalho02;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helbert Monteiro
 */
public class PacienteDAO {
    
    private PreparedStatement pstatement;
    ResultSet resultado;
    
    private String       sql;
    private Paciente     paciente;
    private List<Double> listaImc;
    
    public boolean cadastraPaciente(Paciente paciente){
        sql = "INSERT INTO usuarios(nome, cpf, idade, peso, altura) VALUES(?, ?, ?, ?, ?)";
        
        pstatement = MakeConnection.getPreparedStatement(sql);
        
        try{
            pstatement.setString(1, paciente.getNome());
            pstatement.setString(2, paciente.getCpf());
            pstatement.setInt   (3, paciente.getIdade());
            pstatement.setDouble(4, paciente.getPeso());
            pstatement.setDouble(5, paciente.getAltura());
            
            return true;
        }catch(Exception error){
            System.out.println("Erro de cadastro: " + error.getMessage());
            
            return false;
        }
        
    }
    
    public Paciente buscaPaciente(String cpf){
        sql = "SELECT * FROM usuarios WHERE cpf=?";
        
        pstatement = MakeConnection.getPreparedStatement(sql);
        
        try{
            pstatement.setString(1, cpf);
            resultado = pstatement.executeQuery();
            
            if(resultado.next()){
                paciente = new Paciente();
                
                paciente.setId    (resultado.getInt   ("id"));
                paciente.setNome  (resultado.getString("nome"));
                paciente.setCpf   (resultado.getString("cpf"));
                paciente.setIdade (resultado.getInt   ("idade"));
                paciente.setPeso  (resultado.getDouble("peso"));
                paciente.setAltura(resultado.getDouble("altura"));
            }else{
                paciente = null;
            }
            
        }catch(SQLException error){
            System.out.println("Erro de sql: " + error.getMessage());
        }
        
        return paciente;
    }
    
    public boolean cadastraImc(String cpf, double imc){
        
        paciente = new Paciente();
        paciente = buscaPaciente(cpf);
        
        sql = "INSERT INTO imc_usuarios(id_usuario, imc) VALUES(?, ?)";
        
        pstatement = MakeConnection.getPreparedStatement(sql);
        
        try{
            pstatement.setInt(1, paciente.getId());
            pstatement.setDouble(2, imc);
            
            return true;
        }catch(Exception error){
            System.out.println("Erro de cadastro: " + error.getMessage());
            
            return false;
        }
        
    }
    
    public List<Double> buscaImc(String cpf){
        paciente = new Paciente();
        paciente = buscaPaciente(cpf);
        
        listaImc = new ArrayList<>();
        
        sql = "SELECT imc FROM imc_usuarios WHERE id_usuario=?";
        
        pstatement = MakeConnection.getPreparedStatement(sql);
        
        try{
            pstatement.setInt(0, paciente.getId());
            resultado = pstatement.executeQuery();
            
            while(resultado.next()){
                listaImc.add(resultado.getDouble("imc"));
            }
            
            return listaImc;
        }catch(SQLException erro){
            System.out.println("Erro de sql: " + erro.getMessage());
            
            return listaImc;
        }
    }
    
}