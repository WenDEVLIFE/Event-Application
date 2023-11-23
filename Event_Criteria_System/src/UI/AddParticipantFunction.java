/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import functions.CreateEventCredentials;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class AddParticipantFunction extends javax.swing.JDialog {

    /**
     * Creates new form AddParticipantFunction
     */
    public AddParticipantFunction(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          setLocationRelativeTo(null);
            setResizable(false);
 Image iconImage = Toolkit.getDefaultToolkit().getImage("src/pictures/sports.png");
            setIconImage(iconImage);
            // Set the icon for the dialog
           
        setTitle("Add participants");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Score = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        LastName = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        Emailtype = new javax.swing.JTextField();
        label5 = new java.awt.Label();
        clear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        label6 = new java.awt.Label();
        EventName = new javax.swing.JTextField();
        phonenumber = new javax.swing.JTextField();
        Team = new javax.swing.JTextField();
        label7 = new java.awt.Label();
        Firstname1 = new javax.swing.JTextField();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(575, 658));
        jPanel1.setName("create event"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(575, 658));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Score.setBackground(new java.awt.Color(51, 51, 51));
        Score.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Score.setForeground(new java.awt.Color(255, 255, 255));
        Score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScoreActionPerformed(evt);
            }
        });
        jPanel1.add(Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 450, 40));

        label1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(128, 0, 0));
        label1.setText("Input a Score");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 410, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-plus-32.png"))); // NOI18N
        jButton1.setText("Create");
        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusTraversalPolicyProvider(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 720, 230, 50));

        LastName.setBackground(new java.awt.Color(51, 51, 51));
        LastName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        LastName.setForeground(new java.awt.Color(255, 255, 255));
        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 450, 40));

        label2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(128, 0, 0));
        label2.setText("Add Participants");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 250, 30));

        label3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(128, 0, 0));
        label3.setText("LastName");
        jPanel1.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 120, 30));

        label4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(128, 0, 0));
        label4.setText("Email");
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 130, 30));
        label4.getAccessibleContext().setAccessibleName("Email");

        Emailtype.setBackground(new java.awt.Color(51, 51, 51));
        Emailtype.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Emailtype.setForeground(new java.awt.Color(255, 255, 255));
        Emailtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailtypeActionPerformed(evt);
            }
        });
        jPanel1.add(Emailtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 450, 40));

        label5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label5.setForeground(new java.awt.Color(128, 0, 0));
        label5.setText("Phone number");
        jPanel1.add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 410, -1));
        label5.getAccessibleContext().setAccessibleName("Phone number");

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
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 720, 231, 50));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 110, 90));
        try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("/pictures/pwclogo.jpg"));
            BufferedImage resizedImage = resizeImage(originalImage,72, 72);  // Adjust the dimensions as needed

            ImageIcon imageIcon = new ImageIcon(resizedImage);
            jLabel5.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        label6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label6.setForeground(new java.awt.Color(128, 0, 0));
        label6.setText("EventName");
        jPanel1.add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 220, 30));

        EventName.setBackground(new java.awt.Color(51, 51, 51));
        EventName.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        EventName.setForeground(new java.awt.Color(255, 255, 255));
        EventName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventNameActionPerformed(evt);
            }
        });
        jPanel1.add(EventName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 450, 40));

        phonenumber.setBackground(new java.awt.Color(51, 51, 51));
        phonenumber.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        phonenumber.setForeground(new java.awt.Color(255, 255, 255));
        phonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenumberActionPerformed(evt);
            }
        });
        jPanel1.add(phonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 450, 40));

        Team.setBackground(new java.awt.Color(51, 51, 51));
        Team.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Team.setForeground(new java.awt.Color(255, 255, 255));
        Team.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamActionPerformed(evt);
            }
        });
        jPanel1.add(Team, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 450, 40));

        label7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label7.setForeground(new java.awt.Color(128, 0, 0));
        label7.setText("Team Name");
        jPanel1.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 410, 30));

        Firstname1.setBackground(new java.awt.Color(51, 51, 51));
        Firstname1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Firstname1.setForeground(new java.awt.Color(255, 255, 255));
        Firstname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Firstname1ActionPerformed(evt);
            }
        });
        jPanel1.add(Firstname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 450, 40));

        label8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label8.setForeground(new java.awt.Color(128, 0, 0));
        label8.setText("FirstName");
        jPanel1.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 220, 30));

        label9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label9.setForeground(new java.awt.Color(128, 0, 0));
        label9.setText("EventName");
        jPanel1.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 220, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ScoreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // event name
     String event =EventName.getText();
    String firstn=Firstname1.getText();
    String lastn=LastName.getText();
    String email=Emailtype.getText();
    String  phone=phonenumber.getText();
    String  team_type = Team.getText();
    String sco=Score.getText();
     int score = Integer.parseInt(sco);
    if( event.isEmpty() && firstn.isEmpty() && lastn.isEmpty() && email.isEmpty() && phone.isEmpty() && team_type.isEmpty() && sco.isEmpty()){
         JOptionPane.showMessageDialog(this, "Please fill up firstname, secondname, email, phonenumber, team, and score");
    }
    else {
        CreateEventCredentials n = new CreateEventCredentials( event, firstn,  lastn, email, phone, team_type, score );
        n.create();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void EmailtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailtypeActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        LastName.setText("");
        Emailtype.setText("");
        Score.setText("");
        phonenumber.setText("");
        EventName.setText("");
        Team.setText("");

    }//GEN-LAST:event_clearActionPerformed

    private void EventNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EventNameActionPerformed

    private void phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonenumberActionPerformed

    private void TeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeamActionPerformed

    private void Firstname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Firstname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Firstname1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddParticipantFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddParticipantFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddParticipantFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddParticipantFunction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
   try {
	    	FlatSolarizedLightIJTheme.setup();
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	    }
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddParticipantFunction dialog1 = new AddParticipantFunction(new javax.swing.JFrame(), true);
                dialog1.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog1.setVisible(true);
            }
        });
    }

       private BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
    BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
    Graphics2D g = resizedImage.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
    g.dispose();
    return resizedImage;
    
}
  void showDialog() {
        
        setVisible(true);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
       
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Emailtype;
    private javax.swing.JTextField EventName;
    private javax.swing.JTextField Firstname1;
    private javax.swing.JTextField LastName;
    private javax.swing.JTextField Score;
    private javax.swing.JTextField Team;
    private javax.swing.JButton clear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JTextField phonenumber;
    // End of variables declaration//GEN-END:variables
}

