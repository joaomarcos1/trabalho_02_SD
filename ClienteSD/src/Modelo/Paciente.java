/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Tacio Moreira
 */
public class Paciente {
    
        /*
    ATRIBUTOS DO MEU OBJETO A SER CADASTRADO
    */
    private String nome;
    private String cpf;
    private int id;
    /*
    CONSTRUTOS COM TODOS OS ATRIBUTOS E O QUE VAO RECEBER
    */
    public Paciente(int id, String nome,String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        
    }
    public Paciente( String nome,String cpf) {
        
        this.nome = nome;
        this.cpf = cpf;
    }
    public Paciente(){
    
    }
    /*
    METODOS GET'S E SET'S DE CADA ATRIBUTO;
    */
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public String getcpf() {
        return cpf;
    }
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }
     
}
