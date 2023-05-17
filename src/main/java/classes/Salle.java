package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Salle {

    private int id, capacite;
    private String type;
    private boolean contientProjecteur;

    public Salle() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContientProjecteur(boolean contientProjecteur) {
        this.contientProjecteur = contientProjecteur;
    }

    public Salle(int id, int capacite, String type, boolean contientProjecteur) {
        this.id = id;
        this.capacite = capacite;
        this.type = type;
        this.contientProjecteur = contientProjecteur;
    }

    public int getId() {
        return id;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getType() {
        return type;
    }

    public boolean isContientProjecteur() {
        return contientProjecteur;
    }
///////////===================================> AJOUT
    public void ajouter(int id, int capacite, String type, boolean contientProjecteur) {

        if(verifExistence(id)){
             displayErrorAdd("Salle Existante  !");
            return ;
        }
        
        
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO salle(id, capacite, type, contient_projecteur) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setInt(2, capacite);
            statement.setString(3, type);
            statement.setBoolean(4, contientProjecteur);


            
            int rows = statement.executeUpdate();
            if(rows>0){
                         displaySuccAdd();
                
            }else{
                 displayErrorAdd("impossible d'ajouter la nouvelle salle !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
            displayErrorAdd("impossible d'ajouter la nouvelle salle !");
            e.printStackTrace();

        }

    }
///////////===================================> MODIF
    
    public void modifier( int capacite,String type, boolean contientProjecteur) {


   
        
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

              String query = "UPDATE salle SET capacite = ?, type = ?,contientProjecteur=? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, capacite);
            statement.setString(2, type);
            statement.setBoolean(3, contientProjecteur);
            statement.setInt(4, this.id);


            
            int rows = statement.executeUpdate();
            if(rows>0){
                         displaySuccModif();
                
            }else{
                 displayErrorModif("impossible de modifier  cette salle !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayErrorModif("impossible de modifier  cette salle !");
            e.printStackTrace();

        }

    }
    
    ///////////===================================> DELETE
    public void supprimer( ) {


   
        
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

              String query = "DELETE from salle WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);
 

            
            int rows = statement.executeUpdate();
            if(rows>0){
                
                query ="Update Cours set idSalle=NULL where  idSalle=?";
                 statement = connection.prepareStatement(query);
                 statement.setInt(1, this.id);
                 rows = statement.executeUpdate();
                 if(rows>0){
                        displaySuccDel();   
                 }else{
                                      displayErrorDel("ERREUR !");

                 }
                    
                
            }else{
                 displayErrorDel("impossible de supprimer  cette salle !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayErrorDel("impossible de supprimer  cette salle !");
            e.printStackTrace();

        }

    }
    
  
    
    
  ///////////===================================> VERIF EXISTENCE

    private boolean verifExistence(int id) {
        boolean salleExists=false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

                 String query = "SELECT 1 FROM Salle where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
    

            ResultSet resultSet = statement.executeQuery(query);
            
                if(resultSet.next()){
                    
                    salleExists=resultSet.getInt(1)>0;
                    
                }
            
            
               resultSet.close();
            statement.close();
            
        } catch (SQLException e) {

            e.printStackTrace();
            

        }
            return salleExists;
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
