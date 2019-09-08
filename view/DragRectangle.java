package ir.aut.test.view;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

/**
 * Created by User on 6/4/2017.
 */
public class DragRectangle extends JLayeredPane {
    private static final int width = 500;
    private static final int height = 500;
    private static final int gridRows = 10;
    private static final int gridCols = 10;
    private static final int gap = 1;
    private static final Dimension layeredPaneSize = new Dimension(width, height);
    private static final Dimension lableSize = new Dimension(50, 50);
    //creates a grid layout with the given rows and columns
    // alongwith given horizontal and vertical gaps.
    private GridLayout gridLayout = new GridLayout(gridRows, gridCols, gap, gap);
    private JPanel backingPanel = new JPanel(gridLayout);
    private JPanel[][] panelGrid = new JPanel[gridCols][gridRows];
    private JLabel labelSize4 = new JLabel();
    private JLabel[] labelSize3 = new JLabel[2];
    private JLabel[] labelSize2 = new JLabel[3];
    private JLabel[] labelSize1 = new JLabel[4];
    private int r = -1;
    private int c = -1;
    private int rowClicked=-1;
    private int colClicked=-1;
    private JPanel clickedPanel = null;
    private JLabel dragLabel = null;
    private Shape shapes[] = new Shape[10];
    private JButton[][] jButtons = new JButton[10][10];


    public DragRectangle() {

    }

    public void backGroundPanel() {

        backingPanel.setSize(layeredPaneSize);
        backingPanel.setBackground(Color.BLUE);
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                panelGrid[i][j] = new JPanel(new GridBagLayout());
//                jButtons[i][j]=new JButton();
//                jButtons[i][j].setSize(new Dimension(50,50));
//                add(jButtons[i][j],JLayeredPane.MODAL_LAYER);
                backingPanel.add(panelGrid[i][j]);
//                panelGrid[i][j].add(jButtons[i][j]);

            }
        }
        drawLables();


//in be hashie aslie bazi dor mide(ba ghotr haye 1)
        backingPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(layeredPaneSize);
        add(backingPanel, JLayeredPane.DEFAULT_LAYER);
        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);

    }

    public void drawLables() {
        for (int i = 0; i < 4; i++) {
            labelSize1[i] = new JLabel();
            labelSize1[i].setOpaque(true);
            labelSize1[i].setBackground(Color.CYAN);
            labelSize1[i].setMinimumSize(lableSize);
            labelSize1[i].setBorder(BorderFactory.createLineBorder(Color.black));
            labelSize1[i].setPreferredSize(lableSize);
        }
//        jButtons[0][1].add(labelSize1[0]);
//        jButtons[0][9].add(labelSize1[1]);
//        jButtons[1][7].add(labelSize1[2]);
//        jButtons[3][9].add(labelSize1[3]);
        panelGrid[0][1].add(labelSize1[0]);
        panelGrid[0][9].add(labelSize1[1]);
        panelGrid[1][7].add(labelSize1[2]);
        panelGrid[3][7].add(labelSize1[3]);

        for (int i = 0; i < 3; i++) {
            labelSize2[i] = new JLabel();
            labelSize2[i].setOpaque(true);
            labelSize2[i].setBackground(Color.CYAN);
            labelSize2[i].setMinimumSize(new Dimension(100, 50));
            labelSize2[i].setBorder(BorderFactory.createLineBorder(Color.black));
            labelSize2[i].setPreferredSize(new Dimension(100, 50));

        }
        panelGrid[5][7].add(labelSize2[0]);
        panelGrid[6][4].add(labelSize2[1]);
        panelGrid[7][0].add(labelSize2[2]);

        labelSize4.setOpaque(true);
        labelSize4.setBackground(Color.PINK);
        labelSize4.setPreferredSize(lableSize);
        panelGrid[0][0].add(labelSize4);
//  todo : bara lable 2 tai che konam?  panelGrid[][]
    }


    public class MyMouseAdapter extends MouseAdapter {

        private int dragLabelWidthDiv2;
        private int dragLabelHeightDiv2;


        @Override
        public void mousePressed(MouseEvent m) {
            //the first home that clicked
            clickedPanel = (JPanel) backingPanel.getComponentAt(m.getPoint());
            Component[] components = clickedPanel.getComponents();
            if (components.length == 0) {
                return;
            }
            // if we click on jpanel that holds a jlabel
            if (components[0] instanceof JLabel) {
                dragLabel = (JLabel) components[0];
                clickedPanel.remove(dragLabel);
                clickedPanel.revalidate();
                clickedPanel.repaint();
                dragLabelWidthDiv2 = dragLabel.getWidth() / 2;
                dragLabelHeightDiv2 = dragLabel.getHeight() / 2;

                searchPanelGrid:
                for (int row = 0; row < panelGrid.length; row++) {
                    for (int col = 0; col < panelGrid[row].length; col++) {
                        if (panelGrid[row][col] == clickedPanel) {
                            rowClicked = row;
                            colClicked = col;
                            break searchPanelGrid;
                        }
                    }
                }
                System.out.println(rowClicked+ " " + colClicked);

                int x = m.getPoint().x - dragLabelHeightDiv2;
                int y = m.getPoint().y - dragLabelHeightDiv2;
                dragLabel.setLocation(x, y);
                add(dragLabel, JLayeredPane.DRAG_LAYER);

                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent me) {
            if (dragLabel == null) {
                return;
            }
            int x = me.getPoint().x - dragLabelWidthDiv2;
            int y = me.getPoint().y - dragLabelHeightDiv2;
            dragLabel.setLocation(x, y);
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (dragLabel == null) {
                return;
            }
            remove(dragLabel); // remove dragLabel for drag layer of JLayeredPane
            JPanel droppedPanel = (JPanel) backingPanel.getComponentAt(me.getPoint());
            if (droppedPanel == null) {
                // if off the grid, return label to home
                clickedPanel.add(dragLabel);
                clickedPanel.revalidate();
            } else {
//                int r = -1;
//                int c = -1;
                searchPanelGrid:
                for (int row = 0; row < panelGrid.length; row++) {
                    for (int col = 0; col < panelGrid[row].length; col++) {
                        if (panelGrid[row][col] == droppedPanel) {
                            r = row;
                            c = col;
                            break searchPanelGrid;
                        }
                    }
                }
                System.out.println(r + " " + c);
                System.out.println(droppedPanel.isDoubleBuffered());
                if (r == -1 || c == -1) {
                    // if off the grid, return label to home
                    clickedPanel.add(dragLabel);
                    clickedPanel.revalidate();
                    System.out.println("inja");
                } else {
                    droppedPanel.add(dragLabel);
                    droppedPanel.revalidate();
                    System.out.println("injaaaaa");
                }
            }

            repaint();
            dragLabel = null;
//            Map map = new Map(this);
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public JPanel getClickedPanel() {
            return clickedPanel;
        }

        public JLabel getDragLabel() {
            return dragLabel;
        }

        public int getRowClicked() {
            return rowClicked;
        }
        public int getColClicked() {
            return colClicked;
        }
    }

}

