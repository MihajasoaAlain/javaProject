/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pharma;

import pharma.model.*;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import pharma.controller.*;

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
    Histogramme histo = new Histogramme();
    histo.createHistogram();
    }

}
