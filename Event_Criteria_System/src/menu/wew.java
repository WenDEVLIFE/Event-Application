/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author Administrator
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Help extends JFrame
{
  private    JTabbedPane tabbedPane;
  private    JPanel panel1;
  private    JPanel panel2;

  public Help()
  {

     final JPanel topPanel = new JPanel();
     topPanel.setLayout( new BorderLayout() );
     getContentPane().add( topPanel );

     String[] choose = {"1", "2", "3"};

    final JComboBox chooseBox = new JComboBox(choose);

    JPanel topPanelHeader = new JPanel();
    topPanelHeader.setLayout(new BorderLayout());
    JPanel topPanelHeader2 = new JPanel();
    topPanelHeader2.setLayout(new BorderLayout());

    JButton submit = new JButton("Submit");
    JLabel chooseLabel = new JLabel("Choose one       ");
    JLabel blank = new JLabel("                                       ");


    chooseBox.setSelectedIndex(0);
    topPanelHeader2.add(chooseLabel, BorderLayout.WEST);
    topPanelHeader2.add(chooseBox, BorderLayout.CENTER);
    topPanelHeader2.add(blank, BorderLayout.EAST);
    topPanelHeader.add(submit, BorderLayout.EAST);
    topPanelHeader.add(topPanelHeader2, BorderLayout.WEST);
    topPanel.add(topPanelHeader, BorderLayout.NORTH);

    createPage1(-1);
    createPage2(-1);

    // Create a tabbed pane
    tabbedPane = new JTabbedPane();
    tabbedPane.addTab( "Tab One", panel1 );
    tabbedPane.addTab( "Tab Two", panel2 );

    topPanel.add( tabbedPane, BorderLayout.CENTER );
    chooseBox.setSelectedIndex(-1);

    chooseBox.addActionListener(new ActionListener()
    {
        int selected;

        public void actionPerformed(ActionEvent e)
        {
       selected = chooseBox.getSelectedIndex();

       System.out.println("Made it");
       createPage1(selected);
       panel1.repaint(); //IS NOT REPAINTING, I HAVE ALSO ALREADY TRIED REVALIDATE()
       createPage2(selected);
       panel2.repaint(); //IS NOT REPAINTING

    tabbedPane.removeAll();
    tabbedPane.addTab( "Tab One", panel1 );
    tabbedPane.addTab( "Tab Two", panel2 );
    }
    });

    pack();
    }


public void createPage1(int selected)
    {
System.out.println("createPage1");
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(700, 650));
        String[] list = {"a", "b", "c"};

    JComboBox box = new JComboBox(list);

    switch(selected){
    case 0:
        box.setSelectedIndex(0);

    break;
    case 1:
        box.setSelectedIndex(1);
        break;
        case 2:
        box.setSelectedIndex(2);
        break;
        default:
            box.setSelectedIndex(0);
        break;
    }
    panel1.add(box);

}

     public void createPage2(int selected)
     {
System.out.println("createPage2");
    panel2 = new JPanel();
    panel1.setPreferredSize(new Dimension(700, 650));
    JRadioButton one = new JRadioButton("One");
    JRadioButton two = new JRadioButton("Two");
    ButtonGroup group = new ButtonGroup();
    group.add(one);
    group.add(two);
    switch(selected){
    case 0:
        one.setSelected(true);
        two.setSelected(false);
    break;
    case 1:
        one.setSelected(false);
        two.setSelected(true);
    break;
        default:
            one.setSelected(false);
        two.setSelected(false);
        break;
         }
    panel2.add(one);
    panel2.add(two);
}


public static void main( String args[] )
{
    // Create an instance of the test application
    Help mainFrame  = new Help();
    mainFrame.setVisible( true );
}
}
