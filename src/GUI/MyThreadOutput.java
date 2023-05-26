package GUI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import shapes.Shape;

public class MyThreadOutput extends Thread{

    LinkedList<Shape> clonedShapeList;
    File file;

    public MyThreadOutput(LinkedList<Shape> clonedShapeList, File file){

        this.clonedShapeList = clonedShapeList;
        this.file = file;
    }

    @Override
    public void run(){



        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(clonedShapeList);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
