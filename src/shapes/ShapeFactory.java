package shapes;

public class ShapeFactory{

    public Shape create(String shapeName, int mouseClickedX, int mouseClickedY, boolean filled) {
        // TODO Auto-generated method stub

        if(shapeName == "Rectangle")
            return new Rect(mouseClickedX, mouseClickedY, filled);
        else if (shapeName == "Circle")
            return new Circle(filled);
        else if (shapeName == "Line")
            return new Line(mouseClickedX, mouseClickedY);
        else
            return null;

    }

}
