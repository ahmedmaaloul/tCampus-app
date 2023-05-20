package management;

import Frame.ConsulterStudentFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Etudiant extends Utilisateur {

    private int num_insc;
    private int idGRP;

    public Etudiant(int num_insc, String CIN_Passport, String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance, int idGRP) {
        super(CIN_Passport, nomUtilisateur, email, password, prenom, nom, tel, genre, photo, dateNaissance, 2);
        this.num_insc = num_insc;
        this.idGRP = idGRP;
    }

    public Etudiant() {
        super();
        this.num_insc = 0;
        this.idGRP = 0;
        this.setIdRole(2);
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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS NbreU FROM Utilisateur WHERE typeUser='Etudiant' AND num_insc=?")) {
            // Établir une connexion à la base de données en utilisant JDBC et définir le nom d'utilisateur et le mot de passe

            // Préparer une requête paramétrée avec un espace réservé pour le numéro d'inscription
            // Le point d'interrogation sera remplacé par une valeur réelle ultérieurement
            statement.setInt(1, num_insc); // Définir la valeur du paramètre (num_insc)

            ResultSet resultSet = statement.executeQuery(); // Exécuter la requête de sélection

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
            // Vérifier l'existence de l'Etudiant par le CIN ou le Passport
            // Si l'Etudiant existe, retourner true
            return true;
        }
        if (verifUnicite_num_insc(num_insc) == false) {
            // Vérifier l'unicité du numéro d'inscription de l'Etudiant
            // Si le numéro d'inscription existe déjà, retourner true
            return true;
        }
        // Aucune condition n'a été satisfaite, donc retourner false
        return false;
    }

    public void calculerTauxAbsence(int IdMat) {
        int NbreCoursAb, NbreCours;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) nbreCoursAb FROM ABSENCE WHERE IdE=? AND IdC IN (SELECT IDC  FROM COURS WHERE IDMAT=?)")) {
            // Établir une connexion à la base de données en utilisant JDBC et définir le nom d'utilisateur et le mot de passe

            statement.setInt(1, num_insc); // Définir la valeur du premier paramètre (IdE)
            statement.setInt(2, IdMat); // Définir la valeur du deuxième paramètre (IdMAT)

            ResultSet resultSet = statement.executeQuery(); // Exécuter la première requête de sélection

            if (resultSet.next()) {
                NbreCoursAb = resultSet.getInt("nbreCoursAb");
            } else {
                resultSet.close();
                return;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JFrame frame = new JFrame("Error Dialog");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JOptionPane.showMessageDialog(frame, "Cette fonctionnalité ne fonctionne pas encore", "Info", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) nbreCours FROM COURS WHERE IDMAT=?")) {
            // Établir une nouvelle connexion à la base de données

            statement.setInt(1, IdMat); // Définir la valeur du paramètre (IdMAT)

            ResultSet resultSet = statement.executeQuery(); // Exécuter la deuxième requête de sélection

            if (resultSet.next()) {
                NbreCours = resultSet.getInt("nbreCours");
                double tauxAb = NbreCoursAb / NbreCours;
                tauxAb = tauxAb * 100;
                displayTauxAbsences((float) tauxAb);
            } else {
                resultSet.close();
                return;
            }
            resultSet.close();
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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("UPDATE utilisateurs SET idGRP = NULL WHERE CIN_Passport = ?")) {
            // Établir une connexion à la base de données en utilisant JDBC et définir le nom d'utilisateur et le mot de passe

            // Préparer une requête paramétrée avec un espace réservé
            // Le point d'interrogation sera remplacé par une valeur réelle ultérieurement
            statement.setString(1, CIN_Passport); // Définir la valeur du paramètre (CIN_Passport)

            int rowsAffected = statement.executeUpdate(); // Exécuter la requête de mise à jour

            if (rowsAffected > 0) {
                this.displaySucc("L'Etudiant a été retiré du groupe");
                idGRP = 0;
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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tCampus", "root", "root");
                PreparedStatement statement = connection.prepareStatement("UPDATE utilisateurs SET idGRP = ? WHERE CIN_Passport = ?")) {
            // Établir une connexion à la base de données en utilisant JDBC et définir le nom d'utilisateur et le mot de passe

            // Préparer une requête paramétrée avec des espaces réservés
            // Les points d'interrogation seront remplacés par les valeurs réelles ultérieurement
            statement.setInt(1, idGRP); // Définir la valeur du premier paramètre (idGRP)
            statement.setString(2, CIN_Passport); // Définir la valeur du deuxième paramètre (CIN_Passport)

            int rowsAffected = statement.executeUpdate(); // Exécuter la requête de mise à jour

            if (rowsAffected > 0) {
                this.displaySucc("Etudiant ajouté au groupe");
                this.idGRP = idGRP;
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
            // Vérifier l'existence de l'Etudiant par le CIN ou le Passport et le numéro d'inscription
            // Si l'Etudiant existe déjà, afficher un message d'erreur et quitter la méthode
            this.displayError("probleme d'unicite");
            return;
        }

        // Aucun problème d'unicité, procéder à l'ajout de l'Etudiant
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

        String insertQuery = "INSERT INTO UTILISATEUR (CIN_Passport, nomUtilisateur, email, password, prenom, nom, tel, genre, photo, dateNaissance, num_insc, typeUser, idRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Définir les valeurs des paramètres
            statement.setString(1, CIN_Passport);
            statement.setString(2, nomUtilisateur);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, prenom);
            statement.setString(6, nom);
            String genre_str = genre == 1 ? "1" : "0"; // Conversion du genre en chaîne de caractères ("0" pour masculin, "1" pour féminin)
            statement.setString(7, genre_str);
            statement.setString(8, tel);
            statement.setString(9, photo);
            statement.setString(10, dateNaissance);
            String num_insc_str = Integer.toString(num_insc); // Conversion du numéro d'inscription en chaîne de caractères
            statement.setString(12, num_insc_str);
            statement.setString(13, "2"); // Valeur fixe pour le type d'utilisateur (2 pour étudiant)

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Etudiant ajouté");
            } else {
                this.displayError("Echec lors de l'ajout");
            }

        } catch (SQLException e) {
            System.err.println("Error executing insert query: " + e.getMessage());
        }
    }


    public int modifier(String nomUtilisateur, String email, String password, String prenom, String nom, String tel, int genre, String photo, String dateNaissance) {
        if (this.verifUnicite_num_insc(num_insc)) {
            // Vérifier l'unicité de l'étudiant par le numéro d'inscription
            // Si l'étudiant n'est pas unique, afficher un message d'erreur et quitter la méthode
            this.displayError("Etudiant non modifié");
            return 1;
        }

        // L'étudiant est unique, procéder à la modification des informations
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.tel = tel;
        this.photo = photo;
        this.dateNaissance = dateNaissance;

        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";
        String updateQuery = "UPDATE UTILISATEUR SET nomUtilisateur=?, email=?, password=?, prenom=?, nom=?, genre=?, tel=?, photo=?, dateNaissance=? WHERE CIN_Passport=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Définir les nouvelles valeurs pour chaque colonne
            statement.setString(1, nomUtilisateur);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, prenom);
            statement.setString(5, nom);
            String genre_str = genre == 1 ? "1" : "0"; // Conversion du genre en chaîne de caractères ("0" pour masculin, "1" pour féminin)
            statement.setString(6, genre_str);
            statement.setString(7, tel);
            statement.setString(8, photo);
            statement.setString(9, dateNaissance);
            statement.setString(10, CIN_Passport);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected > 0) {
                this.displaySucc("Etudiant modifié");
            } else {
                this.displayError("Etudiant non modifié");
            }

        } catch (SQLException e) {
            System.err.println("Error executing update query: " + e.getMessage());
            this.displayError("Etudiant non modifié");
        }
        return 1;
    }

    public int fsetInfo() {
        String url = "jdbc:mysql://localhost:3306/tCampus";
        String usernameDB = "root";
        String passwordDB = "root";

        String selectQuery = "SELECT * FROM UTILISATEUR WHERE typeUser='Etudiant' AND num_insc=?";

        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB);
                PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            // Définir la valeur du paramètre pour la condition
            String num_insc_str = Integer.toString(num_insc);
            statement.setString(1, num_insc_str);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Récupérer les valeurs du jeu de résultats
                CIN_Passport = resultSet.getString("CIN_Passport");
                nomUtilisateur = resultSet.getString("nomUtilisateur");
                email = resultSet.getString("email");
                password = resultSet.getString("password");
                prenom = resultSet.getString("prenom");
                nom = resultSet.getString("nom");
                tel = resultSet.getString("tel");
                photo = resultSet.getString("photo");
                dateNaissance = resultSet.getString("dateNaissance");
                num_insc = resultSet.getInt("num_insc");
                idGRP = resultSet.getInt("idGRP");
                return 0;
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.err.println("Error executing select query: " + e.getMessage());
            return -1;
        }
    }

    public void Consulter(int num_insc) {
        this.num_insc = num_insc;
        if (this.fsetInfo() == -1) {
            // Vérifier si l'étudiant a été trouvé ou non
            // Si l'étudiant n'a pas été trouvé, afficher un message d'erreur et quitter la méthode
            this.displayError("Etudiant non trouvé");
            return;
        } else {
            // Afficher les informations de l'étudiant
            displayInfo();
        }
    }

    public void displayInfo() {
        new ConsulterStudentFrame(this);
    }

    public static void main(String[] args) {
        Etudiant e = new Etudiant();
        e.Consulter(156132);
    }
}