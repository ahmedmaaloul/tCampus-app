package management;


import Frame.ConsulterSalleFrame;
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
            
             displayError("Salle Existante  !");
            return ;
        }
        
       
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO  Salle(id, capacite, type, contientProjecteur) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setInt(2, capacite);
            statement.setString(3, type);
            statement.setBoolean(4, contientProjecteur);


            
            int rows = statement.executeUpdate();
            if(rows>0){
                         displaySucc();
                
            }else{
                 displayError("impossible d'ajouter la nouvelle salle !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
            displayError("impossible d'ajouter la nouvelle salle !");
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
                         displaySucc();
                
            }else{
                 displayError("impossible de modifier  cette salle !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayError("impossible de modifier  cette salle !");
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
           
                        displaySucc();   
                 
                    
                
            }else{
                 displayError("impossible de supprimer  cette salle !");
                
            }
            
          
            statement.close();
   
        } catch (SQLException e) {
           displayError("impossible de supprimer  cette salle !");
            e.printStackTrace();

        }

    }
    
  
    
    
  ///////////===================================> VERIF EXISTENCE

    public boolean verifExistence(int id) {
      
        boolean salleExists=false;
        try (
               
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {
                 String query = "SELECT 1 FROM Salle where id=?  ";
                 
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
    
            ResultSet resultSet = statement.executeQuery();
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

    public void displaySucc() {

                                    JOptionPane.showMessageDialog(null, "Operation terminé avec success", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

    
    }
    public void displayError(String Message) {

                                               JOptionPane.showMessageDialog(null, Message,"ERROR", JOptionPane.ERROR_MESSAGE);


    }
    

///////////===================================>  CONSULTER 
    
    public void consulter(int idSalle ){
        this.id=idSalle;
        fsetInfo();
        displayInfo();
        
    
    }
    


    public  void displayInfo() {
     ConsulterSalleFrame salleFrame=new ConsulterSalleFrame(this);
    }

    public void fsetInfo() {
       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"))
                {
             
            String query = "SELECT * FRom salle where id= ?  ";
           
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
                ResultSet   resultSet = statement.executeQuery();
            if (resultSet.next()) {
                 this.capacite=resultSet.getInt("capacite");
                this.type=resultSet.getString("type");
                this.contientProjecteur=resultSet.getBoolean("contientProjecteur");
           
                    
           
            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }
    
    }
    
    
        public static void main(String[] args) {
        Salle s1=new Salle();
        
        //new AjouterSalleFrame();
        s1.consulter(5);

  
    }

}
