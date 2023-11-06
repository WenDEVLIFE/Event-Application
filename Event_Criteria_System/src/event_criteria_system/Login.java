/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package event_criteria_system;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Administrator
 */

public class Login extends javax.swing.JFrame {
public static  int time=0;
public static String mydb_url = "jdbc:mysql://localhost:3306/eventsystem_db";
    public static String myDB_username = "root";  // Database username
    public static  String myDB_PASSWORD = "";  // Define your database password here
    public static Login user;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();   
        setLocationRelativeTo(null);
        
        // to set icons of your titlebar
           Image iconImage = Toolkit.getDefaultToolkit().getImage("src/pictures/sports.png");

        // Set the icon on the frame.
       setIconImage(iconImage);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new PanelRound1();
        label1 = new java.awt.Label();
        userfield = new javax.swing.JTextField();
        passfield = new javax.swing.JPasswordField();
        loginbutton = new javax.swing.JButton();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new ShadowPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PWC Event Criteria System");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        label1.setForeground(new java.awt.Color(128, 0, 0));
        label1.setText("Login");
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        userfield.setBackground(new java.awt.Color(51, 51, 51));
        userfield.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        userfield.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(userfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 420, 50));

        passfield.setBackground(new java.awt.Color(51, 51, 51));
        passfield.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        passfield.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(passfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 420, 50));

        loginbutton.setBackground(new java.awt.Color(128, 0, 0));
        loginbutton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        loginbutton.setForeground(new java.awt.Color(255, 255, 255));
        loginbutton.setText("Sign in");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(loginbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 231, 60));

        label3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(128, 0, 0));
        label3.setText("Password");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        label4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        label4.setForeground(new java.awt.Color(128, 0, 0));
        label4.setText("Username");
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jCheckBox1.setForeground(new java.awt.Color(128, 0, 0));
        jCheckBox1.setText("Check to see the password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 110, 90));
        try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("/pictures/pwclogo.jpg"));
            BufferedImage resizedImage = resizeImage(originalImage,72, 72);  // Adjust the dimensions as needed

            ImageIcon imageIcon = new ImageIcon(resizedImage);
            jLabel5.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 490, 500));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("System");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 210, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 72)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 0, 0));
        jLabel3.setText("PWC");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 210, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Event Criteria ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 390, 60));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 510, 520));

        jLabel1.setText("");
        // this is how to resize the picture in JLabel
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 730));
        try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("/pictures/PWC.jpg"));
            BufferedImage resizedImage = resizeImage(originalImage, 1024, 768);  // Adjust the dimensions as needed

            ImageIcon imageIcon = new ImageIcon(resizedImage);
            jLabel1.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        // TODO add your handling code here:
        String username = userfield.getText();
        String password = new String(passfield.getPassword());
        
         if (isMySQLXAMPPOnline()) {
	                    login(username, password);
	                    
	                } else // else if the database is offline
	                {
	                    ImageIcon imageIcon = new ImageIcon("src//pictures//database.png");
	                    JOptionPane.showMessageDialog(null, "Permission denied. Please contanct the administrator", "Login Message", JOptionPane.PLAIN_MESSAGE, imageIcon);
	                }
       
        
            
    }//GEN-LAST:event_loginbuttonActionPerformed


   

    public boolean isMySQLXAMPPOnline() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/eventsystem_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void login(String username, String password) {
        try {
            if (!isMySQLXAMPPOnline()) {
                ImageIcon imageIcon = new ImageIcon("src//pictures//attention.png");
                JOptionPane.showMessageDialog(null, "MySQL XAMPP is offline. Please try again later.", "Login Message", JOptionPane.PLAIN_MESSAGE, imageIcon);
                return;
            }
            
            // call the database class
            database_user_verification meowc =new database_user_verification(username,password,user);
            meowc.login_authentication(username, password);
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
          // Check if the checkbox is selected.
                if (jCheckBox1.isSelected()) {
                    // Set the JPasswordField to echo the password.
                   passfield.setEchoChar((char) 0);
                } else {
                    // Set the JPasswordField to not echo the password.
                    passfield.setEchoChar('*');
                }
    }//GEN-LAST:event_jCheckBox1ActionPerformed
  
    // to check mysql online
  
   


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         try {
	    	FlatSolarizedLightIJTheme.setup();
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	    }
        /* Create and display the form */
          EventQueue.invokeLater(() -> {
              user = new Login();
             user.setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JButton loginbutton;
    public static javax.swing.JPasswordField passfield;
    public static javax.swing.JTextField userfield;
    // End of variables declaration//GEN-END:variables

  private BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
    BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
    Graphics2D g = resizedImage.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
    g.dispose();
    return resizedImage;
}
}
