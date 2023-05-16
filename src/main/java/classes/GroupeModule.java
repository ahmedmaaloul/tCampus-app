
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class GroupeModule {
    private int id;
    private String nom;
    private float coefficient;

    public GroupeModule() {
    }

    public GroupeModule(int id, String nom, float coefficient) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
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
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

      ///////////===================================> AJOUT
    public void ajouter(int id,String nom,float coefficient) {

        if (verifExistence(id)) {
            displayErrorAdd("Matiere Existante  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO GroupeModule(id, nom,coefficient) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setFloat(3, coefficient);
         

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccAdd();

            } else {
                displayErrorAdd("impossible d'ajouter le groupe module !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorAdd("impossible d'ajouter le groupe module !");
            e.printStackTrace();

        }

    }

    ;
    ///////////===================================> MODIF
    
    public void modifier(String nom,float coefficient) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET nom = ?, coefficient= ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setFloat(2, coefficient);
            statement.setInt(3, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible de modifier le groupe module !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible de modifier  le groupe module!");
            e.printStackTrace();

        }

    }

    ///////////===================================> DELETE
    public void supprimer() {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "DELETE from GroupeModule WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccDel();

            } else {
                displayErrorDel("impossible de supprimer  le gourpe module!");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorDel("impossible de supprimer le groupe module!");
            e.printStackTrace();

        }

    }
        ///////////===================================> ADD
    
     public void AjouterMat(int idMat) {
         if(verifExistenceInGM(idMat))return;
         if(!verifExistenceMat(idMat))return;
         

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET idGM = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);


            statement.setInt(1, this.id);
                    statement.setInt(2,idMat );

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
     public void removeMatiere(int idMat) {
         if(!verifExistenceInGM(idMat))return;
        
            

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET idGM =NULL  WHERE  id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

                    statement.setInt(1,idMat );
     
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
    
    ///////////===================================> VERIF EXISTENCE

    
    private boolean verifExistence(int id) {
        
              boolean gmExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM GroupeModule where id=?";
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
    
     private boolean verifExistenceInGM(int idMat) {
        
              boolean matExistsInGM = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Matiere where idGM=? and id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);
            statement.setInt(2, idMat);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                matExistsInGM = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return matExistsInGM;
        
        
        
    }
     
     
      private boolean verifExistenceMat(int idMat) {
        
              boolean matExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Matiere where id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setInt(2, idMat);

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
         ///////////===================================> DISPLAY


    private void displaySuccDel() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayErrorDel(String Message) {
                               JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

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
    
    
    
}
