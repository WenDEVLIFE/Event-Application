/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import functions.delete_event;
import functions.PanelRound;
import functions.UserExist;
import functions.ButtonColumn;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import java.util.List;
import javax.swing.UIManager;
import event_criteria_system.Login;
import static event_criteria_system.Login.user;
import functions.ButtonColumn1;
import functions.ButtonColumn2;
import functions.convert_pdf_file;
import functions.convert_pdf_file_Score;
import functions.convert_pdf_file_Team_Table;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Administrator
 */
public class dashboard extends javax.swing.JFrame {

    /**
     *
     */
     // this the jframe of class
    public static dashboard meow;
     public static DefaultTableModel model1;
     public static DefaultTableModel model2;
     public static DefaultTableModel model3;
    public static String confirmpassword1;
private DefaultTableModel model;
public static TableRowSorter <DefaultTableModel> sorter;
    private DefaultTableModel tableModel;
 public static String username;
 public static String username1;
    public static String password1;
 static int numberOfRows1;
 public static String eventdb;
  public static String eventname;
    public static  dashboard currentFrame;
    
    
    private String mydb_url = "jdbc:mysql://localhost:3306/eventsystem_db";
		
		@SuppressWarnings("unused")
		//database username
		private String myDB_username = "root";
		@SuppressWarnings("unused")
		
		//database password
		private String myDB_PASSWORD = "";
                
                
    /**
     * Creates new form dashboard
     */
    
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
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
         try {
	    	FlatSolarizedLightIJTheme.setup();
                
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	    }
        EventQueue.invokeLater(() -> {
            try {
                
                meow =  new dashboard(username);
                meow.setVisible(true);
                
 
                
          
                 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	
      
    }
    
    public dashboard(String username) throws SQLException, ClassNotFoundException {
      this.username = username;
        initComponents();
          // to set icons of your titlebar
           Image iconImage = Toolkit.getDefaultToolkit().getImage("src/pictures/sports.png");
        jTabbedPane1.setSelectedIndex(2);
          userole(username);
        // Set the icon on the frame.
       setIconImage(iconImage);
       mysqlstudent();
       mysql_participants();
       mysql_judge();
       mysql_score() ;
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
        Admin = new javax.swing.JButton();
        dash = new javax.swing.JButton();
        label2 = new java.awt.Label();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        evb = new javax.swing.JButton();
        label4 = new java.awt.Label();
        label11 = new java.awt.Label();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        dashboards = new javax.swing.JPanel();
        eventboard1 = new PanelRound();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        participants = new PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new PanelRound();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new PanelRound();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new PanelRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        events = new javax.swing.JPanel();
        jPanel11 = new JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                return (column == 6 || column == 7) ? JButton.class : Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6 || column == 7;
            }
        };

        tableModel.addColumn("Event_ID");
        tableModel.addColumn("Event_Name");
        tableModel.addColumn("Event_Date");
        tableModel.addColumn("Event_Type");
        tableModel.addColumn("Location");
        tableModel.addColumn("Max_Participants");
        tableModel.addColumn("Delete");
        tableModel.addColumn("Open");
        jTable2 = new javax.swing.JTable(tableModel);
        jButton2 = new javax.swing.JButton();
        searchingbar = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        label10 = new java.awt.Label();
        addev4 = new javax.swing.JButton();
        adminpanel = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        label7 = new java.awt.Label();
        User = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        confirmpass = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Pass = new javax.swing.JPasswordField();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        clear = new javax.swing.JButton();
        adduser = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        label8 = new java.awt.Label();
        reports = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        model2 = new DefaultTableModel();
        model2.addColumn("ParticipantID");
        model2.addColumn("FirstName");
        model2.addColumn("LastName");
        model2.addColumn("Email");
        model2.addColumn("Phone");
        model2.addColumn("Team_ID");
        model2.addColumn("Event_ID");
        model2.addColumn("Delete");
        jTable3 = new javax.swing.JTable(model2);
        jPanel12 = new javax.swing.JPanel();
        eventlabels = new java.awt.Label();
        eventlabels1 = new java.awt.Label();
        jComboBox6 = new javax.swing.JComboBox<>();
        label9 = new java.awt.Label();
        addev1 = new javax.swing.JButton();
        addev = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        model3 = new DefaultTableModel();
        model3.addColumn("Team_ID");
        model3.addColumn("Team_Name");
        model3.addColumn("CaptainDorPLayer_ID");
        model3.addColumn("Event_ID");
        model3.addColumn("Delete");
        jTable4 = new javax.swing.JTable(model3);
        jPanel23 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        eventlabels5 = new java.awt.Label();
        eventlabels11 = new java.awt.Label();
        eventlabels9 = new java.awt.Label();
        label13 = new java.awt.Label();
        jComboBox7 = new javax.swing.JComboBox<>();
        addev2 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        model1 = new DefaultTableModel();
        model1.addColumn("ScoreID");
        model1.addColumn("EventID");
        model1.addColumn("ParticipantID");
        model1.addColumn("Score");
        model1.addColumn("Delete");
        jTable5 = new javax.swing.JTable( model1);
        jPanel22 = new javax.swing.JPanel();
        eventlabels7 = new java.awt.Label();
        eventlabels6 = new java.awt.Label();
        jComboBox8 = new javax.swing.JComboBox<>();
        label12 = new java.awt.Label();
        addev7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PWC Event Criteria System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(128, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Admin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Admin.setForeground(new java.awt.Color(128, 0, 0));
        Admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-admin-48.png"))); // NOI18N
        Admin.setText("Admin");
        Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminActionPerformed(evt);
            }
        });
        jPanel1.add(Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 170, 70));

        dash.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        dash.setForeground(new java.awt.Color(128, 0, 0));
        dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-dashboard-48.png"))); // NOI18N
        dash.setText("Dashboard");
        dash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashActionPerformed(evt);
            }
        });
        jPanel1.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 170, 70));

        label2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("@Copyright  2023");
        jPanel1.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 960, 150, 40));

        jButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(128, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logout.png"))); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 170, 70));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-user-60.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 60, 70));

        evb.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        evb.setForeground(new java.awt.Color(128, 0, 0));
        evb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/sports.png"))); // NOI18N
        evb.setText("Events");
        evb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evbActionPerformed(evt);
            }
        });
        jPanel1.add(evb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 170, 70));

        label4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText(username);
        jPanel1.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, 40));

        label11.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label11.setForeground(new java.awt.Color(255, 255, 255));
        label11.setText("User");
        jPanel1.add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 60, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 1000));

        dashboards.setBackground(new java.awt.Color(255, 255, 255));
        dashboards.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventboard1.setBackground(new java.awt.Color(128, 0, 0));
        eventboard1.setForeground(new java.awt.Color(255, 255, 255));
        eventboard1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/sports.png"))); // NOI18N
        eventboard1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Events");
        eventboard1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, 20));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("");
        eventboard1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 70, 20));

        dashboards.add(eventboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 320, 180));

        participants.setBackground(new java.awt.Color(128, 0, 0));
        participants.setForeground(new java.awt.Color(255, 255, 255));
        participants.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Participants");
        participants.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-conference-foreground-selected-48.png"))); // NOI18N
        participants.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("0");
        participants.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 70, 20));

        dashboards.add(participants, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 320, 180));

        jPanel8.setBackground(new java.awt.Color(128, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Judges");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-conference-foreground-selected-48.png"))); // NOI18N
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("0");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 70, 20));

        dashboards.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 320, 180));

        jPanel2.setBackground(new java.awt.Color(128, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Score Distributed");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 20));

        jPanel5.setBackground(new java.awt.Color(128, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Score Distributed");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 20));

        jPanel6.setBackground(new java.awt.Color(128, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Score Distributed");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 20));

        jPanel7.setBackground(new java.awt.Color(128, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Score Distributed");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 20));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 310, 180));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 310, 180));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 310, 180));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-score-48.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 50, 50));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("0");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 150, 20));

        dashboards.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 320, 180));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        label1.setText("Dashboard");
        jPanel10.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 350, 50));

        dashboards.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 100));

        jTabbedPane1.addTab("tab1", dashboards);

        events.setBackground(new java.awt.Color(255, 255, 255));
        events.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        events.setVisible(true);
        jPanel11.setBackground(new java.awt.Color(153, 0, 51));
        jPanel11.setForeground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(tableModel);
        // Apply the centerRenderer to all columns in your JTable
        DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
        centerRenderer1.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer1);
        }

        jTable2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable2.getColumn("Delete").setCellRenderer(new ButtonRenderer1());
        jTable2.getColumn("Delete").setCellEditor(new ButtonEditor1(new JCheckBox(), jTable2, tableModel));

        // For the "Open" column
        jTable2.getColumn("Open").setCellRenderer(new ButtonRenderer1());
        jTable2.getColumn("Open").setCellEditor(new ButtonEditor1(new JCheckBox(), jTable2, tableModel));
        sorter = new TableRowSorter<>(tableModel);
        jTable2.setRowSorter(sorter);
        populateTableFromDatabase();
        jScrollPane3.setViewportView(jTable2);

        jPanel11.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 830));

        events.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1070, 830));

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/search_954591 (1).png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        events.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 170, 40));
        events.add(searchingbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 240, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label10.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        label10.setText("Event");
        jPanel4.add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 210, 50));

        events.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 80));

        addev4.setBackground(new java.awt.Color(0, 153, 51));
        addev4.setForeground(new java.awt.Color(255, 255, 255));
        addev4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-plus-32.png"))); // NOI18N
        addev4.setText("Create a event");
        addev4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addev4ActionPerformed(evt);
            }
        });
        events.add(addev4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, 40));

        jTabbedPane1.addTab("tab2", events);

        adminpanel.setBackground(new java.awt.Color(255, 255, 255));
        adminpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        label7.setForeground(new java.awt.Color(128, 0, 0));
        label7.setText("Add User");
        jPanel16.add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 190, 50));
        label7.getAccessibleContext().setAccessibleName("Admin");

        User.setBackground(new java.awt.Color(51, 51, 51));
        User.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });
        jPanel16.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 310, 50));
        User.getAccessibleContext().setAccessibleName("");

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(128, 0, 0));
        jLabel22.setText("Roles");
        jPanel16.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Judge" }));
        jPanel16.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 310, 40));

        confirmpass.setBackground(new java.awt.Color(51, 51, 51));
        confirmpass.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        confirmpass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel16.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 310, 50));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 0, 0));
        jLabel23.setText("Username");
        jPanel16.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(128, 0, 0));
        jLabel24.setText("Password");
        jPanel16.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 20));

        Pass.setBackground(new java.awt.Color(51, 51, 51));
        Pass.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Pass.setForeground(new java.awt.Color(255, 255, 255));
        jPanel16.add(Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 310, 50));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(128, 0, 0));
        jLabel25.setText("Confirmed password");
        jPanel16.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 20));

        jCheckBox1.setForeground(new java.awt.Color(128, 0, 0));
        jCheckBox1.setText("Check to see the password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel16.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

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
        jPanel16.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 730, 231, 78));

        adduser.setBackground(new java.awt.Color(0, 153, 51));
        adduser.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        adduser.setForeground(new java.awt.Color(255, 255, 255));
        adduser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-plus-32.png"))); // NOI18N
        adduser.setText("Add User");
        adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduserActionPerformed(evt);
            }
        });
        jPanel16.add(adduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 231, 78));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/add-friend.png"))); // NOI18N
        jPanel16.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 70, 80));

        adminpanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 360, 910));

        // Create a table model with button columns
        model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                if (column == 4 || column == 5) { // Assuming delete is column 4 and edit is column 5
                    return JButton.class;
                } else {
                    return Object.class;
                }
            }
        };

        model.addColumn("ID");
        model.addColumn("Username");
        model.addColumn("Role");
        model.addColumn("Delete");
        model.addColumn("Edit");
        jTable.setBackground(new java.awt.Color(255, 255, 255));
        jTable.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable.setForeground(new java.awt.Color(51, 51, 51));
        jTable.setModel(model
        );
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the centerRenderer to all columns in your JTable
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        jTable.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox(), jTable, (DefaultTableModel) jTable.getModel()));

        // For the "Edit" column
        jTable.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        jTable.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox(), jTable, (DefaultTableModel) jTable.getModel()));

        // Create a custom editor for the column containing buttons
        jScrollPane1.setViewportView(jTable);
        try {
            // Establish a database connection
            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "");

            // Create a statement and execute a SELECT query
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery("SELECT id, username, role, password from user");

            // Populate the DefaultTableModel with data from the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");

                // Create buttons for delete and edit
                JButton deleteButton = new JButton("Delete");
                JButton editButton = new JButton("Edit");

                // Add action listeners to the buttons
                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    }
                });

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object[] options = {"Option 1", "Option 2", "Option 3"};

                        // Show the JOptionPane with three buttons
                        int choice = JOptionPane.showOptionDialog(
                            null,
                            "Select an option:",
                            "Options",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0] // Default selection
                        );

                        // Handle the user's choice
                        if (choice == 0) {
                            // User selected "Option 1"
                            JOptionPane.showMessageDialog(null, "You selected Option 1");
                        } else if (choice == 1) {
                            // User selected "Option 2"
                            JOptionPane.showMessageDialog(null, "You selected Option 2");
                        } else if (choice == 2) {
                            // User selected "Option 3"
                            JOptionPane.showMessageDialog(null, "You selected Option 3");
                        }
                    }
                });

                // Add data to the model, including buttons
                model.addRow(new Object[]{id, username, role, "Delete", "Edit"});
            }

            // Close the database connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        adminpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 730, 910));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label8.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        label8.setText("Admin");
        jPanel3.add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 210, 60));

        adminpanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1120, 90));

        jTabbedPane1.addTab("tab4", adminpanel);

        reports.setBackground(new java.awt.Color(255, 255, 255));
        reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonColumn buttonColumn = new ButtonColumn(jTable3, deleteAction,7);
        jScrollPane4.setViewportView(jTable3);

        jPanel13.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 1050, 850));

        reports.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 1050, 850));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setForeground(new java.awt.Color(153, 153, 153));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventlabels.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        eventlabels.setText("Participant Table");
        jPanel12.add(eventlabels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 70));

        eventlabels1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        eventlabels1.setText("Participant Table");
        jPanel12.add(eventlabels1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 440, 70));

        reports.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1110, 90));

        jComboBox6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Participant Table", "Team Table", "Score Table" }));
        reports.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 230, 30));
        jComboBox6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                // Get the selected item
                String selectedTable23 = (String) jComboBox6.getSelectedItem();

                // Perform action based on the selected item
                if ("Participant Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(4);
                } else if ("Team Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(1);
                } else if ("Score Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(0);
                }
            }
        });

        label9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label9.setForeground(new java.awt.Color(128, 0, 0));
        label9.setText("Select Table");
        reports.add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, -1, 20));

        addev1.setBackground(new java.awt.Color(0, 153, 51));
        addev1.setForeground(new java.awt.Color(255, 255, 255));
        addev1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-plus-32.png"))); // NOI18N
        addev1.setText("Create participants, score and team");
        addev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addev1ActionPerformed(evt);
            }
        });
        reports.add(addev1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 260, 40));

        addev.setBackground(new java.awt.Color(0, 153, 51));
        addev.setForeground(new java.awt.Color(255, 255, 255));
        addev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-plus-32.png"))); // NOI18N
        addev.setText("Print");
        addev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addevActionPerformed(evt);
            }
        });
        reports.add(addev, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 240, 40));

        jTabbedPane1.addTab("tab3", reports);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setForeground(new java.awt.Color(204, 204, 204));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonColumn2 buttonColumn2 = new ButtonColumn2(jTable4, deleteAction,4);
        jScrollPane5.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1050, 850));

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));
        jPanel23.setForeground(new java.awt.Color(153, 153, 153));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setForeground(new java.awt.Color(153, 153, 153));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventlabels5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        eventlabels5.setText("Event Name:");
        jPanel19.add(eventlabels5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 70));

        eventlabels11.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        eventlabels11.setText("Event Name:");
        jPanel19.add(eventlabels11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 70));

        eventlabels9.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        eventlabels9.setText("Team Table");
        jPanel19.add(eventlabels9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 610, 70));

        jPanel23.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 90));

        jPanel20.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1110, 90));

        label13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label13.setForeground(new java.awt.Color(128, 0, 0));
        label13.setText("Select Table");
        jPanel20.add(label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, -1, 20));

        jComboBox7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Participant Table", "Team Table", "Score Table" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jPanel20.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 230, 30));
        jComboBox7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                // Get the selected item
                String selectedTable23 = (String) jComboBox7.getSelectedItem();

                // Perform action based on the selected item
                if ("Participant Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(4);
                } else if ("Team Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(1);
                } else if ("Score Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(0);
                }
            }
        });

        addev2.setBackground(new java.awt.Color(0, 153, 51));
        addev2.setForeground(new java.awt.Color(255, 255, 255));
        addev2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-plus-32.png"))); // NOI18N
        addev2.setText("Print");
        addev2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addev2ActionPerformed(evt);
            }
        });
        jPanel20.add(addev2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 240, 40));

        jPanel14.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("tab5", jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setForeground(new java.awt.Color(204, 204, 204));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonColumn1 buttonColumn1 = new ButtonColumn1(jTable5, deleteAction,4);
        jScrollPane6.setViewportView(jTable5);

        jPanel17.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 1050, 850));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1050, 850));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel22.setForeground(new java.awt.Color(153, 153, 153));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventlabels7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        eventlabels7.setText("Event Name:");
        jPanel22.add(eventlabels7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 70));

        eventlabels6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        eventlabels6.setText("Score Table");
        jPanel22.add(eventlabels6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 660, 70));

        jPanel15.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1110, 90));

        jComboBox8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Participant Table", "Team Table", "Score Table" }));
        jPanel15.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 230, 30));
        jComboBox8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)  {
                // Get the selected item
                String selectedTable23 = (String) jComboBox8.getSelectedItem();

                // Perform action based on the selected item
                if ("Participant Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(4);
                } else if ("Team Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(1);
                } else if ("Score Table".equals(selectedTable23)) {
                    // Replace this line with your desired action
                    jTabbedPane1.setSelectedIndex(0);
                }
            }
        });

        label12.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label12.setForeground(new java.awt.Color(128, 0, 0));
        label12.setText("Select Table");
        jPanel15.add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, -1, 20));

        addev7.setBackground(new java.awt.Color(0, 153, 51));
        addev7.setForeground(new java.awt.Color(255, 255, 255));
        addev7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/icons8-plus-32.png"))); // NOI18N
        addev7.setText("Print");
        addev7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addev7ActionPerformed(evt);
            }
        });
        jPanel15.add(addev7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 240, 40));

        jTabbedPane1.addTab("tab6", jPanel15);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -30, 1110, 1030));
        jTabbedPane1.addTab("Tab 1", dashboards);
        jTabbedPane1.addTab("Tab 2", events);
        jTabbedPane1.addTab("Tab 3", reports);
        jTabbedPane1.addTab("Tab 4", adminpanel);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param originalImage
     * @param i
     * @param i0
     * @return
     */
    private BufferedImage resizeImage(BufferedImage originalImage, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  // Custom button renderer for JTable
     private AbstractAction deleteAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTable table = (JTable) e.getSource();
            int row = Integer.parseInt(e.getActionCommand());

            // Get the user ID from the selected row
            int userId = (int) table.getValueAt(row, 0);

            // Perform delete operation in the database
            deleteUser(userId);

            // Remove the row from the table
            model1.removeRow(row);
        }

        private void deleteUser(int userId) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
    // this is JTABLE2
class ButtonRenderer extends JButton implements TableCellRenderer {
    private ImageIcon deleteIcon;
    private ImageIcon editIcon;
    public ButtonRenderer() {
         // Load icons for delete and edit buttons
        deleteIcon = new ImageIcon("src/pictures/icons8-trash-can-layout-for-a-indication-to-throw-trash-24.png");
        editIcon = new ImageIcon("src/pictures/edituser.png");
        
            deleteIcon = resizeIcon(deleteIcon, 10, 10); // Adjust the size as needed
        editIcon = resizeIcon(editIcon, 10, 10);     // Adjust the size as needed

        setBackground(new Color(128, 0, 0)); // Set background color to maroon
        setOpaque(true);
    }
      private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable2, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
          if (column == 3) { // Assuming "Delete" column is at index 3
            setIcon(deleteIcon);
        } else if (column == 4) { // Assuming "Edit" column is at index 4
            setIcon(editIcon);
        }

        if (isSelected) {
            setForeground(jTable2.getSelectionForeground());
            setBackground(jTable2.getSelectionBackground());
        } else {
            setForeground(jTable2.getForeground());
            setForeground(Color.WHITE);
            setBackground(UIManager.getColor("Button.background"));
              setBackground(new Color(128, 0, 0));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

// to display the eventtable
private void populateTableFromDatabase() {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "");

            // Create a statement and execute a SELECT query
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Event_ID, Event_Name, Event_Date, Event_Type, Location, Max_Participants FROM pwc_event_table");

            // Populate the DefaultTableModel with data from the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("Event_ID");
                String eventName = resultSet.getString("Event_Name");
                String date = resultSet.getString("Event_Date");
                String eventType = resultSet.getString("Event_Type");
                String location = resultSet.getString("Location");
                String maxParticipants = resultSet.getString("Max_Participants");

                tableModel.addRow(new Object[]{id, eventName, date, eventType, location, maxParticipants, "Delete", "Open"});
            }

            // Close the database connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// this is for the Event Table
  // The ButtonRenderer1 class
 public class ButtonRenderer1 extends JButton implements TableCellRenderer {
     private ImageIcon deleteIcon1;
    private ImageIcon editIcon1;  
    public ButtonRenderer1() {
         // Load icons for delete and edit buttons
        deleteIcon1 = new ImageIcon("src/pictures/icons8-trash-can-layout-for-a-indication-to-throw-trash-24.png");
        editIcon1 = new ImageIcon("src/pictures/open.png");
        
            deleteIcon1 = resizeIcon(deleteIcon1, 10, 10); // Adjust the size as needed
        editIcon1 = resizeIcon(editIcon1, 10, 10);     // Adjust the size as needed
            setForeground(Color.WHITE);
        setBackground(new Color(128, 0, 0)); // Set background color to maroon
        setOpaque(true);
    }
      private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

        @Override
        public Component getTableCellRendererComponent(JTable jtable2, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
              if (column == 6) { // Assuming "Delete" column is at index 3
            setIcon(deleteIcon1);
        } else if (column == 7) { // Assuming "Edit" column is at index 4
            setIcon(editIcon1);
        }
             if (isSelected) {
            setForeground(jTable2.getSelectionForeground());
            setBackground(jTable2.getSelectionBackground());
        } else {
                setForeground(jTable2.getForeground());
            setForeground(Color.WHITE);
            setBackground(UIManager.getColor("Button.background"));
              setBackground(new Color(128, 0, 0));
        }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // The ButtonEditor1 class
  public class ButtonEditor1 extends DefaultCellEditor {
    protected JButton editButton1;
    private String label;
    private boolean isPushed;
    private final JTable jTable2;
    private final DefaultTableModel tableModel;

    public ButtonEditor1(JCheckBox checkBox, JTable jTable2, DefaultTableModel tableModel) {
        super(checkBox);
        editButton1 = new JButton("Open");
        editButton1.setOpaque(true);
        editButton1.addActionListener((ActionEvent e) -> fireEditingStopped());
        this.jTable2 = jTable2;
        this.tableModel = tableModel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jTable2, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        editButton1.setText(label);
        isPushed = true;
        return editButton1;
    }

    @Override
   public Object getCellEditorValue() {
        if (isPushed) {
            int selectedRow = jTable2.getSelectedRow();

   
                Object eventIDObject = tableModel.getValueAt(selectedRow, 0);
                 int eventID = (int) eventIDObject;


                    if ("Delete".equals(label)) {
                        int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this event?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                        if (confirmResult == JOptionPane.YES_OPTION) {
                            // Handle delete button click
                            System.out.println("Delete button clicked for Event ID: " + eventID);
                            delete_event e = new delete_event(eventID);
                            e.deleteEventFromDatabase();
                            tableModel.removeRow(selectedRow);
                        }
                    } else if ("Open".equals(label)) {
                        // Handle open button click
                        String eventInRow = (String) tableModel.getValueAt(selectedRow, 1);

                        // Now you can use eventInRow to retrieve the corresponding event from the database
                        // Perform a database query here and store the result in a variable
                        eventdb = retrieveEventFromDatabase(eventInRow);

                        if (eventdb != null) {
                            // Do something with the retrieved event name
                            System.out.println("Retrieved event name: " + eventdb);

                            // Assuming eventlabels is a JLabel, set the text
                
                            eventlabels.setText("Event Name:"+eventdb);
                            eventlabels5.setText("Event Name:"+eventdb);
                            eventlabels7.setText("Event Name:"+eventdb);
                                   jTabbedPane1.setSelectedIndex(4);
                        } else {
                            System.out.println("Event not found in the database.");
                        }
                
            }
        }
        isPushed = false;
        return label;
    }


        private String retrieveEventFromDatabase(String eventInRow) {
            eventname = null;

            // Define your database connection parameters
            String dbUrl = "jdbc:mysql://localhost:3306/eventsystem_db";
            String dbUser = "root";
            String dbPassword = "";

            // Define the SQL query to retrieve the event name
            String sql = "SELECT Event_Name FROM pwc_event_table WHERE Event_Name = ?";

            try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, eventInRow);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        eventname = resultSet.getString("Event_Name");
                        // Optionally, set the retrieved event name in a label or elsewhere
                        eventlabels.setText(eventname);
                        displayScores(eventname);
                        display_participant(eventname);
                        display_Team(eventname);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle any database-related exceptions here
            }

            return eventname;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    
    // bro this table breaks my mind because of same variable, the functions conflict and the event table wont delete
    // for usertable
public class ButtonEditor extends DefaultCellEditor {
    
    protected JButton button;
    private String label;
    private boolean isPushed;
    private int selectedRow;
    private final JTable jTable;
    private final DefaultTableModel model;
   public static String username_table;
    public ButtonEditor(JCheckBox checkBox, JTable jTable, DefaultTableModel model) {
        super(checkBox);
        this.username_table = username_table;
        button = new JButton();
        
        button.setOpaque(true);
            button = new JButton();
        button.addActionListener((ActionEvent e) -> {
            fireEditingStopped();
        });
        this.jTable = jTable;
        this.model = model;
    }

    @Override

public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    if (isSelected) {
        button.setForeground(table.getSelectionForeground());
        button.setBackground(table.getSelectionBackground());
    } else {
        button.setForeground(table.getForeground());
        button.setBackground(table.getBackground());
    }

    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    selectedRow = row;

    // Check if it's the "Delete" button
    if ("Delete".equals(label)) {
        String usernameInRow = (String) model.getValueAt(selectedRow, 1); // Assumes username is in column 1

        if (usernameInRow.equals(username)) {
            // Disable the button for the user in the title bar
            JOptionPane.showMessageDialog(null, "You cannot delete yourself.", "Error", JOptionPane.ERROR_MESSAGE);
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    return button;
}

    @Override
   public Object getCellEditorValue() {
    if (isPushed) {
             if ("Edit".equals(label)){

                 System.out.println("hehee");
                                       Object[] options = {"Change Username", "Change Password", "Cancel"};

        // Show the JOptionPane with three buttons
        int choice = JOptionPane.showOptionDialog(
            null,
            "Select to edit",
            "Options",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0] // Default selection
        );

        // Handle the user's choice
        if (choice == 0) {
              int selectedRow = jTable.getSelectedRow();

            if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
                // Assuming the username is in the second column (index 1)
                String usernameInRow = (String) model.getValueAt(selectedRow, 1);

                // Now you can use usernameInRow to retrieve the corresponding username from the database
                // Perform a database query here and store the result in a variable
                String usernameFromDatabase = retrieveUsernameFromDatabase(usernameInRow);

                if (usernameFromDatabase != null) {
                    // Do something with the retrieved username
                    System.out.println("Retrieved username: " + usernameFromDatabase);
                       EditUsername dialog = new  EditUsername(new javax.swing.JFrame(), true , username_table);
                     dialog.showDialog();
                } else {
                    System.out.println("Username not found in the database.");
                }
            }
        
     
        } else if (choice == 1) {
             int selectedRow = jTable.getSelectedRow();

            if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
                // Assuming the username is in the second column (index 1)
                String usernameInRow = (String) model.getValueAt(selectedRow, 1);

                // Now you can use usernameInRow to retrieve the corresponding username from the database
                // Perform a database query here and store the result in a variable
                String usernameFromDatabase = retrieveUsernameFromDatabase(usernameInRow);

                if (usernameFromDatabase != null) {
                    // Do something with the retrieved username
                    System.out.println("Retrieved username: " + usernameFromDatabase);
                         Newpasswordgui dialog2 = new Newpasswordgui(new javax.swing.JFrame(), true, username_table);
                    Image iconImage = Toolkit.getDefaultToolkit().getImage("src/pictures/sports.png");
                    dialog2.setIconImage(iconImage);
                    dialog2.showDialog();
                } else {
                    System.out.println("Username not found in the database.");
                }
            }
    
             
        } else if (choice == 2) {
          
        }
             }
            if ("Delete".equals(label)) {
                if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
                    try {
                        int idToDelete = (int) model.getValueAt(selectedRow, 0);
                        int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                        if (confirmResult == JOptionPane.YES_OPTION) {
                            String deleteQuery = "DELETE FROM user WHERE id = ?";
                            try (java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "");
                                 java.sql.PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                                deleteStatement.setInt(1, idToDelete);
                                int rowsDeleted = deleteStatement.executeUpdate();
                                if (rowsDeleted > 0) {
                                    System.out.println("User with ID " + idToDelete + " deleted from the database."); 
                                    
                                    meow.dispose();
                                    meow =  new dashboard(username);
                                    meow.setVisible(true);
                                            jTabbedPane1.setSelectedIndex(5);
                                } else {
                                    System.out.println("User deletion failed.");
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            model.removeRow(selectedRow);
                            // You may also remove the item from your data source here
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        ex.printStackTrace();
                    }
                }
    }
    }
    isPushed = false;
    return label;
}
   
   // this is also connected to the table database
  private String retrieveUsernameFromDatabase(String username) {
        String retrievedUsername = null;
        
        // Define your database connection parameters
        String dbUrl = "jdbc:mysql://localhost:3306/eventsystem_db";
        String dbUser = "root";
        String dbPassword = "";

        // Define the SQL query to retrieve the username
        String sql = "SELECT username FROM user WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Username found in the database
                    retrievedUsername = resultSet.getString("username");
                   username_table= retrievedUsername;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related exceptions here
        }

        return retrievedUsername;
    }
    // Method to remove marked rows
    public void removeMarkedRows(List<Integer> rowsToDelete) {
        for (int i = rowsToDelete.size() - 1; i >= 0; i--) {
            int rowToDelete = rowsToDelete.get(i);
            model.removeRow(rowToDelete);
            // Update your data source here
        }

        rowsToDelete.clear();
        model.fireTableDataChanged();
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

   
    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

}

// go to admin panel
    private void AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminActionPerformed
        // TODO add your handling code here:
                          jTabbedPane1.setSelectedIndex(5);
        

    }//GEN-LAST:event_AdminActionPerformed

    // go to dashboard
    private void dashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashActionPerformed
        // TODO add your handling code here:
        //dashboard
           jTabbedPane1.setSelectedIndex(2);
     
    }//GEN-LAST:event_dashActionPerformed

    // logout button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        int result = JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Confirmation", JOptionPane.YES_NO_OPTION);

if (result == JOptionPane.YES_OPTION) {
  // Dispose
   meow.dispose();
   user = new Login();
   user.setVisible(true);
        user.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
} else if (result == JOptionPane.NO_OPTION) {
  // Cancel the operation.
} else {
  // The user closed the dialog box without clicking on either button.
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void evbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evbActionPerformed
        // TODO add your handling code here:
        
        //event
                jTabbedPane1.setSelectedIndex(3);
            
         
           
    }//GEN-LAST:event_evbActionPerformed

    private void adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduserActionPerformed
        // TODO add your handling code here:

        //get value from the arrays
        Object selectedItem2 = jComboBox1.getSelectedItem();
        String selectedItemString = (String) selectedItem2;

        // get text the value from the textfields and password
        username1 = User.getText();
        password1 = new String(Pass.getPassword());
        confirmpassword1 = new String(confirmpass.getPassword());

        // to check if its empty
        if (username1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);

            // if both passworld field is empty
        } else if (password1.isEmpty() || confirmpassword1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);

            // if password and confirm password is not equal
        } else if (!password1.equals(confirmpassword1)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);

            //if the lenght is not commit on the desire value from 8 to 12 letters
        } else if (!verifyPasswordLength(confirmpassword1)) {
            JOptionPane.showMessageDialog(null, "Password must be at least X characters long.", "Error", JOptionPane.ERROR_MESSAGE);

        }
        else {
            boolean hasCapsLock = false;
            boolean hasSpecialCharacters = false;

            for (char character : confirmpassword1.toCharArray()) {
                if (Character.isUpperCase(character)) {
                    hasCapsLock = true;
                } else if (!Character.isLetterOrDigit(character)) {
                    hasSpecialCharacters = true;
                }
            }
            // if user has no capslock and special character
            if (!hasCapsLock || !hasSpecialCharacters) {
                JOptionPane.showMessageDialog(null, "The password must contain at least one uppercase letter and one special character.");
            }

            // the user goes here if the usercommit all the requirements
            else {
                // All checks passed, user registration or other actions can proceed here
                UserExist meow2 = new UserExist(username1, password1, selectedItemString);
                meow2.user_identification();
                User.setText("");
                Pass.setText("");
                confirmpass.setText("");
                meow.repaint();
                meow.dispose();
                try {
                    meow =  new dashboard(username);
                } catch (SQLException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                meow.setVisible(true);
                jTabbedPane1.setSelectedIndex(5);

            }
        }
    }//GEN-LAST:event_adduserActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        User.setText("");
        Pass.setText("");
        confirmpass.setText("");

    }//GEN-LAST:event_clearActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        // Check if the checkbox is selected.
        if (jCheckBox1.isSelected()) {
            // Set the JPasswordField to echo the password.
            confirmpass.setEchoChar((char) 0);
            Pass.setEchoChar((char) 0);
        } else {
            // Set the JPasswordField to not echo the password.
            confirmpass.setEchoChar('*');
            Pass.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String search = searchingbar.getText();

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + search); // Case-insensitive search

        sorter.setRowFilter(rowFilter);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void addev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addev1ActionPerformed
        // TODO add your handling code here:
           AddParticipantFunction dialog1 = new AddParticipantFunction(new javax.swing.JFrame(), true);
           dialog1.showDialog();
    }//GEN-LAST:event_addev1ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void addev4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addev4ActionPerformed
        // TODO add your handling code here:
            create_event dialog = new create_event(new java.awt.Frame(), true , username);
            dialog.showDialog();
    }//GEN-LAST:event_addev4ActionPerformed

    private void addevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addevActionPerformed
        try {
            // TODO add your handling code here:
            convert_pdf_file p = new  convert_pdf_file(eventname);
            p.pdf();
        } catch (IOException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addevActionPerformed

    private void addev7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addev7ActionPerformed
        try {
            // TODO add your handling code here:
            convert_pdf_file_Score pdfScoreGenerator = new convert_pdf_file_Score(eventname);
            pdfScoreGenerator.pdf();
        } catch (IOException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addev7ActionPerformed

    private void addev2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addev2ActionPerformed
        try {
            // TODO add your handling code here:
            convert_pdf_file_Team_Table s = new convert_pdf_file_Team_Table(eventname);
            s.pdf();
        } catch (IOException ex) {
            Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addev2ActionPerformed

// To verify the password length
public static boolean verifyPasswordLength(String password) {
    int length = password.length();
    return length >= 8 && length <=20;
} 
 private void userole(String user) {
     try {
    
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsystem_db", "root", "");
         java.sql.Statement statement = connection.createStatement();

         // Query the database for the user's role based on the username
         ResultSet resultSet = statement.executeQuery("SELECT role FROM user WHERE username = '" + username + "'");

         if (resultSet.next()) {
             String role = resultSet.getString("Role");
             if (role.equals("Admin")) {
                 Admin.setVisible(true);
             } else {
                Admin.setVisible(false);
             }
         } else {
             // Username does not exist in the database
          
         }

         resultSet.close();
         statement.close();
         connection.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
public int mysqlstudent() throws SQLException, ClassNotFoundException {
   int numberOfRows1 = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS rowCount FROM pwc_event_table")) {

            // Check if the result set has data
            if (rs.next()) {
                numberOfRows1 = rs.getInt("rowCount");
                jLabel18.setText(""+numberOfRows1);
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfRows1;
		
}

public int mysql_participants() throws SQLException, ClassNotFoundException {
   int numberOfRows11 = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS ParticipantID FROM participants_table")) {

            // Check if the result set has data
            if (rs.next()) {
                numberOfRows11 = rs.getInt("ParticipantID");
                jLabel19.setText(""+numberOfRows11);
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfRows11;
		
}

public int mysql_judge() throws SQLException, ClassNotFoundException {
 int numberOfJudges = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS id FROM user WHERE role = 'Judge'")) {

            // Check if the result set has data
            if (rs.next()) {
               numberOfJudges = rs.getInt("id");
                jLabel20.setText(""+numberOfJudges);
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfJudges;
		
}

public double mysql_score() throws SQLException, ClassNotFoundException {
double numberOfScore = 0;

        // Load MySQL driver
        Class.forName("com.mysql.jdbc.Driver");

        // Connect to the database using try-with-resources
        try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD);
             java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(Score)  AS Score FROM score_table")) {

            // Check if the result set has data
            if (rs.next()) {
               numberOfScore = rs.getInt("Score");
                jLabel15.setText(""+numberOfScore);
            }
        } // Resources are closed automatically due to try-with-resources

        return numberOfScore;
		
}

// to display the score table
public void displayScores(String eventname) {
  model1.setRowCount(0); // Clear existing data in the table

    try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
        String query = "SELECT ScoreID, Event_ID, ParticipantID, Score FROM score_table WHERE Event_ID IN (SELECT Event_ID FROM pwc_event_table WHERE Event_Name = ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, eventname);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int scoreID = rs.getInt("ScoreID");
                    int eventID = rs.getInt("Event_ID");
                    int participantID = rs.getInt("ParticipantID");
                    double score = rs.getDouble("Score");

                    // Assuming ButtonColumn is a class you've implemented
                    JButton deleteButton = new JButton("Delete");
                      ButtonColumn deleteAction = new ButtonColumn(jTable5, new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle delete button click action
        int row = jTable5.convertRowIndexToModel(jTable5.getEditingRow());
     

    }
}, 4);

                    model1.addRow(new Object[]{scoreID, eventID, participantID, score, deleteButton});
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

public void display_participant(String eventname) {
  model2.setRowCount(0); // Clear existing data in the table

    try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
        String query = "SELECT ParticipantID, Firstname, Lastname,email, Phone, Team_ID, Event_ID FROM participants_table WHERE Event_ID IN (SELECT Event_ID FROM pwc_event_table WHERE Event_Name = ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, eventname);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int partID = rs.getInt("ParticipantID");
                   String fname= rs.getString("Firstname");
                   String lname= rs.getString("Lastname");
                   String email= rs.getString("email");
                   String intnum= rs.getString("Phone");
                   int participantID = rs.getInt("Team_ID");
                  int eventID = rs.getInt("Event_ID");
                 

                    // Assuming ButtonColumn is a class you've implemented
                    JButton deleteButton = new JButton("Delete");
                      ButtonColumn1 deleteAction = new ButtonColumn1(jTable3, new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle delete button click action
        int row = jTable3.convertRowIndexToModel(jTable3.getEditingRow());
     

    }
}, 7);

                    model2.addRow(new Object[]{partID, fname, lname, email, intnum, participantID,  eventID ,deleteButton});
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

public void display_Team(String eventname) {
  model3.setRowCount(0); // Clear existing data in the table

    try (Connection con = DriverManager.getConnection(mydb_url, myDB_username, myDB_PASSWORD)) {
        String query = "SELECT Team_ID, Team_Name, CaptainDorPLayer_ID, Event_ID FROM team_table WHERE Event_ID IN (SELECT Event_ID FROM pwc_event_table WHERE Event_Name = ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, eventname);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int team_ID = rs.getInt("Team_ID");
                   String teamname= rs.getString("Team_Name");
                 
                   int player_id = rs.getInt("CaptainDorPLayer_ID");
                  int eventID = rs.getInt("Event_ID");
                 

                    // Assuming ButtonColumn is a class you've implemented
                      JButton deleteButton = new JButton("Delete");
             
                   ButtonColumn2 deleteAction = new ButtonColumn2(jTable4, new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle delete button click action
        int row = jTable4.convertRowIndexToModel(jTable4.getEditingRow());
    }
}, 4);
                      
// Assuming model3 has at least 5 columns
                    model3.addRow(new Object[]{team_ID, teamname, player_id,  eventID ,deleteButton});
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Admin;
    public static javax.swing.JPasswordField Pass;
    public static javax.swing.JTextField User;
    private javax.swing.JButton addev;
    private javax.swing.JButton addev1;
    private javax.swing.JButton addev2;
    private javax.swing.JButton addev4;
    private javax.swing.JButton addev7;
    private javax.swing.JButton adduser;
    private javax.swing.JPanel adminpanel;
    private javax.swing.JButton clear;
    public static javax.swing.JPasswordField confirmpass;
    private javax.swing.JButton dash;
    private javax.swing.JPanel dashboards;
    private javax.swing.JButton evb;
    public static transient volatile javax.swing.JPanel eventboard1;
    public static java.awt.Label eventlabels;
    private java.awt.Label eventlabels1;
    private java.awt.Label eventlabels11;
    public static java.awt.Label eventlabels5;
    private java.awt.Label eventlabels6;
    public static java.awt.Label eventlabels7;
    private java.awt.Label eventlabels9;
    private javax.swing.JPanel events;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable2;
    public static javax.swing.JTable jTable3;
    public static javax.swing.JTable jTable4;
    public static javax.swing.JTable jTable5;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JPanel participants;
    private javax.swing.JPanel reports;
    private javax.swing.JTextField searchingbar;
    // End of variables declaration//GEN-END:variables

  // this is where you code
}
