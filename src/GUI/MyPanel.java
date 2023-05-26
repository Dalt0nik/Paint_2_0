package GUI;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import shapes.*;


public class MyPanel extends JPanel {

    public int x,y;

    public MyPanel(){

    }

    public LinkedList<Shape> shapes = new LinkedList<Shape>();

    public void initColors(){

        for(int i = 0; i < shapes.size(); i++){

            shapes.get(i).selectedColor = shapes.get(i).myColor;
        }
    }

    public void addShape(String shapeName, int mouseClickedX, int mouseClickedY, boolean filled){

        ShapeFactory myShapeFactory = new ShapeFactory();
        shapes.add(myShapeFactory.create(shapeName, mouseClickedX, mouseClickedY, filled));

    }

    public void duplicateShape(int i){

        try {
            Shape duplicatedShape = shapes.get(i).clone();
            shapes.add(duplicatedShape);

            shapes.get(shapes.size()-1).shift(50,50);
            shapes.get(shapes.size()-1).selectedColor = shapes.get(shapes.size()-1).myColor;

            this.repaint();

        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteShape(int i){

        shapes.remove(i);
        this.repaint();
    }

    public void resizeTopShape(int mouseClickedX, int mouseClickedY, int mouseReleasedX, int mouseReleasedY){

        shapes.get(shapes.size()-1).resize(mouseClickedX, mouseClickedY, mouseReleasedX, mouseReleasedY);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D myGraphics2d = (Graphics2D) g;

        for(Shape shapeToDraw : shapes){

            shapeToDraw.draw(myGraphics2d);
        }

    }
}


