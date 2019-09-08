//package ir.aut.test.models;
//
//import ir.aut.test.view.DragRectangle;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Map {
//    DragRectangle.MyMouseAdapter dragRectangle;
//
//    public Map(DragRectangle.MyMouseAdapter dragRectangle) {
//        this.dragRectangle = dragRectangle;
//        textMap();
//    }
//
//
//
//    public void textMap() {
//        char[][] letters = new char[10][10];
//        FileOutputStream out = null;
//        Scanner read = null;
//        try {
//            read = new Scanner(new File("map.txt"));
//            out = new FileOutputStream("Map1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        while (read.hasNextLine()) {
//            for (int row = 0; row < letters.length; row++) {
//                String line = read.nextLine();
//
//                for (int col = 0; col < letters[row].length; col++) {
//                    letters[row][col] = line.charAt(col);
//
//
//                    //for conflict label
//                    if (row == dragRectangle.getR() && col == dragRectangle.getC()
//                            && (letters[dragRectangle.getR()][dragRectangle.getC()] == '1'))
////                            letters[dragRectangle.getR() + 1][dragRectangle.getC()] == '1' ||
////                            letters[dragRectangle.getR()][dragRectangle.getC() + 1] == '1' ||
////                            letters[dragRectangle.getR() - 1][dragRectangle.getC()] == '1' ||
////                            letters[dragRectangle.getR()][dragRectangle.getC() - 1] == '1' ||
////                            letters[dragRectangle.getR() + 1][dragRectangle.getC() + 1] == '1' ||
////                            letters[dragRectangle.getR() - 1][dragRectangle.getC() - 1] == '1' ||
////                            letters[dragRectangle.getR() + 1][dragRectangle.getC() - 1] == '1' ||
////                            letters[dragRectangle.getR() - 1][dragRectangle.getC() + 1] == '1'))
//                    {
//                        System.out.println("1");
//                        dragRectangle.getClickedPanel().add(dragRectangle.getDragLabel());
//                        dragRectangle.getClickedPanel().revalidate();
//
//                        //for empty home
//                    } else if (row == dragRectangle.getR() && col == dragRectangle.getC()
//                            && letters[dragRectangle.getR()][dragRectangle.getC()] == '0') {
//                        System.out.println("2");
//                        try {
//                            out.write(letters[dragRectangle.getR()][dragRectangle.getC()] = '1');
//                            out.write(letters[dragRectangle.getRowClicked()][dragRectangle.getColClicked()] = '0');
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                    else if (row == dragRectangle.getRowClicked() && col == dragRectangle.getColClicked())
//                        continue;
//                    else {
//                        try {
//                            System.out.println("3");
//                            out.write(letters[row][col]);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//    }
//}