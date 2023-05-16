/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class Utilisateur {

    protected String CIN_Passport, nomUtilisateur, email, password, prenom, nom, tel, photo;
    protected String dateNaissance; // should be stored as date type in DB
    protected int genre;
    protected int idRole;

    public Utilisateur(String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel,int genre,String photo, String dateNaissance,int idRole) {
        this.CIN_Passport = CIN_Passport;
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.genre= genre;
        this.tel = tel;
        this.photo = photo;
        this.dateNaissance = dateNaissance;
        this.idRole= idRole;
    }

    public Utilisateur() {
        this.CIN_Passport = "";
        this.nomUtilisateur = "";
        this.email = "";
        this.password = "";
        this.prenom = "";
        this.nom = "";
        this.genre =0;
        this.tel = "";
        this.photo = "";
        this.dateNaissance = "";
        this.idRole= 0;
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

    public int ajouter(String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel,int genre,String photo, String dateNaissance) {
        return 0;
    }

    public boolean verifUniciteCIN_Passport(String CIN_Passport) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) AS NbreU FROM Utilisateur WHERE CIN_Passport='" + CIN_Passport + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int nbreU = resultSet.getInt("NbreU");
                if(nbreU == 0){
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
    public void displayErrorSearch(){
      JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur non trouvé", "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }
    public void displaySuccAdd(){
      JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur ajouté", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }
     public void displaySuccDel(){
      JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur supprimé", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }
      public void displayErrorModif(){
      JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur non modifié", "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }
       public void displaySuccModif(){
      JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur modifié", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }
       public void displaySuccAssign(){
      JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Utilisateur modifié", "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }
         public void displayError(String reason){
      JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Info", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }
      
     public boolean verifExistence(String CIN_Passport) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root"); Statement statement = connection.createStatement()) {

            String query = "SELECT COUNT(*) AS NbreU FROM Utilisateur WHERE CIN_Passport='" + CIN_Passport + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int nbreU = resultSet.getInt("NbreU");
                if(nbreU == 1){
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
}
