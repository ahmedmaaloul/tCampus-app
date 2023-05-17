package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Departement {
private int id;
private String nom;

    public Departement() {
    }

    public Departement(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

      ///////////===================================> AJOUT
    public void ajouter(int id,String nom,int idChefDept) {

        if (verifExistence(id)) {
            displayErrorAdd("Departement Existant  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Departement(id, nom,idChefDept) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setFloat(3, idChefDept);
         

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccAdd();

            } else {
                displayErrorAdd("impossible d'ajouter le Departement !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorAdd("impossible d'ajouter le Departement !");
            e.printStackTrace();

        }

    }

    ;
    ///////////===================================> MODIF
    
    public void modifier(String nom) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET nom = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setInt(2, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible de modifier le Departement !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible de modifier  le Departement!");
            e.printStackTrace();

        }

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    ///////////===================================> DELETE
    public void supprimer() {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "DELETE from Departement WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccDel();

            } else {
                displayErrorDel("impossible de supprimer  le Departement!");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorDel("impossible de supprimer le Departement!");
            e.printStackTrace();

        }

    }
        ///////////===================================> ASSIGNER
    
     public void AssignChefDept(int idChefDept) {
         if(!verifExistenceChefDept(idChefDept))return;
    
         

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Departement SET idChefDept = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);


            statement.setInt(1, idChefDept);
                    statement.setInt(2,this.id );

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccAdd();

            } else {
                displayErrorAdd("impossible d'assigner le chef departement !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorAdd("impossible d'assigner le chef departement!");
            e.printStackTrace();

        }

    }
    ///////////===================================> ADD
      public void addClasse(int idClasse) {
         if(verifExistenceInDept(idClasse))return;
         if(!verifExistenceClasse(idClasse))return;
         

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Classe SET idDept= ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);


            statement.setInt(1, this.id);
                    statement.setInt(2,idClasse );

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccAdd();

            } else {
                displayErrorAdd("impossible d'ajouter la classe !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible d'ajouter la classe!");
            e.printStackTrace();

        }

    }
         ///////////===================================> REMOVE
         public void removeClasse(int idClasse) {
         if(!verifExistenceInDept(idClasse))return;
        
            

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Classe SET idDept =NULL  WHERE  id = ? ";
            PreparedStatement statement = connection.prepareStatement(query);

                    statement.setInt(1,idClasse );
            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccDel();

            } else {
                displayErrorDel("impossible de retirer  la classe !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible de retirer  la classe!");
            e.printStackTrace();

        }

    }
    
      
 
    ///////////===================================> VERIF EXISTENCE

    
    public boolean verifExistence(int id) {
        
              boolean DeptExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Departement where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                DeptExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return DeptExists;
        
        
        
    }
    private boolean verifExistenceChefDept( int idChefDept){
        
         
              boolean ChefDeptExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM utilisateur where CNSS=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idChefDept);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                ChefDeptExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return ChefDeptExists;
        
        
        
    }
        private boolean verifExistenceInDept( int idClasse){
        
         
              boolean classeExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM classe where id=? and idDept=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idClasse);
                  statement.setInt(2,this.id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                classeExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return classeExists;
        
        
        
    }
            private boolean verifExistenceClasse( int idClasse){
        
         
              boolean ClasseExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Classe where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idClasse);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                ClasseExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return ClasseExists;
        
        
        
    }
    
    
   ///////////===================================> DISPLAY
    private void displayErrorAdd(String Message) {
                       JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    private void displaySuccAdd() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displaySuccModif() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayErrorModif(String Message) {
                     JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    private void displaySuccDel() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayErrorDel(String Message) {
                            JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

}