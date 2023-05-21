import Dashboard.DashBoard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import management.Utilisateur;
import underHood.RoundJPasswordField;
import underHood.RoundJTextField;

public class Login extends JFrame {

    JPanel loginPage, welcomeSide, loginSide, emailPanel, passwordPanel, connectPanel, forgotPasswordPanel;
    JTextField email, password;
    Color inputColor = new Color(0xBBCEFF);
    Color buttonColor = new Color(0x80A3FF);
    ImageIcon slogan;
    JLabel imageContainer, emailLabel, passwordLabel;
    JButton connect;

    public Login() {

        loginPage = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setLayout(null);
                Graphics2D g2d = (Graphics2D) g;
                int frameWidth = getWidth();
                int frameHeight = getHeight();
                Color color1 = new Color(0x629CFF);
                Color color2 = new Color(0x1751EA);
                GradientPaint gp = new GradientPaint(0, 0, color1, frameWidth, 0, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, frameWidth, frameHeight);
            }
        };
        loginPage.setPreferredSize(new Dimension(1280, 720));
        loginPage.setBorder(new EmptyBorder(150, 0, 0, 55)); // top, left, bottom, right
        slogan = new ImageIcon(Login.class.getResource("Slogan.png"));
        Image image = slogan.getImage();
        image = image.getScaledInstance(272, 200, Image.SCALE_SMOOTH);
        slogan = new ImageIcon(image);
        imageContainer = new JLabel();
        imageContainer.setIcon(slogan);

        welcomeSide = new JPanel();
        loginSide = new JPanel();
        loginSide.setLayout(new GridLayout(4, 1));
     //   loginSide.setBorder(new EmptyBorder(150, 150, 0, 0)); // top, left, bottom, right

        emailLabel = new JLabel("Identifiant");
        emailLabel.setFont(new Font("Inter", Font.BOLD, 20));
        emailLabel.setForeground(Color.white);
       emailLabel.setPreferredSize(new Dimension(350, 20));
       emailLabel.setHorizontalAlignment(JLabel.LEFT);

        passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setPreferredSize(new Dimension(350, 20));
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 20));
        passwordLabel.setForeground(Color.white);
        passwordLabel.setHorizontalAlignment(JLabel.LEFT);


    
    
  
 

               connect = new LoginButton("Se connecter");
        connect.setFocusable(false);
        connect.setPreferredSize(new Dimension(157, 46));
        connect.setBorder(new RoundedBorder(10));
        connect.setFont(new Font("Inter", Font.BOLD, 20));

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the button is clicked
                Utilisateur uti=new Utilisateur();
       //         String id=uti.Login(email.getText(), password.getText());
                String id=uti.Login("Abdou48", "Abdou48");
                if(!"".equals(id)){
                    DashBoard dashboard=new DashBoard(id);
                    dispose();
                }
              
             
            
            }
        });
        
        
        
        emailPanel = new JPanel();
     // emailPanel.setPreferredSize(new Dimension(200, 98));
        emailPanel.setBackground(new Color(255, 255, 255, 0));
        emailPanel.setOpaque(false);
        passwordPanel = new JPanel();
     //   passwordPanel.setPreferredSize(new Dimension(350, 98));
        passwordPanel.setBackground(new Color(255, 255, 255, 0));
        passwordPanel.setOpaque(false);
        forgotPasswordPanel = new JPanel();
        forgotPasswordPanel.setPreferredSize(new Dimension(350, 50));
        forgotPasswordPanel.setBackground(new Color(255, 255, 255, 0));
        forgotPasswordPanel.setOpaque(false);
        connectPanel = new JPanel();
        connectPanel.setPreferredSize(new Dimension(350, 10));
        connectPanel.setBackground(new Color(255, 255, 255, 0));
        connectPanel.setOpaque(false);

        email = new RoundJTextField(46);
        email.setPreferredSize(new Dimension(350, 40));
        email.setBackground(inputColor);
        password = new RoundJPasswordField(46);
        password.setPreferredSize(new Dimension(350, 40));
        password.setBackground(inputColor);
       
        emailPanel.add(emailLabel);
        emailPanel.add(email);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(password);

        forgotPasswordPanel.add(connect);

        welcomeSide.add(imageContainer);
        welcomeSide.setBackground(new Color(255, 255, 255, 0));
        welcomeSide.setOpaque(false);
        loginSide.add(emailPanel);
        loginSide.setOpaque(false);
        loginSide.add(passwordPanel);
        loginSide.add(forgotPasswordPanel);
        loginSide.setBackground(new Color(255, 255, 255, 0));
        loginSide.setOpaque(false);

        loginPage.add(loginSide, BorderLayout.WEST);
        loginPage.add(welcomeSide, BorderLayout.EAST);

        this.add(loginPage);
        this.pack();
        setVisible(true);
    }

    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

    }

    private static class LoginButton extends JButton {
        private Color pressedColor = new Color(0x5790fa);
        private Color rolloverColor = new Color(0x5790fa);
        private Color normalColor = new Color(0x80A3FF);

        public LoginButton(String text) {
            super(text);
            setBorderPainted(false);
            setFocusPainted(false);

            setContentAreaFilled(false);
            setOpaque(true);

            setBackground(normalColor);
            setForeground(Color.WHITE);
            setFont(new Font("Tahoma", Font.BOLD, 12));
            setText(text);

            addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent evt) {
                    if (getModel().isPressed()) {
                        setBackground(pressedColor);
                   

                    } else if (getModel().isRollover()) {
                        setBackground(rolloverColor);
                    } else {
                        setBackground(normalColor);
                    }
                }
            });
        }

        @Override
        public void setBorder(Border border) {
            super.setBorder(border);
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
