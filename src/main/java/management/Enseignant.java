
package management;


import Frame.ConsulterEnseignantFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Enseignant extends Utilisateur {
     public enum Type {
        PERMANENT,
        VACATAIRE
    }
    private int CNSS;
    private String fonction;
    private Type type;
    public Enseignant() {
    }

    public Enseignant(String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance,int CNSS, String fonction) {
          super(CIN_Passport, nomUtilisateur, email, password, prenom, nom, tel, genre, photo, dateNaissance, 3);
        this.CNSS = CNSS;
        this.fonction = fonction;
    }

    public int getCNSS() {
        return CNSS;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFonction() {
        return fonction;
    }

    public void setCNSS(int CNSS) {
        this.CNSS = CNSS;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
    
    public void ajouter(String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance, int CNSS,String type,String fonction) {
        if (this.verifExistanceEns(CIN_Passport, CNSS)) {
            this.displayError("probleme d'unicite");
            return;
        }
        this.CIN_Passport = CIN_Passport;
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.tel = tel;
        this.photo = photo;
        this.dateNaissance = dateNaissance;
        this.CNSS = CNSS;
        this.fonction=fonction;
        if("Permanent".equals(type)){
            this.type=Type.PERMANENT;
                    }   else{
            this.type=Type.VACATAIRE;
            type="Vacataire";
            
        }     
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String insertQuery = "INSERT INTO UTILISATEUR (CIN_Passport, nomUtilisateur,email,password,prenom,nom,tel,genre,photo,dateNaissance,CNSS,type,fonction,idRole) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the values for the parameters
            statement.setString(1, CIN_Passport);
            statement.setString(2, nomUtilisateur);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, prenom);
            statement.setString(6, nom);
            statement.setInt(7, genre);
            statement.setString(8, tel);
            statement.setString(9, photo);
            statement.setString(10, dateNaissance);
            statement.setInt(11, CNSS);
            statement.setString(12, type);
            statement.setString(13, fonction);
            statement.setString(14, "3");

            int rows = statement.executeUpdate();
  

            if (rows> 0) {
                this.displaySucc();
            } else {
                this.displayError("Echec lors de l'ajout");
            }

        } catch (SQLException e) {
            System.err.println("Error executing insert query: " + e.getMessage());
        }
    }
      public void modifier(String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance,String type,String fonction) {
        if (this.verifUnicite_CNSS(CNSS)) {
            this.displayError("");
            return;
        }
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.tel = tel;
        this.photo = photo;
        this.dateNaissance = dateNaissance;
        
        this.fonction=fonction;
              if("Permanent".equals(type)){
            this.type=Type.PERMANENT;
                    }   else{
            this.type=Type.VACATAIRE;
            type="Vacataire";
            
        }   
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE UTILISATEUR SET nomUtilisateur= ? ,email=?,password=?,prenom=?,nom=?genre=?,tel=?,photo=?,dateNaissance=?,type=?,fonction=? WHERE CIN_Passport= ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Set the new value for the column
            statement.setString(1, nomUtilisateur);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, prenom);
            statement.setString(5, nom);
            statement.setInt(6, genre);
            statement.setString(7, tel);
            statement.setString(8, photo);
            statement.setString(9, dateNaissance);
               statement.setString(10, type);
                           statement.setString(11, fonction);

            statement.setString(12, CIN_Passport);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                this.displaySucc();
            } else {
                this.displayError("");
            }

        } catch (SQLException e) {
            System.err.println("Error executing update query: " + e.getMessage());
            this.displayError("");
        }
    }
    
    
    ///////////===================================>  EXISTENCE
       public boolean verifExistanceEns(String CIN_Passport, int num_insc) {
        if (super.verifExistence(CIN_Passport)) {
            return true;
        }
        if (!verifUnicite_CNSS(num_insc) ) {
            return true;
        }
        return false;
    }
  
private boolean verifUnicite_CNSS(int CNSS) {
        boolean cnssExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Utilisateur where CNSS=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, CNSS);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                cnssExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return cnssExists;
    }
///////////===================================>  DISPLAY
   
    
   

///////////===================================>  CONSULTER 
    
    public void consulter(int CNSS) {
        this.CNSS = CNSS;
        fsetInfo();
        displayInfo(this);

    }

    private void displayInfo(Enseignant enseignant) {
   

       ConsulterEnseignantFrame matiereFrame = new ConsulterEnseignantFrame(enseignant);
    }

    private void fsetInfo() {
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT * FRom utilisateur where CNSS= ?  ";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, CNSS);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.nom = resultSet.getString("nom");
                this.prenom= resultSet.getString("prenom");
             
              
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
