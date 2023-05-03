
package com.mycompany.finalpro;


import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JButton;


public class Controller extends JPanel  {

     Vector <Shapes> createdShapes = new Vector<>();
     Vector<Point> createdlines = new Vector<Point>();

    Point startPoint , endPoint ;
    int height , width ;

    String pressedButton ;

    JButton red , green , blue ;
    JButton rectangle , oval , line ;
    JButton freeHand ;
    JButton eraser , clearAll ;
 //   JButton undo , save , open ;

    Checkbox dotted , filled ;

    Graphics2D g2 ;

    Stroke dotted_line ;

    Color selectedColor ;

    boolean flagLines , flagFilled ;


    public Controller(){
        pressedButton = "nothing";
        flagLines = false ;
        flagFilled = false ;
        selectedColor = Color.BLACK ;


      createdShapes = new Vector<>();


        red = new JButton("Red");
        red.setBackground(Color.RED.brighter());
        red.addActionListener(new ButtonListener());
        add(red);

        green = new JButton("Green");
        green.setBackground(Color.GREEN.brighter());
        green.addActionListener(new ButtonListener());
        add(green);

        blue = new JButton("Blue");
        blue.setBackground(Color.BLUE.brighter());
        blue.addActionListener(new ButtonListener());
        add(blue);

        rectangle = new JButton("Rectangle");
        rectangle.addActionListener(new ButtonListener());
        add(rectangle);

        oval = new JButton("Oval");
        oval.addActionListener(new ButtonListener());
        add(oval);

        line = new JButton("Line");
        line.addActionListener(new ButtonListener());
        add(line);

        freeHand = new JButton("Free Hand");
        freeHand.addActionListener(new ButtonListener());
        add(freeHand);

        eraser = new JButton("Eraser");
        eraser.addActionListener(new ButtonListener());
        add(eraser);

        clearAll =  new JButton("Clear All");
        clearAll.addActionListener(new ButtonListener());
        add(clearAll);

        dotted = new Checkbox("Dotted");
        dotted.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource() == dotted) {
                    flagLines = true ;
                }

            }
        }
        );
        add(dotted);

         filled = new Checkbox("Filled");
        add(filled);
        filled.addItemListener(new ItemListener()
        {@Override
 public void itemStateChanged(ItemEvent e)
        {
            if (e.getStateChange() == 1)
                flagFilled = true ;
            else
                flagFilled = false ;
        }} );


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = new Point(e.getX() , e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (pressedButton){
            case "Rectangle":
                createdShapes.add(new Rectangle( startPoint,  endPoint,selectedColor, flagLines,  flagFilled ,  height , width));
                break ;

            case "Line":
                createdShapes.add(new Line( startPoint, endPoint,selectedColor,  flagLines, flagFilled));
                break ;

            case "Oval":
                createdShapes.add(new Oval(startPoint, endPoint, selectedColor , flagLines, flagFilled ,width , height)) ;
                break ;

            /* case "Free Hand":
            createdShapes.add(new FreeHand(startPoint, endPoint, selectedColor , flagLines, flagFilled)) ;
                break ;*/

             /*   case "Eraser":
            createdShapes.add(new Eraser(startPoint, endPoint, selectedColor , flagLines, flagFilled)) ;
                break ;*/
        }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                 endPoint =new Point(e.getX(),e.getY());
                  width = endPoint.x - startPoint.x ;
                  height = endPoint.y - startPoint.y ;
         repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

        });


    }



    @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g ;
        dotted_line = new BasicStroke(1, BasicStroke.CAP_BUTT , BasicStroke.JOIN_BEVEL , 0 , new float[]{1,2} , 0) ;

        g.setColor(selectedColor);

        switch(pressedButton){
            case "Rectangle":
                if(flagLines == true){
                    g2.setStroke(dotted_line);
                    g.drawRect(startPoint.x, startPoint.y,width, height);

                }
                else
                    g.drawRect(startPoint.x, startPoint.y,width, height);

                break ;

            case "Line":
                System.out.println("LINE2");
                g.drawLine(startPoint.x, startPoint.y,endPoint.x, endPoint.y);
                break;

            case "Oval":
                g.drawOval(startPoint.x, startPoint.y,width, height);
                break ;

            case "Free Hand":
            g.drawLine( startPoint.x,  startPoint.y,endPoint. x+2, startPoint.y+2); ;
                break ;

                case "Eraser":
            g.drawRect(startPoint.x, startPoint.y,width, height);
                break ;

        }

        for(Shapes i : createdShapes){
            i.paint(g);
        }


        }



    class ButtonListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        String check = e.getActionCommand() ;
        switch(check){
            case "Red":
                selectedColor =Color.RED;
                break ;

            case "Green":
                selectedColor =Color.GREEN;
                break ;

            case "Blue":
                selectedColor =Color.BLUE;
                break;

            case "Line":
                pressedButton ="Line";
                System.out.println("line");
                break ;

            case "Rectangle":
                pressedButton ="Rectangle";
                break ;

            case "Oval":
                pressedButton = "Oval";
                break ;

            case "Free Hand":
                pressedButton = "Free Hand";
                break ;

            case "Eraser":
                pressedButton = "Eraser";
                break ;

            case "Clear All":
                pressedButton = "Clear All";
                createdShapes.clear();
                repaint();
                break ;

        }
    }

    }

 }



