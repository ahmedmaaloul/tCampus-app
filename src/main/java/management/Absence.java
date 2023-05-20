package management;

import Frame.ConsulterAbsenceFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ahmed
 */
public class Absence {

    private String IdE;
    private int IdC;
    private boolean justifie;
    private String justification;

    public Absence(String IdE, int IdC, boolean justifie, String justification) {
        this.IdE = IdE;
        this.IdC = IdC;
        this.justifie = justifie;
        this.justification = justification;
    }

    public Absence() {
        this.IdE = "";
        this.IdC = 0;
        this.justifie = false;
        this.justification = "";
    }

    public String getIdE() {
        return IdE;
    }

    public int getIdC() {
        return IdC;
    }

    public boolean isJustifie() {
        return justifie;
    }

    public String getJustification() {
        return justification;
    }

    public void setIdE(String IdE) {
        this.IdE = IdE;
    }

    public void setIdC(int IdC) {
        this.IdC = IdC;
    }

    public void setJustifie(boolean justifie) {
        this.justifie = justifie;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public void displaySucc(String info) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, info, "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public boolean verifExistance(String IdE, int IdC) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS NbreA FROM Absence WHERE IdE=? AND IdC=?")) {

            // Définir les valeurs des paramètres pour la requête préparée
            statement.setString(1, IdE);
            statement.setInt(2, IdC);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int nbreA = resultSet.getInt("NbreU");
                if (nbreA == 0) {
                    resultSet.close();
                    return true;
                }
            }
            resultSet.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void supprimerJustificatif() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("UPDATE tcampus.absence SET Justifie = false, justificatif = '' WHERE IdC = ? AND IdE = ?")) {

            // Définir les valeurs des paramètres pour la requête préparée
            statement.setInt(1, IdC);
            statement.setString(2, IdE);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                this.displaySucc("Modifié avec succès");
            } else {
                this.displayError("Échec de modification");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.displayError("Échec de modification");
            return;
        }
    }

    public void ajouterJustificatif(String Justificatif) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("UPDATE tcampus.absence SET Justifie = true, justificatif = ? WHERE IdC = ? AND IdE = ?")) {

            // Définir les valeurs des paramètres pour la requête préparée
            statement.setString(1, Justificatif);
            statement.setInt(2, IdC);
            statement.setString(3, IdE);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                this.displaySucc("Modifié avec succès");
            } else {
                this.displayError("Échec de modification");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.displayError("Échec de modification");
            return;
        }
    }

    public void ajouter(String IdE, int IdC, boolean justifie, String justification) {
        if (this.verifExistance(IdE, IdC)) {
            this.displayError("Échec de l'ajout");
            return;
        }
        this.IdE = IdE;
        this.IdC = IdC;
        this.justifie = justifie;
        this.justification = justification;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO Absence (IdE, IdC, justifie, justification) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Définir les valeurs des paramètres
            String justifie_str = justifie ? "true" : "false";
            String IdC_str = Integer.toString(IdC);
            statement.setString(1, IdE);
            statement.setString(2, IdC_str);
            statement.setString(3, justifie_str);
            statement.setString(4, justification);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Lignes affectées : " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Ajouté avec succès");
            } else {
                this.displayError("Échec de l'ajout");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.displayError("Échec de l'ajout");
            return;
        }
    }

    public void supprimer() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";

        String deleteQuery = "DELETE FROM Absence WHERE IdE=? AND IdC=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Définir les valeurs des paramètres
            statement.setString(1, IdE);
            statement.setInt(2, IdC);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Lignes affectées : " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Supprimé avec succès");
            } else {
                System.out.println("Erreur lors de la suppression");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête de suppression : " + e.getMessage());
        }
    }

    public int fsetInfo() {
        // Définition des informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        // Requête SELECT pour récupérer les informations de l'absence
        String selectQuery = "SELECT * FROM ABSENCE WHERE idE=? AND idC=?";
        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Définir les valeurs des paramètres de la condition
            String idC_str = Integer.toString(this.IdC);
            statement.setString(1, this.IdE);
            statement.setString(2, idC_str);

            // Exécuter la requête SELECT
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Récupérer les valeurs du résultat
                justifie = resultSet.getBoolean("justifie");
                justification = resultSet.getString("justification");
                return 0;
            } else {
                // Retourner -1 si aucune donnée n'a été trouvée
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête SELECT : " + e.getMessage());
            return -1;
        }
    }

    public void Consulter(String IdE, int IdC) {
        // Assigner les valeurs aux variables d'instance
        this.IdE = IdE;
        this.IdC = IdC;

        // Appeler la méthode fsetInfo() pour récupérer les informations
        if (this.fsetInfo() == -1) {
            // Vérifier si les informations n'ont pas été trouvées
            this.displayError("Non trouvé");
            return;
        } else {
            // Afficher les informations
            displayInfo();
        }
    }

    public void displayInfo() {
        new ConsulterAbsenceFrame(this);
    }

    public static void main(String[] args) {
        Absence a = new Absence();
        a.Consulter("165123", 1);
    }
}
