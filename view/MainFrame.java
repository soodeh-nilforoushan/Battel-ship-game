package ir.aut.test.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by User on 6/4/2017.
 */
public class MainFrame extends JFrame {

    JFrame jFrame;
    JMenu file;
    JMenu help;
    JMenuBar jMenuBar;
    public MainFrame() throws AWTException, IOException {

        jFrame=new JFrame("My Game");
        jFrame.setLayout(null);
        jMenuBar =new JMenuBar();
        file=new JMenu("File");
        help=new JMenu("Help");
        jFrame.setJMenuBar(jMenuBar);
        jMenuBar.add(file);
        jMenuBar.add(help);

        jFrame.setSize(1400,1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BackGround backGround=new BackGround();
        jFrame.add(backGround.getGUI());
//        DragRectangle dragRectangle=new DragRectangle();
//        dragRectangle.setLocation(700,500);
//        jFrame.add(dragRectangle);
        jFrame.setVisible(true);

    }
}
