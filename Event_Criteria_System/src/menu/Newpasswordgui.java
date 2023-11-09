/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package menu;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static menu.dashboard.meow;
import static menu.dashboard.username;
/**
 *
 * @author Administrator
 */
public class Newpasswordgui extends javax.swing.JDialog {
            public static String mydb_url="jdbc:mysql://localhost:3306/eventsystem_db";
            public static String myDB_username="root";
            public static String myDB_PASSWORD="";
            public static String username_table;
    /**
     * Creates new form Newpasswordgui
     * @param parent
     * @param modal
     */
    public Newpasswordgui(Frame parent, boolean modal, String username_table) {
        super(parent, modal);
               this.username_table = username_table; 
                setLocationRelativeTo(null);
            setResizable(false);
            setTitle("Edit Username");
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        userform = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        clear = new javax.swing.JButton();
        confirmpassword = new javax.swing.JPasswordField(20);
        password = new javax.swing.JPasswordField(20);
        label6 = new java.awt.Label();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(575, 658));
        setPreferredSize(new java.awt.Dimension(575, 658));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(575, 658));
        jPanel2.setPreferredSize(new java.awt.Dimension(575, 658));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 110, 90));
        try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("/pictures/pwclogo.jpg"));
            BufferedImage resizedImage = resizeImage(originalImage,72, 72);  // Adjust the dimensions as needed

            ImageIcon imageIcon = new ImageIcon(resizedImage);
            jLabel5.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        label2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(128, 0, 0));
        label2.setText("New Password");
        jPanel2.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 290, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-conference-foreground-selected-48.png"))); // NOI18N
        jButton1.setText("Change Username");
        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusTraversalPolicyProvider(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 230, 50));

        userform.setText(username_table);
        userform.setEditable(false);
        userform.setBackground(new java.awt.Color(51, 51, 51));
        userform.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        userform.setForeground(new java.awt.Color(255, 255, 255));
        userform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userformActionPerformed(evt);
            }
        });
        jPanel2.add(userform, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 450, 40));

        label4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(128, 0, 0));
        label4.setText("Username");
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 290, 30));

        label5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label5.setForeground(new java.awt.Color(128, 0, 0));
        label5.setText("Old Password");
        jPanel2.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 290, 30));

        clear.setBackground(new java.awt.Color(153, 0, 0));
        clear.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-trash-can-layout-for-a-indication-to-throw-trash-24.png"))); // NOI18N
        clear.setText("Clear All");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 231, 50));

        confirmpassword.setBackground(new java.awt.Color(51, 51, 51));
        confirmpassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        confirmpassword.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(confirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 450, 40));

        password.setBackground(new java.awt.Color(51, 51, 51));
        password.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 450, 40));

        label6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        label6.setForeground(new java.awt.Color(128, 0, 0));
        label6.setText("New Password");
        jPanel2.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 250, 30));
        label6.getAccessibleContext().setAccessibleName("Edit Password");

        jCheckBox2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(128, 0, 0));
        jCheckBox2.setText("Check to see the password");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            changePassword();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Newpasswordgui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Newpasswordgui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
private void changePassword() throws NoSuchAlgorithmException, InvalidKeySpecException {
    String username1 = userform.getText();
    String passwordold = new String(password.getPassword());
    String passwordnew = new String(confirmpassword.getPassword());

    if (username1.isEmpty() || passwordold.isEmpty() || passwordnew.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in the blanks");
    } else {
        if (verifyPasswordLength(passwordnew)) {
            boolean hasCapsLock = false;
            boolean hasSpecialCharacters = false;

            for (char character : passwordnew.toCharArray()) {
                if (Character.isUpperCase(character)) {
                    hasCapsLock = true;
                } else if (!Character.isLetterOrDigit(character)) {
                    hasSpecialCharacters = true;
                }
            }

            if (!hasCapsLock || !hasSpecialCharacters) {
                JOptionPane.showMessageDialog(null, "The password must contain at least one uppercase letter and one special character.");
            } else {
                // Check if the current password exists in the database
                try (Connection connection = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
                    // Prepare the SQL statement
                    PreparedStatement statement = connection.prepareStatement("SELECT password, salt FROM user WHERE username = ?");
                    String usertype = username1;

                    // Set the parameters
                    statement.setString(1, usertype);

                    // Execute the statement and get the result set
                    ResultSet resultSet = statement.executeQuery();

                    // Check if the result set is empty
                    if (!resultSet.next()) {
                        // The username does not exist in the database
                        JOptionPane.showMessageDialog(null, "Username not found.");
                        return;
                    }

                    // Retrieve the hashed password and salt from the database
                    String storedPassword = resultSet.getString("password");
                    byte[] salt = resultSet.getBytes("salt");

                    // Hash the user's input current password with the retrieved salt
                    String hashedInputPassword = hashPassword(passwordold, salt);

                    // Compare the hashed input password with the stored password
                    if (!hashedInputPassword.equals(storedPassword)) {
                        // The current password is incorrect
                        JOptionPane.showMessageDialog(null, "Incorrect current password.");
                        return;
                    } else {
                        // Generate a new salt for the new password
                        byte[] newSalt = generateSalt();

                        // Hash the new password using the new salt
                        String hashedNewPassword = hashPassword(passwordnew, newSalt);

                        // Update the password and salt in the database
                        PreparedStatement updateStatement = connection.prepareStatement("UPDATE user SET password = ?, salt = ? WHERE username = ?");
                        updateStatement.setString(1, hashedNewPassword);
                        updateStatement.setBytes(2, newSalt);
                        updateStatement.setString(3, usertype);
                        updateStatement.executeUpdate();

                        // Notify the user that the password has been changed
                        JOptionPane.showMessageDialog(null, "Password changed successfully!");
                        password.setText("");
                        confirmpassword.setText("");
                        meow.dispose();
                            meow =  new dashboard(username);
                meow.setVisible(true);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

private byte[] generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16]; // You can adjust the salt size as needed
    random.nextBytes(salt);
    return salt;
}

// MD5 function 1
private String hashPassword(String passwordnew, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
    int iterations = 10000; // Number of iterations
    int keyLength = 256; // Key length in bits

    PBEKeySpec spec = new PBEKeySpec(passwordnew.toCharArray(), salt, iterations, keyLength);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    byte[] hashedNewPassword = factory.generateSecret(spec).getEncoded();

    return bytesToHex(hashedNewPassword);
}

// MD5 function 2
private String bytesToHex(byte[] bytes) {
    StringBuilder hexString = new StringBuilder();
    for (byte aByte : bytes) {
        hexString.append(String.format("%02x", aByte));
    }
    return hexString.toString();
}

public boolean verifyPasswordLength(String passwordold) {
    int length = passwordold.length();
    return length >= 8 && length <= 12;
}
    private void userformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userformActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        // Check if the checkbox is selected.
        if (jCheckBox2.isSelected()) {
            // Set the JPasswordField to echo the password.
            password.setEchoChar((char) 0);
            confirmpassword.setEchoChar((char) 0);

        } else {
            // Set the JPasswordField to not echo the password.
            password.setEchoChar('\u2022'); // Use the bullet character as the echo character
            confirmpassword.setEchoChar('\u2022');

        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed
     private BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
    BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
    Graphics2D g = resizedImage.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
    g.dispose();
    return resizedImage;
}
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
            java.util.logging.Logger.getLogger(Newpasswordgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Newpasswordgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Newpasswordgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Newpasswordgui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Newpasswordgui dialog2 = new Newpasswordgui(new javax.swing.JFrame(), true, username_table);
                    Image iconImage = Toolkit.getDefaultToolkit().getImage("src/pictures/sports.png");
                    dialog2.setIconImage(iconImage);
                dialog2.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog2.setVisible(true);
            }
        });
    }
    void showDialog(){
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JPasswordField confirmpassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField userform;
    // End of variables declaration//GEN-END:variables
}