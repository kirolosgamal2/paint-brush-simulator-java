
package com.mycompany.finalpro;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;


public class Oval extends Shapes {
    int width , height ;

    public Oval(Point startPoint, Point endPoint, Color color, boolean flagLines, boolean flagFilled , int width , int height) {
        super(startPoint, endPoint, color, flagLines, flagFilled);
        this.width = width ;
        this.height = height ;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(getColor());

        Graphics2D g2 = (Graphics2D) g ;
        Stroke dotted_line = new BasicStroke(1, BasicStroke.CAP_BUTT , BasicStroke.JOIN_BEVEL , 0 , new float[]{1,2} , 0) ;

        if (isFlagFilled() == true){
            g.fillOval(startPoint.x , startPoint.y , width , height );
        }

        if (isFlagLines() == true){
            g2.setStroke(dotted_line);
            g.drawOval(startPoint.x , startPoint.y , width , height );
        }
        else {
            g.drawOval(startPoint.x , startPoint.y , width, height);
        }
    }


}