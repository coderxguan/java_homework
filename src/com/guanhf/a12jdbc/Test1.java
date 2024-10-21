package com.guanhf.a12jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 功能:
 * 作者:
 * 日期:2024/10/18 8:09
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
//        // 加载驱动
//        String driverName = "com.mysql.jdbc.Driver";
//        Class.forName(driverName);

        // 建立连接
        String url = "jdbc:mysql://47.121.181.198:3306/java";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 创建语句
        String sql = "select * from student";
        PreparedStatement pst = conn.prepareStatement(sql);



        // test
        ResultSet rs = pst.executeQuery();

//        int i = pst.executeUpdate();

        while (rs.next()) {
            System.out.print(rs.getString(1) + " ");
            System.out.print(rs.getString(2) + " ");
            System.out.print(rs.getString(3) + " ");
            System.out.println();
        }

//        if(i>0) {
//            System.out.println("execute successfully");
//        }

        rs.close();
        pst.close();
        conn.close();
    }
}
