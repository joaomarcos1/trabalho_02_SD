/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesd;

import Conect_banco.MakeConnection;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tacio Moreira
 */
public class ClienteDAO {
    
     /*
    CLASSE QUE FAZ TODAS OS TIPOS DE MANIPULACOES NO BANCO DE DADOS 
    DEPOIS DE EXERCER A CONECÇÃO COM O BANCO
    */
    private Connection connection;
    
    public ClienteDAO(){
        this.connection = MakeConnection.getConnection();
    }/*
    FUNCAO QUE INSERE DADOS INFORMADOS PELO USUARIO AO
    BANCO DE DADOS E SALVA OS VALORES
    */
    public void InserirCliente(Paciente obj_cliente){
        
        Connection connection = MakeConnection.getConnection(); 
        String sql = "insert into cadastro(nomeTema, disciplina, descricao)  values (?, ?, ?)";
            
            
        try {
            PreparedStatement stmt;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, obj_cliente.getnome());
            stmt.setString(2, obj_cliente.getcpf());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException ex1) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
    }
    /*
    FUNÇÃO QUE VAI NO BANCO DE DADOS E SELECIONA TODOS OS TEMAS 
    NO BANCO PARA QUE POSSAM SER LISTADOS
    */
    public ArrayList<Paciente> listar() throws SQLException{
        ArrayList<Paciente> a = new ArrayList();
        
        Connection con = MakeConnection.getConnection();
        String cmd = "select cod, nome, cpf from cadastro";// nome das variaveis ...
        Statement stmt = con.prepareStatement(cmd);
        ResultSet dados;
        dados = stmt.executeQuery(cmd);
        
        
        while(dados.next()){
            int id = dados.getInt(1);
            String nome = dados.getString(2);
            String cpf = dados.getString(3);
            
            Paciente t = new Paciente(id, nome, cpf);
            
            a.add(t);
            
        }
        return a;
    }
    /*
    FUNCAO QUE RECEBE UM VALOR INTEIRO E VERIFICA SE NO BANCO 
    ESSE VALOR DO ID ESTA CADASTRADO, CASO ESSE ID ESTEJA CADASTRADO
    O METODO SELECIONA OS ATRIBUTOS DESSE ID PARA QUE POSSA SER 
    IMPRESSO NA TELA PARA O USUARIO SE NAO ESONTRAR
    A FUNCAO RETORNA NULO
    */
    public Paciente Busca(int c) throws SQLException{
        
        Connection con = MakeConnection.getConnection();
        
        String busca = "select cod, nomeTema,disciplina,descricao from cadastro where cod = '" +c+"'";
       
        Statement stmt = con.prepareStatement(busca);
        
        ResultSet dados;
        
        dados = stmt.executeQuery(busca);
      
        
        while(dados.next()){
            int id = dados.getInt(1);
            String nome = dados.getString(2);
            String cpf = dados.getString(3);
            
            Paciente t = new Paciente(nome,cpf);
            
               
            if(id == c){
               return t;
            }
        }      
         
        return null;
    }
    /*
    METODO CRIADO PARA ALTERAR OS DADOS BUSCADOS, APOS VERIFICAR 
    SE O ID QUE O USUARIO INFORMOU ESTÁ CADASTRADO NO BANCO
    VAI RECEBER OS DADOS QUE O USUARIO INFORMOU NOS CAMPOS E 
    ALTERAR NO BANCO E SALVAR OS DADOS ALTERADOS
    */
    public void altera(Paciente obj_paciente, int c) throws SQLException{
         
        Connection con = MakeConnection.getConnection();
        String cmd = "update cadastro set nome='"+obj_paciente.getnome()+"',cpf='"+obj_paciente.getcpf()+"' where cod ='"+c+"'";
        PreparedStatement stmt = con.prepareStatement(cmd); 
        
        
        try {
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /*
    METODO QUE RECEBE UM NUMERO INTEIRO DO USUARIO 
    E COMPRAR COM OS ID'S CADASTRADOS NO BANCO DE DADOS
    CASO ESSE ID EXISTA NO BANCO ELE BUSTA TODOS OS ATRIBUTOS
    E EXCLUI TODOS DO BANCO DE DADOS
    */
    public void remover(int c) throws SQLException{
   
        Connection con = MakeConnection.getConnection();
        String cmd = "delete from cadastro where cod = '" + c + "'";
        
        try {
            Statement stmt = con.prepareStatement(cmd);
            stmt.execute(cmd);
            
        } catch (Exception e) {
            System.out.println(e);
        }      
        
    }
    
}
