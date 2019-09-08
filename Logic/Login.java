package ir.aut.test.Logic;

import javax.swing.*;

/**
 import javax.swing.*;
 import java.awt.*;

 /**
 * Created by Soudabeh on 7/6/2017.
 */


public class Login extends JFrame {


    JFrame jFrame;
    JLabel nameLabel,hostPortLabel,IPLabel,portGuestLabel;
    JTextField nameText,hostPortText,IPText,portGuestText;
    JRadioButton guestButton;
    JRadioButton hostButton;
    JButton exitButton,startButton;


    public Login(){

        jFrame =new JFrame("Select Connection Mode");
        jFrame.setLayout(null);
        jFrame.setSize(700,600);
        nameLabel=new JLabel();
        hostPortLabel=new JLabel();
        IPLabel=new JLabel();
        portGuestLabel=new JLabel();
        nameText = new JTextField();
        hostPortText = new JTextField();
        IPText = new JTextField();
        portGuestText = new JTextField();
        guestButton = new JRadioButton();
        hostButton = new JRadioButton();
        exitButton=new JButton();
        startButton=new JButton();



        nameLabel.setText("Name: ");
        nameLabel.setLocation(10,10);
        nameLabel.setSize(50,50);
        nameLabel.setVisible(true);

        nameText.setBounds(55,30,400,40);
        nameText.setVisible(true);

        hostButton.setBounds(10,100,70,70);
        hostButton.setText("    Host");
        hostButton.setVisible(true);

        hostPortLabel.setText("Port: ");
        hostPortLabel.setLocation(10,200);
        hostPortLabel.setSize(50,50);
        hostPortLabel.setVisible(true);


        hostPortText.setBounds(55,200,300,40);
        hostPortText.setVisible(true);


        guestButton.setBounds(10,300,70,70);
        guestButton.setText("    Guest");
        guestButton.setVisible(true);


        IPLabel.setText("IP: ");
        IPLabel.setLocation(10,400);
        IPLabel.setSize(50,50);
        IPLabel.setVisible(true);

        IPText.setBounds(30,400,200,40);
        IPText.setVisible(true);



        portGuestLabel.setText("Port: ");
        portGuestLabel.setLocation(300,400);
        portGuestLabel.setSize(50,50);
        portGuestLabel.setVisible(true);

        portGuestText.setBounds(350,400,200,40);
        portGuestText.setVisible(true);


        exitButton.setBounds(400,500,100,40);
        exitButton.setText("Exit");


        startButton.setBounds(530,500,100,40);
        startButton.setText("Start");


        jFrame.add(guestButton);
        jFrame.add(hostButton);
        jFrame.add(nameLabel);
        jFrame.add(hostPortLabel);
        jFrame.add(IPLabel);
        jFrame.add(portGuestLabel);
        jFrame.add(nameText);
        jFrame.add(hostPortText);
        jFrame.add(IPText);
        jFrame.add(portGuestText);
        jFrame.add(startButton);
        jFrame.add(exitButton);
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}


