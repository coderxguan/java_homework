package com.guanhf.a04;

public class RectangleTest {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10, 5);

        System.out.println("r1: "+ "length: " + r1.getLength() + " width: " + r1.getWidth());
        System.out.println("area: " + r1.calcArea()+ " perimeter: " + r1.calcPerimeter());

        System.out.println("r2: "+ "length: " + r2.getLength() + " width: " + r2.getWidth());
        System.out.println("area: " + r2.calcArea()+ " perimeter: " + r2.calcPerimeter());



    }
}
