package com.guanhf.a09regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonExpression {
    public static void main(String[] args) {

        String regex = "(\\d+(\\.\\d+)?)([+*/-])(\\d+(\\.\\d+)?)";
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("请输入表达式: ");
            String expression = sc.nextLine();
            Pattern p = Pattern.compile(regex);
            Matcher matcher = p.matcher(expression);
            if(matcher.find()){
                double num1 = Double.parseDouble(matcher.group(1));
                double num2 = Double.parseDouble(matcher.group(4));
                String op = matcher.group(3);

                switch (op) {
                    case "+" -> System.out.println(expression + "=" + (num1 + num2));
                    case "-" -> System.out.println(expression + "=" + (num1 - num2));
                    case "*" -> System.out.println(expression + "=" + (num1 * num2));
                    case "/" -> System.out.println(expression + "=" + (num1 / num2));
                }
                break;
            }else{
                System.out.println("表达式不符合, 请重新输入!!");
            }

        }



    }
}
