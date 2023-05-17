
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Role {
    private int id;
    private String nom;
    private String description;

    public Role() {
    }

    public Role(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    ///////////===================================> AJOUT
    public void ajouter(int id, String nom,String description) {

        if(verifExistence(id)){
             displayErrorAdd("Role Existante  !");
            return ;
        }
        
        
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Role(id, nom,description) VALUES (?, ?, ? )";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setString(3, description);


            
            int rows = statement.executeUpdate();
            if(rows>0){
                         displaySuccAdd();
                
            }else{
                 displayErrorAdd("impossible d'ajouter le nouveau role !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
            displayErrorAdd("impossible d'ajouter le nouveau role !");
            e.printStackTrace();

        }

    }
///////////===================================> MODIF
    
    public void modifier( String nom,String description) {


   
        
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

              String query = "UPDATE role SET nom = ?, description= ?  WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setString(2, description);
            statement.setInt(3, this.id);


            
            int rows = statement.executeUpdate();
            if(rows>0){
                         displaySuccModif();
                
            }else{
                 displayErrorModif("impossible de modifier  ce role !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayErrorModif("impossible de modifier  ce role !");
            e.printStackTrace();

        }

    }
    
    ///////////===================================> DELETE
    public void supprimer( ) {


   
        
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

              String query = "DELETE from role WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);
 

            
            int rows = statement.executeUpdate();
            if(rows>0){
                         displaySuccDel();
                
            }else{
                 displayErrorDel("impossible de supprimer  ce role !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayErrorDel("impossible de supprimer  ce role !");
            e.printStackTrace();

        }

    }
    
  
    
    
  ///////////===================================> VERIF EXISTENCE

    private boolean verifExistence(int id) {
        boolean roleExists=false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

                 String query = "SELECT 1 FROM role where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
    

            ResultSet resultSet = statement.executeQuery(query);
            
                if(resultSet.next()){
                    
                    roleExists=resultSet.getInt(1)>0;
                    
                }
            
            
               resultSet.close();
            statement.close();
            
        } catch (SQLException e) {

            e.printStackTrace();
            

        }
            return roleExists;
    }      
    
    
    
    
    
///////////===================================>  DISPLAY

    private void displaySuccAdd() {

                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayErrorAdd(String Message) {

                                               JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);


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

        private void displayErrorSearch() {
                                               JOptionPane.showMessageDialog(null, "ERROR", "Erreur de recherche", JOptionPane.ERROR_MESSAGE);

    }

    
    
}
