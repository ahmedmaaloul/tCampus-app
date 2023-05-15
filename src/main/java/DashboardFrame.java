
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class DashboardFrame extends JFrame implements MouseListener{
      ImageIcon logoSys;
      JLabel header,EtudiantsLabel,EnseignantsLabel,ModulesLabel,MatieresLabel,EvaluationsLabel,GroupesLabel,StagesLabel,AccueilLabel,ProfileLabel,UserLabel,DeptLabel,RoleLabel;
      JPanel sidebar,main;
      JPanel EtudiantsPanel,EnseignantsPanel,GroupesPanel,MatieresPanel,ModulesPanel,ProfilePanel,AccueilPanel,EvaluationsPanel,StagesPanel,UserPanel,DeptPanel,RolePanel;
      Object ClickedPanel;
   
    
      DashboardFrame(){
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setSize(1440,720);
          this.setLayout(new BorderLayout());
          
          //importing images
          logoSys = new ImageIcon(DashboardFrame.class.getResource("tCampus.png"));
          
          // Panels
          sidebar = new JPanel();
          main = new JPanel();
          ClickedPanel=new JPanel();
          EtudiantsPanel = new JPanel();
          EnseignantsPanel= new JPanel();
          GroupesPanel = new JPanel();
          MatieresPanel = new JPanel();
          ModulesPanel = new JPanel();
          ProfilePanel = new JPanel();
          EvaluationsPanel=new JPanel();
          AccueilPanel=new JPanel();
          StagesPanel=new JPanel();
          UserPanel=new JPanel();
          RolePanel=new JPanel();
          DeptPanel=new JPanel();
          // labels
          header = new JLabel();
          EtudiantsLabel = new JLabel();
          EnseignantsLabel=new JLabel();
          ModulesLabel=new JLabel();
          MatieresLabel=new JLabel();
          EvaluationsLabel=new JLabel();
          GroupesLabel=new JLabel();
          StagesLabel=new JLabel();
          AccueilLabel=new JLabel();
          ProfileLabel=new JLabel();
          UserLabel=new JLabel();
          RoleLabel=new JLabel();
          DeptLabel=new JLabel();
          
          
     
 
          
          
          sidebar.setBackground(new Color(0x1877F2));
          EtudiantsPanel.setBackground(new Color(0x1877F2));
          EnseignantsPanel.setBackground(new Color(65,66,5));
          GroupesPanel.setBackground(new Color(0x1877F2));
          MatieresPanel.setBackground(new Color(0x1877F2));
          ModulesPanel.setBackground(new Color(0,5,255));
          ProfilePanel.setBackground(new Color(0x1877F2));
           EvaluationsPanel.setBackground(new Color(0x1877F2));
          AccueilPanel.setBackground(new Color(0x1877F2));
           StagesPanel.setBackground(new Color(0x1877F2));
              UserPanel.setBackground(new Color(0x1877F2));
                 DeptPanel.setBackground(new Color(0x1877F2));
                    RolePanel.setBackground(new Color(0x1877F2));
          
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
          sidebar.add(AccueilPanel);
          sidebar.add(EvaluationsPanel);
          sidebar.add(StagesPanel);
            sidebar.add(UserPanel);
              sidebar.add(RolePanel);
                sidebar.add(DeptPanel);
          
          

            
            ImageIcon  normal_Accueil = new ImageIcon(DashboardFrame.class.getResource("normal_Accueil.png"));
           AccueilLabel.setIcon(normal_Accueil);
          
          
          
          AccueilPanel.setBounds(50,100,220,50);
          AccueilPanel.setBackground(     new Color(0x1877F2));
          AccueilPanel.add(AccueilLabel);
          AccueilPanel.addMouseListener(this);
          AccueilPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
      
           
     
            ImageIcon  normal_etudiants = new ImageIcon(DashboardFrame.class.getResource("normal_etudiants.png"));
           EtudiantsLabel.setIcon(normal_etudiants);
          
          
          
          EtudiantsPanel.setBounds(50,150,220,50);
          EtudiantsPanel.setBackground(     new Color(0x1877F2));
          EtudiantsPanel.add(EtudiantsLabel);
          EtudiantsPanel.addMouseListener(this);
          EtudiantsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
          
          
          
            ImageIcon  normal_enseignants = new ImageIcon(DashboardFrame.class.getResource("normal_enseignants.png"));
           EnseignantsLabel.setIcon(normal_enseignants);    
           
          EnseignantsPanel.setBounds(50,200,220,50);
          EnseignantsPanel.addMouseListener(this);
          EnseignantsPanel.setBackground(     new Color(0x1877F2));
          EnseignantsPanel.add(EnseignantsLabel);
               EnseignantsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
          ImageIcon  normal_Modules = new ImageIcon(DashboardFrame.class.getResource("normal_Modules.png"));
           ModulesLabel.setIcon(normal_Modules);    
           
          ModulesPanel.setBounds(50,250,220,50);
          ModulesPanel.addMouseListener(this);
          ModulesPanel.setBackground(     new Color(0x1877F2));
          ModulesPanel.add(ModulesLabel);
              ModulesPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
          
                      ImageIcon  normal_Matieres = new ImageIcon(DashboardFrame.class.getResource("normal_Matieres.png"));
           MatieresLabel.setIcon(normal_Matieres);    
           
           
          MatieresPanel.setBounds(50,300,220,50);
          MatieresPanel.addMouseListener(this);
          MatieresPanel.setBackground(     new Color(0x1877F2));
          MatieresPanel.add(MatieresLabel);
               MatieresPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
                  ImageIcon  normal_Evaluations = new ImageIcon(DashboardFrame.class.getResource("normal_Evaluations.png"));
           EvaluationsLabel.setIcon(normal_Evaluations); 
           
          EvaluationsPanel.setBounds(50,350,220,50);
          EvaluationsPanel.addMouseListener(this);
          EvaluationsPanel.setBackground(     new Color(0x1877F2));
          EvaluationsPanel.add(EvaluationsLabel);
               EvaluationsPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
          
                ImageIcon  normal_Groupes = new ImageIcon(DashboardFrame.class.getResource("normal_Groupes.png"));
           GroupesLabel.setIcon(normal_Groupes); 
           
          GroupesPanel.setBounds(50,400,220,50);
          GroupesPanel.addMouseListener(this);
          GroupesPanel.setBackground(     new Color(0x1877F2));
          GroupesPanel.add(GroupesLabel);
               GroupesPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
            
                ImageIcon  normal_Stages = new ImageIcon(DashboardFrame.class.getResource("normal_Stages.png"));
           StagesLabel.setIcon(normal_Stages); 
           
          StagesPanel.setBounds(50,450,220,50);
          StagesPanel.addMouseListener(this);
          StagesPanel.setBackground(     new Color(0x1877F2));
          StagesPanel.add(StagesLabel);
               StagesPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
                ImageIcon  normal_Profile = new ImageIcon(DashboardFrame.class.getResource("normal_Profile.png"));
           ProfileLabel.setIcon(normal_Profile); 
           
          ProfilePanel.setBounds(50,500,220,50);
          ProfilePanel.addMouseListener(this);
          ProfilePanel.setBackground(     new Color(0x1877F2));
          ProfilePanel.add(ProfileLabel);
               ProfilePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
               
               
               
            
               
               
               
                //ImageIcon  normal_Dept = new ImageIcon(DashboardFrame.class.getResource("normal_Dept.png"));
           //DeptLabel.setIcon(normal_Dept); 
           DeptLabel.setText("Departement");
          DeptPanel.setBounds(50,550,220,50);
          DeptPanel.addMouseListener(this);
          DeptPanel.setBackground(     new Color(0x1877F2));
          DeptPanel.add(DeptLabel);
               DeptPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
               
               
               
              //  ImageIcon  normal_User = new ImageIcon(DashboardFrame.class.getResource("normal_User.png"));
          // UserLabel.setIcon(normal_User); 
           UserLabel.setText("Utilisateur");
           
          UserPanel.setBounds(50,600,220,50);
          UserPanel.addMouseListener(this);
          UserPanel.setBackground(     new Color(0x1877F2));
          UserPanel.add(UserLabel);
               UserPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
          
          
          
          
             // ImageIcon  normal_Role = new ImageIcon(DashboardFrame.class.getResource("normal_Role.png"));
    //       RoleLabel.setIcon(normal_Role); 
        RoleLabel.setText("Role");
    
          RolePanel.setBounds(50,650,220,50);
          RolePanel.addMouseListener(this);
          RolePanel.setBackground(     new Color(0x1877F2));
          RolePanel.add(RoleLabel);
               RolePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
          this.add(sidebar,BorderLayout.WEST);
          this.add(main);
          
          this.setVisible(true);       

      }
      
      
    private void unfocus(MouseEvent e){
        
               
   if(e.getSource()==AccueilPanel   &&   e.getSource()!=ClickedPanel   ){
             ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_Accueil.png"));
           AccueilLabel.setIcon(unfocused);
   }
   else   if(e.getSource()==EtudiantsPanel   &&   e.getSource()!=ClickedPanel){
         
      ImageIcon  focused_etudiants = new ImageIcon(DashboardFrame.class.getResource("normal_etudiants.png"));
           EtudiantsLabel.setIcon(focused_etudiants);
          }else     if(e.getSource()==EnseignantsPanel   &&   e.getSource()!=ClickedPanel){
                 ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_enseignants.png"));
           EnseignantsLabel.setIcon(unfocused);
  
         }
          else if(e.getSource()==ModulesPanel   &&   e.getSource()!=ClickedPanel){
    ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_Modules.png"));
           ModulesLabel.setIcon(unfocused);
          
      }
          else if(e.getSource()==MatieresPanel   &&   e.getSource()!=ClickedPanel){
    ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_Matieres.png"));
           MatieresLabel.setIcon(unfocused);
          
      }
          else if(e.getSource()==EvaluationsPanel   &&   e.getSource()!=ClickedPanel){
    ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_Evaluations.png"));
           EvaluationsLabel.setIcon(unfocused);
          
      }
          else if(e.getSource()==GroupesPanel   &&   e.getSource()!=ClickedPanel){
    ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_Groupes.png"));
           GroupesLabel.setIcon(unfocused);
          
      }
          else if(e.getSource()==StagesPanel   &&   e.getSource()!=ClickedPanel){
    ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_Stages.png"));
           StagesLabel.setIcon(unfocused);
          
      }
          else if(e.getSource()==ProfilePanel   &&   e.getSource()!=ClickedPanel){
    ImageIcon  unfocused = new ImageIcon(DashboardFrame.class.getResource("normal_Profile.png"));
           ProfileLabel.setIcon(unfocused);
          
      }
        
    }
    
    private void unfocus_ALL(MouseEvent e){
        
           
 
             ImageIcon  unfocused_Accueil = new ImageIcon(DashboardFrame.class.getResource("normal_Accueil.png"));
           AccueilLabel.setIcon(unfocused_Accueil);
  
  
         
      ImageIcon  unfocused_Etudiant= new ImageIcon(DashboardFrame.class.getResource("normal_etudiants.png"));
           EtudiantsLabel.setIcon(unfocused_Etudiant);
         
     
                 ImageIcon  unfocused_Enseignant = new ImageIcon(DashboardFrame.class.getResource("normal_enseignants.png"));
           EnseignantsLabel.setIcon(unfocused_Enseignant);
  
        
     
    ImageIcon  unfocused_Module = new ImageIcon(DashboardFrame.class.getResource("normal_Modules.png"));
           ModulesLabel.setIcon(unfocused_Module);
          

    ImageIcon  unfocused_Matiere = new ImageIcon(DashboardFrame.class.getResource("normal_Matieres.png"));
           MatieresLabel.setIcon(unfocused_Matiere);
          

    ImageIcon  unfocused_Evaluation = new ImageIcon(DashboardFrame.class.getResource("normal_Evaluations.png"));
           EvaluationsLabel.setIcon(unfocused_Evaluation);
          
   
    ImageIcon  unfocused_Groupe = new ImageIcon(DashboardFrame.class.getResource("normal_Groupes.png"));
           GroupesLabel.setIcon(unfocused_Groupe);
          

    ImageIcon  unfocused_Stage = new ImageIcon(DashboardFrame.class.getResource("normal_Stages.png"));
           StagesLabel.setIcon(unfocused_Stage);
          

    ImageIcon  unfocused_Profile = new ImageIcon(DashboardFrame.class.getResource("normal_Profile.png"));
           ProfileLabel.setIcon(unfocused_Profile);
         
      
       
    }
    private void focus(MouseEvent e){
        
        
   if(e.getSource()==AccueilPanel){
             ImageIcon  focused = new ImageIcon(DashboardFrame.class.getResource("focused_Accueil.png"));
           AccueilLabel.setIcon(focused);
   }
   else   if(e.getSource()==EtudiantsPanel){
         
      ImageIcon  focused_etudiants = new ImageIcon(DashboardFrame.class.getResource("focused_etudiants.png"));
           EtudiantsLabel.setIcon(focused_etudiants);
          }else     if(e.getSource()==EnseignantsPanel){
                 ImageIcon  focused_enseignants = new ImageIcon(DashboardFrame.class.getResource("focused_enseignants.png"));
           EnseignantsLabel.setIcon(focused_enseignants);
  
         }
          else if(e.getSource()==ModulesPanel){
    ImageIcon  focused = new ImageIcon(DashboardFrame.class.getResource("focused_Modules.png"));
           ModulesLabel.setIcon(focused);
          
      }
          else if(e.getSource()==MatieresPanel){
    ImageIcon  focused = new ImageIcon(DashboardFrame.class.getResource("focused_Matieres.png"));
           MatieresLabel.setIcon(focused);
          
      }
          else if(e.getSource()==EvaluationsPanel){
    ImageIcon  focused = new ImageIcon(DashboardFrame.class.getResource("focused_Evaluations.png"));
           EvaluationsLabel.setIcon(focused);
          
      }
          else if(e.getSource()==GroupesPanel){
    ImageIcon  focused = new ImageIcon(DashboardFrame.class.getResource("focused_Groupes.png"));
           GroupesLabel.setIcon(focused);
          
      }
          else if(e.getSource()==StagesPanel){
    ImageIcon  focused = new ImageIcon(DashboardFrame.class.getResource("focused_Stages.png"));
           StagesLabel.setIcon(focused);
          
      }
          else if(e.getSource()==ProfilePanel){
    ImageIcon  focused = new ImageIcon(DashboardFrame.class.getResource("focused_Profile.png"));
           ProfileLabel.setIcon(focused);
          
      }
        
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
     
        ClickedPanel=e.getSource();
          unfocus_ALL(e);
           focus(e);
            
       
           
           
           
       Role newRole=new Role();
           JPanel x=newRole.getInterface();
        
           
           
            remove(main);    
            main = x;
            add(main);
            revalidate();
            repaint();
   
       
           
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        


           focus(e);
      
               
                
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
 
        
          unfocus(e);
                 
           
        

    };
}