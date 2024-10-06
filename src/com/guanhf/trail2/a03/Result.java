package com.guanhf.trail2.a03;

import java.util.ArrayList;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/02 19:28
 */
public class Result {
    private String province;
    private int num;
    private ArrayList<String> name;

    public Result() {
    }

    public Result(String province, int num, ArrayList<String> name) {
        this.province = province;
        this.num = num;
        this.name = name;
    }

    /**
     * 获取
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * 获取
     * @return name
     */
    public ArrayList<String> getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public String toString() {
        return "Result{province = " + province + ", num = " + num + ", name = " + name + "}";
    }
}
