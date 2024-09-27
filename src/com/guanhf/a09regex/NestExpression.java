package com.guanhf.a09regex;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NestExpression {
    public static void main(String[] args) {
        String regex = "((add|sub|max|min|doubleMe)\\(\\d+(\\.\\d+)?(,\\d+(\\.\\d+)?)?\\))";
        String expression;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入表达式:");
        String expr = sc.nextLine();
//      String expr = "add(add(add(2,1),3),doubleMe(3.4))";

        // 保留原表达式, 用作结果输出
        expression = expr;
        Pattern pattern = Pattern.compile(regex);
        while(true){
            // 匹配子表达式
            Matcher matcher = pattern.matcher(expression);
            if(matcher.find()){
                // 匹配找到的第一个子表达式
                expression = matcher.replaceFirst(evaluateExpression(matcher.group()));
//                System.out.println(expression);
            }
            // 如果只剩数字则表达式计算完毕
            else if(expression.matches("\\d+(\\.\\d+)?")){
                System.out.println(expr + "=" + expression);
                break;

            }
            // 如果既不是数字也不是表达式说明这个表达式有问题
            else{
                System.out.println("输入的表达式有误!!");
                break;
            }
        }

    }

    // 计算表达式
    public static String evaluateExpression(String expression){
        String function = expression.substring(0, expression.indexOf("("));
        double result;
        if ("doubleMe".equals(function)) {
            double num1 = Double.parseDouble(expression.substring(expression.indexOf("(") + 1, expression.indexOf(")")));
            result = 2 * num1;
        } else {
            double num1 = Double.parseDouble(expression.substring(expression.indexOf("(") + 1, expression.indexOf(",")));
            double num2 = Double.parseDouble(expression.substring(expression.indexOf(",") + 1, expression.indexOf(")")));
            result = switch (function) {
                case "add" -> num1 + num2;
                case "sub" -> num1 - num2;
                case "max" -> Math.max(num1, num2);
                case "min" -> Math.min(num1, num2);
                default -> throw new IllegalArgumentException("不支持的函数");
            };
        }
        return String.valueOf(result);
    }
}
