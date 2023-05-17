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
public class Groupe {

    private int Id, IdC, num;
    private String nom;

    public Groupe(int Id, int IdC, int num, String nom) {
        this.Id = Id;
        this.IdC = IdC;
        this.num = num;
        this.nom = nom;
    }

    public Groupe() {
        this.Id = 0;
        this.IdC = 0;
        this.num = 0;
        this.nom = "";
    }

    public int getId() {
        return Id;
    }

    public int getIdC() {
        return IdC;
    }

    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setIdC(int IdC) {
        this.IdC = IdC;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouter(int Id, String nom, int num, int IdC) {
        if(this.verifExistence(Id)){
            this.displayErrorAdd("Problème d'unicite");
            return;
        }
        Classe c = new Classe();
        if(c.verifExistence(IdC) == false){
            this.displayErrorAdd("Classe non trouvée !");
            return;
        }
        this.Id = Id;
        this.IdC = IdC;
        this.num = num;
        this.nom = nom;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO GROUPE (Id, nom,num,idc) VALUES (?, ?, ? ,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the values for the parameters
            String Id_str = Integer.toString(Id);
            String IdC_str = Integer.toString(IdC);
            String num_str = Float.toString(num);
            statement.setString(1, Id_str);
            statement.setString(2, nom);
            statement.setString(3, num_str);
            statement.setString(4, IdC_str);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccAdd();
            } else {
                this.displayErrorAdd("Groupe existe déja");
            }
        } catch (SQLException e) {

            e.printStackTrace();
            this.displayErrorAdd("Impossible d'ajouter le groupe");
            return;

        }

    }
  public boolean verifExistence(int id) {
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "root";
        String password = "root";

        String selectQuery = "SELECT Count(*) as NbreG FROM GROUPE WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int nbreG = resultSet.getInt("NbreG");
                if (nbreG == 1) {
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
    public void modifier(String nom, int num) {
        this.num = num;
        this.nom = nom;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE GROUPE SET nom= ?,num=? WHERE  id= ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            String Id_str = Integer.toString(Id);
            String num_str = Float.toString(num);
            statement.setString(1, nom);
            statement.setString(2, num_str);
            statement.setString(3, Id_str);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccModif();
            } else {
                this.displayErrorModif();
            }

        } catch (SQLException e) {
            System.err.println("Error executing update query: " + e.getMessage());
            this.displayErrorModif();
        }
    }
    public void supprimer() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String deleteQuery = "DELETE FROM GROUPE WHERE WHERE id= ?";
        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Set the parameter value for the condition
            String Id_str = Integer.toString(Id);
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

        JOptionPane.showMessageDialog(frame, "Groupe non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }
    public void genererPV() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }
    public void displayPV(String result) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccAdd() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Groupe ajouté", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Groupe supprimé", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayErrorDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Groupe non supprimé", "Error", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displayErrorAdd(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }
       public void displayErrorModif() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Groupe non modifié", "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccModif() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Groupe modifié", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }
}
