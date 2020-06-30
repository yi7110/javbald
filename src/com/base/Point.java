package com.base;

/**
 * com.base
 *
 * @author Liuzf
 * @date 2020-06-23 15:22:50
 */
public class Point {
    private int x;
    private int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setLocation(int x,int y){
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        modifyPoint(p1,p2);
        System.out.println("["+p1.x+","+p1.y+"],["+p2.x+","+p2.y+"]");
    }

    public static void modifyPoint(Point p1, Point p2){
        Point tmpPoint = p1;
        p1 = p2;
        p2 = tmpPoint;
        p1.setLocation(5,5);
        p2 = new Point(5,5);

    }
}
