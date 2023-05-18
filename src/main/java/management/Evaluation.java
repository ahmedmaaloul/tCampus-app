package management;

import Frame.ConsulterEvaluationFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, info, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public boolean verifExistence(String idE, int idM, float note, String type) {
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "root";
        String password = "root";

        String selectQuery = "SELECT Count(*) as NbreE FROM Evaluation WHERE idE = ? AND idM =? AND type=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
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

            e.printStackTrace();
            return false;

        }
    }

    public void ajouter(String idE, int idM, float note, String type) {
        if (this.verifExistence(idE, idM, note, type)) {
            this.displayError("Evalutation non ajouté");
            return;
        }
        this.idE = idE;
        this.idM = idM;
        this.note = note;
        this.type = type;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO Evaluation (IdE, IdM,note,type) VALUES (?, ?, ? ,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the values for the parameters
            statement.setString(1, idE);
            String idm_str = Integer.toString(idM);
            statement.setString(2, idm_str);
            String note_str = Float.toString(note);
            statement.setString(3, note_str);
            statement.setString(4, type);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Evalutation ajouté");
            } else {
                this.displayError("Evalutation non ajouté");
            }
        } catch (SQLException e) {

            e.printStackTrace();
            this.displayError("Evalutation non ajouté");
            return;

        }

    }

    public void modifier(float note) {
        this.note = note;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE EVALUATION SET note= ? WHERE  idE = ? AND idM =? AND type=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Set the new value for the column
            String note_str = Float.toString(note);
            statement.setString(1, note_str);
            statement.setString(2, idE);
            String idm_str = Integer.toString(idM);
            statement.setString(3, idm_str);
            statement.setString(4, type);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Evalutation modifié");
            } else {
                this.displayError("Evalutation non modifié");
            }

        } catch (SQLException e) {
            System.err.println("Error executing update query: " + e.getMessage());
            this.displayError("Evalutation non modifié");
        }
    }

    public void supprimer() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String deleteQuery = "DELETE FROM EVALUATION WHERE WHERE idE = ? AND idM =? AND type=?";
        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Set the parameter value for the condition
            statement.setString(1, idE);
            String idm_str = Integer.toString(idM);
            statement.setString(2, idm_str);
            statement.setString(3, type);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Evalutation supprimé");
            } else {
                System.out.println("No rows affected. Delete query did not delete any data.");
            }

        } catch (SQLException e) {
            System.err.println("Error executing delete query: " + e.getMessage());
        }
    }

    public int fsetInfo() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String selectQuery = "SELECT * FROM EVALUATION WHERE idE=? AND idM=? and type=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
            String idM_str = Integer.toString(this.idM);
            statement.setString(1, this.idE);
            statement.setString(2, idM_str);
            statement.setString(3, this.type);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve values from the result set
                note = resultSet.getFloat("note");
                return 0;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Error executing select query: " + e.getMessage());
            return -1;
        }
    }

    public void Consulter(String idE, int idM, String type) {
        this.idE = idE;
        this.idM = idM;
        this.type = type;
        if (fsetInfo() == -1) {
            this.displayError("Evalutation non trouvé");
        } else {
            displayInfo();
        }
    }

    public void displayInfo() {
        new ConsulterEvaluationFrame(this);
    }

    public static void main(String[] args) {
        Evaluation ev = new Evaluation();
        ev.Consulter("1651651", 1, "DS");
    }
}
