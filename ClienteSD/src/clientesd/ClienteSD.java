/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesd;

/**
 *
 * @author Tacio Moreira
 */
public class ClienteSD {
    public ClienteSD() {
        
        Tela_inicial tel = new Tela_inicial();//CRIA OBJETO TELA INICIAL
        //CRIA O PAINEL
        tel.setVisible(true);
        tel.setSize(450,600);
        tel.setLocation(450, 70);
        tel.setTitle("Majuca Nutrição, uma Divisão da Majuca S.A");
        tel.setDefaultCloseOperation(Tela_inicial.EXIT_ON_CLOSE); // Caso o usuario pressione o X, essa função encerra a aplicação.
        
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ClienteSD();
        // TODO code application logic here
    }
    
}
