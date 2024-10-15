package com.guanhf.a11IO;

import java.util.List;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/15 22:53
 */
public class Province {
    private String code;
    private String text;
    private List<City> cities;

    public Province() {
    }

    public Province(String code, String text, List<City> cities) {
        this.code = code;
        this.text = text;
        this.cities = cities;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取
     * @return cities
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * 设置
     * @param cities
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String toString() {
        return "Province{code = " + code + ", text = " + text + ", cities = " + cities + "}";
    }

    // getter 和 setter 方法
}

class City {
    private String code;
    private String text;
    private List<County> countys;

    public City() {
    }

    public City(String code, String text, List<County> countys) {
        this.code = code;
        this.text = text;
        this.countys = countys;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取
     * @return countys
     */
    public List<County> getCountys() {
        return countys;
    }

    /**
     * 设置
     * @param countys
     */
    public void setCountys(List<County> countys) {
        this.countys = countys;
    }

    public String toString() {
        return "City{code = " + code + ", text = " + text + ", countys = " + countys + "}";
    }

    // getter 和 setter 方法
}

class County {
    private String code;
    private String text;
    private List<Town> towns;

    public County() {
    }

    public County(String code, String text, List<Town> towns) {
        this.code = code;
        this.text = text;
        this.towns = towns;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取
     * @return towns
     */
    public List<Town> getTowns() {
        return towns;
    }

    /**
     * 设置
     * @param towns
     */
    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

    public String toString() {
        return "County{code = " + code + ", text = " + text + ", towns = " + towns + "}";
    }

    // getter 和 setter 方法
}

class Town {
    private String code;
    private String text;

    public Town() {
    }

    public Town(String code, String text) {
        this.code = code;
        this.text = text;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "Town{code = " + code + ", text = " + text + "}";
    }

    // getter 和 setter 方法
}
