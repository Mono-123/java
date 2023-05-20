package com.aliyun.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "";
        String JDBC_USER = "";
        String JDBC_PASSWORD = "";
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接:
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            // TODO: 访问数据库...
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1");

            while (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
                long grade = rs.getLong(2);
                String name = rs.getString(3);
                int gender = rs.getInt(4);
                System.out.println(id + grade + name  + gender);
            }
            // 关闭连接:
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
