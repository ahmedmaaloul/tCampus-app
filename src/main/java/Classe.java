
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
public class Classe {

    private int id;
    private String nom;
    private String specialite;
    private String diplome;
    private String niveau;
    private String anneeUni;
    private int idDept;

    public Classe(int id, String nom, String specialite, String diplome, String niveau, String anneeUni, int idDept) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.diplome = diplome;
        this.niveau = niveau;
        this.anneeUni = anneeUni;
        this.idDept = idDept;
    }

    public Classe() {
        this.id = 0;
        this.nom = "";
        this.specialite = "";
        this.diplome = "";
        this.niveau = "";
        this.anneeUni = "";
        this.idDept = 0;
    }

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getDiplome() {
        return diplome;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getAnneeUni() {
        return anneeUni;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setAnneeUni(String anneeUni) {
        this.anneeUni = anneeUni;
    }

    public void displayErrorSearch() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Classe non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccAdd() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Classe ajouté", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Classe supprimé", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayErrorDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Classe non supprimé", "Error", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displayErrorAdd() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Classe non ajouté", "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccModif() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Classe modifié", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public boolean verifExistence(int id) {
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "root";
        String password = "root";

        String selectQuery = "SELECT Count(*) as NbreC FROM Classe WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int nbreC = resultSet.getInt("NbreC");
                if (nbreC == 1) {
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

    public void ajouter(int id, String nom, String specialite, String diplome, String niveau, String anneeUni, int idDept) {
        if(this.verifExistence(id)){
            this.displayErrorAdd();
            return;
        }
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.diplome = diplome;
        this.niveau = niveau;
        this.anneeUni = anneeUni;
        this.idDept = idDept;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO CLASSE (Id, nom,specialite,diplome,niveau,anneeUni,idDept) VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the values for the parameters
            String Id_str = Integer.toString(id);
            String idDept_str = Integer.toString(idDept);
            statement.setString(1, Id_str);
            statement.setString(2, nom);
            statement.setString(3, specialite);
            statement.setString(4, diplome);
            statement.setString(5, niveau);
            statement.setString(6, anneeUni);
            statement.setString(7, idDept_str);

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

    public void modifier(String specialite, String diplome, String niveau, String anneeUni, int idDept) {
        this.nom = nom;
        this.specialite = specialite;
        this.diplome = diplome;
        this.niveau = niveau;
        this.anneeUni = anneeUni;
        this.idDept = idDept;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE CLASSE SET nom= ?,specialite=?,diplome=?,niveau=?,anneeUni=?,idDept=? WHERE  id= ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            String Id_str = Integer.toString(id);
            String idDept_str = Integer.toString(idDept);

            statement.setString(1, nom);
            statement.setString(2, specialite);
            statement.setString(3, diplome);
            statement.setString(4, niveau);
            statement.setString(5, anneeUni);
            statement.setString(6, idDept_str);
            statement.setString(7, Id_str);


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
        String deleteQuery = "DELETE FROM CLASSE WHERE WHERE id= ?";
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
}
