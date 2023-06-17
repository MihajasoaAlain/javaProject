/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.controller;

import pharma.model.Config;
import pharma.model.Medicament;

/**
 *
 * @author Mihajasoa
 */
import pharma.model.Medicament;

public class MedicamentController {
    
    private Medicament medicament;
    
    public MedicamentController() {
        medicament = new Medicament();
    }
    
    public void ajouterMedicament(String numMedoc, String design, int prixUnitaire, int stock) {
        medicament.add(numMedoc, design, prixUnitaire, stock);
    }
    
    public void afficherMedicaments() {
        medicament.show();
    }
    
    public void mettreAJourMedicament(String ancienNumMedoc, String nouveauNumMedoc, String design, int prixUnitaire, int stock) {
        medicament.update(ancienNumMedoc, nouveauNumMedoc, design, prixUnitaire, stock);
    }
    
    public void supprimerMedicament(String numMedoc) {
        medicament.delete(numMedoc);
    }
    
    public void rechercherMedicament(String designMedoc) {
        medicament.search(designMedoc);
    }
    
    public void afficherRuptureStock() {
        medicament.ruptureStock();
    }
    
    public void afficherTopVentes() {
        medicament.recette();
    }
}

