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
public class calculo extends JFrame implements ActionListener{
    
    float Peso, Altura, Imc;
    
    JPanel p = new JPanel();
    JLabel pesot= new JLabel("Peso");
    JLabel alturat = new JLabel("Altura");
    JLabel calculot = new JLabel("IMC");
    
    JTextField peso = new JTextField();
    JTextField altura = new JTextField();
    JTextField calculo = new JTextField();
    
    
    JButton calcular = new JButton("Calcular");
    JButton voltar = new JButton("Voltar");
    
    public calculo(){
        JPanel p = new JPanel(); // Definir o Painel.
        p.setLayout(null);
        
        JLabel Imagem = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/tela_cliente.jpg")));
        JLabel alturabt = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/altura.jpg")));
        JLabel pesobt = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/peso.jpg")));
        JLabel imc = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/imc.jpg")));
        JLabel foto = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagem.jpg")));
        calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/calcular.jpg")));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.jpg")));
        
        JLabel Desc_IMC = new JLabel("O IMC é o índice aceito pela ");
        JLabel a = new JLabel("\"Organização Mundial de Saúde(OMS)\"");
        JLabel Desc_calculo = new JLabel("que estabelece as faixas de índice que");
        JLabel b = new JLabel(" indicam se uma pessoa  está ou não");
        JLabel Desc_cal = new JLabel(" dentro do peso ideal");
        
        setVisible(true);
        setTitle("Calculo de IMC");
        setSize(450,600);
        setLocation(450,70);
        //setDefaultCloseOperation(calculo.DISPOSE_ON_CLOSE);
        p.setLayout(null);
        
        p.add(Imagem);
        Imagem.setSize(320, 200);
        Imagem.setLocation(60, 0);
        
        p.add(Desc_IMC);
        Desc_IMC.setSize(400, 20);
        Desc_IMC.setLocation(250, 220);
        Desc_IMC.setForeground(Color.black);
        
        p.add(a);
        a.setSize(400, 20);
        a.setLocation(200, 240);
        a.setForeground(Color.black);
        
        p.add(Desc_calculo);
        Desc_calculo.setSize(450, 20);
        Desc_calculo.setLocation(200, 260);
        Desc_calculo.setForeground(Color.black);
        
        p.add(b);
        b.setSize(400, 20);
        b.setLocation(200, 280);
        b.setForeground(Color.black);
        
        p.add(Desc_cal);
        Desc_cal.setSize(430, 20);
        Desc_cal.setLocation(200, 300);
        Desc_cal.setForeground(Color.black);
        
        p.add(alturabt);
        alturabt.setSize(25, 25);
        alturabt.setLocation(10, 303);
        
        p.add(pesobt);
        pesobt.setSize(25, 25);
        pesobt.setLocation(10, 233);
        
        p.add(imc);
        imc.setSize(25, 25);
        imc.setLocation(10, 403);
        
        //descreve o campo peso
        p.add(pesot);
        pesot.setSize(100, 20);
        pesot.setLocation(40, 210);
        
        //campo para adicionar o peso
        p.add(peso);
        peso.setSize(100,30);
        peso.setLocation(40, 230); 
        
        //descreve o campo altura
        p.add(alturat);
        alturat.setSize(100, 20);
        alturat.setLocation(40, 280);
        
        //campo para adicionar a altura
        p.add(altura);
        altura.setSize(100,30);
        altura.setLocation(40, 300); 
        
        
        p.add(calcular);
        calcular.setBackground(Color.white);
        calcular.setForeground(Color.gray);
        calcular.setSize(150,30);
        calcular.setLocation(40,350);
        
        //campo para mostrar o calculo
        p.add(calculo);
        calculo.setSize(200,30);
        calculo.setLocation(40, 400); 
        
         p.add(voltar);
        voltar.setBackground(Color.white);
        voltar.setForeground(Color.gray);
        voltar.setSize(150,30);
        voltar.setLocation(40,480);
        
        p.add(foto);
        foto.setSize(450, 600);
        foto.setLocation(0, 150);
        
        p.setBackground(Color.white);
        add(p);
        
        calcular.addActionListener(this);
        voltar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calcular){
            
            if(!"".equals(peso.getText()) && !"".equals(altura.getText())){//SE OS CAMPOS ESTIVEREM PREENCHIDOS
               
                    String H, P;
            
                    H = altura.getText(); 
                    P = peso.getText();

                    Peso = Float.parseFloat(P);
                    Altura = Float.parseFloat(H);

                    Imc = Peso / (Altura*Altura);
                    System.out.println("IMC: " +Imc);

                    if(Imc<18.5){
                        calculo.setText("Seu IMC é: " + Imc);
                        System.out.println("Voce está abaixo do peso ideal");
                    }else if(Imc>18.5 && Imc <25){
                        calculo.setText("Seu IMC é: " + Imc);
                        System.out.println(" Voce está no peso ideal");

                    }else{
                        calculo.setText("Seu IMC é: " + Imc);
                        System.out.println(" Voce está acima do peso ideal");
                    }
                    String msg = "Deseja calcular outro IMC ?";
                    String nome = "Opçao";
                    int escolha = JOptionPane.showConfirmDialog(null, msg, nome, JOptionPane.YES_NO_OPTION);//PERGUNTA SE DESEJA CADASTRAR OUTRO TEMA

                    if(escolha == JOptionPane.YES_OPTION){//CASO SIM, ELE LIMPA OS CAMPOS PARA Q POSSA SER INSERIDO OUTRO TEMA
                        peso.setText("");
                        altura.setText("");
                       
                    } else{
                        this.dispose();
                    }
                
                
                
                
            } else {//CASO ALGUM CAMPO ESTEJA VAZIO
                JOptionPane.showMessageDialog(null,"Preencha todos os campos !!", "ERRO!",JOptionPane.WARNING_MESSAGE);
            }
            
            
                
        }else if(e.getSource() == voltar){
            this.dispose();
        }
    }
}
