package management;

import Frame.ConsulterStageForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Stage {

    private int id;
    private String type;
    private String dateDebut;
    private String dateFin;
    private String idEtu;

    public Stage(int id, String type, String dateDebut, String dateFin, String idEtu) {
        this.id = id;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idEtu = idEtu;
    }

    public Stage() {
        this.id = 0;
        this.type = "";
        this.dateDebut = "";
        this.dateFin = "";
        this.idEtu = "";
    }

    public String getIdEtu() {
        return idEtu;
    }

    public void setIdEtu(String idEtu) {
        this.idEtu = idEtu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public boolean verifExistence(int id) {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";

        String selectQuery = "SELECT Count(*) as NbreS FROM Stage WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Définir la valeur du paramètre pour la condition
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int nbreS = resultSet.getInt("NbreS");
                if (nbreS == 1) {
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

    public void ajouter(int id, String type, String dateDebut, String dateFin, String idEtu) {
        if (this.verifExistence(id)) {
            this.displayError("Problème d'unicité");
            return;
        }
        Etudiant t = new Etudiant();
    
        if (t.verifExistence(idEtu) == false) {
            this.displayError("Etudiant non trouvé");
            return;
        }
        this.id = id;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idEtu = idEtu;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String username = "root";
        String password = "root";
        String insertQuery = "INSERT INTO STAGE (id, type, dateDebut, dateFin, idEtu) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Définir les valeurs des paramètres
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);
            statement.setString(2, type);
            statement.setString(3, dateDebut);
            statement.setString(4, dateFin);
            statement.setString(5, idEtu);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Stage ajouté");
            } else {
                this.displayError("Stage existe déjà");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.displayError("Erreur dans l'ajout du Stage");
            return;
        }
    }

    public void modifier(String type, String dateDebut, String dateFin) {
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE STAGE SET type=?, dateDebut=?, dateFin=? WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            String id_str = Integer.toString(id);
            statement.setString(1, type);
            statement.setString(2, dateDebut);
            statement.setString(3, dateFin);
            statement.setString(4, id_str);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Stage modifié");
            } else {
                System.out.println("Erreur lors de la mise à jour");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête de mise à jour : " + e.getMessage());
            System.out.println("Erreur lors de la mise à jour");
        }
    }

    public void supprimer() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String deleteQuery = "DELETE FROM STAGE WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Définir la valeur du paramètre pour la condition
            String id_str = Integer.toString(id);
            statement.setString(1, id_str);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Lignes affectées : " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Stage supprimé");
            } else {
                System.out.println("Aucune ligne affectée. La requête de suppression n'a pas supprimé de données.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête de suppression : " + e.getMessage());
        }
    }

    public void displayError(String reason) {
        JFrame frame = new JFrame("Error Dialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, reason, "Erreur", JOptionPane.ERROR_MESSAGE);

        frame.dispose();
    }

    public void displaySucc(String info) {
        JFrame frame = new JFrame("info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, info, "Info", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
    }

    public int fsetInfo() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String selectQuery = "SELECT * FROM STAGE WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Définir la valeur du paramètre pour la condition
            String id_str = Integer.toString(this.id);
            statement.setString(1, id_str);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Récupérer les valeurs à partir du résultat de la requête
                type = resultSet.getString("type");
                dateDebut = resultSet.getString("dateDebut");
                dateFin = resultSet.getString("dateFin");
                idEtu = resultSet.getString("idEtu");
                return 0;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête de sélection : " + e.getMessage());
            return -1;
        }
    }

    public void Consulter(int id) {
        this.id = id;
        System.out.println("id is "+id);
        if (fsetInfo() == -1) {
            this.displayError("Impossible de trouver ce stage");
        } else {
            displayInfo();
        }
    }

    public void displayInfo() {
        new ConsulterStageForm(this);
    }

    public static void main(String[] args) {
        Stage s = new Stage();
        s.Consulter(1);
    }
}