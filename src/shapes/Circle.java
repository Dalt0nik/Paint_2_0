package shapes;

import java.awt.*;

public class Circle extends Shape{

    private int radius;

    public Circle(boolean filled){

        this(100, 100, 0, 5, Color.BLACK, filled);
    }

    //konstruktorius
    public Circle(int x, int y, int radius, int thickness, Color newColor, boolean filled){

        super(newColor, thickness, x, y);
        this.radius = radius;
        this.filled = filled;
    }

    //seteriai
    public void setRadius(int radius){

        this.radius = radius;
    }


    public void shift(int shiftX, int shiftY){

        pointX += shiftX;
        pointY += shiftY;
    }


    @Override
    public void draw(Graphics2D myGraphics2d){

        myGraphics2d.setColor(selectedColor);
        myGraphics2d.setStroke(new BasicStroke(myThickness));
        if(!filled)
            myGraphics2d.drawOval(pointX-radius, pointY-radius, radius*2, radius*2);
        else
            myGraphics2d.fillOval(pointX-radius, pointY-radius, radius*2, radius*2);
    }


    @Override
    public void resize(int mouseClickedX, int mouseClickedY, int mouseReleasedX, int mouseReleasedY){

        pointX = mouseClickedX;
        pointY = mouseClickedY;
        double absX = (double)Math.abs(mouseReleasedX-mouseClickedX);
        double absY = (double)Math.abs(mouseReleasedY-mouseClickedY);

        radius = (int)(Math.sqrt((Math.pow(absX, 2.0))+(Math.pow(absY, 2.0))));
    }

    @Override
    public String toString() {

        return "radius: "+radius+'\n';
    }

}
