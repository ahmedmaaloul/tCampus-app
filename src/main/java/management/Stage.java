package management;


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
public class Stage {

    private int id;
    private String type;
    private String dateDebut;
    private String dateFin;
    private String idEtu;

    public Stage(int id, String type, String dateDebut, String dateFin, String idEtu) {
        this.id = id;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idEtu = idEtu;
    }

    public Stage() {
        this.id = 0;
        this.type = "";
        this.dateDebut = "";
        this.dateFin = "";
        this.idEtu = "";
    }

    public String getIdEtu() {
        return idEtu;
    }

    public void setIdEtu(String idEtu) {
        this.idEtu = idEtu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public boolean verifExistence(int id) {
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "root";
        String password = "root";

        String selectQuery = "SELECT Count(*) as NbreS FROM Stage WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int nbreS = resultSet.getInt("NbreS");
                if (nbreS == 1) {
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

    public void ajouter(int id, String type, String dateDebut, String dateFin, String idEtu) {
        if (this.verifExistence(id)) {
            this.displayError("Problème d'unicité");
            return;
        }
        Etudiant t = new Etudiant();
        if (t.verifExistence(idEtu) == false) {
            this.displayError("Etudiant non trouvé");
            return;
        }
        this.id = id;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idEtu = idEtu;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO STAGE (id, type,dateDebut,dateFin,idEtu) VALUES (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the values for the parameters
            String Id_str = Integer.toString(id);
            statement.setString(1, Id_str);
            statement.setString(2, type);
            statement.setString(3, dateDebut);
            statement.setString(4, dateFin);
            statement.setString(5, idEtu);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccAdd();
            } else {
                this.displayError("Stage existe déja");
            }
        } catch (SQLException e) {

            e.printStackTrace();
            this.displayError("Erreur dans l'ajout du Stage");
            return;

        }

    }

    public void modifier(String type, String dateDebut, String dateFin) {
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE STAGE SET type= ?,dateDebut=?,dateFin=? WHERE  id= ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            String Id_str = Integer.toString(id);
            statement.setString(1, type);
            statement.setString(2, dateDebut);
            statement.setString(3, dateFin);
            statement.setString(4, Id_str);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccModif();
            } else {
                System.out.println("error in updating");
            }

        } catch (SQLException e) {
            System.err.println("Error executing update query: " + e.getMessage());
            System.out.println("error in updating");
        }
    }

    public void supprimer() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String deleteQuery = "DELETE FROM STAGE WHERE WHERE id= ?";
        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Set the parameter value for the condition
            String Id_str = Integer.toString(id);
            statement.setString(1, Id_str);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccDel();
            } else {
                System.out.println("No rows affected. Delete query did not delete any data.");
            }

        } catch (SQLException e) {
            System.err.println("Error executing delete query: " + e.getMessage());
        }
    }

    public void displayErrorSearch() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Evalutation non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccAdd() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Evalutation ajouté", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Evalutation supprimé", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccModif() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Evalutation modifié", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }
      public int fsetInfo() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String selectQuery = "SELECT * FROM STAGE WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
            String id_str = Integer.toString(this.id);
            statement.setString(1, id_str);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve values from the result set
                type = resultSet.getString("type");
                dateDebut = resultSet.getString("dateDebut");
                dateFin = resultSet.getString("dateFin");
                idEtu= resultSet.getString("idEtu");
                return 0;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Error executing select query: " + e.getMessage());
            return -1;
        }
    }
}
