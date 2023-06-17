package pharma.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Config {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/pharmacie";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "mihajasoa";
    private Connection connection = null;
    public Statement statement = null;

    public Config() {
        try {
            Class.forName("org.postgresql.Driver"); // Chargement du pilote JDBC

            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connexion à la base de données établie !");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Pilote JDBC non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données.");
            e.printStackTrace();
        }
    }
    //pour avoir la connexion
    public Connection getConnection() {
        return connection;
    }
    //pour lancer le statement
   public Statement getStatement() {
        return statement;
    }

    public void closeDb() {
        try {
            if (statement != null) {
                statement.close();
                System.out.println("Statement fermé !");
            }
            if (connection != null) {
                connection.close();
                System.out.println("Connexion à la base de données fermée !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la base de données.");
            e.printStackTrace();
        }
    }
}
