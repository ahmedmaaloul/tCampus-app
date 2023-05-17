package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Cours {

    private int id;
    private String nom, description;
    private float duree;
    private Date horaireDebut;

    public Cours() {
    }

    public Cours(int id, String nom, String description, float duree, Date horaireDebut) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.duree = duree;
        this.horaireDebut = horaireDebut;
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

    public float getDuree() {
        return duree;
    }

    public Date getHoraireDebut() {
        return horaireDebut;
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

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public void setHoraireDebut(Date horaireDebut) {
        this.horaireDebut = horaireDebut;
    }
    ///////////===================================> AJOUT
    public void ajouter(int id, String nom, String description, float duree, Date horaireDebut) {

        if (verifExistence(id)) {
            displayErrorAdd("Cours Existant  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Cours(id, nom,description, horaireDebut,duree) VALUES (?, ?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setString(3, description);
            statement.setDate(4, horaireDebut);
            statement.setFloat(5, duree);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccAdd();

            } else {
                displayErrorAdd("impossible d'ajouter le cours !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorAdd("impossible d'ajouter le cours !");
            e.printStackTrace();

        }

    }

    ;
    ///////////===================================> MODIF
    
    public void modifier(String nom, String description, float duree, Date horaireDebut) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET nom = ?, description = ?,duree=? ,horaireDebut=? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setString(2, description);
            statement.setFloat(3, duree);
            statement.setDate(4, horaireDebut);
            statement.setInt(5, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible de modifier le cours !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible de modifier  le cours !");
            e.printStackTrace();

        }

    }

    ///////////===================================> DELETE
    public void supprimer() {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "DELETE from salle WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccDel();

            } else {
                displayErrorDel("impossible de supprimer le cours !");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorDel("impossible de supprimer  le cours!");
            e.printStackTrace();

        }

    }
    ///////////===================================> ASSIGNER 

    public void AssignerAEns(int idEns) {

        if (verifExistenceEns(idEns)) {
            displayErrorAdd("Enseignant inExistant  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET idEns= ?WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idEns);
            statement.setInt(2, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible d'assigner l'enseignant au cours!");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible d'assigner l'enseignant au cours !");
            e.printStackTrace();

        }

    }
    
    public void AssignerAMat(int idMat) {

        if (verifExistenceMat(idMat)) {
            displayErrorAdd("Matiere inExistante  !");
            return;
        }
        

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET idMat= ?WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idMat);
            statement.setInt(2, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible d'assigner la matiere  au cours!");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible d'assigner la matiere  au cours !");
            e.printStackTrace();

        }

    }
    
    public void AssignerASalle(int idSalle) {

        if (VerifExistenceEtDisponibilite(idSalle)) {
            displayErrorAdd("Salle inExistante ou non Disponible  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET idSalle= ?WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idSalle);
            statement.setInt(2, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySuccModif();

            } else {
                displayErrorModif("impossible d'assigner la salle  au cours!");

            }

            statement.close();

        } catch (SQLException e) {
            displayErrorModif("impossible d'assigner la salle  au cours !");
            e.printStackTrace();

        }

    }
    

    ///////////===================================> VERIF EXISTENCE
    private boolean verifExistence(int id) {
        boolean salleExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Cours where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                salleExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return salleExists;
    }

    private boolean verifExistenceEns(int id) {

        boolean EnsExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Enseignants where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                EnsExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return EnsExists;
    }

    private boolean verifExistenceMat(int id) {

        boolean MatExists = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Matiere where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                MatExists = resultSet.getInt(1) > 0;

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return MatExists;
    }

    private boolean VerifExistenceEtDisponibilite(int IdSalle) {

        boolean SalleExists = false ;
        boolean SalleDispo = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Salle where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                SalleExists = resultSet.getInt(1) > 0;
                if (SalleExists) {
                    query = "SELECT 1 FROM Cours where idSalle=? and  HoraireDebut>=? and HoraireDebut<=?";
                    statement = connection.prepareStatement(query);
                    statement.setInt(1, IdSalle);
                    statement.setDate(2, this.horaireDebut);
                    
                    // ==> preparing the horaire of ending the course
                    int duration = (int) this.duree * 60;
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(this.horaireDebut);
                    calendar.add(Calendar.MINUTE, duration);
                    Date HoraireFin=(Date) calendar.getTime() ;
                    //
                    statement.setDate(3, HoraireFin);
                    
                     resultSet = statement.executeQuery(query);
                         
                             if (resultSet.next()) {

                SalleDispo = resultSet.getInt(1) > 0;

            }

                }

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return SalleDispo;
    }

///////////===================================> DISPLAY
    private void concsulterLesAbsences(int idCours){
        
        
          try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root") ) {

            String query = "SELECT idE FROM  absence where idC=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idCours);

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                    /* 
                
                    DISPLAAAY RESULTS !!!!
                
                
                */
                
            }

                

            

            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
        
        
    }
    

///////////===================================> DISPLAY
private void displayErrorAdd(String Message) {
            JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    };

    private void displaySuccAdd() {
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    };

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
