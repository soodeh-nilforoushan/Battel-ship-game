package ir.aut.test.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Soudabeh on 7/9/2017.
 */
public class GuestList extends JFrame {


    JFrame jFrame;
    JPanel jPanel;
    JLabel nameLabel;
    JButton rejectButton, acceptButton;
    JList<JPanel> jList;
     JScrollBar jScrollBar;


    public GuestList(String name) {

        jFrame = new JFrame();
        jPanel = new JPanel();
        nameLabel = new JLabel();
        rejectButton = new JButton();
        acceptButton = new JButton();
        jList= new JList();
        // jScrollBar= new JScrollBar();



        //  jFrame.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        jPanel.setLayout(null);
        jFrame.setBounds(200, 200, 450, 600);
        jPanel.setBounds(0, 0, 100, 70);
        nameLabel.setText(name);
        nameLabel.setBounds(10, 10, 100, 30);
        // jScrollBar.setBounds(400,0,30,600);

        rejectButton.setBounds(200, 60, 100, 30);
        rejectButton.setText("reject");

        acceptButton.setBounds(310, 60, 100, 30);
        acceptButton.setText("accept");

        jPanel.add(nameLabel);
        jPanel.add(rejectButton);
        jPanel.add(acceptButton);
        jList.add(jPanel);
        jFrame.add(jList);
        //  jFrame.add(jScrollBar);
        jFrame.setVisible(true);


    }

}
