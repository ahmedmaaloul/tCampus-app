
package management;


import Frame.ConsulterMatiereFrame;
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
private int idGm;
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

    public int getIdGm() {
        return idGm;
    }

    public void setIdGm(int idGm) {
        this.idGm = idGm;
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
            displayError("Matiere Existante  !");
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
                displaySucc();

            } else {
                displayError("impossible d'ajouter la matiere !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter la matiere !");
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
                displaySucc();

            } else {
                displayError("impossible de modifier la matiere !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de modifier  la matiere!");
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
                      query ="Update Cours set idMat=NULL where  idMat=?";
                 statement = connection.prepareStatement(query);
                 statement.setInt(1, this.id);
                 rows = statement.executeUpdate();
           

            } else {
                displayError("impossible de supprimer  cette matiere!");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de supprimer cette matiere!");
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

            ResultSet resultSet = statement.executeQuery();

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

            ResultSet resultSet = statement.executeQuery();

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
         if(!verifExistenceGM(idGM))return;
        
         

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Matiere SET idGM = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

              statement.setInt(1,idGM );
            statement.setInt(2, this.id);
      

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible d'ajouter la matiere !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter la matiere!");
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
                displaySucc();

            } else {
                displayError("impossible de retirer  la matiere !");

            }   

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de retirer  la matiere!");
            e.printStackTrace();

        }

    }
///////////===================================> DISPLAY
private void displayError(String Message) {
                                   JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }
    private void displaySucc() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }



///////////===================================>  CONSULTER 
    
    public void consulter(int idGM) {
        this.id = idGM;
        fsetInfo();
        displayInfo(this);

    }

    private void displayInfo(Matiere matiere) {
   

        ConsulterMatiereFrame matiereFrame = new ConsulterMatiereFrame(matiere);
    }

    private void fsetInfo() {
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT * FRom matiere where id= ?  ";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.nom = resultSet.getString("nom");
                this.coefficient= resultSet.getFloat("coefficient");
                this.vHoraire = resultSet.getFloat("vHoraire");
                this.idGm = resultSet.getInt("idGm");
              
            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        System.out.println("hii");

    }


    
    
    
}
