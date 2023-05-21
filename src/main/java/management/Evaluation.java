package management;

import Frame.ConsulterEvaluationFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Evaluation {

    private String idE;
    private int idM;
    private float note;
    private String type;

    public Evaluation(String idE, int idM, float note, String type) {
        this.idE = idE;
        this.idM = idM;
        this.note = note;
        this.type = type;
    }

    public Evaluation() {
        this.idE = "";
        this.idM = 0;
        this.note = 0;
        this.type = "";
    }

    public String getIdE() {
        return idE;
    }

    public int getIdM() {
        return idM;
    }

    public float getNote() {
        return note;
    }

    public String getType() {
        return type;
    }

    public void setIdE(String idE) {
        this.idE = idE;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void displaySucc(String info) {
        JFrame frame = new JFrame(" Info Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, info, "Erreur", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public boolean verifExistence(String idE, int idM, float note, String type) {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";

        // Requête de sélection pour vérifier l'existence de l'évaluation
        String selectQuery = "SELECT Count(*) as NbreE FROM Evaluation WHERE idE = ? AND idM =? AND type=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Définition des valeurs des paramètres pour la condition
            statement.setString(1, idE);
            String idm_str = Integer.toString(idM);
            statement.setString(2, idm_str);
            statement.setString(3, type);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int nbreE = resultSet.getInt("NbreE");
                if (nbreE == 1) {
                    resultSet.close();
                    return true;
                }
            }
            resultSet.close();
            return false;
        } catch (SQLException e) {
            // Affichage de l'erreur SQL
            e.printStackTrace();
            return false;
        }
    }

    public void ajouter(String idE, int idM, float note, String type) {
        // Vérifier l'existence de l'évaluation
        if (this.verifExistence(idE, idM, note, type)) {
            this.displayError("Evaluation non ajoutée");
            return;
        }

        // Affecter les valeurs aux variables membres de la classe
        this.idE = idE;
        this.idM = idM;
        this.note = note;
        this.type = type;

        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";

        // Requête d'insertion pour ajouter l'évaluation
        String insertQuery = "INSERT INTO Evaluation (IdE, IdM, note, type) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Affecter les valeurs aux paramètres
            statement.setString(1, idE);
            String idm_str = Integer.toString(idM);
            statement.setString(2, idm_str);
            String note_str = Float.toString(note);
            statement.setString(3, note_str);
            statement.setString(4, type);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Evaluation ajoutée");
            } else {
                this.displayError("Evaluation non ajoutée");
            }
        } catch (SQLException e) {
            // Affichage de l'erreur SQL
            e.printStackTrace();
            this.displayError("Evaluation non ajoutée");
            return;
        }
    }

    public void modifier(float note) {
        // Affecter la nouvelle note à la variable membre
        this.note = note;

        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        // Requête de mise à jour pour modifier l'évaluation
        String updateQuery = "UPDATE EVALUATION SET note = ? WHERE idE = ? AND idM = ? AND type = ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Affecter la nouvelle valeur à la colonne
            String note_str = Float.toString(note);
            statement.setString(1, note_str);
            statement.setString(2, idE);
            String idm_str = Integer.toString(idM);
            statement.setString(3, idm_str);
            statement.setString(4, type);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Evaluation modifiée");
            } else {
                this.displayError("Evaluation non modifiée");
            }

        } catch (SQLException e) {
            // Affichage de l'erreur SQL
            System.err.println("Error executing update query: " + e.getMessage());
            this.displayError("Evaluation non modifiée");
        }
    }

    public void supprimer() {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        // Requête de suppression pour supprimer l'évaluation
        String deleteQuery = "DELETE FROM EVALUATION WHERE idE = ? AND idM = ? AND type = ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Affecter les valeurs des paramètres pour la condition
            statement.setString(1, idE);
            String idm_str = Integer.toString(idM);
            statement.setString(2, idm_str);
            statement.setString(3, type);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Evaluation supprimée");
            } else {
                System.out.println("No rows affected. Delete query did not delete any data.");
            }

        } catch (SQLException e) {
            // Affichage de l'erreur SQL
            System.err.println("Error executing delete query: " + e.getMessage());
        }
    }

    public int fsetInfo() {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        // Requête de sélection pour récupérer les informations de l'évaluation
        String selectQuery = "SELECT * FROM EVALUATION WHERE idE = ? AND idM = ? AND type = ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Affecter les valeurs des paramètres pour la condition
            String idM_str = Integer.toString(this.idM);
            statement.setString(1, this.idE);
            statement.setString(2, idM_str);
            statement.setString(3, this.type);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Récupérer les valeurs du résultat
                note = resultSet.getFloat("note");
                return 0;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            // Affichage de l'erreur SQL
            System.err.println("Error executing select query: " + e.getMessage());
            return -1;
        }
    }

    public void Consulter(String idE, int idM, String type) {
        // Affecter les valeurs des paramètres
        this.idE = idE;
        this.idM = idM;
        this.type = type;

        // Vérifier si l'évaluation existe en récupérant ses informations
        if (fsetInfo() == -1) {
            this.displayError("Evaluation non trouvée");
        } else {
            displayInfo();
        }
    }

    public void displayInfo() {
        // Afficher les informations de l'évaluation dans une nouvelle fenêtre
        new ConsulterEvaluationFrame(this);
    }

    public static void main(String[] args) {
        // Créer une instance d'évaluation
        Evaluation ev = new Evaluation();

        // Consulter une évaluation spécifique avec des valeurs prédéfinies
        ev.Consulter("1651651", 1, "DS");
    }

}