/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesd;

import Modelo.Paciente;
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Buscar extends JFrame implements ActionListener {
    
     JPanel p2 = new JPanel();
    JLabel nomet= new JLabel("Nome");
    JLabel CPFt = new JLabel("CPF");
    JLabel CPF = new JLabel("CPF");
    JLabel Dica = new JLabel("Informe o CPF só com numeros");
    
    JTextField busca = new JTextField();
    
    JTextField nome = new JTextField();
    JTextField cpf = new JTextField();
    
    
    JButton buscar = new JButton("buscar");
    JButton voltar = new JButton("Voltar");
    
    public Buscar(){
        JPanel p2 = new JPanel(); // Definir o Painel.
        p2.setLayout(null);
        
        JLabel Imagem = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_cliente.jpg")));
        JLabel foto = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem.jpg")));
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.jpg")));
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
       
        p2.add(CPF);
        CPF.setSize(100, 20);
        CPF.setLocation(40, 220);
        
        p2.add(busca);
        busca.setSize(200,30);
        busca.setLocation(40, 240); 
        
        p2.add(Dica);
        Dica.setSize(200, 20);
        Dica.setLocation(40, 270);
       
        //descreve o campo NOME
        p2.add(nomet);
        nomet.setSize(200, 20);
        nomet.setLocation(40, 330);
        
        //campo para adicionar o NOME
        p2.add(nome);
        nome.setSize(200,30);
        nome.setLocation(40, 350); 
        
        //descreve o campo O CPF
        p2.add(CPFt);
        CPFt.setSize(200, 20);
        CPFt.setLocation(40, 390);
        
        //campo para adicionar o CPF
        p2.add(cpf);
        cpf.setSize(200,30);
        cpf.setLocation(40, 410); 
        
        
        p2.add(buscar);
        buscar.setBackground(Color.white);
        buscar.setForeground(Color.gray);
        buscar.setSize(103,30);
        buscar.setLocation(250,240);
        
  
        
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
        
        buscar.addActionListener(this);
        voltar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource() == buscar){
            
            if(!"".equals(cpf.getText())){//SE O CAMPO NAO ESTIVER VAZIO
                Paciente tema = new Paciente();//OBJETO DO TIPO TEMA
                ClienteDAO t = new ClienteDAO();//OBJETO DO TIPO temaDAO
                try {
                    tema = t.Busca(Integer.parseInt( cpf.getText()));//OBJ TEMA RECEBE temaDAOBUSCA E PEGA O VALOR QUE DESEJA BUSCAR
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(tema==null){//SE O TEMA ESTIVER NULO ELE N EXISTE NO BANCO DE DADOS
                    JOptionPane.showMessageDialog(null,"Tema não encontrado !!", "ERRO!",JOptionPane.WARNING_MESSAGE);
                    cpf.setText("");//LIMPA O CAMPO DE BUSCA
                }else{
               
                nome.setText(tema.getnome());//IMPRIME NA TELA O NOME DO TEMA
                cpf.setText(tema.getcpf());//IMPRIME NA TELA O NOMDE DA DISCIPLINA
                    //AQUI DEVESE FAZER O CALCULO DO PRIMEIRO E ULTIMO IMC DO PACIENTE E MOSTRAR NA TELA
                }
                
                
                }else//SE PESQUISAR COM O CAMPO VAZIO
                     JOptionPane.showMessageDialog(null,"Informe o tema que deseja buscar !!", "ERRO!",JOptionPane.WARNING_MESSAGE);
                
                
            
             }else if (e.getSource() == voltar){//EVENTO DO BOTAO VOLTAR
                this.dispose();//FECHA A TELA
            } 
        
    }

   

    
}
