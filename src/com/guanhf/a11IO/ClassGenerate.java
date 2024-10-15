package com.guanhf.a11IO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/15 22:36
 */
public class ClassGenerate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入类名
        System.out.println("请输入类名：");
        String className = scanner.nextLine();

        // 输入成员变量数量
        System.out.println("请输入成员变量数量：");
        int fieldCount = scanner.nextInt();
        scanner.nextLine();  // 处理换行符

        String[] fieldNames = new String[fieldCount];
        String[] fieldTypes = new String[fieldCount];

        // 输入成员变量的名称和类型
        for (int i = 0; i < fieldCount; i++) {
            System.out.println("请输入第 " + (i + 1) + " 个成员变量的类型及名称：");
            String info = scanner.nextLine();
            fieldTypes[i] = info.split(", ")[0];
            fieldNames[i] = info.split(", ")[1];
        }

        // 生成 Java 类的源代码
        String classCode = generateClassCode(className, fieldNames, fieldTypes);

        // 将生成的代码写入 .java 文件
        try (FileWriter fileWriter = new FileWriter("src/com/guanhf/a11IO/" + className + ".java")) {
            fileWriter.write(classCode);
            System.out.println(className + ".java 文件生成成功！");
        } catch (IOException e) {
            System.out.println("文件生成失败: " + e.getMessage());
        }
    }

    // 生成 Java 类代码的函数
    public static String generateClassCode(String className, String[] fieldNames, String[] fieldTypes) {
        StringBuilder code = new StringBuilder();

        // 包装类定义
        code.append("public class ").append(className).append(" {\n\n");

        // 生成成员变量
        for (int i = 0; i < fieldNames.length; i++) {
            code.append("    private ").append(fieldTypes[i]).append(" ").append(fieldNames[i]).append(";\n");
        }

        code.append("\n");

        // 生成无参构造方法
        code.append("    public ").append(className).append("() {}\n\n");

        // 生成带所有参数的构造方法
        code.append("    public ").append(className).append("(");
        for (int i = 0; i < fieldNames.length; i++) {
            code.append(fieldTypes[i]).append(" ").append(fieldNames[i]);
            if (i < fieldNames.length - 1) {
                code.append(", ");
            }
        }
        code.append(") {\n");
        for (String fieldName : fieldNames) {
            code.append("        this.").append(fieldName).append(" = ").append(fieldName).append(";\n");
        }
        code.append("    }\n\n");

        // 生成 getter 和 setter 方法
        for (int i = 0; i < fieldNames.length; i++) {
            // 生成 getter
            code.append("    public ").append(fieldTypes[i]).append(" get").append(capitalize(fieldNames[i])).append("() {\n")
                    .append("        return ").append(fieldNames[i]).append(";\n")
                    .append("    }\n\n");

            // 生成 setter
            code.append("    public void set").append(capitalize(fieldNames[i])).append("(").append(fieldTypes[i]).append(" ").append(fieldNames[i]).append(") {\n")
                    .append("        this.").append(fieldNames[i]).append(" = ").append(fieldNames[i]).append(";\n")
                    .append("    }\n\n");
        }

        // 生成 toString 方法
        code.append("    @Override\n");
        code.append("    public String toString() {\n");
        code.append("        return \"").append(className).append(" {");
        for (int i = 0; i < fieldNames.length; i++) {
            code.append(fieldNames[i]).append("=\" + ").append(fieldNames[i]);
            if (i < fieldNames.length - 1) {
                code.append(" + \", ");
            }
        }
        code.append(" + \"}\";\n");
        code.append("    }\n");

        code.append("}\n");

        return code.toString();
    }

    // 首字母大写辅助函数
    public static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

