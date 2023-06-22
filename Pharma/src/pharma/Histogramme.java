package pharma;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.lang.Cloneable;
import java.time.LocalDate;
import java.time.Month;

public class Histogramme {
    public static void createHistogram() {
        // Code pour créer l'histogramme
        int[] ventesParMois = {100, 200, 150, 300, 250, 400};
        int [] mois ={1,2,3,4,5,6};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        LocalDate date = LocalDate.now();
        Month currentMonth = date.getMonth();
        System.out.println(currentMonth);
        
        String [] moisLettre = {"Janvier","fevrier","Mars","avril","Mai","Juin","juillet","Aout","Septembre","Octobre","Novenbre","Decembre"};
        for (int i = 0; i < ventesParMois.length; i++) {
                    
            dataset.setValue(ventesParMois[i], "Ventes", "Mois " + moisLettre[i + 1]);
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Histogramme des ventes par mois", // Titre du graphique
            "Mois", // Étiquette de l'axe des x
            "Ventes", // Étiquette de l'axe des y
            dataset, // Jeu de données
            PlotOrientation.VERTICAL, // Orientation du graphique
            true, // Inclure une légende
            true, // Inclure des tooltips (info-bulles)
            false // Inclure des URLs pour une interaction avancée
        );
        ChartFrame frame = new ChartFrame("Histogramme des ventes", chart);
        frame.pack(); // Ajuster la taille de la fenêtre au contenu du graphique
        frame.setVisible(true); // Afficher la fenêtre
    }
}
