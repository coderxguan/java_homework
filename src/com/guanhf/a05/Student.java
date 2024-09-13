package com.guanhf.a05;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 16:35
 */

public class Student {
    private String name;
    private String phone;
    private String id;

    public Student() {
    }

    public Student(String name, String phone, String id) {
        this.name = name;
        this.phone = phone;
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
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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

    public String displayStudent() {
        return "Student{name = " + name + ", phone = " + phone + ", id = " + id + "}";
    }
}
