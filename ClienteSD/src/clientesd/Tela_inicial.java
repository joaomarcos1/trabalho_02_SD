/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tacio Moreira
 */
public class Tela_inicial extends JFrame implements ActionListener{
    
    JLabel CPF = new JLabel("CPF Do Cliente");
    
    JButton imc = new JButton("IMC");
    JButton buscar = new JButton("Buscar");
    JButton cadastrar = new JButton("Cadastrar");
    JButton sair = new JButton("Sair");
    
    
    //JTextField Nome = new JTextField();
    JTextField cpf = new JTextField();
    
    public Tela_inicial(){
        
        JPanel p1 = new JPanel(); // Definir o Painel.
        p1.setLayout(null);
        
        JLabel Imagem = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_cliente.jpg")));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.jpg")));
        imc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imc.jpg")));
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.jpg")));
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadastrar.jpg")));
        JLabel foto = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem.jpg")));

        
        p1.add(Imagem);
        Imagem.setSize(320, 200);
        Imagem.setLocation(60, 0);
        
        p1.add(cadastrar);
        cadastrar.setBackground(Color.white);
        cadastrar.setForeground(Color.black);
        cadastrar.setSize(175,30);
        cadastrar.setLocation(130, 300);
        
        p1.add(buscar);
        buscar.setBackground(Color.white);
        buscar.setForeground(Color.black);
        buscar.setSize(175,30);
        buscar.setLocation(130, 340);
        
        p1.add(imc);
        imc.setBackground(Color.white);
        imc.setForeground(Color.black);
        imc.setSize(175,30);
        imc.setLocation(130,380);
        
        p1.add(sair);
        sair.setBackground(Color.white);
        sair.setForeground(Color.black);
        sair.setSize(175,30);
        sair.setLocation(130, 420);
        
        p1.add(foto);
        foto.setSize(450, 600);
        foto.setLocation(0, 150);
        
        p1.setBackground(Color.white);
        add(p1);
        
        cadastrar.addActionListener(this);
        buscar.addActionListener(this);
        imc.addActionListener(this);
        sair.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == cadastrar){
            
            Cadastro CD = new Cadastro();
             
        }else if(e.getSource() == buscar){
            //aqui será feita a busca na base de dados para saber se o cluente esta cadastrado
            Buscar busca = new Buscar();
        }else if(e.getSource() == imc){
            calculo IMC = new calculo();
         
        }else {
            String msg = "Deseja Sair Da Aplicação ?";
                String nome = "Opção";
                int escolha = JOptionPane.showConfirmDialog(null, msg, nome, JOptionPane.YES_NO_OPTION);
                
                if(escolha == JOptionPane.YES_OPTION){
                    System.exit(0);//fecha a aplicação
                }
           
        }
    }

    
    
}
