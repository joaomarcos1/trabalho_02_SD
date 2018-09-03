/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_sd_trabalho02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author nupasd-ufpi
 */
public class Server_SD_trabalho02 extends JFrame {

    PreparedStatement st;
    ResultSet rs;
    Connection con = MakeConnection.getConnection();
    
    ArrayList<String> ca = new ArrayList<>();    
    
    //abaixo: variáveis para interface
    Object[][] dados;
    JTable tabela;
    JScrollPane barraRolagem;
    String[] colunas = {"Usuário", "Última alteração"};
    
    
    JLabel nome_usuario = new JLabel("Nome Usuário");  
    
    JTextField campo_usuario = new JTextField();
    
    JButton pesquisar = new JButton("Pesquisar"); 

    //JButton relatório = new JButton("Atualizar Relatório");
    
    
    //métodos banco de dados
    public void testeBanco(){
        
        if (con != null) {
            System.out.println("Conexão bem sucedida!");
        } else {
            System.out.println("Conexão não foi bem sucedida");
        } 
        
       try{      
        st = con.prepareStatement("select * from usuarios");//Comando SQL para a seleção de todos os filmes da base de dados
        rs = st.executeQuery();
        String recebe = null;
        while (rs.next()) {
            recebe =  rs.getString("nome");
            ca.add(recebe);
        }
        
        for (int i = 0; i < ca.size(); i++){
            System.out.println(ca.get(i)+"\n");
        }
       }catch (SQLException e){
        
    }
    }
  
    
    public Server_SD_trabalho02(){
        JPanel painel = new JPanel();
        painel.setLayout(null);

        setTitle("Listagem de Filmes");
        setSize(750, 570);
        setLocation(390, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        painel.add(nome_usuario);
        nome_usuario.setBounds(20, 20, 150, 20);

        painel.add(campo_usuario);
        campo_usuario.setBounds(20, 50, 250, 30);
        
        painel.add(pesquisar);
        pesquisar.setBounds(20, 85, 200, 40); 
        
        pesquisar.addActionListener(
        new ActionListener(){//Evento anônimo para o clique no botão "pesquisar"
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        }
        );
        
        
        
        setVisible(true);
        add(painel);
        
        testeBanco();
        
        
    }
    
    public static void main(String[] args) {
       
     new Server_SD_trabalho02();   
    
            
    }
    
    
    
}
