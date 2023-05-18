package management;


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

    public void displaySuccAdd() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Ajouté avec succès", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayErrorAdd() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Échec de l'ajout", "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccChg() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Modifié avec succès", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayErrorChg() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Échec de modification", "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Supprimé avec succès", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayErrorSearch() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Non trouvé", "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public boolean verifExistance(String IdE, int IdC) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) AS NbreA FROM Absence WHERE IdE='" + IdE + "' AND IdC=" + IdC;
            ResultSet resultSet = statement.executeQuery(query);
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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "Update tcampus.absence \n"
                    + "set \n"
                    + "Justifie = false,\n"
                    + "justificatif =''\n"
                    + "WHERE IdC=" + IdC + " AND IdE='" + IdE + "'";
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                this.displaySuccChg();
            } else {
                this.displayErrorChg();
            }
        } catch (SQLException e) {

            e.printStackTrace();
            this.displayErrorChg();
            return;

        }
    }

    public void ajouterJustificatif(String Justificatif) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "Update tcampus.absence \n"
                    + "set \n"
                    + "Justifie = true,\n"
                    + "justificatif ='" + Justificatif + "'\n"
                    + "WHERE IdC=" + IdC + " AND IdE='" + IdE + "'";
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                this.displaySuccChg();
            } else {
                this.displayErrorChg();
            }
        } catch (SQLException e) {

            e.printStackTrace();
            this.displayErrorChg();
            return;

        }
    }

    public void ajouter(String IdE, int IdC, boolean justifie, String justification) {
        if(this.verifExistance(IdE, IdC)){
            this.displayErrorAdd();
            return;
        }
        this.IdE = IdE;
        this.IdC = IdC;
        this.justifie = justifie;
        this.justification = justification;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO Absence (IdE, IdC,justifie,justification) VALUES (?, ?, ? ,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the values for the parameters
            String justifie_str = justifie ? "true" : "false";
            String IdC_str = Integer.toString(IdC);
            statement.setString(1, IdE);
            statement.setString(2, IdC_str);
            statement.setString(3, justifie_str);
            statement.setString(4, justification);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccAdd();
            } else {
                this.displayErrorAdd();
            }
        } catch (SQLException e) {

            e.printStackTrace();
            this.displayErrorAdd();
            return;

        }

    }

    public void supprimer() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";

        String deleteQuery = "DELETE FROM Absence WHERE IdE='" + IdE + "' AND IdC="+IdC;

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccDel();
            } else {
                System.out.println("Error in deleting");
            }

        } catch (SQLException e) {
            System.err.println("Error executing delete query: " + e.getMessage());
        }
    }
   public int fsetInfo() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String selectQuery = "SELECT * FROM ABSENCE WHERE idE=? AND idC=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
            String idC_str = Integer.toString(this.IdC);
            statement.setString(1, this.IdE);
            statement.setString(2, idC_str);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve values from the result set
                justifie = resultSet.getBoolean("justifie");
                justification = resultSet.getString("justification");
                return 0;
            }
            else{
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Error executing select query: " + e.getMessage());
            return -1;
        }
    }
}
