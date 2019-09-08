package ir.aut.test.models;

import ir.aut.test.view.BackGround;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextFile {

    BackGround backGround;

    char[][] letters = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}};
    FileOutputStream out = null;
    Scanner read = null;

    public TextFile(BackGround backGround) {
        this.backGround = backGround;
    }

    public void readMap() {
        try {
            read = new Scanner(new File("map.txt"));
            out = new FileOutputStream("map.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (read.hasNextLine()) {
            for (int row = 0; row < letters.length; row++) {
                String line = read.nextLine();
                System.out.println(line);
                for (int col = 0; col < letters[row].length; col++) {
                    letters[row][col] = line.charAt(col);

                }
            }
        }
    }

    public void textMap() {
        readMap();
        while (read.hasNextLine()) {
            for (int row = 0; row < letters.length; row++) {
                String line = read.nextLine();
                for (int col = 0; col < letters[row].length; col++) {
                    letters[row][col] = line.charAt(col);
                    if (letters[backGround.getRowLabelPlace()][backGround.getColLabelPlace()] == '0'
//                            row == backGround.getRowLabelPlace() && col == backGround.getColLabelPlace()
                            )

                        letters[backGround.getRowLabelPlace()][backGround.getColLabelPlace()] = '1';


                }
            }
            writeMap();
        }
    }
    public void textMap2() {
        readMap();
        if (letters[backGround.getRowLabelPlace2()[0]][backGround.getColLabelPlace2()[0]] == '0' &&
                letters[backGround.getRowLabelPlace2()[1]][backGround.getColLabelPlace2()[1]] == '0'
//                            row == backGround.getRowLabelPlace2()[0] && col == backGround.getColLabelPlace2()[0] &&
//                            row+1 == backGround.getRowLabelPlace2()[1] && col == backGround.getColLabelPlace2()[1]
                ) {
            letters[backGround.getRowLabelPlace2()[0]][backGround.getColLabelPlace2()[0]] = '1';
            letters[backGround.getRowLabelPlace2()[1]][backGround.getColLabelPlace2()[1]] = '1';
        }
        writeMap();
    }


    public void textMap3() {
        System.out.println("3");
        readMap();
//        if (
//                letters[backGround.getRowLabelPlace2()[0]][backGround.getColLabelPlace2()[0]] == '0' &&
//                        letters[backGround.getRowLabelPlace2()[1]][backGround.getColLabelPlace2()[1]] == '0'
////                            row == backGround.getRowLabelPlace2()[0] && col == backGround.getColLabelPlace2()[0] &&
////                            row+1 == backGround.getRowLabelPlace2()[1] && col == backGround.getColLabelPlace2()[1]
//                ) {
        letters[backGround.getRowLabelPlace3()[0]][backGround.getColLabelPlace3()[0]] = '1';
        letters[backGround.getRowLabelPlace3()[1]][backGround.getColLabelPlace3()[1]] = '1';
        letters[backGround.getRowLabelPlace3()[2]][backGround.getColLabelPlace3()[2]] = '1';

        writeMap();
    }

    public void textMap4() {
        System.out.println("FFF");
        readMap();
//        if (
//                letters[backGround.getRowLabelPlace2()[0]][backGround.getColLabelPlace2()[0]] == '0' &&
//                        letters[backGround.getRowLabelPlace2()[1]][backGround.getColLabelPlace2()[1]] == '0'
////                            row == backGround.getRowLabelPlace2()[0] && col == backGround.getColLabelPlace2()[0] &&
////                            row+1 == backGround.getRowLabelPlace2()[1] && col == backGround.getColLabelPlace2()[1]
//                ) {
        letters[backGround.getRowLabelPlace4()[0]][backGround.getColLabelPlace4()[0]] = '1';
        letters[backGround.getRowLabelPlace4()[1]][backGround.getColLabelPlace4()[1]] = '1';
        letters[backGround.getRowLabelPlace4()[2]][backGround.getColLabelPlace4()[2]] = '1';
        letters[backGround.getRowLabelPlace4()[3]][backGround.getColLabelPlace4()[3]] = '1';

        writeMap();
    }

    public void writeMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
//                    System.out.println('A');
//                    System.out.println(letters[i][j]);
                    out.write(letters[i][j]);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            char c='\n';
            try {
                out.write(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

