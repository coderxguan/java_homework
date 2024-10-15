package com.guanhf.a11IO;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/15 23:00
 */
import java.util.List;

public class SchoolData {
    private List<SchoolProvince> schools;

    public SchoolData() {
    }

    public SchoolData(List<SchoolProvince> schools) {
        this.schools = schools;
    }

    /**
     * 获取
     *
     * @return schools
     */
    public List<SchoolProvince> getSchools() {
        return schools;
    }

    /**
     * 设置
     * @param schools
     */
    public void setSchools(List<SchoolProvince> schools) {
        this.schools = schools;
    }

    public String toString() {
        return "SchoolData{schools = " + schools + "}";
    }

    // getter 和 setter 方法
}

class SchoolProvince {
    private String province_name;
    private List<SchoolCity> cities;

    public SchoolProvince() {
    }

    public SchoolProvince(String province_name, List<SchoolCity> cities) {
        this.province_name = province_name;
        this.cities = cities;
    }

    /**
     * 获取
     * @return province_name
     */
    public String getProvince_name() {
        return province_name;
    }

    /**
     * 设置
     * @param province_name
     */
    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    /**
     * 获取
     * @return cities
     */
    public List<SchoolCity> getCities() {
        return cities;
    }

    /**
     * 设置
     * @param cities
     */
    public void setCities(List<SchoolCity> cities) {
        this.cities = cities;
    }

    public String toString() {
        return "SchoolProvince{province_name = " + province_name + ", cities = " + cities + "}";
    }

    // getter 和 setter 方法
}

class SchoolCity {
    private String city_name;
    private List<String> universities;

    public SchoolCity() {
    }

    public SchoolCity(String city_name, List<String> universities) {
        this.city_name = city_name;
        this.universities = universities;
    }

    /**
     * 获取
     * @return city_name
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * 设置
     * @param city_name
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    /**
     * 获取
     * @return universities
     */
    public List<String> getUniversities() {
        return universities;
    }

    /**
     * 设置
     * @param universities
     */
    public void setUniversities(List<String> universities) {
        this.universities = universities;
    }

    public String toString() {
        return "SchoolCity{city_name = " + city_name + ", universities = " + universities + "}";
    }

    // getter 和 setter 方法
}

