
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmed
 */
public class DashboardFrame extends JFrame{
      ImageIcon logoSys;
      JLabel header;
      JPanel sidebar,main;
      JButton Etudiants,Enseignants,Groupes,Matieres,Modules,Profile;
      JPanel EtudiantsPanel,EnseignantsPanel,GroupesPanel,MatieresPanel,ModulesPanel,ProfilePanel;
      DashboardFrame(){
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setSize(1440,720);
          this.setLayout(new BorderLayout());
          
          //importing images
          logoSys = new ImageIcon(DashboardFrame.class.getResource("tCampus.png"));
          
          // Panels
          sidebar = new JPanel();
          main = new JPanel();
          EtudiantsPanel = new JPanel();
          EnseignantsPanel= new JPanel();
          GroupesPanel = new JPanel();
          MatieresPanel = new JPanel();
          ModulesPanel = new JPanel();
          ProfilePanel = new JPanel();
          
          // labels
          header = new JLabel();
          
          
          // buttons
          Etudiants = new JButton("Etudiants");
          Etudiants.setBorder(new RoundedBorder(10));
          Enseignants = new JButton("Enseignants");
          Groupes = new JButton("Groupes");
          Matieres = new JButton("Matieres");
          Modules = new JButton("Modules");
          Profile = new JButton("Profile");
 
          
          
          sidebar.setBackground(new Color(0x1877F2));
          EtudiantsPanel.setBackground(new Color(0x1877F2));
          EnseignantsPanel.setBackground(new Color(0x1877F2));
          GroupesPanel.setBackground(new Color(0x1877F2));
          MatieresPanel.setBackground(new Color(0x1877F2));
          ModulesPanel.setBackground(new Color(0x1877F2));
          ProfilePanel.setBackground(new Color(0x1877F2));
          
          main.setBackground(Color.white);
          sidebar.setPreferredSize(new Dimension(262,1024));
          sidebar.setLayout(new GridLayout(7,1));
          header.setBounds(50,50,246,100);
          
          header.setIcon(logoSys);
          header.setAlignmentY(CENTER_ALIGNMENT);
          
          
         //adding button containers to sidebar
          sidebar.add(header);
          sidebar.add(EtudiantsPanel);
          sidebar.add(EnseignantsPanel);
          sidebar.add(GroupesPanel);
          sidebar.add(MatieresPanel);
          sidebar.add(ModulesPanel);
          sidebar.add(ProfilePanel);
          
          
          // adding buttons to their containers
          EtudiantsPanel.add(Etudiants);
          EnseignantsPanel.add(Enseignants);
          GroupesPanel.add(Groupes);
          MatieresPanel.add(Matieres);
          ModulesPanel.add(Modules);
          ProfilePanel.add(Profile);
          
          this.add(sidebar,BorderLayout.WEST);
          this.add(main);
          this.setVisible(true);       

      }
    private static class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
}
