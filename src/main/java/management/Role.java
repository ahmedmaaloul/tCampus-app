
package management;


import interfaces.ConsulterRoleFrame;
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
             displayError("Role Existante  !");
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
                         displaySucc();
                
            }else{
                 displayError("impossible d'ajouter le nouveau role !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
            displayError("impossible d'ajouter le nouveau role !");
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
                         displaySucc();
                
            }else{
                 displayError("impossible de modifier  ce role !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayError("impossible de modifier  ce role !");
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
                                       query ="Update utilisateur set idRole=NULL where  idRole=?";
                 statement = connection.prepareStatement(query);
                 statement.setInt(1, this.id);
                 rows = statement.executeUpdate();
                 if(rows>0){
                        displaySucc();   
                 }else{
                                      displayError("ERREUR !");

                 }
                
            }else{
                 displayError("impossible de supprimer  ce role !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayError("impossible de supprimer  ce role !");
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
    

            ResultSet resultSet = statement.executeQuery();
            
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

    private void displaySucc() {

                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayError(String Message) {

                                               JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    
    
///////////===================================>  CONSULTER 
    
    public void consulter(int idRole ){
        this.id=idRole;
        fsetInfo();
        displayInfo();
        
    
    }
    


    private  void displayInfo() {
     ConsulterRoleFrame roleFrame=new ConsulterRoleFrame(id,nom,description);
    }

    private void fsetInfo() {
       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"))
                {
             
            String query = "SELECT * FRom role where id= ?  ";
           
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
                ResultSet   resultSet = statement.executeQuery();
            if (resultSet.next()) {
                 this.nom=resultSet.getString("nom");
                this.description=resultSet.getString("description");
           
                    
           
            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }
    
    }
    public static void main(String[] args) {
        Role r1=new Role();
        r1.consulter(1);
    }
}
