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
    /* MedicamentController medicamentController = new MedicamentController();
AchatController achatController = new AchatController();
achatController.ajouterAchat("A145", "M126", "Grand", 1000, Date.valueOf("2023-12-25"));*/
     // Obtenir les données de recette de la classe PharmacyData/ Obtient les recettes des 5 derniers mois

        // Créer un jeu de données pour l'histogramme
       // Simuler les données de recette pour les 5 derniers mois
      /* LocalDate date = LocalDate.now();
        Month currentMonth = date.getMonth();
        System.out.println(currentMonth);
        Medicament medoc = new Medicament();
        medoc.recetteMois();
        double[] revenues = {12, 15, 18, 14, 16};
           String [] moisLettre = {"Janvier","fevrier","Mars","avril","Mai","Juin","juillet","Aout","Septembre","Octobre","Novenbre","Decembre"};
        // Créer un jeu de données pour l'histogramme
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < revenues.length; i++) {
            dataset.addValue(revenues[i], "Recette",moisLettre[i + 1]);
        }
        // Créer l'histogramme
        JFreeChart chart = ChartFactory.createBarChart(
                "Recette des 5 derniers mois",
                "Mois",
                "Recette",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );*/

        // Afficher l'histogramme dans une fenêtre
       /* ChartFrame frame = new ChartFrame("Histogramme de recette", chart);
        frame.pack();
        frame.setVisible(true);*/
       Medicament medoc = new Medicament();
       medoc.recetteMois();
    }
    }
