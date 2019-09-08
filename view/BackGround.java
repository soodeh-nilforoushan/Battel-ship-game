package ir.aut.test.view;

import ir.aut.test.models.TextFile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BackGround extends JPanel implements ActionListener, KeyListener {
    JPanel jPanel;
    JButton jButton[][] = new JButton[10][10];
    JButton reset = new JButton();
    JButton ready = new JButton();
    JButton rotate = new JButton();
    JButton buttonSize4 = new JButton();
    JButton buttonSize3 = new JButton();
    JButton buttonSize2 = new JButton();
    JButton buttonSize1 = new JButton();


    ArrayList<JButton> buttonArray = new ArrayList<>();

    boolean checkbutton1 = false;
    boolean checkbutton2 = false;
    boolean checkbutton3 = false;
    boolean checkbutton4 = false;
    boolean checkRotate = false;
    boolean ctrlPressed = false;
    boolean rPressed = false;
    int countButton1 = 0;
    int countButton2 = 0;
    int countButton3 = 0;
    int countButton4 = 0;

    //    int[] arraySize4 = new int[4];
//    int[] arraySize3 = new int[3];
//    int[] arraySize2 = new int[2];
    int rowLabelPlace1;
    int colLabelPlace1;
    int[] rowLabelPlace2 = new int[2];
    int[] colLabelPlace2 = new int[2];
    int[] rowLabelPlace3 = new int[3];
    int[] colLabelPlace3 = new int[3];
    int[] rowLabelPlace4 = new int[4];
    int[] colLabelPlace4 = new int[4];

    public BackGround() {
        jPanel = new JPanel();
        jPanel.setSize(900, 1000);
        drawJbuttons();
        drawShips();
        extraButtons();
    }

    public void drawJbuttons() {
        int x = 0, y = -50;
        for (int i = 0; i < 10; i++) {
            y += 50;
            for (int j = 0; j < 10; j++) {
                jButton[i][j] = new JButton();
                if (y == 500) {
                    y = 0;
                }
                if (x == 500) {
                    x = 0;
                }
                jButton[i][j].setBounds(200 + x, 100 + y, 50, 50);
                x += 50;
                jButton[i][j].setBackground(new Color(255, 255, 255));
                jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                jButton[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
                jPanel.add(jButton[i][j]);
                jButton[i][j].addActionListener(this);
            }
        }
        jPanel.setVisible(true);
        jPanel.setLayout(null);
    }

    public void drawShips() {
        JLabel one = new JLabel("* 4");
        JLabel two = new JLabel("* 3");
        JLabel three = new JLabel("* 2");
        JLabel four = new JLabel("* 1");
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        jPanel.setBorder(border);
        buttonSize4.setBackground(new Color(255, 204, 229));
        buttonSize4.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
        buttonSize4.setBounds(100, 650, 200, 50);
        four.setBounds(340, 650, 50, 50);
        buttonSize4.addActionListener(this);
        jPanel.add(four);
        jPanel.add(buttonSize4);

        buttonSize3.setBackground(new Color(255, 255, 204));
        buttonSize3.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
        buttonSize3.setBounds(100, 710, 150, 50);
        three.setBounds(340, 710, 50, 50);
        buttonSize3.addActionListener(this);
        jPanel.add(buttonSize3);
        jPanel.add(three);

        buttonSize2.setBackground(new Color(204, 255, 204));
        buttonSize2.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 0)));
        buttonSize2.setBounds(100, 770, 100, 50);
        two.setBounds(340, 770, 50, 50);
        buttonSize2.addActionListener(this);
        jPanel.add(buttonSize2);
        jPanel.add(two);

        buttonSize1.setBackground(new Color(229, 204, 255));
        buttonSize1.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 204)));
        buttonSize1.setBounds(100, 830, 50, 50);
        one.setBounds(340, 830, 50, 50);
        buttonSize1.addActionListener(this);
        jPanel.add(buttonSize1);
        jPanel.add(one);

    }

    public void extraButtons() {
        ready.setBackground(new Color(204, 255, 255));
        ready.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        ready.setBounds(600, 800, 80, 50);
        ready.setText("ready");
        jPanel.add(ready);
        ready.addActionListener(this);

        reset.setBackground(new Color(204, 255, 255));
        reset.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        reset.setBounds(690, 800, 80, 50);
        reset.setText("reset");
        jPanel.add(reset);
        reset.addActionListener(this);

        rotate.setBackground(new Color(204, 255, 255));
        rotate.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        rotate.setBounds(780, 800, 80, 50);
        rotate.setText("rotate");
        jPanel.add(rotate);
        rotate.addActionListener(this);

    }


    public JComponent getGUI() {
        return jPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSize1) {
            checkbutton1 = true;
        } else if (e.getSource() == buttonSize2) {
            checkbutton2 = true;
        } else if (e.getSource() == buttonSize3) {
            checkbutton3 = true;
        } else if (e.getSource() == buttonSize4) {
            checkbutton4 = true;

        } else if (e.getSource() == ready) {
            //todo
        } else if (e.getSource() == reset) {
            jPanel.repaint();
            jPanel.revalidate();
            //todo
        } else if (e.getSource() == rotate) {
            checkRotate = true;
        }

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {

                JButton buttonPressed = (JButton) e.getSource();

                /**its for clear the vertical ship
                 */
                if (jButton[i][j] == buttonPressed &&
                        jButton[i][j].getBackground().getRed() == 229 &&
                        jButton[i][j].getBackground().getGreen() == 204 &&
                        jButton[i][j].getBackground().getBlue() == 255) {
                    jButton[i][j].setBackground(Color.WHITE);
                    jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    countButton1--;
                } else if (jButton[i][j] == buttonPressed &&
                        jButton[i][j].getBackground().getRed() == 204 &&
                        jButton[i][j].getBackground().getGreen() == 255 &&
                        jButton[i][j].getBackground().getBlue() == 204 &&
                        jButton[i + 1][j].getBackground().getRed() == 204 &&
                        jButton[i + 1][j].getBackground().getGreen() == 255 &&
                        jButton[i + 1][j].getBackground().getBlue() == 204) {
                    jButton[i][j].setBackground(Color.WHITE);
                    jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i + 1][j].setBackground(Color.WHITE);
                    jButton[i + 1][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    countButton2--;

                } else if (jButton[i][j] == buttonPressed &&
                        jButton[i][j].getBackground().getRed() == 255 &&
                        jButton[i][j].getBackground().getGreen() == 255 &&
                        jButton[i][j].getBackground().getBlue() == 204 &&
                        jButton[i + 1][j].getBackground().getRed() == 255 &&
                        jButton[i + 1][j].getBackground().getGreen() == 255 &&
                        jButton[i + 1][j].getBackground().getBlue() == 204 &&
                        jButton[i + 2][j].getBackground().getRed() == 255 &&
                        jButton[i + 2][j].getBackground().getGreen() == 255 &&
                        jButton[i + 2][j].getBackground().getBlue() == 204) {
                    jButton[i][j].setBackground(Color.WHITE);
                    jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i + 1][j].setBackground(Color.WHITE);
                    jButton[i + 1][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i + 2][j].setBackground(Color.WHITE);
                    jButton[i + 2][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    countButton3--;
                } else if (jButton[i][j] == buttonPressed &&
                        jButton[i][j].getBackground().getRed() == 255 &&
                        jButton[i][j].getBackground().getGreen() == 204 &&
                        jButton[i][j].getBackground().getBlue() == 229 &&
                        jButton[i + 1][j].getBackground().getRed() == 255 &&
                        jButton[i + 1][j].getBackground().getGreen() == 204 &&
                        jButton[i + 1][j].getBackground().getBlue() == 229 &&
                        jButton[i + 2][j].getBackground().getRed() == 255 &&
                        jButton[i + 2][j].getBackground().getGreen() == 204 &&
                        jButton[i + 2][j].getBackground().getBlue() == 229 &&
                        jButton[i + 3][j].getBackground().getRed() == 255 &&
                        jButton[i + 3][j].getBackground().getGreen() == 204 &&
                        jButton[i + 3][j].getBackground().getBlue() == 229) {
                    jButton[i][j].setBackground(Color.WHITE);
                    jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i + 1][j].setBackground(Color.WHITE);
                    jButton[i + 1][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i + 2][j].setBackground(Color.WHITE);
                    jButton[i + 2][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i + 3][j].setBackground(Color.WHITE);
                    jButton[i + 3][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    countButton4--;


/**
 * its for clear horizontal ships
 */
                } else if (jButton[i][j] == buttonPressed &&
                        jButton[i][j].getBackground().getRed() == 204 &&
                        jButton[i][j].getBackground().getGreen() == 255 &&
                        jButton[i][j].getBackground().getBlue() == 204) {
                    jButton[i][j].setBackground(Color.WHITE);
                    jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i][j + 1].setBackground(Color.WHITE);
                    jButton[i][j + 1].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    countButton2--;


                } else if (jButton[i][j] == buttonPressed &&
                        jButton[i][j].getBackground().getRed() == 255 &&
                        jButton[i][j].getBackground().getGreen() == 255 &&
                        jButton[i][j].getBackground().getBlue() == 204) {
                    jButton[i][j].setBackground(Color.WHITE);
                    jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i][j + 1].setBackground(Color.WHITE);
                    jButton[i][j + 1].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i][j + 2].setBackground(Color.WHITE);
                    jButton[i][j + 2].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    countButton3--;
                } else if (jButton[i][j] == buttonPressed &&
                        jButton[i][j].getBackground().getRed() == 255 &&
                        jButton[i][j].getBackground().getGreen() == 204 &&
                        jButton[i][j].getBackground().getBlue() == 229) {
                    jButton[i][j].setBackground(Color.WHITE);
                    jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i][j + 1].setBackground(Color.WHITE);
                    jButton[i][j + 1].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i][j + 2].setBackground(Color.WHITE);
                    jButton[i][j + 2].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    jButton[i][j + 3].setBackground(Color.WHITE);
                    jButton[i][j + 3].setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
                    countButton4--;
                }

                /**
                 * its for drop the label
                 */
                else if (jButton[i][j] == e.getSource()) {
                    if (checkbutton1 == true && countButton1 < 4) {
                        jButton[i][j].setBackground(new Color(229, 204, 255));
                        jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(102, 0, 204)));
                        rowLabelPlace1 = i;
                        colLabelPlace1 = j;
                        checkbutton1 = false;
                        buttonArray.add(jButton[i][j]);
                        countButton1++;
                        TextFile textFile = new TextFile(this);
                        textFile.textMap();
                    } else if (checkbutton2 == true && checkRotate == false && countButton2 < 3) {
                        if (i == 9) {
                            handleCorner();
                            break;
                        }
                        jButton[i][j].setBackground(new Color(204, 255, 204));
                        jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 204, 0)));
                        rowLabelPlace2[0] = i;
                        colLabelPlace2[0] = j;
//                        System.out.println(i+"   "+j);
                        jButton[i + 1][j].setBackground(new Color(204, 255, 204));
                        jButton[i + 1][j].setBorder(BorderFactory.createLineBorder(new Color(0, 204, 0)));
                        rowLabelPlace2[1] = i + 1;
                        colLabelPlace2[1] = j;
//                        System.out.println(i+1+"       "+j);
                        checkbutton2 = false;
                        countButton2++;
                        TextFile textFile = new TextFile(this);
                        textFile.textMap2();

                    } else if (checkbutton3 == true && checkRotate == false && countButton3 < 2) {
                        if (i >= 8) {
                            handleCorner();
                            break;
                        }
                        jButton[i][j].setBackground(new Color(255, 255, 204));
                        jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
                        rowLabelPlace3[0] = i;
                        colLabelPlace3[0] = j;

                        jButton[i + 1][j].setBackground(new Color(255, 255, 204));
                        jButton[i + 1][j].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
                        rowLabelPlace3[1] = i + 1;
                        colLabelPlace3[1] = j;
                        jButton[i + 2][j].setBackground(new Color(255, 255, 204));
                        jButton[i + 2][j].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
                        rowLabelPlace3[2] = i + 2;
                        colLabelPlace3[2] = j;
                        checkbutton3 = false;
                        buttonArray.add(jButton[i][j]);
                        countButton3++;
                        TextFile textFile = new TextFile(this);
                        textFile.textMap3();
                    } else if (checkbutton4 == true && checkRotate == false && countButton4 < 1) {
                        if (i >= 7) {
                            handleCorner();
                            break;
                        }
                        jButton[i][j].setBackground(new Color(255, 204, 229));
                        jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[0] = i;
                        colLabelPlace4[0] = j;
                        jButton[i + 1][j].setBackground(new Color(255, 204, 229));
                        jButton[i + 1][j].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[1] = i + 1;
                        colLabelPlace4[1] = j;
                        jButton[i + 2][j].setBackground(new Color(255, 204, 229));
                        jButton[i + 2][j].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[2] = i + 2;
                        colLabelPlace4[2] = j;
                        jButton[i + 3][j].setBackground(new Color(255, 204, 229));
                        jButton[i + 3][j].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[3] = i + 3;
                        colLabelPlace4[3] = j;
                        checkbutton4 = false;
                        countButton4++;
                        buttonArray.add(jButton[i][j]);
                        TextFile textFile = new TextFile(this);
                        textFile.textMap4();

                        /**
                         * its for rotate the label
                         */
                    } else if (checkbutton2 == true && checkRotate == true && countButton2 < 3) {
                        if (j == 9) {
                            handleCorner();
                            break;
                        }
                        jButton[i][j].setBackground(new Color(204, 255, 204));
                        jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 204, 0)));
                        rowLabelPlace2[0] = i;
                        colLabelPlace2[0] = j;
                        jButton[i][j + 1].setBackground(new Color(204, 255, 204));
                        jButton[i][j + 1].setBorder(BorderFactory.createLineBorder(new Color(0, 204, 0)));
                        rowLabelPlace2[1] = i;
                        colLabelPlace2[1] = j+1;
                        checkRotate = false;
                        countButton2++;
                        TextFile textFile = new TextFile(this);
                        textFile.textMap2();

                    } else if (checkbutton3 == true && checkRotate == true && countButton3 < 2) {
                        if (j >= 8) {
                            handleCorner();
                            break;
                        }
                        jButton[i][j].setBackground(new Color(255, 255, 204));
                        jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
                        rowLabelPlace3[0] = i;
                        colLabelPlace3[0] = j+1;
                        jButton[i][j + 1].setBackground(new Color(255, 255, 204));
                        jButton[i][j + 1].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
                        rowLabelPlace3[1] = i;
                        colLabelPlace3[1] = j+1;
                        jButton[i][j + 2].setBackground(new Color(255, 255, 204));
                        jButton[i][j + 2].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0)));
                        rowLabelPlace3[2] = i;
                        colLabelPlace3[2] = j+2;
                        checkRotate = false;
                        countButton3++;
                        TextFile textFile = new TextFile(this);
                        textFile.textMap3();
                    } else if (checkbutton4 == true && checkRotate == true && countButton4 < 1) {
                        if (j >= 7) {
                            handleCorner();
                            break;
                        }
                        jButton[i][j].setBackground(new Color(255, 204, 229));
                        jButton[i][j].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[0] = i;
                        colLabelPlace4[0] = j;
                        jButton[i][j + 1].setBackground(new Color(255, 204, 229));
                        jButton[i][j + 1].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[1] = i;
                        colLabelPlace4[1] = j+1;
                        jButton[i][j + 2].setBackground(new Color(255, 204, 229));
                        jButton[i][j + 2].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[2] = i;
                        colLabelPlace4[2] = j+2;
                        jButton[i][j + 3].setBackground(new Color(255, 204, 229));
                        jButton[i][j + 3].setBorder(BorderFactory.createLineBorder(new Color(204, 0, 102)));
                        rowLabelPlace4[3] = i;
                        colLabelPlace4[3] = j+3;
                        countButton4++;
                        TextFile textFile = new TextFile(this);
                        textFile.textMap4();

                    }
                }
            }
        }
    }

    private void handleCorner() {
        JOptionPane.showMessageDialog(new JFrame(), "Position is not correct!");
    }

    public int getRowLabelPlace() {
        return rowLabelPlace1;
    }

    public int getColLabelPlace() {
        return colLabelPlace1;
    }

    public int[] getRowLabelPlace2() {
        return rowLabelPlace2;
    }

    public int[] getColLabelPlace2() {
        return colLabelPlace2;
    }

    public int[] getRowLabelPlace3() {
        return rowLabelPlace3;
    }

    public int[] getColLabelPlace3() {
        return colLabelPlace3;
    }

    public int[] getRowLabelPlace4() {
        return rowLabelPlace4;
    }

    public int[] getColLabelPlace4() {
        return colLabelPlace4;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == (KeyEvent.VK_R)) {
            rPressed = true;
            System.out.println("hh");
        }
        if (e.getKeyCode() == (KeyEvent.VK_CONTROL))
            ctrlPressed = true;
        if (ctrlPressed && rPressed)
            checkRotate = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


