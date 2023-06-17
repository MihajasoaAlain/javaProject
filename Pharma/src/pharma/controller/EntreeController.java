package pharma.controller;

import pharma.model.Entree;

import java.sql.Date;

public class EntreeController {

    private Entree entree;

    public EntreeController() {
        entree = new Entree();
    }

    public void ajouterEntree(String numEntree, String numMedoc, int stockEntree, Date dateEntree) {
        entree.add(numEntree, numMedoc, stockEntree, dateEntree);
    }

    public void afficherEntrees() {
        entree.show();
    }

    public void mettreAJourEntree(String ancienNumEntree, String nouveauNumEntree, String numMedoc, int stockEntree, Date dateEntree) {
        entree.update(ancienNumEntree, nouveauNumEntree, numMedoc, stockEntree, dateEntree);
    }

    public void supprimerEntree(String numEntree) {
        entree.delete(numEntree);
    }
}
