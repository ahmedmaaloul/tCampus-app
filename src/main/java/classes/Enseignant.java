
package classes;

import javax.swing.JOptionPane;


public class Enseignant extends Utilisateur {
    
    private int CNSS;
    private String fonction;

    public Enseignant() {
    }

    public Enseignant(int CNSS, String fonction) {
        this.CNSS = CNSS;
        this.fonction = fonction;
    }

    public int getCNSS() {
        return CNSS;
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
    
    
    
    
    
    
    
    
///////////===================================>  DISPLAY

    private void displaySucc() {

                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Operation terminé avec success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void displayError(String Message) {

                                               JOptionPane.showMessageDialog(null, "ERROR", Message, JOptionPane.ERROR_MESSAGE);


    }

    
}
