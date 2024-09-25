package com.guanhf.a8常用类;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // 正则表达式模式
        String simplePattern = "^-?\\d+(\\.\\d+)?[+\\-*/]-?\\d+(\\.\\d+)?$";
        String functionPattern = "^(add|sub|max|min|doubleMe)\\((-?\\d+(\\.\\d+)?)(,\\s*-?\\d+(\\.\\d+)?)?\\)$";

        while (true) {
            System.out.print("请输入运算表达式 ：");
            input = scanner.nextLine();

            // 简单表达式
            if (input.matches(simplePattern)) {
                int indexPlus = input.indexOf("+");
                int indexMinus = input.indexOf("-");
                int indexMultiply = input.indexOf("*");
                int indexDivide = input.indexOf("/");
                if(indexPlus != -1){
                    double op1 = Double.parseDouble(input.substring(0, indexPlus));
                    double op2 = Double.parseDouble(input.substring(indexPlus + 1));
                    System.out.println(input + "="+(op1+op2));

                }else if(indexMinus != -1){
                    double op1 = Double.parseDouble(input.substring(0, indexMinus));
                    double op2 = Double.parseDouble(input.substring(indexMinus + 1));
                    System.out.println(input + "="+(op1-op2));

                }
                else if(indexMultiply != -1){
                    double op1 = Double.parseDouble(input.substring(0, indexMultiply));
                    double op2 = Double.parseDouble(input.substring(indexMultiply + 1));
                    System.out.println(input + "="+(op1*op2));
                }
                else if(indexDivide != -1){
                    double op1 = Double.parseDouble(input.substring(0, indexDivide));
                    double op2 = Double.parseDouble(input.substring(indexDivide + 1));
                    System.out.println(input + "="+(op1/op2));
                }
            }
            // 函数表达式
            else if (input.matches(functionPattern)) {
                    double result = getResult(input);
                    System.out.println(input + "=" + result);
            }else if(input.equals("quit")){ // 数据quit退出循环
                break;
            }
            else {
                System.out.println("表达式格式不正确，请重新输入");
            }
        }
    }


    // 求解表达式函数抽取
    private static double getResult(String input) {
        String function = input.substring(0, input.indexOf("("));

        double result;
        if ("doubleMe".equals(function)) {
            double num1 = Double.parseDouble(input.substring(input.indexOf("(") + 1, input.indexOf(")")));
            result = 2 * num1;
        } else {
            double num1 = Double.parseDouble(input.substring(input.indexOf("(") + 1, input.indexOf(",")));
            double num2 = Double.parseDouble(input.substring(input.indexOf(",") + 1, input.indexOf(")")));
            result = switch (function) {
                case "add" -> num1 + num2;
                case "sub" -> num1 - num2;
                case "max" -> Math.max(num1, num2);
                case "min" -> Math.min(num1, num2);
                default -> throw new IllegalArgumentException("不支持的函数");
            };
        }
        return result;
    }
}
