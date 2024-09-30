package com.guanhf.a10date;

import java.awt.desktop.ScreenSleepEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sale {
    public static void main(String[] args) {
        ArrayList<Record> input = input();
        process(input);
        System.out.println(input);
    }

    public static void process(ArrayList<Record> records){
        int i = 0;
        for (Record record : records) {
            String lsh = "";
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            lsh = format.format(date) + "000" + (i++);
            record.setLsh(lsh);
        }
    }

    public static ArrayList<Record> input(){
        ArrayList<Record> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        while(!info.equals("0000")){
            String[] split = info.split(",");
            String name = split[0];
            double price = Double.parseDouble(split[1]);
            int num = Integer.parseInt(split[2]);

            Record record = new Record(name, price, num);
            records.add(record);
            info = scanner.nextLine();
        }
        return records;
    }
}
