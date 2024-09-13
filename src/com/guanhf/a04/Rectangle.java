package com.guanhf.a04;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    public double calcArea(){
        return this.length*this.width;
    }
    public double calcPerimeter(){
        return this.length*2 + this.width*2;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
