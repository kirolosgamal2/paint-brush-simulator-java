package com.mycompany.finalpro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;


public class Shapes {
    Point startPoint , endPoint ;
    Color color ;
    boolean flagLines , flagFilled ;
     Vector<Point> createdlines = new Vector<Point>();

    public Shapes(Point startPoint, Point endPoint, Color color, boolean flagLines, boolean flagFilled) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.color = color;
        this.flagLines = flagLines;
        this.flagFilled = flagFilled;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFlagLines(boolean flagLines) {
        this.flagLines = flagLines;
    }

    public void setFlagFilled(boolean flagFilled) {
        this.flagFilled = flagFilled;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFlagLines() {
        return flagLines;
    }

    public boolean isFlagFilled() {
        return flagFilled;
    }

    public void  paint(Graphics g){
    }







}