/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesd;

import java.io.OutputStream;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Helbert Monteiro
 */
public class GeradorGrafico {
    
    private final JFrame                 frame = new JFrame();
    private final DefaultCategoryDataset dado = new DefaultCategoryDataset();
    private JFreeChart                   grafico;
    private OutputStream                 arquivo;
    private ChartUtilities               chartUtilities;
    private ChartPanel                   chartPanel;
    
    
    
    public void addValor(double imc, int dia, String linha){
        dado.addValue(imc, linha, "dia" + dia);
    }
    
    private void criaGrafico(){
        grafico = ChartFactory.createLineChart("Gráfico", "Dias", "IMC", dado, PlotOrientation.VERTICAL, true, true, false);
    }
    
    public void exibeGrafico(){
        criaGrafico();
        
        chartPanel = new ChartPanel(grafico);
        
        frame.add(chartPanel);
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
}
