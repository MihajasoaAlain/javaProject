package pharma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
public class Entree {
    private String numEntree;
    private String numMedoc;
    private int stockEntree;
    private Date dateEntree;

    public Entree() {
        System.out.println("Entree créé avec succès");
    }

    public void add(String numEntree, String numMedoc,int stockEntree,Date dateEntree) {
        this.numEntree = numEntree;
        this.numMedoc = numMedoc;
        this.stockEntree = stockEntree;
        this.dateEntree = dateEntree;
        Config config = new Config();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO entree VALUES (?, ?, ?, ?)");
                //requette pour mettre a jour stock
             PreparedStatement updateStatement = connection.prepareStatement("UPDATE medicament SET stock = stock + ? WHERE numMedoc = ?");) {
            
            
            //achat
            preparedStatement.setString(1, this.numEntree);
            preparedStatement.setString(2, this.numMedoc);
            preparedStatement.setInt(3, this.stockEntree);
            preparedStatement.setDate(4, this.dateEntree);
            
            //execution de la requette
            preparedStatement.executeUpdate();
            // Mettre à jour le stock dans la table 'medicament'
        updateStatement.setInt(1, this.stockEntree);
        updateStatement.setString(2, this.numMedoc);
        updateStatement.executeUpdate();
            System.out.println("add fait avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'entree : " + e.getMessage());
        }
    }

    public void show() {
        Config config = new Config();
        try (Connection connection = config.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM entree")) {
            System.out.println("liste des achat");
            // Process the ResultSet
            while (resultSet.next()) {
                // Lire les colonnes et afficher les données
                String numEntree = resultSet.getString("numEntree");
                String numMedoc = resultSet.getString("numMedoc");
                int stockEntree = resultSet.getInt("stockEntree");
                Date dateEntree = resultSet.getDate("dateEntree");
                System.out.println("Numéro d'Entree : " + numEntree);
                System.out.println("Numéro de médicament : " + numMedoc);
                System.out.println("Quantité de stock Entree: " + stockEntree);
                System.out.println("Date d'Entree : " + dateEntree);
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des achats : " + e.getMessage());
        }
    }

    public void update(String oldNumEntree,String newNumEntree, String numMedoc,int stockEntree,Date dateEntree) {
        this.numEntree = newNumEntree;
        this.numMedoc = numMedoc;
        this.stockEntree = stockEntree;
        this.dateEntree = dateEntree;

        Config config = new Config();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE entree SET numEntree = ?, numMedoc = ?, stockEntree = ?, dateEntree = ? WHERE numEntree = ?")) {
            preparedStatement.setString(1, this.numEntree);
            preparedStatement.setString(2, this.numMedoc);
            preparedStatement.setInt(3, this.stockEntree);
            preparedStatement.setDate(4, this.dateEntree);
            preparedStatement.setString(5, oldNumEntree);
            int result = preparedStatement.executeUpdate();
            System.out.println("update fait avec succès");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'achat : " + e.getMessage());
        }
    }

    public void delete(String numEntree) {
        Config config = new Config();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM entree WHERE numEntree = ?")) {
            preparedStatement.setString(1, numEntree);
            int result = preparedStatement.executeUpdate();
            System.out.println("suppression d'achat effectuée");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
