/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pharma;

import pharma.model.*;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

//Date.valueOf("2023-06-14")

/**
 *
 * @author Mihajasoa
 */
public class Pharma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        
        
        
        Achat achat = new Achat();
        achat.getRevenueHistogram();
        
    }
    }
