
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
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
import javax.swing.border.Border;


public class DashboardFrame extends JFrame implements MouseListener{
      ImageIcon logoSys;
      JLabel header,EtudiantsLabel,EnseignantsLabel,ModulesLabel,MatiereLabel,EvaluationLabel,GroupeLabel,StageLabel;
      JPanel sidebar,main;
      JButton Etudiants,Enseignants,Groupes,Matieres,Modules,Profile;
      JPanel EtudiantsPanel,EnseignantsPanel,GroupesPanel,MatieresPanel,ModulesPanel,ProfilePanel;
      Boolean clicked=false;
    
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
          EtudiantsLabel = new JLabel();
          EnseignantsLabel=new JLabel();
          ModulesLabel=new JLabel();
          MatiereLabel=new JLabel();
          EvaluationLabel=new JLabel();
          GroupeLabel=new JLabel();
          StageLabel=new JLabel();
          
          
          
          
          
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
          sidebar.setLayout(null);
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
          
          //EtudiantsPanel.add(Etudiants);
      
           
     
            ImageIcon  normal_etudiants = new ImageIcon(DashboardFrame.class.getResource("normal_etudiants.png"));
           EtudiantsLabel.setIcon(normal_etudiants);
          
          
          
          EtudiantsPanel.setBounds(50,250,220,50);
          EtudiantsPanel.setBackground(     new Color(0x1877F2));
          EtudiantsPanel.add(EtudiantsLabel);
          EtudiantsPanel.addMouseListener(this);
          EtudiantsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
          
          
          
            ImageIcon  normal_enseignants = new ImageIcon(DashboardFrame.class.getResource("normal_enseignants.png"));
           EnseignantsLabel.setIcon(normal_enseignants);    
          EnseignantsPanel.setBounds(50,300,220,50);
          EnseignantsPanel.addMouseListener(this);
          EnseignantsPanel.setBackground(     new Color(0x1877F2));
          EnseignantsPanel.add(EnseignantsLabel);
          
          
                      ImageIcon  normal_Modules = new ImageIcon(DashboardFrame.class.getResource("normal_enseignants.png"));
           ModulesLabel.setIcon(normal_Modules);    
          ModulesLabel.setBounds(50,350,220,50);
          ModulesLabel.addMouseListener(this);
          ModulesLabel.setBackground(     new Color(0x1877F2));
          ModulesPanel.add(ModulesLabel);
          
          
          
          
          
          
          
          
          
          
          
          
          GroupesPanel.add(Groupes);
          MatieresPanel.add(Matieres);
          ModulesPanel.add(Modules);
          ProfilePanel.add(Profile);
          
          this.add(sidebar,BorderLayout.WEST);
          this.add(main);
          this.setVisible(true);       

      }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked=true;
           ImageIcon  focused_etudiants = new ImageIcon(DashboardFrame.class.getResource("focused_etudiants.png"));
           EtudiantsLabel.setIcon(focused_etudiants);
           
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
   
       if(e.getSource()==EtudiantsPanel){
         
      ImageIcon  focused_etudiants = new ImageIcon(DashboardFrame.class.getResource("focused_etudiants.png"));
           EtudiantsLabel.setIcon(focused_etudiants);
          }
        System.out.println(e.getSource());
      if(e.getSource()==EnseignantsPanel){
              
       
                 ImageIcon  focused_enseignants = new ImageIcon(DashboardFrame.class.getResource("focused_enseignants.png"));
           EnseignantsLabel.setIcon(focused_enseignants);
      
         }

           
      
               
                
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
 
        if(!clicked){
            
                
                           ImageIcon  normal_etudiants = new ImageIcon(DashboardFrame.class.getResource("normal_etudiants.png"));
           EtudiantsLabel.setIcon(normal_etudiants);
            
         
                 
           
        }

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
