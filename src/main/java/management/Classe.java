package management;

import Frame.ConsulterClasseFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Classe {

    private int id;
    private String nom;
    private String specialite;
    private String diplome;
    private String niveau;
    private String anneeUni;
    private int idDept;

    public Classe(int id, String nom, String specialite, String diplome, String niveau, String anneeUni, int idDept) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.diplome = diplome;
        this.niveau = niveau;
        this.anneeUni = anneeUni;
        this.idDept = idDept;
    }

    public Classe() {
        this.id = 0;
        this.nom = "";
        this.specialite = "";
        this.diplome = "";
        this.niveau = "";
        this.anneeUni = "";
        this.idDept = 0;
    }

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getDiplome() {
        return diplome;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getAnneeUni() {
        return anneeUni;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setAnneeUni(String anneeUni) {
        this.anneeUni = anneeUni;
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySucc(String info) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, info, "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public boolean verifExistence(int id) {
        // Définition des informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";

        // Requête SELECT pour vérifier l'existence d'un enregistrement dans la table Classe
        String selectQuery = "SELECT Count(*) as NbreC FROM Classe WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Définir la valeur du paramètre pour la condition
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);

            // Exécuter la requête SELECT
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int nbreC = resultSet.getInt("NbreC");
                if (nbreC == 1) {
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

    public void ajouter(int id, String nom, String specialite, String diplome, String niveau, String anneeUni, int idDept) {
        // Vérifier l'unicité de l'identifiant de la classe
        if (this.verifExistence(id)) {
            this.displayError("Problème d'unicité");
            return;
        }

        // Vérifier l'existence du département
        Departement t = new Departement();
        if (!t.verifExistence(idDept)) {
            this.displayError("Département inconnu");
            return;
        }

        // Définir les valeurs des attributs de la classe
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.diplome = diplome;
        this.niveau = niveau;
        this.anneeUni = anneeUni;
        this.idDept = idDept;

        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";

        // Requête INSERT pour ajouter une classe
        String insertQuery = "INSERT INTO CLASSE (Id, nom, specialite, diplome, niveau, anneeUni, idDept) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Définir les valeurs des paramètres
            String id_str = Integer.toString(id);
            String idDept_str = Integer.toString(idDept);
            statement.setString(1, id_str);
            statement.setString(2, nom);
            statement.setString(3, specialite);
            statement.setString(4, diplome);
            statement.setString(5, niveau);
            statement.setString(6, anneeUni);
            statement.setString(7, idDept_str);

            // Exécuter la requête INSERT
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Classe ajoutée");
            } else {
                this.displayError("La classe existe déjà");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.displayError("Erreur lors de l'ajout de la classe");
            return;
        }
    }

    public void modifier(String nom, String specialite, String diplome, String niveau, String anneeUni, int idDept) {
        // Vérifier l'existence du département
        Departement t = new Departement();
        if (!t.verifExistence(idDept)) {
            this.displayError("Département inconnu");
            return;
        }

        // Définir les nouvelles valeurs des attributs de la classe
        this.nom = nom;
        this.specialite = specialite;
        this.diplome = diplome;
        this.niveau = niveau;
        this.anneeUni = anneeUni;
        this.idDept = idDept;

        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        // Requête UPDATE pour modifier une classe
        String updateQuery = "UPDATE CLASSE SET nom=?, specialite=?, diplome=?, niveau=?, anneeUni=?, idDept=? WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            String id_str = Integer.toString(id);
            String idDept_str = Integer.toString(idDept);

            // Définir les valeurs des paramètres
            statement.setString(1, nom);
            statement.setString(2, specialite);
            statement.setString(3, diplome);
            statement.setString(4, niveau);
            statement.setString(5, anneeUni);
            statement.setString(6, idDept_str);
            statement.setString(7, id_str);

            // Exécuter la requête UPDATE
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Classe modifiée");
            } else {
                System.out.println("Erreur lors de la mise à jour");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête de mise à jour : " + e.getMessage());
            System.out.println("Erreur lors de la mise à jour");
        }
    }

    public void supprimer() {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        // Requête DELETE pour supprimer une classe
        String deleteQuery = "DELETE FROM CLASSE WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Définir la valeur du paramètre pour la condition
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);

            // Exécuter la requête DELETE
            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Classe supprimée");
            } else {
                System.out.println("Aucune ligne affectée. La requête de suppression n'a pas supprimé de données.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête de suppression : " + e.getMessage());
        }
    }

    public int fsetInfo() {
        // Informations de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        // Requête SELECT pour récupérer les informations de la classe
        String selectQuery = "SELECT * FROM CLASSE WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Définir la valeur du paramètre pour la condition
            String id_str = Integer.toString(this.id);
            statement.setString(1, id_str);

            // Exécuter la requête SELECT
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Récupérer les valeurs du résultat
                nom = resultSet.getString("nom");
                specialite = resultSet.getString("specialite");
                diplome = resultSet.getString("diplome");
                niveau = resultSet.getString("niveau");
                anneeUni = resultSet.getString("anneeUni");
                idDept = resultSet.getInt("idDept");
                return 0;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête SELECT : " + e.getMessage());
            return -1;
        }
    }

    public void Consulter(int id) {
        // Définition de l'identifiant de la classe à consulter
        this.id = id;

        // Appel de la fonction fsetInfo pour récupérer les informations de la classe
        if (fsetInfo() == -1) {
            // Si la classe n'est pas trouvée, afficher un message d'erreur
            this.displayError("Classe non trouvée");
        } else {
            // Si la classe est trouvée, afficher les informations de la classe
            displayInfo();
        }
    }

    public void displayInfo() {
        // Affichage des informations de la classe dans une nouvelle fenêtre
        new ConsulterClasseFrame(this);
    }

}