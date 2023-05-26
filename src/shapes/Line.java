package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Line extends Shape{

    int Ax, Ay, Bx, By;

    public Line(int mouseClickedX, int mouseClickedY) {

        super(Color.BLACK, 4, mouseClickedX, mouseClickedY);
        Ax = mouseClickedX;
        Ay = mouseClickedY;
        Bx = mouseClickedX;
        By = mouseClickedY;
    }

    @Override
    public void shift(int shiftX, int shiftY) {

        Ax += shiftX;
        Bx += shiftX;
        Ay += shiftY;
        By += shiftY;
    }

    @Override
    public void draw(Graphics2D myGraphics2d) {

        myGraphics2d.setColor(selectedColor);
        myGraphics2d.setStroke(new BasicStroke(myThickness));
        myGraphics2d.drawLine(Ax, Ay, Bx, By);
    }

    @Override
    public void resize(int mouseClickedX, int mouseClickedY, int mouseReleasedX, int mouseReleasedY) {

        Ax = mouseClickedX;
        Ay = mouseClickedY;
        Bx = mouseReleasedX;
        By = mouseReleasedY;
    }

}
