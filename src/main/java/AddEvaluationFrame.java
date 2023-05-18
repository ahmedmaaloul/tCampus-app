


import underHood.RoundJTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmed
 */
public class AddEvaluationFrame extends JFrame {
    private Color inputColor = new Color(0xBBCEFF);
    ImageIcon logoSys;
    JLabel TitleLabel,EtudiantLabel,MatiereLabel,TypeNoteLabel,NoteLabel,logoLabel;
    JTextField Etudiant,Matiere,Note;
    JComboBox TypeNote;
    JPanel TitlePanel,EtudiantPanel,MatierePanel,TypeNotePanel,NotePanel,Page,Content,ButtonsPanel,logoPanel;
    JButton AddButton, UndoButton;
    
    AddEvaluationFrame(){
        this.setResizable(false);
        logoSys = new ImageIcon(AddEvaluationFrame.class.getResource("tCampus.png"));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Page = new JPanel();
        Page.setBackground(new Color(0x1681ff));
        Page.setPreferredSize(new Dimension(1024,768));
        Page.setLayout(new FlowLayout());
        
        Content = new JPanel();
        Content.setLayout(new GridLayout(6,1));
        Content.setOpaque(false);
        
        logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(1020,100));
        logoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setOpaque(false);
                
        TitlePanel = new JPanel();
        TitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        TitlePanel.setPreferredSize(new Dimension(522,110));
        TitlePanel.setOpaque(false);
        
        EtudiantPanel = new JPanel();
        EtudiantPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        EtudiantPanel.setPreferredSize(new Dimension(522,110));
        EtudiantPanel.setOpaque(false);
        
        MatierePanel = new JPanel();
        MatierePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        MatierePanel.setPreferredSize(new Dimension(522,110));
        MatierePanel.setOpaque(false);
        
        TypeNotePanel = new JPanel();
        TypeNotePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        TypeNotePanel.setPreferredSize(new Dimension(522,110));
        TypeNotePanel.setOpaque(false);
        
        NotePanel = new JPanel();
        NotePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        NotePanel.setPreferredSize(new Dimension(522,110));
        NotePanel.setOpaque(false);
        
        ButtonsPanel = new JPanel();
        ButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonsPanel.setPreferredSize(new Dimension(522,110));
        ButtonsPanel.setOpaque(false);
        
    
        logoLabel = new JLabel();
        logoLabel.setIcon(logoSys);
                
        TitleLabel = new JLabel("Enregistrer une évaluation");
        TitleLabel.setFont(new Font("Inter",Font.BOLD,40));
        TitleLabel.setForeground(Color.white);
        
        EtudiantLabel = new JLabel("Identifiant Etudiant");
        EtudiantLabel.setHorizontalTextPosition(JLabel.LEFT);
        EtudiantLabel.setFont(new Font("Inter",Font.BOLD,18));
        EtudiantLabel.setPreferredSize(new Dimension(480,20));
        EtudiantLabel.setForeground(Color.white);
        
        MatiereLabel = new JLabel("Identifiant Matière");
        MatiereLabel.setHorizontalTextPosition(JLabel.LEFT);
        MatiereLabel.setFont(new Font("Inter",Font.BOLD,18));
        MatiereLabel.setPreferredSize(new Dimension(480,20));
        MatiereLabel.setForeground(Color.white);
        
        TypeNoteLabel = new JLabel("Type de note");
        TypeNoteLabel.setHorizontalTextPosition(JLabel.LEFT);
        TypeNoteLabel.setFont(new Font("Inter",Font.BOLD,18));
        TypeNoteLabel.setPreferredSize(new Dimension(480,20));
        TypeNoteLabel.setForeground(Color.white);
        
        NoteLabel = new JLabel("Note");
        NoteLabel.setHorizontalTextPosition(JLabel.LEFT);
        NoteLabel.setFont(new Font("Inter",Font.BOLD,18));
        NoteLabel.setPreferredSize(new Dimension(480,20));
        NoteLabel.setForeground(Color.white);
        
        Etudiant = new RoundJTextField(47);
        Etudiant.setPreferredSize(new Dimension(522,50));
        
        Matiere = new RoundJTextField(47);
        Matiere.setPreferredSize(new Dimension(522,50));
        String [] choixTypes = {"DS","Examen","TP"};
        TypeNote= new JComboBox(choixTypes);
	//TypeNote.setBorder(new SimpleRoundBorder());
        //TypeNote = new RoundJTextField(47);
        TypeNote.setBackground(inputColor);
        TypeNote.setPreferredSize(new Dimension(470,50));
        
        Note = new RoundJTextField(47);
        Note.setPreferredSize(new Dimension(522,50));
        
        AddButton = new JButton("Ajouter");
        AddButton.setBackground(inputColor);
        AddButton.setFocusable(false);
        AddButton.setPreferredSize(new Dimension(157, 46));
        AddButton.setBorder(new RoundedBorder(10));
        AddButton.setForeground(new Color(0x0b4080));
        AddButton.setFont(new Font("Inter",Font.BOLD,20));
        
        UndoButton = new JButton("Annuler");
        UndoButton.setBackground(inputColor);
        UndoButton.setFocusable(false);
        UndoButton.setPreferredSize(new Dimension(157, 46));
        UndoButton.setBorder(new RoundedBorder(10));
        UndoButton.setForeground(new Color(0x0b4080));
        UndoButton.setFont(new Font("Inter",Font.BOLD,20));
        UndoButton.setBackground(inputColor);
        
        logoPanel.add(logoLabel);
        
        TitlePanel.add(TitleLabel);
        
        EtudiantPanel.add(EtudiantLabel);
        EtudiantPanel.add(Etudiant);
        
        MatierePanel.add(MatiereLabel);
        MatierePanel.add(Matiere);
        
        TypeNotePanel.add(TypeNoteLabel);
        TypeNotePanel.add(TypeNote);
        
        NotePanel.add(NoteLabel);
        NotePanel.add(Note);
       
        ButtonsPanel.add(AddButton);
        ButtonsPanel.add(UndoButton);
        
        Content.add(TitlePanel);
        Content.add(EtudiantPanel);
        Content.add(MatierePanel);
        Content.add(TypeNotePanel);
        Content.add(NotePanel);
        Content.add(ButtonsPanel);
        
        Page.add(logoPanel);
        Page.add(Content);
        
        this.add(Page);
        this.pack();
        this.setVisible(true);
    }
    class SimpleRoundBorder extends AbstractBorder 
{
	Color bgColor = inputColor;
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) 
    {
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setColor( bgColor );
        ((Graphics2D)g).drawRoundRect(x, y, width-1, height-1, 12, 12); 
    }
 
    public Insets getBorderInsets(Component c) 
    {
        return new Insets(3, 6, 3, 3);
    }
 
    public Insets getBorderInsets(Component c, Insets insets) 
    {
        insets.top = insets.left = insets.bottom = insets.right = 3;
        return insets;
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
