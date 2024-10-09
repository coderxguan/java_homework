package com.guanhf.trail2.a05;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    // 定义全局变量
    static final String[] identify = {"add","sub", "max", "min", "doubleMe"};
    static final Random random = new Random();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要生成表达式的个数: ");
        int num = sc.nextInt();

        writeExprToFile("src/com/guanhf/trail2/a05/question.txt", num);
        System.out.println("生成表达式成功!!!");
        writeResultToFile("src/com/guanhf/trail2/a05/question.txt", "src/com/guanhf/trail2/a05/answer.txt");
        System.out.println("生成结果成功!!!");
    }
    // 计算文件中表达式的结果并写入文件
    public static void writeResultToFile(String readFileName, String writeFileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(readFileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter(writeFileName));
        String expression;
        while ((expression = br.readLine()) != null) {
            String result   = processExpression(expression);
            result = expression + "=" + result;
            System.out.println(result);
            bw.write(result);
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    // 将表达式写入文件
    public static void writeExprToFile(String fileName, int num) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < num; i++) {
            String expression = generateExpression(0);
            System.out.println(expression);
            bw.write(expression);
            bw.newLine();
        }
        bw.close();
    }

    // 生成表达式
    public static String generateExpression(int depth){
        // 获取操作符
        String operation = identify[random.nextInt(identify.length)];
        if(random.nextDouble() < 0.5 || depth > 5){
            if (operation.equals("doubleMe")) {
                // 保留一位小数
                double operate =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                return "doubleMe(" + operate + ")";
            } else {
                double operate1 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                double operate2 =  Math.round((Math.random() * 100) * 10.0) / 10.0;

                return operation + "(" + operate1 + "," + operate2 + ")";
            }
        }

        // 否则继续嵌套生成表达式
        switch (operation) {
            case "add":
                int cases = random.nextInt(4);
                double operate1 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                double operate2 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                // 实现多种形式的嵌套
                switch (cases) {
                    case 0:
                        return "add(" + generateExpression(depth+1) + "," + generateExpression(depth+1) + ")";
                    case 1:
                        return "add(" + generateExpression(depth+1) + "," + operate1 + ")";
                    case 2:
                        return "add(" + operate2  + "," + generateExpression(depth+1) + ")";
                    case 3:
                        return "add(" + operate1 + "," + operate2 + ")";
                }
            case "sub":
                 cases = random.nextInt(4);
                 operate1 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                 operate2 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                // 实现多种形式的嵌套
                switch (cases) {
                    case 0:
                        return "sub(" + generateExpression(depth + 1) + "," + generateExpression(depth + 1) + ")";
                    case 1:
                        return "sub(" + generateExpression(depth + 1) + "," + operate1 + ")";
                    case 2:
                        return "sub(" + operate2 + "," + generateExpression(depth + 1) + ")";
                    case 3:
                        return "sub(" + operate1 + "," + operate2 + ")";
                }
            case "max":
                cases = random.nextInt(4);
                operate1 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                operate2 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                // 实现多种形式的嵌套
                switch (cases) {
                    case 0:
                        return "max(" + generateExpression(depth + 1) + "," + generateExpression(depth + 1) + ")";
                    case 1:
                        return "max(" + generateExpression(depth + 1) + "," + operate1 + ")";
                    case 2:
                        return "max(" + operate2 + "," + generateExpression(depth + 1) + ")";
                    case 3:
                        return "max(" + operate1 + "," + operate2 + ")";
                }
            case "min":
                cases = random.nextInt(4);
                operate1 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                operate2 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                // 实现多种形式的嵌套
                switch (cases) {
                    case 0:
                        return "min(" + generateExpression(depth + 1) + "," + generateExpression(depth + 1) + ")";
                    case 1:
                        return "min(" + generateExpression(depth + 1) + "," + operate1 + ")";
                    case 2:
                        return "min(" + operate2 + "," + generateExpression(depth + 1) + ")";
                    case 3:
                        return "min(" + operate1 + "," + operate2 + ")";
                }
            case "doubleMe":
                cases = random.nextInt(2);
                operate1 =  Math.round((Math.random() * 100) * 10.0) / 10.0;
                // 实现多种形式的嵌套
                switch (cases) {
                    case 0:
                        return "doubleMe(" + generateExpression(depth + 1) + ")";
                    case 1:
                        return "doubleMe(" + operate1 + ")";
                }
            default:
                return "";
        }
    }

    // 处理嵌套表达式
    public static String processExpression(String expression) {
        String regex = "((add|sub|max|min|doubleMe)\\(\\d+(\\.\\d+)?(,\\d+(\\.\\d+)?)?\\))";
        Pattern pattern = Pattern.compile(regex);
        while(true){
            // 匹配子表达式
            Matcher matcher = pattern.matcher(expression);
            if(matcher.find()){
                // 匹配找到的第一个子表达式
                expression = matcher.replaceFirst(evaluateExpression(matcher.group()));
            }
            // 如果只剩数字则表达式计算完毕
            else if(expression.matches("\\d+(\\.\\d+)?")){
                return expression;
            }
        }
    }



    // 计算单表达式
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
                case "sub" -> Math.abs(num1 - num2);
                case "max" -> Math.max(num1, num2);
                case "min" -> Math.min(num1, num2);
                default -> throw new IllegalArgumentException("不支持的函数");
            };
        }
        return String.format("%.1f", result);
    }
}
