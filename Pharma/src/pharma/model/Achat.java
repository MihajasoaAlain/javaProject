package pharma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
public class Achat {
    private String numAchat;
    private String numMedoc;
    private String nomClient;
    private int nbr;
    private Date dateAchat;

    public Achat() {
        System.out.println("Achat créé avec succès");
    }

    public void add(String numAchat, String numMedoc, String nomClient, int nbr, Date dateAchat) {
        this.numAchat = numAchat;
        this.numMedoc = numMedoc;
        this.nomClient = nomClient;
        this.nbr = nbr;
        this.dateAchat = dateAchat;
        Config config = new Config();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO achat VALUES (?, ?, ?, ?, ?)");
                //requette pour mettre a jour stock
             PreparedStatement updateStatement = connection.prepareStatement("UPDATE medicament SET stock = stock - ? WHERE numMedoc = ? AND stock >=0");) {
            
            
            //achat
            preparedStatement.setString(1, this.numAchat);
            preparedStatement.setString(2, this.numMedoc);
            preparedStatement.setString(3, this.nomClient);
            preparedStatement.setInt(4, this.nbr);
            preparedStatement.setDate(5, this.dateAchat);
            
            //execution de la requette
            preparedStatement.executeUpdate();
            // Mettre à jour le stock dans la table 'medicament'
        updateStatement.setInt(1, this.nbr);
        updateStatement.setString(2, this.numMedoc);
        updateStatement.executeUpdate();
            System.out.println("add fait avec succès");
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'achat : " + e.getMessage());
            config.closeDb();
        }
    }

    public void show() {
        Config config = new Config();
        try (Connection connection = config.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM achat")) {
            System.out.println("liste des achat");
            // Process the ResultSet
            while (resultSet.next()) {
                // Lire les colonnes et afficher les données
                String numAchat = resultSet.getString("numAchat");
                String numMedoc = resultSet.getString("numMedoc");
                String nomClient = resultSet.getString("nomClient");
                int nbr = resultSet.getInt("nbr");
                Date dateAchat = resultSet.getDate("dateAchat");

                System.out.println("Numéro d'achat : " + numAchat);
                System.out.println("Numéro de médicament : " + numMedoc);
                System.out.println("Nom du client : " + nomClient);
                System.out.println("Quantité : " + nbr);
                System.out.println("Date d'achat : " + dateAchat);
                System.out.println("---------------------");
                
            }
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des achats : " + e.getMessage());
            config.closeDb();
        }
    }

    public void update(String oldNumAchat, String newNumAchat, String numMedoc, String nomClient, int nbr, Date dateAchat) {
        this.numAchat = newNumAchat;
        this.numMedoc = numMedoc;
        this.nomClient = nomClient;
        this.nbr = nbr;
        this.dateAchat = dateAchat;

        Config config = new Config();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE achat SET numAchat = ?, numMedoc = ?, nomClient = ?, nbr = ?, dateAchat = ? WHERE numAchat = ?")) {
            preparedStatement.setString(1, this.numAchat);
            preparedStatement.setString(2, this.numMedoc);
            preparedStatement.setString(3, this.nomClient);
            preparedStatement.setInt(4, this.nbr);
            preparedStatement.setDate(5, this.dateAchat);
            preparedStatement.setString(6, oldNumAchat);
            int result = preparedStatement.executeUpdate();
            System.out.println("update fait avec succès");
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'achat : " + e.getMessage());
            config.closeDb();
        }
    }

    public void delete(String numAchat) {
        Config config = new Config();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM achat WHERE numAchat = ?")) {
            preparedStatement.setString(1, numAchat);
            int result = preparedStatement.executeUpdate();
            System.out.println("suppression d'achat effectuée");
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
            config.closeDb();
        }
    }
    public int  stock(String numMedoc){
         int resultat=0;
         Config config = new Config();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT stock FROM medicament WHERE numMedoc = ?")) {
            preparedStatement.setString(1, numMedoc);
             ResultSet result = preparedStatement.executeQuery();
              resultat = result.getInt(nomClient);
              System.out.println("le nombre de stock est "+resultat);
            System.out.println("suppression d'achat effectuée");
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
            config.closeDb();
        }
        return resultat;
}
}
