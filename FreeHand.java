package com.mycompany.finalpro;

import java.util.Vector;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class FreeHand extends Shapes {

   // Vector<Point> createdlines = new Vector<Point>();


   
    public FreeHand(Point startPoint, Point endPoint, Color color, boolean flagLines, boolean flagFilled) {
        super (startPoint, endPoint, color, flagLines, flagFilled);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(getColor()); 
       
        Graphics2D g2 =(Graphics2D) g ;
        Stroke dotted_line = new java.awt.BasicStroke(1, java.awt.BasicStroke.CAP_BUTT , java.awt.BasicStroke.JOIN_BEVEL , 0 , new float[]{1,2} , 0) ;

        if (isFlagLines() == true){
        
            for(int i = 0; i < createdlines.size() - 1; i++) {
                g2.setStroke(dotted_line);
		g.drawLine(createdlines .get(i).x, createdlines.get(i).y,
                        createdlines.get(i+1).x,createdlines.get(i+1).y);
        }
        }
        else
        {
           for(int i = 0; i < createdlines.size() - 1; i++) {
		g.drawLine(createdlines .get(i).x, createdlines.get(i).y,
                        createdlines.get(i+1).x,createdlines.get(i+1).y);
		}
        
                }
        }
    }


  