package management;

import management.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Ahmed
 */
public class Etudiant extends Utilisateur {

    private int num_insc;
    private int idGRP;
    public Etudiant(int num_insc, String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance,int idGRP) {
        super(CIN_Passport, nomUtilisateur, email, password, prenom, nom, tel, genre, photo, dateNaissance, 2);
        this.num_insc = num_insc;
        this.idGRP= idGRP;
    }

    public Etudiant() {
        super();
        this.num_insc = 0;
        this.idGRP= 0;
        this.setIdRole(2);
    }

    @Override
    public void displayError(String reason) {
        super.displayError(reason); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displaySuccAssign() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Etudiant ajouté au groupe", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    @Override
    public void displaySuccModif() {
        super.displaySuccModif(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayErrorModif() {
        super.displayErrorModif(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displaySuccDel() {
        super.displaySuccDel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displaySuccAdd() {
        super.displaySuccAdd(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayErrorSearch() {
        super.displayErrorSearch(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifUniciteCIN_Passport(String CIN_Passport) {
        return super.verifUniciteCIN_Passport(CIN_Passport); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNum_insc(int num_insc) {
        this.num_insc = num_insc;
    }

    @Override
    public void setDateNaissance(String dateNaissance) {
        super.setDateNaissance(dateNaissance); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPhoto(String photo) {
        super.setPhoto(photo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getGenre() {
        return super.getGenre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setGenre(int genre) {
        super.setGenre(genre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIdRole(int idRole) {
        super.setIdRole(idRole); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdRole() {
        return super.getIdRole(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTel(String tel) {
        super.setTel(tel); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNomUtilisateur(String nomUtilisateur) {
        super.setNomUtilisateur(nomUtilisateur); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCIN_Passport(String CIN_Passport) {
        super.setCIN_Passport(CIN_Passport); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDateNaissance() {
        return super.getDateNaissance(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNum_insc() {
        return num_insc;
    }

    @Override
    public String getPhoto() {
        return super.getPhoto(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTel() {
        return super.getTel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNom() {
        return super.getNom(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrenom() {
        return super.getPrenom(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNomUtilisateur() {
        return super.getNomUtilisateur(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCIN_Passport() {
        return super.getCIN_Passport(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verifUnicite_num_insc(int num_insc) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) AS NbreU FROM Utilisateur WHERE typeUser='Etudiant' num_insc=" + num_insc;
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

    public boolean verifExistanceEt(String CIN_Passport, int num_insc) {
        if (super.verifExistence(CIN_Passport)) {
            return true;
        }
        if (verifUnicite_num_insc(num_insc) == false) {
            return true;
        }
        return false;
    }

    public void displayErrorDel() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Erreur lors de la suppression", "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySuccRemove() {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "L'Etudaint a été retiré du groupe", "MAJ", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void calculerTauxAbsence(int IdMat) {
        int NbreCoursAb, NbreCours;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) nbreCoursAb FROM ABSENCE WHERE IdE=" + num_insc + " AND IdC IN (SELECT IDC  FROM COURS WHERE IDMAT =" + IdMat + ");";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                NbreCoursAb = resultSet.getInt("nbreCoursAb");
            } else {
                return;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            JFrame frame = new JFrame("Error Dialog");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Info", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
            return;

        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) nbreCours FROM COURS WHERE IDMAT =" + IdMat + ";";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                NbreCours = resultSet.getInt("nbreCours");
                double tauxAb = NbreCoursAb / NbreCours;
                tauxAb = tauxAb * 100;
                displayTauxAbsences((float) tauxAb);
            } else {
                return;
            }
        } catch (SQLException e) {

            e.printStackTrace();
            JFrame frame = new JFrame("Error Dialog");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Info", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
            return;

        }
    }

    public void displayTauxAbsences(float tauxAb) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, " " + tauxAb + "%", "Taux d'Absence", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void afficheResultat(int anneeUni) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Taux d'Absence", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void displayReleve(String CIN_Passport) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Taux d'Absence", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public void removeGRP() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "UPDATE utilisateurs SET idGRP = NULL WHERE CIN_Passport ='" + CIN_Passport + "'";
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                this.displaySuccRemove();
                idGRP=0;
                
            } else {
                displayError("La requête de mise à jour n'a modifié aucune donnée.");
            }
        } catch (SQLException e) {

            e.printStackTrace();
            JFrame frame = new JFrame("Error Dialog");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Info", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
            return;

        }
    }

    public void assignGRP(int idGRP) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "UPDATE utilisateurs SET idGRP =" + idGRP + " WHERE CIN_Passport ='" + CIN_Passport + "'";
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                this.displaySuccAssign();
                this.idGRP=idGRP;
            } else {
                displayError("La requête de mise à jour n'a modifié aucune donnée.");
            }
        } catch (SQLException e) {

            e.printStackTrace();
            JFrame frame = new JFrame("Error Dialog");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Info", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
            return;

        }
    }

    public void ajouter(String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance, int num_insc) {
        if (this.verifExistanceEt(CIN_Passport, num_insc)) {
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
        this.num_insc = num_insc;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String insertQuery = "INSERT INTO UTILISATEUR (CIN_Passport, nomUtilisateur,email,password,prenom,nom,tel,genre,photo,dateNaissance,num_insc,typeUser,idRole) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Set the values for the parameters
            statement.setString(1, CIN_Passport);
            statement.setString(2, nomUtilisateur);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, prenom);
            statement.setString(6, nom);
            String genre_str = genre == 1 ? "1" : "0";
            statement.setString(7, genre_str);
            statement.setString(8, tel);
            statement.setString(9, photo);
            statement.setString(10, dateNaissance);
            String num_insc_str = Integer.toString(num_insc);
            statement.setString(12, num_insc_str);
            statement.setString(13, "2");

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccAdd();
            } else {
                this.displayError("Echec lors de l'ajout");
            }

        } catch (SQLException e) {
            System.err.println("Error executing insert query: " + e.getMessage());
        }
    }

    public void modifier(String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance, int num_insc) {
        if (this.verifUnicite_num_insc(num_insc)) {
            this.displayErrorModif();
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
        this.num_insc = num_insc;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE UTILISATEUR SET nomUtilisateur= ? ,email=?,password=?,prenom=?,nom=?genre=?,tel=?,photo=?,dateNaissance=?,num_insc=? WHERE CIN_Passport= ?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Set the new value for the column
            statement.setString(1, nomUtilisateur);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, prenom);
            statement.setString(5, nom);
            String genre_str = genre == 1 ? "1" : "0";
            statement.setString(6, genre_str);
            statement.setString(7, tel);
            statement.setString(8, photo);
            statement.setString(9, dateNaissance);
            String num_insc_str = Integer.toString(num_insc);
            statement.setString(10, num_insc_str);
            statement.setString(10, CIN_Passport);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySuccModif();
            } else {
                this.displayErrorModif();
            }

        } catch (SQLException e) {
            System.err.println("Error executing update query: " + e.getMessage());
            this.displayErrorModif();
        }
    }

    public int fsetInfo() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String selectQuery = "SELECT * FROM UTILISATEUR WHERE typeUser='Etudiant' AND num_insc=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Set the parameter value for the condition
            String num_insc_str = Integer.toString(num_insc);
            statement.setString(1, num_insc_str);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve values from the result set
                CIN_Passport = resultSet.getString("CIN_Passport");
                nomUtilisateur = resultSet.getString("nomUtilisateur");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                prenom = resultSet.getString("prenom");
                nom = resultSet.getString("nom");
                tel = resultSet.getString("tel");
                photo =resultSet.getString("photo");
                dateNaissance =resultSet.getString("dateNaissance");
                num_insc =resultSet.getInt("num_insc");
                idGRP = resultSet.getInt("idGRP");
                return 0;
            }
            else{
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Error executing select query: " + e.getMessage());
            return -1;
        }
    }
}
