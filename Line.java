
package com.mycompany.finalpro;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;


public class Line  extends Shapes{

    public Line(Point startPoint, Point endPoint, Color color, boolean flagLines, boolean flagFilled) {
        super(startPoint, endPoint, color, flagLines, flagFilled);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(getColor());
        Graphics2D g2 =(Graphics2D) g ;
        Stroke dotted_line = new java.awt.BasicStroke(1, java.awt.BasicStroke.CAP_BUTT , java.awt.BasicStroke.JOIN_BEVEL , 0 , new float[]{1,2} , 0) ;


        if(isFlagLines()== true){
            g2.setStroke(dotted_line);
            g2.drawLine(startPoint.x, startPoint.y,endPoint.x, endPoint.y);
        }
        else
            g.drawLine(startPoint.x, startPoint.y,endPoint.x, endPoint.y);

    }




}