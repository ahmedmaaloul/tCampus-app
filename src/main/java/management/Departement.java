package management;

import Frame.ConsulterDepartementFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Departement {
private int id;
private String nom;
private String idChefDept;
    public Departement() {
    }

    public Departement(int id, String nom,String idChefDept) {
        this.id = id;
        this.nom = nom;
        this.idChefDept=idChefDept;
        
    }

    public int getId() {
        return id;
    }

    public String getIdChefDept() {
        return idChefDept;
    }

    public void setIdChefDept(String idChefDept) {
        this.idChefDept = idChefDept;
    }

    public String getNom() {
        return nom;
    }

      ///////////===================================> AJOUT
    public void ajouter(int id,String nom) {

        if (verifExistence(id)) {
            displayError("Departement Existant  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Departement(id, nom) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
          
         

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible d'ajouter le Departement !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter le Departement !");
            e.printStackTrace();

        }

    }

    ;
    ///////////===================================> MODIF
    
    public void modifier(String nom) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Departement SET nom = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setInt(2, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible de modifier le Departement !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de modifier  le Departement!");
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
                displaySucc();

            } else {
                displayError("impossible de supprimer  le Departement!");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de supprimer le Departement!");
            e.printStackTrace();

        }

    }
        ///////////===================================> ASSIGNER
    
     public void AssignChefDept(String idChefDept) {
         
         if(!verifExistenceChefDept(idChefDept))
         {
               displayError("Chef département non existant ou deja assigné ");
             return;
    
         }
           
         

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Departement SET idChefDept = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);


            statement.setString(1, idChefDept);
                    statement.setInt(2,this.id );

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible d'assigner le chef departement !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'assigner le chef departement!");
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

            ResultSet resultSet = statement.executeQuery();

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
    private boolean verifExistenceChefDept( String idChefDept){
        
         
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT CIN_PASSPORT FROM utilisateur where typeUser!=2 AND CIN_PASSPORT= ?  ";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, idChefDept);
          

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                if(resultSet.getString("CIN_PASSPORT")==idChefDept)return false;
                
                 query="Select idChefDept from departement where idChefDept=?";
                  statement = connection.prepareStatement(query);
                           statement.setString(1, idChefDept);

             resultSet = statement.executeQuery(query);
             if(resultSet.next()){
                 
                if(resultSet.getString("idChefDpet")==idChefDept)return false;
                 
             }

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return true;
        
        
        
    }
      
          
        
    
    
    
   ///////////===================================> DISPLAY
    private void displayError(String Message) {
                       JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    private void displaySucc() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    

  
    
///////////===================================>  CONSULTER 
    
    public void consulter(int idDept ){
        this.id=idDept;
        fsetInfo();
        displayInfo(this);
        
    
    }
    


    private  void displayInfo(Departement dept) {
     ConsulterDepartementFrame roleFrame=new ConsulterDepartementFrame(dept);
    }

    private void fsetInfo() {
       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"))
                {
             
            String query = "SELECT * FRom departement where id= ?  ";
           
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
                ResultSet   resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.id=resultSet.getInt("id");
                 this.nom=resultSet.getString("nom");
                           this.idChefDept=resultSet.getString("idChefDept");

                    
           
            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }
    
    }
    public static void main(String[] args) {
 
    }
}
