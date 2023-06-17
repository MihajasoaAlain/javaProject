package pharma.controller;

import pharma.model.Achat;

import java.sql.Date;

public class AchatController {

    private Achat achat;

    public AchatController() {
        achat = new Achat();
    }

    public void ajouterAchat(String numAchat, String numMedoc, String nomClient, int nbr, Date dateAchat) {
        achat.add(numAchat, numMedoc, nomClient, nbr, dateAchat);
    }

    public void afficherAchats() {
        achat.show();
    }

    public void mettreAJourAchat(String ancienNumAchat, String nouveauNumAchat, String numMedoc, String nomClient, int nbr, Date dateAchat) {
        achat.update(ancienNumAchat, nouveauNumAchat, numMedoc, nomClient, nbr, dateAchat);
    }

    public void supprimerAchat(String numAchat) {
        achat.delete(numAchat);
    }
    
    public int getStock(String numMedoc) {
        return achat.stock(numMedoc);
    }
}
