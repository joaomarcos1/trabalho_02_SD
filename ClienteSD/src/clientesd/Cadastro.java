/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesd;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tacio Moreira
 */
public class Cadastro extends JFrame implements ActionListener{
    
    JPanel p2 = new JPanel();
    JLabel nomet= new JLabel("Nome");
    JLabel CPFt = new JLabel("CPF");
    JLabel Dica = new JLabel("Informe o CPF só com numeros");
    
    JTextField nome = new JTextField();
    JTextField cpf = new JTextField();
    
    
    JButton cadastrar = new JButton("Cadastrar");
    JButton voltar = new JButton("Voltar");
    
    public Cadastro(){
        JPanel p2 = new JPanel(); // Definir o Painel.
        p2.setLayout(null);
        
        JLabel Imagem = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_cliente.jpg")));
        JLabel foto = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem.jpg")));
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadastrar.jpg")));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.jpg")));
        
        
  
        
        setVisible(true);
        setTitle("cadastrar Paciente");
        setSize(450,600);
        setLocation(450,70);
        setDefaultCloseOperation(Cadastro.DISPOSE_ON_CLOSE);
        p2.setLayout(null);
        
        p2.add(Imagem);
        Imagem.setSize(320, 200);
        Imagem.setLocation(60, 0);
       
     
        
        //descreve o campo NOME
        p2.add(nomet);
        nomet.setSize(100, 20);
        nomet.setLocation(40, 210);
        
        //campo para adicionar o NOME
        p2.add(nome);
        nome.setSize(100,30);
        nome.setLocation(40, 230); 
        
        //descreve o campo O CPF
        p2.add(CPFt);
        CPFt.setSize(100, 20);
        CPFt.setLocation(40, 280);
        
        //campo para adicionar o CPF
        p2.add(cpf);
        cpf.setSize(100,30);
        cpf.setLocation(40, 300); 
        
        
        p2.add(cadastrar);
        cadastrar.setBackground(Color.white);
        cadastrar.setForeground(Color.gray);
        cadastrar.setSize(150,30);
        cadastrar.setLocation(40,350);
        
  
        
        p2.add(voltar);
        voltar.setBackground(Color.white);
        voltar.setForeground(Color.gray);
        voltar.setSize(150,30);
        voltar.setLocation(40,480);
        
        p2.add(foto);
        foto.setSize(450, 600);
        foto.setLocation(0, 150);
        
        p2.setBackground(Color.white);
        add(p2);
        
        cadastrar.addActionListener(this);
        voltar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cadastrar){
            
            //será feito o cadastro dos paciente com cpf e nome
            
        } else if(e.getSource() == voltar){
            this.dispose();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
