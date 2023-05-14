
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
      DashboardFrame(){
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setSize(1440,720);
          this.setLayout(new BorderLayout());
          
          //importing images
          logoSys = new ImageIcon(DashboardFrame.class.getResource("tCampus.png"));
          
          
          sidebar = new JPanel();
          main = new JPanel();
          header = new JLabel();
          
          sidebar.setBackground(new Color(0x1877F2));
          main.setBackground(Color.white);
          sidebar.setPreferredSize(new Dimension(262,1024));
          header.setBounds(50,50,246,100);
          
          header.setIcon(logoSys);
          header.setAlignmentY(CENTER_ALIGNMENT);
          
          sidebar.add(header);
          this.add(sidebar,BorderLayout.WEST);
          this.add(main);
          this.setVisible(true);       
          
          
      }
}
