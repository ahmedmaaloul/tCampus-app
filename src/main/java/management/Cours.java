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
    private int idMat, idSalle;
    private String idEns="";

    
    public enum Day {
        LUNDI,
        MARDI,
        MERCREDI,
        JEUDI,
        VENDREDI,
        SAMEDI
        
    }

    private Day day;

  
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
  public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Day stringToDay(String day) {
        if ("LUNDI".equals(day)) {
            return Cours.Day.LUNDI;
        }
        if ("MARDI".equals(day)) {
            return Cours.Day.MARDI;
        }
        if ("MERCREDI".equals(day)) {
            return Cours.Day.MERCREDI;
        }
           if ("JEUDI".equals(day)) {
            return Cours.Day.JEUDI;
        }
        if ("VENDREDI".equals(day)) {
            return Cours.Day.VENDREDI;
        }
        
            return Cours.Day.SAMEDI;

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

    public String getIdEns() {
        return idEns;
    }

    public void setIdEns(String idEns) {
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
    public void ajouter(int id, String nom, String description, float duree, String horaireDebut, String day) {

        if (verifExistence(id)) {
            displayError("Cours Existant  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "INSERT INTO Cours(id, nom,description, horaireDebut,duree,day) VALUES (?, ?, ?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, nom);
            statement.setString(3, description);
            statement.setString(4, horaireDebut);
            statement.setFloat(5, duree);
            statement.setString(6, day);

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
    
    public void modifier(String nom, String description, float duree, String horaireDebut, String day) {
        
       
      
        if( !verifExistenceEtDisponibiliteEns(idEns,day,duree,horaireDebut )
                ||  !verifExistenceEtDisponibiliteSalle(idSalle,day,duree,horaireDebut))
            {displayError("Vueillez respecter la disponibilité des enseignants et salles ");
            return ;
        }
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET nom = ?, description = ?,duree=? ,horaireDebut=? ,day=? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nom);
            statement.setString(2, description);
            statement.setFloat(3, duree);
            statement.setString(4, horaireDebut);
            statement.setString(5, day);
            statement.setInt(6, this.id);

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

    public void AssignerAEns(String idEns) {

        if (!verifExistenceEtDisponibiliteEns(idEns,this.day.toString(),this.duree,this.horaireDebut)) {
            displayError("Enseignant non existant or non disponible  !");
            return;
        }

        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET idEns= ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println("id ens " + idEns + "   id cours " + this.id);
            statement.setString(1, idEns);
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
       
        if (!verifExistenceMat(idMat)) {
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
 
        if (!verifExistenceEtDisponibiliteSalle(idSalle,this.day.toString(),this.duree,this.horaireDebut)) {

            displayError("Salle inExistante ou non Disponible  !");
            return;
        }
        System.out.println("VERIF CHECK BY PASSED");
        try (
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {

            String query = "UPDATE Cours SET idSalle= ? WHERE id = ?";
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
    public boolean verifExistence(int id) {
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

    public boolean verifExistenceEtDisponibiliteEns(String idEns,String day,float duree,String horaireDebut) {
        boolean EnsExists = false;
        boolean EnsDispo = true;
        if(idEns==null)return true;
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {
            String query = "SELECT 1 FROM Utilisateur WHERE CIN_Passport=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idEns);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                EnsExists = true;

                query = "SELECT idEns FROM Cours WHERE   id!=? AND idEns=? AND day=? AND "
                        + " ("
                        + " (TIME(HoraireDebut) >= TIME(?) AND TIME(HoraireDebut) <= TIME(?)) "
                        + "OR"
                        + " (TIME(HoraireDebut) <= TIME(?) AND ADDTIME(HoraireDebut, SEC_TO_TIME(Cours.Duree * 3600)) >= TIME(?)     )  "
                        + "      )";

                PreparedStatement statement2 = connection.prepareStatement(query);
                    statement2.setInt(1, this.id);
                statement2.setString(2, idEns);
                  statement2.setString(3, day);
                
                statement2.setString(4, horaireDebut);

                int duration = (int) duree * 60;
                LocalTime horaireDebutTime = LocalTime.parse(horaireDebut);
                LocalTime horaireFinTime = horaireDebutTime.plusMinutes(duration);
                statement2.setString(5, horaireFinTime.toString());
                statement2.setString(6, horaireDebut);
                statement2.setString(7, horaireDebut);

                ResultSet resultSet2 = statement2.executeQuery();

                if (resultSet2.next() && resultSet2.getString("idEns").equals(idEns)) {
                    EnsDispo = false;
                }

                resultSet2.close();
                statement2.close();
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return EnsExists && EnsDispo;
    }

    public boolean verifExistenceMat(int id) {

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

    public  boolean verifExistenceEtDisponibiliteSalle(int idSalle,String day,float duree,String horaireDebut) {
        boolean SalleExists = false;
        boolean SalleDispo = true;
        if(idSalle==0)return true;
        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root")) {
            System.out.println("before query");
            String query = "SELECT id FROM Salle where id=?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idSalle);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                SalleExists = true;

                query = "SELECT idSalle FROM Cours WHERE   id!=? AND idSalle=? AND day=? AND "
                        + " ("
                        + " (TIME(HoraireDebut) >= TIME(?) AND TIME(HoraireDebut) <= TIME(?)) "
                        + "OR"
                        + " (TIME(HoraireDebut) <= TIME(?) AND ADDTIME(HoraireDebut, SEC_TO_TIME(Cours.Duree * 3600)) >= TIME(?)     )  "
                        + "      )";
                PreparedStatement statement2 = connection.prepareStatement(query);
                      statement2.setInt(1, this.id);
                statement2.setInt(2, idSalle);
                  statement2.setString(3, day);
                statement2.setString(4, horaireDebut);

                int duration = (int)duree * 60;
                LocalTime horaireDebutTime = LocalTime.parse(horaireDebut);
                LocalTime horaireFinTime = horaireDebutTime.plusMinutes(duration);

                statement2.setString(5, horaireFinTime.toString()); // Set HoraireFin
                statement2.setString(6, horaireDebut);
                statement2.setString(7, horaireDebut);
                ResultSet resultSet2 = statement2.executeQuery();

                if (resultSet2.next() && resultSet2.getInt("IdSalle") == idSalle) {
                    SalleDispo = false;
                }

                resultSet2.close();
                statement2.close();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SalleExists && SalleDispo;
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

///////////===================================>  CONSULTER 
    public void consulter(int idGM) {
        this.id = idGM;
        fsetInfo();
        displayInfo(this);

    }

    public void displayInfo(Cours cours) {

        ConsulterCoursFrame coursFrame = new ConsulterCoursFrame(cours);
    }

    public void fsetInfo() {
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
                this.idEns = resultSet.getString("idEns");
                this.day=stringToDay( resultSet.getString("day"));

            }

            resultSet.close();
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

///////////===================================> DISPLAY
    public void displayError(String Message) {
        JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);

    }

    ;

    public void displaySucc() {
        JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

;

}
