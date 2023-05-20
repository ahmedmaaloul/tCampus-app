package management;

import Frame.ConsulterCoursFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Cours {

    private int id;
    private String nom, description;
    private float duree;
    private String horaireDebut;
    private int idEns, idMat, idSalle;

    public Cours() {
    }

    public Cours(int id, String nom, String description, float duree, String horaireDebut) {
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

    public String getHoraireDebut() {
        return horaireDebut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEns() {
        return idEns;
    }

    public void setIdEns(int idEns) {
        this.idEns = idEns;
    }

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
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

    public void setHoraireDebut(String horaireDebut) {
        this.horaireDebut = horaireDebut;
    }

    ///////////===================================> AJOUT
    public void ajouter(int id, String nom, String description, float duree, String horaireDebut) {

        if (verifExistence(id)) {
            displayError("Cours Existant  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Cours(id, nom,description, horaireDebut,duree) VALUES (?, ?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setString(3, description);
            statement.setString(4, horaireDebut);
            statement.setFloat(5, duree);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible d'ajouter le cours !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'ajouter le cours !");
            e.printStackTrace();

        }

    }

    ;
    ///////////===================================> MODIF
    
    public void modifier(String nom, String description, float duree, String horaireDebut) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET nom = ?, description = ?,duree=? ,horaireDebut=? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setString(2, description);
            statement.setFloat(3, duree);
            statement.setString(4, horaireDebut);
            statement.setInt(5, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible de modifier le cours !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de modifier  le cours !");
            e.printStackTrace();

        }

    }

    ///////////===================================> DELETE
    public void supprimer() {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "DELETE from cours WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible de supprimer le cours !");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible de supprimer  le cours!");
            e.printStackTrace();

        }

    }
    ///////////===================================> ASSIGNER 

    public void AssignerAEns(int idEns) {

        if (verifExistenceEns(idEns)) {
            displayError("Enseignant inExistant  !");
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
                displaySucc();

            } else {
                displayError("impossible d'assigner l'enseignant au cours!");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'assigner l'enseignant au cours !");
            e.printStackTrace();

        }

    }

    public void AssignerAMat(int idMat) {

        if (verifExistenceMat(idMat)) {
            displayError("Matiere inExistante  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET idMat= ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idMat);
            statement.setInt(2, this.id);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                displaySucc();

            } else {
                displayError("impossible d'assigner la matiere  au cours!");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'assigner la matiere  au cours !");
            e.printStackTrace();

        }

    }

    public void AssignerASalle(int idSalle) {

        if (VerifExistenceEtDisponibilite(idSalle)) {
            displayError("Salle inExistante ou non Disponible  !");
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
                displaySucc();

            } else {
                displayError("impossible d'assigner la salle  au cours!");

            }

            statement.close();

        } catch (SQLException e) {
            displayError("impossible d'assigner la salle  au cours !");
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

            ResultSet resultSet = statement.executeQuery();

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

            ResultSet resultSet = statement.executeQuery();

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

            ResultSet resultSet = statement.executeQuery();

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

        boolean SalleExists = false;
        boolean SalleDispo = false;
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT 1 FROM Salle where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                SalleExists = resultSet.getInt(1) > 0;
                if (SalleExists) {
                    query = "SELECT 1 FROM Cours where idSalle=? and  HoraireDebut>=? and HoraireDebut<=?";
                    statement = connection.prepareStatement(query);
                    statement.setInt(1, IdSalle);
                    statement.setString(2, this.horaireDebut);

                    // ==> preparing the horaire of ending the course
                   int duration = (int) this.duree * 60;
    LocalTime horaireDebutTime = LocalTime.parse(this.horaireDebut);
    LocalTime horaireFinTime = horaireDebutTime.plusMinutes(duration);

    statement.setString(3, horaireFinTime.toString()); // Set HoraireFin

                    resultSet = statement.executeQuery();

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
    public void concsulterLesAbsences(int idCours) {

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT idE FROM  absence where idC=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, idCours);

            ResultSet resultSet = statement.executeQuery();

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
    private void displayError(String Message) {
        JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    ;

    private void displaySucc() {
        JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    ;

///////////===================================>  CONSULTER 
    
    public void consulter(int idGM) {
        this.id = idGM;
        fsetInfo();
        displayInfo(this);

    }

    private void displayInfo(Cours cours) {
   

        ConsulterCoursFrame coursFrame = new ConsulterCoursFrame(cours);
    }

    private void fsetInfo() {
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "SELECT * FRom Cours where id= ?  ";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.nom = resultSet.getString("nom");
                this.description = resultSet.getString("description");
                this.horaireDebut = resultSet.getString("horaireDebut");
                this.duree = resultSet.getFloat("duree");
                this.idMat = resultSet.getInt("idMat");
                this.idSalle = resultSet.getInt("idSalle");
                this.idEns = resultSet.getInt("idEns");

            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        System.out.println("hii");
        Cours tempCours = new Cours();
        //       tempGM.ajouter(1,"Algo",(float)3.5);
        tempCours.consulter(5);

    }

}
