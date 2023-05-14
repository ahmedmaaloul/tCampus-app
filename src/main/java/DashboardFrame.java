
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmed
 */
public class DashboardFrame extends JFrame implements MouseListener{
      ImageIcon logoSys,EtudiantsIcon,EnseignantsIcon,GroupesIcon,MatieresIcon,ModulesIcon,ProfileIcon;
      JLabel header;
      JPanel sidebar,main;
      JLabel Etudiants,Enseignants,Groupes,Matieres,Modules,Profile;
      Color blueColor = new Color(0x1877F2);
      JPanel EtudiantsPanel,EnseignantsPanel,GroupesPanel,MatieresPanel,ModulesPanel,ProfilePanel;
      DashboardFrame(){
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setSize(1440,720);
          this.setLayout(new BorderLayout());
          
          //importing images
          logoSys = new ImageIcon(DashboardFrame.class.getResource("tCampus.png"));
          EtudiantsIcon = new ImageIcon(DashboardFrame.class.getResource("Enseignants_blue.png"));
          Image scaledImage = EtudiantsIcon.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH);
          EtudiantsIcon = new ImageIcon(scaledImage);
          
          EnseignantsIcon = new ImageIcon(DashboardFrame.class.getResource("Enseignants_blue.png"));
          GroupesIcon = new ImageIcon(DashboardFrame.class.getResource("Enseignants_blue.png"));
          MatieresIcon = new ImageIcon(DashboardFrame.class.getResource("Enseignants_blue.png"));
          ModulesIcon = new ImageIcon(DashboardFrame.class.getResource("Enseignants_blue.png"));
          ProfileIcon = new ImageIcon(DashboardFrame.class.getResource("Enseignants_blue.png"));
          // Panels
          sidebar = new JPanel();
          main = new JPanel();
          EtudiantsPanel =  new JPanel();
          EtudiantsPanel.setLayout(null);
          EnseignantsPanel=  new JPanel(new FlowLayout(FlowLayout.RIGHT, 0,5));
          GroupesPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT, 0,5));
          MatieresPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT, 0,5));
          ModulesPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT, 0,5));
          ProfilePanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT, 0,5));
          
          // labels
          header = new JLabel();
          
          
          // buttons
          Etudiants = new JLabel("Etudiants");
          Etudiants.setBorder(new RoundedBorder(50,Color.white));
          Etudiants.setPreferredSize(new Dimension(229, 53));
          Etudiants.setBackground(new Color(0x1877F2));
          Etudiants.setIcon(EtudiantsIcon);
          Etudiants.addMouseListener(this);

          
          
          Enseignants = new JLabel("Enseignants");
          Enseignants.setPreferredSize(new Dimension(229, 53));
          Enseignants.setBackground(new Color(0x1877F2));
          Enseignants.setBorder(new RoundedBorder(10,blueColor));
          Enseignants.setIcon(EnseignantsIcon);
          
          
          Groupes = new JLabel("Groupes");
          Groupes.setPreferredSize(new Dimension(229, 53));
          Groupes.setBackground(new Color(0x1800F2));
          Groupes.setBorder(new RoundedBorder(10,blueColor));
          Groupes.setIcon(GroupesIcon);
          
          
          Matieres = new JLabel("Matieres");
          Matieres.setPreferredSize(new Dimension(229, 53));
          Matieres.setBackground(new Color(0x1877F2));
          Matieres.setBorder(new RoundedBorder(10,blueColor));
          Matieres.setIcon(MatieresIcon);

          
          
          Modules = new JLabel("Modules");
          Modules.setPreferredSize(new Dimension(229, 53));
          Modules.setBackground(new Color(0x1877F2));
          Modules.setBorder(new RoundedBorder(10,blueColor));
          Modules.setIcon(ModulesIcon);
          
          
          Profile = new JLabel("Profile");
          Profile.setPreferredSize(new Dimension(229, 53));
          Profile.setBackground(new Color(0x1877F2));
          Profile.setBorder(new RoundedBorder(10,blueColor));
          Profile.setIcon(ProfileIcon);
 
          
          
          sidebar.setBackground(new Color(0x1877F2));
          header.setIconTextGap(0);
          header.setHorizontalAlignment(JLabel.CENTER);
          header.setVerticalAlignment(JLabel.CENTER);
          EtudiantsPanel.setBackground(blueColor);
          EnseignantsPanel.setBackground(blueColor);
          GroupesPanel.setBackground(blueColor);
          MatieresPanel.setBackground(blueColor);
          ModulesPanel.setBackground(blueColor);
          ProfilePanel.setBackground(blueColor);
          
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
          
          Etudiants.setBounds(100,0,229,53);
          
          this.add(sidebar,BorderLayout.WEST);
          this.add(main);
          this.setVisible(true);       

      }
    private static class RoundedBorder implements Border {
    private Color color;
    private int radius;


    RoundedBorder(int radius,Color color) {
        this.radius = radius;
        this.color = color;
    }
    

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Etudiants.setOpaque(true);
        Etudiants.setBackground(new Color(0xFFFFFF));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
