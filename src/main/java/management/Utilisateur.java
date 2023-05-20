package management;

import Frame.ConsulterUtilisateurFrame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utilisateur {

    protected String CIN_Passport, nomUtilisateur, email, password, prenom, nom, tel, photo;
    protected String dateNaissance; // should be stored as date type in DB
    protected int genre;
    protected int idRole;

    public Utilisateur(String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance, int idRole) {
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
        this.idRole = idRole;
    }

    public Utilisateur() {
        this.CIN_Passport = "";
        this.nomUtilisateur = "";
        this.email = "";
        this.password = "";
        this.prenom = "";
        this.nom = "";
        this.genre = 0;
        this.tel = "";
        this.photo = "";
        this.dateNaissance = "";
        this.idRole = 0;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getCIN_Passport() {
        return CIN_Passport;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getGenre() {
        return genre;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getTel() {
        return tel;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setCIN_Passport(String CIN_Passport) {
        this.CIN_Passport = CIN_Passport;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void  ajouter(String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance,int idRole)  {

        if (!verifUniciteCIN_Passport(CIN_Passport)) {
            displayError("Utilisateur Existant  !");
 
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Utilisateur(CIN_Passport,nomUtilisateur, email,password,prenom,nom,tel,genre,photo,dateNaissance,idRole) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

         
    
            statement.setString(1, CIN_Passport);
            statement.setString(2, nomUtilisateur);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, prenom);
            statement.setString(6, nom);
            statement.setString(7, tel);
            statement.setInt(8, genre);
            statement.setString(9, photo);
            statement.setString(10, dateNaissance);
                        statement.setInt(11, idRole);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();
            
            } else {
       displayError("impossible d'ajouter l'utlisateur !");
            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter l'utlisateur !");
            e.printStackTrace();

        }


    }
    
    
    public int modifier( String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance) throws ParseException {

  

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = " UPDATE Utilisateur set nomUtilisateur=?,  email=?, password=?, prenom=?, nom=? ,tel=?, genre=?,  photo=?,dateNaissance=? where CIN_Passport=?";
            PreparedStatement statement = connection.prepareStatement(query);

            // =>(dataNaissence) converting string to date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateNaissence_db = new Date(1, 1, 1);
            try {
                dateNaissence_db = (Date) sdf.parse(dateNaissance);
                System.out.println(dateNaissence_db);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // end of converting
           
            statement.setString(1, nomUtilisateur);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, prenom);
            statement.setString(5, nom);
            statement.setString(6, tel);
            statement.setInt(7, genre);
            statement.setString(8, photo);
            statement.setDate(9, dateNaissence_db);
           statement.setString(10, this.CIN_Passport);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();
                return 1;
            } else {
         displayError("impossible d'ajouter l'utlisateur !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter l'utlisateur !");
            e.printStackTrace();

        }

        return 0;
    }
    
    
    
  public int supprimer(){
         try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = " DELETE from utilisateur where CIN_Passport=?";
            PreparedStatement statement = connection.prepareStatement(query);
statement.setString(1, this.CIN_Passport);
          

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();
                return 1;
            } else {
    displayError("impossible d'ajouter l'utlisateur !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter l'utlisateur !");
            e.printStackTrace();

        }

        return 0;
      
      
      
      
      
  }
  public boolean Login(String username,String password){
  
         try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = " Select from Utilisateur where username=? and password=? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
statement.setString(2, password);
          

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();
                return true;
                
            } else {
    displayError("username ou mot de passe incorrect !");
           
            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de connecter  !");
            e.printStackTrace();

        }
      
      return false;
  
  }
  
  public void  AssignerRole(int idRole){
      
      if(!verifExistenceRole(idRole)){
          displayError("Role non existant");
      }
      
      
          try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = " Update utilisateur set idRole=? where CIN_Passport=? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idRole);
statement.setString(2, this.CIN_Passport);
          

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();
                
            } else {
    displayError("impossible d'ajouter l'utlisateur !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter l'utlisateur !");
            e.printStackTrace();

        }
      
      
      
      
      
      
      
  }
    public boolean verifUniciteCIN_Passport(String CIN_Passport) {
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");  Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) AS NbreU FROM Utilisateur WHERE CIN_Passport='" + CIN_Passport + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int nbreU = resultSet.getInt("NbreU");
                if (nbreU == 0) {
                    resultSet.close();
                    return true;
                }
            }
            resultSet.close();
            return false;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }

   private boolean verifExistenceRole(int idRole) {
        boolean roleExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM role where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idRole);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                roleExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return roleExists;
    }
  
    
 

 

    public void displaySucc() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Operation terminé !", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccAdd() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   

        frame.dispose();
    }

    public void displaySucc(String info) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, info, "MAJ", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur supprimé", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayErrorModif() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur non modifié", "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccModif() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur modifié", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displaySuccAssign() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur modifié", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public boolean verifExistence(String CIN_Passport) {
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");  Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) AS NbreU FROM Utilisateur WHERE CIN_Passport='" + CIN_Passport + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int nbreU = resultSet.getInt("NbreU");
                if (nbreU == 1) {
                    resultSet.close();
                    return true;
                }
            }
            resultSet.close();
            return false;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }
    
    
///////////===================================>  CONSULTER 
    
    public void consulter(String CIN_Passport) {
        this.CIN_Passport = CIN_Passport;
        fsetInfo();
        displayInfo(this);

    }

    private void displayInfo(Utilisateur utilisateur) {
   

       ConsulterUtilisateurFrame utlisateurFrame = new ConsulterUtilisateurFrame(utilisateur);
    }

    private void fsetInfo() {
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT * FRom utilisateur where CIN_Passport= ?  ";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, CIN_Passport);
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
