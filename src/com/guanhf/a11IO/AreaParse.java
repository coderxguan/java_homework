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
 * 日期:2024/10/15 22:50
 */
public class AreaParse {
    public static void main(String[] args) {
        // 读取并解析 JSON 文件
        List<Province> provinces = loadProvincesFromFile("src/com/guanhf/a11IO/area.txt");

        if (provinces == null) {
            System.out.println("读取文件失败！");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        // 查询省份
        System.out.println("请输入省份名称：");
        String provinceName = scanner.nextLine();
        Province selectedProvince = findProvinceByName(provinces, provinceName);
        if (selectedProvince != null) {
            // 打印该省的所有城市
            System.out.println("该省的所有城市：");
            for (City city : selectedProvince.getCities()) {
                System.out.println(city.getText());
            }

            // 查询城市
            System.out.println("\n请输入城市名称：");
            String cityName = scanner.nextLine();
            City selectedCity = findCityByName(selectedProvince.getCities(), cityName);
            if (selectedCity != null) {
                // 打印该城市的所有区
                System.out.println("该城市的所有区：");
                for (County county : selectedCity.getCountys()) {
                    System.out.println(county.getText());
                }

                // 查询区
                System.out.println("\n请输入区名称：");
                String countyName = scanner.nextLine();
                County selectedCounty = findCountyByName(selectedCity.getCountys(), countyName);
                if (selectedCounty != null) {
                    // 打印该区的所有街道
                    System.out.println("该区的所有街道：");
                    for (Town town : selectedCounty.getTowns()) {
                        System.out.println(town.getText());
                    }
                } else {
                    System.out.println("未找到该区。");
                }
            } else {
                System.out.println("未找到该城市。");
            }
        } else {
            System.out.println("未找到该省份。");
        }

        scanner.close();
    }

    // 加载 JSON 文件并解析为 Province 列表
    private static List<Province> loadProvincesFromFile(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, new TypeToken<List<Province>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 根据省份名称查找 Province 对象
    private static Province findProvinceByName(List<Province> provinces, String name) {
        for (Province province : provinces) {
            if (province.getText().equals(name)) {
                return province;
            }
        }
        return null;
    }

    // 根据城市名称查找 City 对象
    private static City findCityByName(List<City> cities, String name) {
        for (City city : cities) {
            if (city.getText().equals(name)) {
                return city;
            }
        }
        return null;
    }

    // 根据区名称查找 County 对象
    private static County findCountyByName(List<County> countys, String name) {
        for (County county : countys) {
            if (county.getText().equals(name)) {
                return county;
            }
        }
        return null;
    }
}
