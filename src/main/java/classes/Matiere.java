
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Matiere {
    
private int id;
private String nom;
private float coefficient;
private float vHoraire; 

    public Matiere() {
    }

    public Matiere(int id, String nom, float coefficient, float vHoraire) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
        this.vHoraire = vHoraire;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public float getvHoraire() {
        return vHoraire;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public void setvHoraire(float vHoraire) {
        this.vHoraire = vHoraire;
    }

    
    
    
      ///////////===================================> AJOUT
    public void ajouter(int id,String nom,float coefficient,float vHoraire) {

        if (verifExistence(id)) {
            displayErrorAdd("Matiere Existante  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Matiere(id, nom,coefficient,vHoraire) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setFloat(3, coefficient);
            statement.setFloat(4, vHoraire);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccAdd();

            } else {
                displayErrorAdd("impossible d'ajouter la matiere !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorAdd("impossible d'ajouter la matiere !");
            e.printStackTrace();

        }

    }

    ;
    ///////////===================================> MODIF
    
    public void modifier(String nom,float coefficient,float vHoraire) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET nom = ?, coefficient= ?,vHoraire=? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setFloat(2, coefficient);
            statement.setFloat(3, vHoraire);
            statement.setInt(4, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible de modifier la matiere !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible de modifier  la matiere!");
            e.printStackTrace();

        }

    }

    ///////////===================================> DELETE
    public void supprimer() {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "DELETE from matiere WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccDel();

            } else {
                displayErrorDel("impossible de supprimer  cette matiere!");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorDel("impossible de supprimer cette matiere!");
            e.printStackTrace();

        }

    }
    ///////////===================================> VERIF EXISTENCE

    
    private boolean verifExistence(int id) {
        
              boolean matExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Matiere where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                matExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return matExists;
        
        
        
    }
       private boolean verifExistenceGM(int id) {
        
              boolean gmExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM groupeModule where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                gmExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return gmExists;
        
        
        
    }
  ///////////===================================> ADD   
    
    public void AssignerMat_GM(int idGM) {
         if(verifExistenceGM(idGM))return;
        
         

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET idGM = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

              statement.setInt(1,idGM );
            statement.setInt(2, this.id);
      

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible d'ajouter la matiere !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible d'ajouter la matiere!");
            e.printStackTrace();

        }

    }
            ///////////===================================> REMOVE
     public void RetierMat_GM() {
      
        
            

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET idGM =NULL  WHERE  id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

                    statement.setInt(1,this.id );
     
            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible de retirer  la matiere !");

            }   

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible de retirer  la matiere!");
            e.printStackTrace();

        }

    }
///////////===================================> DISPLAY
private void displayErrorDel(String Message) {
                                   JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }
    private void displaySuccDel() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayErrorModif(String Message) {
                                       JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    private void displaySuccModif() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayErrorAdd(String Message) {
                                       JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    private void displaySuccAdd() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

        
    }
    private void displayErrorSearch() {
                                       JOptionPane.showMessageDialog(null, "ERROR", "Erreur de recherche", JOptionPane.ERROR_MESSAGE);

    }
    
    
    
    
    
    
}
