package com.guanhf.trail2.a03;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/02 19:22
 */
public class Student {
    private String id;
    private String name;
    private String gender;
    private String province;

    public Student() {
    }

    public Student(String id, String name, String gender, String province) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.province = province;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", gender = " + gender + ", province = " + province + "}";
    }
}
