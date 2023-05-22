package com.aliyun.demo;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.aliyun.demo.Entity.gradeone;
import com.aliyun.demo.Entity.score;

public class main2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(
                    Main.class.getClassLoader().getResourceAsStream("config.properties"));
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

                // printByName(conn, "%五%");
                // queryMath(conn,"王五");
                paging(conn, 4);
                // insertgradeone(conn, new gradeone("anna", 1, 3, 89, 74, 75));
                // add(conn, new gradeone("amy", 2, 3, 98, 74, 67));

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

    public static void printByName(Connection conn, String name) {
        try {
            System.out.println("print name like: " + name);

            String sql = "SELECT id, name, classes, grade, Chinese, Math, English FROM gradeone WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                long id = rs.getLong(1);// 注意：索引从1开始
                String nameResult = rs.getString(2);
                long grade = rs.getLong(3);
                int classes = rs.getInt(4);
                int Chinese = rs.getInt(5);
                int Math = rs.getInt(6);
                int English = rs.getInt(7);
                System.out.println(id + "," + nameResult + "," + grade + "," + classes + "," + Chinese + "," + Math
                        + "," + English);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add(Connection conn, gradeone gradeone) {
        try {
            System.out.println("insert: " + gradeone.toString());

            String sql = "INSERT INTO gradeone (name, classes, grade, Chinese, Math, English) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, gradeone.getName());
            ps.setObject(2, gradeone.getGrade());
            ps.setObject(3, gradeone.getClasses());
            ps.setObject(4, gradeone.getChinese());
            ps.setObject(5, gradeone.getMath());
            ps.setObject(6, gradeone.getEnglish());
            int rows = ps.executeUpdate();

            System.out.println("inserted: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void queryMath(Connection conn, String name) {
        try {
            System.out.println("print name like: " + name);

            String sql = "SELECT id, name,  grade,classes, Math FROM gradeone WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                long id = rs.getLong(1);// 注意：索引从1开始
                String nameResult = rs.getString(2);
                long grade = rs.getLong(3);
                int classes = rs.getInt(4);
                int Math = rs.getInt(5);
                System.out.println(id + "," + nameResult + "," + grade + "," + classes + "," + Math);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertgradeone(Connection conn, gradeone gradeone) {
        try {
            System.out.println("insert: " + gradeone.toString());

            String sql = "INSERT INTO grade1 (name, classes, grade, Chinese, Math, English) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, gradeone.getName());
            ps.setObject(2, gradeone.getGrade());
            ps.setObject(3, gradeone.getClasses());
            ps.setObject(4, gradeone.getChinese());
            ps.setObject(5, gradeone.getMath());
            ps.setObject(6, gradeone.getEnglish());
            int rows = ps.executeUpdate();

            System.out.println("inserted: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void paging(Connection conn, int num) {
        try {

            String sql = "SELECT Chinese+Math+English sum , id, name, grade, classes,Chinese, Math ,English FROM score ORDER BY sum DESC LIMIT ? OFFSET 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, num);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int sum = rs.getInt(1);
                long id = rs.getLong(2);// 注意：索引从1开始
                String name = rs.getString(3);
                long grade = rs.getLong(4);
                int classes = rs.getInt(5);
                int Chinese = rs.getInt(6);
                int Math = rs.getInt(7);
                int English = rs.getInt(8);
                System.out.println(sum + "," + id + "," + name + "," + grade + "," + classes + "," + Chinese + ","
                        + Math + "," + English);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
