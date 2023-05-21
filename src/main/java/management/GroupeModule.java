



package management;


import Frame.ConsulterGroupeModuleFrame;
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
    private int idClasse;

    public GroupeModule() {
    }

    public GroupeModule(int id, String nom, float coefficient,int idClasse) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
        this.idClasse = idClasse;
    }

    public int getId() {
        return id;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
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
            displayError("Matiere Existante  !");
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
                displaySucc();

            } else {
                displayError("impossible d'ajouter le groupe module !");

            }

            statement.close();

        } catch (SQLException e) {
          
            displayError("impossible d'ajouter le groupe module !");
            e.printStackTrace();

        }

    }

    ;
    ///////////===================================> MODIF
    
    public void modifier(String nom,float coefficient) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE GroupeModule SET nom = ?, coefficient= ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setFloat(2, coefficient);
            statement.setInt(3, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible de modifier le groupe module !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de modifier  le groupe module!");
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
                           query ="Update Matiere set idGM=NULL where  idGM=?";
                 statement = connection.prepareStatement(query);
                 statement.setInt(1, this.id);
                  statement.executeUpdate();
                  displaySucc();
          

            } else {
                displayError("impossible de supprimer  le gourpe module!");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de supprimer le groupe module!");
            e.printStackTrace();

        }

    }
        ///////////===================================> ADD
    
     public void AjouterGM_Classe(int idClasse) {
         if(!verifExistenceInClasse(idClasse))return;
        

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE GroupeModule SET idClasse = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

         statement.setInt(1,idClasse );
            statement.setInt(2, this.id);
           

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible d'ajouter le groupemodule !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter le groupemodule!");
            e.printStackTrace();

        }

    }
            ///////////===================================> REMOVE
     public void removeGM_Classe() {

            

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE GroupeModule SET idClasse =NULL  WHERE  id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

                    statement.setInt(1,this.id );
     
            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible de retirer  le groupemodule !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de retirer  le groupemodule!");
            e.printStackTrace();

        }

    }
    
    ///////////===================================> VERIF EXISTENCE

    
    public boolean verifExistence(int id) {
        
              boolean gmExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "Select 1 from groupemodule where id=?";
                  try (
                          
                     PreparedStatement statement = connection.prepareStatement(query)) {
                      statement.setInt(1, id);
                      
                      ResultSet resultSet = statement.executeQuery();
                      
                      if (resultSet.next()) {
                          
                          gmExists = resultSet.getInt(1) > 0;
                          
                      }
                      
                      resultSet.close();
                  }

        } catch (SQLException e) {
  System.out.println("pspspsps");
            e.printStackTrace();

        }
        return gmExists;
        
        
        
    }
    
     public  boolean verifExistenceInClasse(int idClasse) {
        
              boolean classeExists = false;
        try (
                
                
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Classe where  id=?";
            PreparedStatement statement = connection.prepareStatement(query);

   
            statement.setInt(1, idClasse);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                classeExists = resultSet.getInt(1) > 0;

            }else{
                System.out.println("fuck");
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return classeExists;
        
        
        
    }
     
     
   
         ///////////===================================> DISPLAY


    public void displaySucc() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    public void displayError(String Message) {
                               JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }
   

///////////===================================>  CONSULTER 
    
    public void consulter(int idGM ){
        this.id=idGM;
        fsetInfo();
        displayInfo();
        
    
    }
    


    public  void displayInfo() {
     ConsulterGroupeModuleFrame salleFrame=new ConsulterGroupeModuleFrame(this);
    }

    public void fsetInfo() {
       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"))
                {
             
            String query = "SELECT * FRom groupeModule where id= ?  ";
           
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
                ResultSet   resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.nom=resultSet.getString("nom");
                this.coefficient=resultSet.getFloat("coefficient");
                this.idClasse=resultSet.getInt("idClasse");
           
                    
           
            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }
    
    }
    
    
        public static void main(String[] args) {
               System.out.println("hii");
       GroupeModule tempGM=new GroupeModule();
    //       tempGM.ajouter(1,"Algo",(float)3.5);
         tempGM.consulter(5);
         
    }
    
}
