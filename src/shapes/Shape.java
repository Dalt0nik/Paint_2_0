package shapes;
import java.awt.*;
import java.io.Serializable;




public abstract class Shape implements Resizeable, Cloneable, Serializable{

    public Color myColor, selectedColor;
    public boolean selected = false, filled = false;
    protected int myThickness, pointX, pointY;


    public Shape(int mouseClickedX, int mouseClickedY){

        this(Color.BLACK, 1, mouseClickedX, mouseClickedY);
    }

    public Shape(Color myColor, int myThickness, int mouseX, int mouseY){

        this.myColor = myColor;
        this.selectedColor = myColor;
        this.myThickness = myThickness;
        this.pointX = mouseX;
        this.pointY = mouseY;
    }

    public Shape clone() throws CloneNotSupportedException{

        Shape clone = (Shape) super.clone();
        //clone.myTest = (TestCloneable)myTest.clone();

        return clone;

    }

    public void select(boolean b){

        if(b == true){

        }
    }

    public abstract void shift(int shiftX, int shiftY);

    public abstract void draw(Graphics2D myGraphics2d);

    public abstract void resize(int mouseClickedX, int mouseClickedY, int mouseReleasedX, int mouseReleasedY);
}
