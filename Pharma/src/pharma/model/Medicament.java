/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pharma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Mihajasoa
 */
public class Medicament {

    private String numMedoc;
    private String design;
    int prix_unitaire;
    int stock;
    Config config = new Config();

    public Medicament() {
        System.out.println("Medicament créé avec succès");
    }

    public void add(String numMedoc, String design, int prix_unitaire, int stock) {
        this.numMedoc = numMedoc;
        this.design = design;
        this.prix_unitaire = prix_unitaire;
        this.stock = stock;

        try (Connection connection = config.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicament VALUES (?, ?, ?, ?)");) {

            //medicament
            preparedStatement.setString(1, this.numMedoc);
            preparedStatement.setString(2, this.design);
            preparedStatement.setInt(3, this.prix_unitaire);
            preparedStatement.setInt(4, this.stock);

            //execution de la requette
            preparedStatement.executeUpdate();

            System.out.println("add fait avec succès");
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de mediament : " + e.getMessage());
            config.closeDb();
        }
    }

    public void show() {
        try (Connection connection = config.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM medicament")) {
            System.out.println("liste des medicament");
            // Process the ResultSet
            while (resultSet.next()) {
                // Lire les colonnes et afficher les données
                String numMedoc = resultSet.getString("numMedoc");
                String design = resultSet.getString("design");
                int prix_unitaire = resultSet.getInt("prix_unitaire");
                int stock = resultSet.getInt("stock");
                System.out.println("Numéro du medoc : " + numMedoc);
                System.out.println("design du medicament : " + design);
                System.out.println("Prix unitaire : " + prix_unitaire);
                System.out.println("Stock : " + stock);
                System.out.println("---------------------");

            }
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des medicament : " + e.getMessage());
            config.closeDb();
        }
    }

    public void update(String oldNumMedoc, String newNumMedoc, String design, int prix_unitaire, int stock) {
        this.numMedoc = newNumMedoc;
        this.design = design;
        this.prix_unitaire = prix_unitaire;
        this.stock = stock;
        Config config = new Config();
        try (Connection connection = config.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE medicament SET numMedoc = ?,design = ?, prix_unitaire = ?, stock = ? WHERE numMedoc = ?")) {
            preparedStatement.setString(1, this.numMedoc);
            preparedStatement.setString(2, this.design);
            preparedStatement.setInt(3, this.prix_unitaire);
            preparedStatement.setInt(4, this.stock);
            preparedStatement.setString(5, oldNumMedoc);
            int result = preparedStatement.executeUpdate();
            System.out.println("update fait avec succès");
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du medicament : " + e.getMessage());
            config.closeDb();
        }
    }

    public void delete(String numMedoc) {
        Config config = new Config();
        try (Connection connection = config.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM medicament WHERE numMedoc = ?")) {
            preparedStatement.setString(1, numMedoc);
            int result = preparedStatement.executeUpdate();
            System.out.println("suppression du medicament effectuée");
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
            config.closeDb();
        }

    }

    public void search(String designMedoc) {
        Config config = new Config();
        try (Connection connection = config.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM medicament WHERE design LIKE '%" + designMedoc + "%'")) {
            System.out.println("recheche effectuer");
            // Process the ResultSet
            while (resultSet.next()) {
                // Lire les colonnes et afficher les données
                String numMedoc1 = resultSet.getString("numMedoc");
                String design1 = resultSet.getString("design");
                int prix_unitaire1 = resultSet.getInt("prix_unitaire");
                int stock1 = resultSet.getInt("stock");
                System.out.println("Numéro du medoc : " + numMedoc1);
                System.out.println("design du medicament : " + design1);
                System.out.println("Prix unitaire : " + prix_unitaire1);
                System.out.println("Stock : " + stock1);
                System.out.println("---------------------");
            }
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des medicament : " + e.getMessage());
            config.closeDb();
        }
    }

    public void ruptureStock() {
        Config config = new Config();
        try (Connection connection = config.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM medicament WHERE stock <=5")) {
            System.out.println("recheche effectuer");
            // Process the ResultSet
            while (resultSet.next()) {
                // Lire les colonnes et afficher les données
                String numMedoc1 = resultSet.getString("numMedoc");
                String design1 = resultSet.getString("design");
                int prix_unitaire1 = resultSet.getInt("prix_unitaire");
                int stock1 = resultSet.getInt("stock");
                System.out.println("Numéro du medoc : " + numMedoc1);
                System.out.println("design du medicament : " + design1);
                System.out.println("Prix unitaire : " + prix_unitaire1);
                System.out.println("Stock : " + stock1);
                System.out.println("---------------------");
            }
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des medicament : " + e.getMessage());
            config.closeDb();
        }
    }

    public void recettePlusVendu() {
        Config config = new Config();
        try (Connection connection = config.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT medicament.design, SUM(achat.nbr) AS total_nbr "
                + "FROM medicament INNER JOIN achat "
                + "ON medicament.nummedoc = achat.nummedoc "
                + "GROUP BY medicament.design "
                + "ORDER BY total_nbr DESC LIMIT 5;")) {
            System.out.println("TOP 5 DES MEDICAMENTS LES PLUS VENDUS");
            // Process the ResultSet
            while (resultSet.next()) {
                // Lire les colonnes et afficher les données
                String design = resultSet.getString("design");
                int nombre = resultSet.getInt("total_nbr");
                System.out.println("Design du médicament : " + design);
                System.out.println("Nombre vendu : " + nombre);
                System.out.println("---------------------");
            }
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des médicaments : " + e.getMessage());
            config.closeDb();
        }
    }

    public void recetteTotal() {
        Config config = new Config();
        try (Connection connection = config.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("select sum (achat.nbr*medicament.prix_unitaire) as recette_total from achat,medicament  where medicament.nummedoc= achat.nummedoc;")) {
            System.out.println("TOTAL DE LA RECETTE");
            // Process the ResultSet
            int total;
            while (resultSet.next()) {
                // Lire les colonnes et afficher les données
                total = resultSet.getInt("recette_total");
                System.out.println("La recette total de la pharmacie est " + total);
            }
            config.closeDb();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des médicaments : " + e.getMessage());
            config.closeDb();
        }
    }

    public void recetteMois() {
        
    }
}
