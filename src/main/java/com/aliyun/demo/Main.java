package com.aliyun.demo;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.aliyun.demo.Entity.Student;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(
                Main.class.getClassLoader().getResourceAsStream("config.properties")
            );

            // JDBC连接的URL, 不同数据库有不同的格式:
            String JDBC_URL = properties.getProperty("JDBC_URL");
            String JDBC_USER = properties.getProperty("JDBC_USER");
            String JDBC_PASSWORD = properties.getProperty("JDBC_PASSWORD");

            System.out.println("读取了数据库配置如下：");
            System.out.println(JDBC_URL);
            System.out.println(JDBC_USER);
            System.out.println(JDBC_PASSWORD);

            try {
                // Class.forName("com.mysql.cj.jdbc.Driver");
                // 获取连接:
                Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

                // printByName(conn, "明%\" AND gender = 0 OR name Like \"%");
                // printByName2(conn, "%明%");
                // printByName2(conn, "%明% OR name Like %%");
                // add(conn, "Tom", 1, 1, 100);
                // Student student = new Student();
                // student.setName("Jerry");
                // student.setGender(1);
                // student.setGrade(1);
                // student.setScore(99);
                // add(conn, new Student("Jane", 1, 2, 98));
                // 关闭连接:
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("读取配置文件失败");
            e.printStackTrace();
        }
    }

    public static void printByGender(Connection conn, int gender) {
        try {
            System.out.println("print gender is: " + gender);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=" + gender);

            while (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
                long grade = rs.getLong(2);
                String name = rs.getString(3);
                int genderResult = rs.getInt(4);
                System.out.println(id + "," + grade + name + genderResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printByName(Connection conn, String name) {
        try {
            System.out.println("print name like: " + name);

            Statement stmt = conn.createStatement();
            String sql = "SELECT id, grade, name, gender FROM students WHERE name LIKE \"%" + name + "%\"";
            System.out.println("执行了这个SQL: "+ sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
                long grade = rs.getLong(2);
                String nameResult = rs.getString(3);
                int gender = rs.getInt(4);
                System.out.println(id + "," + grade + nameResult + gender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printByName2(Connection conn, String name) {
        try {
            System.out.println("print name like: " + name);

            String sql = "SELECT id, grade, name, gender FROM students WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
                long grade = rs.getLong(2);
                String nameResult = rs.getString(3);
                int gender = rs.getInt(4);
                System.out.println(id + "," + grade + nameResult + gender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add(Connection conn, String name, int grade, int gender, int score) {
        try {
            System.out.println("insert: " + name + grade + gender + score);

            String sql = "INSERT INTO students (name, grade, gender, score) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2, grade);
            ps.setObject(3, gender);
            ps.setObject(4, score);
            int rows = ps.executeUpdate();

            System.out.println("inserted: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add(Connection conn, Student student) {
        try {
            System.out.println("insert: " + student.toString());

            String sql = "INSERT INTO students (name, grade, gender, score) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, student.getName());
            ps.setObject(2, student.getGrade());
            ps.setObject(3, student.getGender());
            ps.setObject(4, student.getScore());
            int rows = ps.executeUpdate();

            System.out.println("inserted: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
