/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ahmed
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
public class RoundJTextField extends JTextField  {
    private Shape shape;
    private Color inputColor = new Color(0xBBCEFF);
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    @Override
    protected void paintComponent(Graphics g) {
         g.setColor(inputColor);
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g) {
         g.setColor(inputColor);
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    @Override
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
    @Override
   public void setPreferredSize(Dimension preferredSize) {
    super.setPreferredSize(preferredSize);
}
    
}
