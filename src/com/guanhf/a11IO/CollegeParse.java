package com.guanhf.a11IO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/15 22:51
 */
public class CollegeParse {
    public static void main(String[] args) {
        // 读取并解析 JSON 文件
        SchoolData schoolData = loadSchoolsFromFile("src/com/guanhf/a11IO/全国高校.txt");

        if (schoolData == null) {
            System.out.println("读取文件失败！");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        // 查询省份
        System.out.println("请输入省份名称：");
        String provinceName = scanner.nextLine();
        SchoolProvince selectedProvince = findProvinceByName(schoolData.getSchools(), provinceName);
        if (selectedProvince != null) {
            // 打印该省的所有大学
            System.out.println("该省的所有大学：");
            for (SchoolCity city : selectedProvince.getCities()) {
                for (String university : city.getUniversities()) {
                    System.out.println(university);
                }
            }
        } else {
            System.out.println("未找到该省份。");
        }

        scanner.close();
    }

    // 加载 JSON 文件并解析为 SchoolData 对象
    private static SchoolData loadSchoolsFromFile(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, new TypeToken<SchoolData>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 根据省份名称查找 SchoolProvince 对象
    private static SchoolProvince findProvinceByName(List<SchoolProvince> provinces, String name) {
        for (SchoolProvince province : provinces) {
            if (province.getProvince_name().equals(name)) {
                return province;
            }
        }
        return null;
    }
}
