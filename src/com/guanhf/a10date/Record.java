package com.guanhf.a10date;

public class Record {
    private String lsh;
    private String name;
    private int num;
    private double price;
    private double total;

    public Record(String name, double price, int num){
        this.name = name;
        this.num = num;
        this.price = price;
        this.total = num * price;
    }

    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Record{" +
                "list='" + lsh + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
