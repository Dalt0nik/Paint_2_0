package shapes;

import java.awt.*;

import Exceptions.WrongSizeException;

public class Rect extends Shape{

    private int height, width;


    //konstruktorius
    public Rect(int x, int y, int height, int width, int thickness, Color newColor, boolean filled){

        super(newColor, thickness, x, y);
        this.height = height;
        this.width = width;
        this.filled = filled;
    }

    public Rect(int mouseClickedX, int mouseClickedY, boolean filled){

        this(mouseClickedX, mouseClickedY, 0, 0, 2, Color.BLACK, filled);
    }

    //seteriai
    public void setHeight(int height) throws WrongSizeException{

        this.height = height;

        if(height <= 0){

            throw new WrongSizeException("height");
        }
    }

    public void setWidth(int width) throws WrongSizeException{

        this.width = width;

        if(height <= 0){

            throw new WrongSizeException("width");
        }
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
            myGraphics2d.drawRect(super.pointX, super.pointY, width, height);
        else
            myGraphics2d.fillRect(super.pointX, super.pointY, width, height);
    }

    @Override
    public void resize(int mouseClickedX, int mouseClickedY, int mouseReleasedX, int mouseReleasedY){

        this.pointX = mouseClickedX;
        this.pointY = mouseClickedY;
        this.width = mouseReleasedX-mouseClickedX;
        this.height = mouseReleasedY-mouseClickedY;

        if(mouseClickedX > mouseReleasedX){
            this.pointX = mouseReleasedX;
            this.width = mouseClickedX-mouseReleasedX;
        }
        if(mouseClickedY > mouseReleasedY){
            this.pointY = mouseReleasedY;
            this.height = mouseClickedY-mouseReleasedY;
        }

    }
}
