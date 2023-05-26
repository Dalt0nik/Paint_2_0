package GUI;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;


public class MyFrame extends JFrame implements MouseListener, MouseMotionListener{

    MyPanel panel;
    public JToggleButton buttonRectangle, buttonCircle, buttonRectangleFilled, buttonCircleFilled, buttonLine, editShape;
    public JButton buttonLeft, buttonRight, buttonDuplicate, buttonDelete, buttonSave, buttonLoad;
    public Icon rectIcon, circleIcon, rectSelectedIcon, circleSelectedIcon, rectFilledIcon, circleFilledIcon,
            rectFilledSelectedIcon, circleFilledSelectedIcon, lineIcon, lineSelectedIcon;


    public int mouseClickedX, mouseClickedY, mouseReleasedX, mouseReleasedY;
    public int shapeSelector = 0, scrollIterator = 0, editBlockY = 300;
    public boolean filled = false;

    ButtonGroup shapeButtons = new ButtonGroup();

    public String[] shapeNames = {"Rectangle", "Circle", "Line"};

    public MyFrame(){

        this.setBackground(Color.black);

        setPanel();
        setIcons();
        setShapeButtons();
        setShapeScrollButtons();
        setShapeActionButtons();
        setFileButtons();

        setButtonListeners();

        this.setSize(1000, 800);
        this.setLayout(null);

        this.add(panel);


        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        panel.addMouseListener(this); //adding mouse listener to panel component
        panel.addMouseMotionListener(this);
    }

    private void setShapeButtons(){

        buttonRectangle = new JToggleButton(rectIcon, true);
        buttonCircle = new JToggleButton(circleIcon);
        buttonRectangleFilled = new JToggleButton(rectFilledIcon, true);
        buttonCircleFilled = new JToggleButton(circleFilledIcon);
        buttonLine = new JToggleButton(lineIcon);

        // | -10- | | -5- | | -10- |
        buttonRectangle.setBounds(10, 120, 45, 45);
        buttonCircle.setBounds(65, 120, 45, 45);
        buttonRectangleFilled.setBounds(10, 175, 45, 45);
        buttonCircleFilled.setBounds(65, 175, 45, 45);
        buttonLine.setBounds(10, 230, 45, 45);

        buttonRectangle.setSelectedIcon(rectSelectedIcon);
        buttonCircle.setSelectedIcon(circleSelectedIcon);
        buttonRectangleFilled.setSelectedIcon(rectFilledSelectedIcon);
        buttonCircleFilled.setSelectedIcon(circleFilledSelectedIcon);
        buttonLine.setSelectedIcon(lineSelectedIcon);

        this.add(buttonRectangle);
        this.add(buttonCircle);
        this.add(buttonRectangleFilled);
        this.add(buttonCircleFilled);
        this.add(buttonLine);

        shapeButtons.add(buttonRectangle);
        shapeButtons.add(buttonCircle);
        shapeButtons.add(buttonRectangleFilled);
        shapeButtons.add(buttonCircleFilled);
        shapeButtons.add(buttonLine);
    }

    private void setShapeScrollButtons(){

        editShape = new JToggleButton("Edit");
        buttonLeft = new JButton("L");
        buttonRight = new JButton("R");

        editShape.setBounds(10, editBlockY, 100, 30);
        buttonLeft.setBounds(10, editBlockY+35, 45, 30);
        buttonRight.setBounds(65, editBlockY+35, 45, 30);

        buttonLeft.setVisible(false);
        buttonRight.setVisible(false);

        shapeButtons.add(editShape);

        this.add(editShape);
        this.add(buttonLeft);
        this.add(buttonRight);
    }

    private void setShapeActionButtons(){

        buttonDuplicate = new JButton("Clone");
        buttonDelete = new JButton("Delete");

        buttonDuplicate.setBounds(10, editBlockY + 90, 100, 30);
        buttonDelete.setBounds(10, editBlockY + 125, 100, 30);

        buttonDuplicate.setVisible(false);
        buttonDelete.setVisible(false);

        this.add(buttonDuplicate);
        this.add(buttonDelete);
    }

    private void setFileButtons(){

        buttonSave = new JButton("Save");
        buttonLoad = new JButton("Load");

        buttonSave.setBounds(120, 25, 80, 30);
        buttonLoad.setBounds(205, 25, 80, 30);

        this.add(buttonSave);
        this.add(buttonLoad);
    }

    private boolean shapeExist(){

        if(panel.shapes.size() > 0)
            return true;
        else
            return false;
    }

    private boolean isDrawable(){

        return (buttonRectangle.isSelected() || buttonCircle.isSelected() || buttonCircleFilled.isSelected() || buttonRectangleFilled.isSelected() || buttonLine.isSelected());
    }

    private void enableButtons(){

        if(isDrawable()){

            buttonLeft.setVisible(false);
            buttonRight.setVisible(false);
            buttonDuplicate.setVisible(false);
            buttonDelete.setVisible(false);

            if(panel.shapes.size() != 0){

                panel.shapes.get(scrollIterator).selectedColor = panel.shapes.get(scrollIterator).myColor;
                panel.repaint();
            }

        }

        else if(editShape.isSelected()){

            buttonLeft.setVisible(true);
            buttonRight.setVisible(true);
            buttonDuplicate.setVisible(true);
            buttonDelete.setVisible(true);
        }

    }

    private void setPanel(){

        panel = new MyPanel();
        panel.setBackground(Color.white);
        panel.setBounds(120, 120, 760, 560);
    }

    private void setIcons(){

        rectIcon = new ImageIcon(getClass().getResource("/images/rectangle.png"));
        circleIcon = new ImageIcon(getClass().getResource("/images/circle.png"));
        rectSelectedIcon = new ImageIcon(getClass().getResource("/images/rectangleSelected.png"));
        circleSelectedIcon = new ImageIcon(getClass().getResource("/images/circleSelected.png"));
        rectFilledIcon = new ImageIcon(getClass().getResource("/images/rectangleFilled.png"));
        circleFilledIcon = new ImageIcon(getClass().getResource("/images/circleFilled.png"));
        rectFilledSelectedIcon = new ImageIcon(getClass().getResource("/images/rectangleFilledSelected.png"));
        circleFilledSelectedIcon = new ImageIcon(getClass().getResource("/images/circleFilledSelected.png"));
        lineIcon = new ImageIcon(getClass().getResource("/images/line.png"));
        lineSelectedIcon = new ImageIcon(getClass().getResource("/images/lineSelected.png"));
    }

    private void setButtonListeners() {
        buttonRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                enableButtons();
                shapeSelector = 0;
                filled = false;
            }
        });

        buttonRectangleFilled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                enableButtons();
                shapeSelector = 0;
                filled = true;
            }
        });

        buttonCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                enableButtons();
                shapeSelector = 1;
                filled = false;
            }
        });

        buttonCircleFilled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                enableButtons();
                shapeSelector = 1;
                filled = true;
            }
        });

        buttonLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                enableButtons();
                shapeSelector = 2;
            }
        });

        editShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                enableButtons();

                if(shapeExist())
                {
                    panel.shapes.get(scrollIterator).selectedColor = Color.green;
                    panel.repaint();
                }

            }
        });

        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(shapeExist()){

                    panel.shapes.get(scrollIterator).selectedColor = panel.shapes.get(scrollIterator).myColor;

                    if(scrollIterator == panel.shapes.size()-1)
                        scrollIterator = 0;
                    else
                        scrollIterator++;

                    panel.shapes.get(scrollIterator).selectedColor = Color.green;
                    panel.repaint();
                }

            }
        });

        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(shapeExist()){

                    panel.shapes.get(scrollIterator).selectedColor = panel.shapes.get(scrollIterator).myColor;

                    if(scrollIterator == 0)
                        scrollIterator = panel.shapes.size()-1;
                    else
                        scrollIterator--;

                    panel.shapes.get(scrollIterator).selectedColor = Color.green;
                    panel.repaint();
                }

            }
        });

        buttonDuplicate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(shapeExist())
                    panel.duplicateShape(scrollIterator);
            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if(shapeExist()){

                    panel.deleteShape(scrollIterator);

                    scrollIterator = 0;
                    if(shapeExist()){

                        panel.shapes.get(scrollIterator).selectedColor = Color.green;
                        panel.repaint();
                    }


                }

            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("./savedFiles"));

                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){

                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());


                    MyThreadOutput thread2 = new MyThreadOutput(panel.shapes, file);
                    thread2.start();
                }


            }
        });

        buttonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("./savedFiles"));

                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    MyThreadInput thread2 = new MyThreadInput(panel, file);
                    thread2.start();
                }
            }
        });
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub


    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

        if(isDrawable()){
            mouseClickedX = e.getX();
            mouseClickedY = e.getY();
            panel.addShape(shapeNames[shapeSelector], mouseClickedX, mouseClickedY, filled);
            panel.repaint();
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub



    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub


    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

        if(isDrawable()){

            panel.resizeTopShape(mouseClickedX, mouseClickedY, e.getX(), e.getY());
            panel.repaint();
        }


        //throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub




        //throw new UnsupportedOperationException("Unimplemented method 'mouseMoved'");
    }
}




