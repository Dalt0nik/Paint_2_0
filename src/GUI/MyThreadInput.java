package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import javax.swing.SwingUtilities;

import shapes.Shape;

public class MyThreadInput extends Thread{

    MyPanel panel;
    File file;

    public MyThreadInput(MyPanel panel, File file){

        this.panel = panel;
        this.file = file;
    }

    @Override
    public void run(){


        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis);) {

            LinkedList<Shape> loadedShapeList = (LinkedList) ois.readObject();

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    panel.shapes = loadedShapeList;
                    panel.initColors();
                    panel.repaint();
                }
            });
        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

}
