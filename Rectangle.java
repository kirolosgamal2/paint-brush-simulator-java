package com.mycompany.finalpro;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;



public class Rectangle  extends Shapes{
    int height , width ;

    public Rectangle(Point startPoint, Point endPoint, Color color, boolean flagLines, boolean flagFilled , int height , int width) {
        super(startPoint, endPoint, color, flagLines, flagFilled);
        this.height = height ;
        this.width = width ;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    @Override
    public void paint(Graphics g){
        g.setColor(getColor());

        Graphics2D g2 = (Graphics2D) g ;
        Stroke dotted_line = new BasicStroke(1, BasicStroke.CAP_BUTT , BasicStroke.JOIN_BEVEL , 0 , new float[]{1,2} , 0) ;

        if (isFlagFilled() == true){
            g.fillRect(startPoint.x , startPoint.y , width , height );
        }

        if (isFlagLines() == true){
            g2.setStroke(dotted_line);
            g.drawRect(startPoint.x , startPoint.y , width , height );
        }
        else {
            g.drawRect(startPoint.x , startPoint.y , width, height);
        }

    }



}