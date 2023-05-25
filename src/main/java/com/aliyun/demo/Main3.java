package com.aliyun.demo;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStreamReader;
import java.io.Reader;
import com.aliyun.demo.Entity.Grade;
import com.aliyun.demo.Mapper.GradeMapper;

public class Main3 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(
                    Main3.class.getClassLoader().getResourceAsStream("config.properties"));

            // JDBC连接的URL, 不同数据库有不同的格式:
            String JDBC_URL = properties.getProperty("JDBC_URL");
            String JDBC_USER = properties.getProperty("JDBC_USER");
            String JDBC_PASSWORD = properties.getProperty("JDBC_PASSWORD");

            System.out.println("读取了数据库配置如下：");
            System.out.println(JDBC_URL);
            System.out.println(JDBC_USER);
            System.out.println(JDBC_PASSWORD);

            Reader reader = new InputStreamReader(
                    Main3.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader, properties);

            SqlSession session = factory.openSession();
            GradeMapper GradeMapper = session.getMapper(GradeMapper.class);

//查询
            System.out.println("printtop");
            printtop (GradeMapper);
            System.out.println("print id = 2");
            printById(GradeMapper, 4);
            System.out.println("print id = 9999");
            printById(GradeMapper, 9999);
//插入
            Grade newGrade = new Grade(4, 1, 0);
            GradeMapper.insertGrade(newGrade);
            session.commit();
            System.out.println("print after insert: " + newGrade.getId());
//输出插入的数据
            Grade Grade = GradeMapper.getGrade(newGrade.getId());
            System.out.println(Grade);

//更新 年纪加一
            System.out.println("grade + 1 : ");
            GradeMapper.updateGrade();
            session.commit();
            System.out.println(Grade);

//更新 毕业            
            System.out.println("graduate : ");
            GradeMapper.updateGraduated();
            session.commit();
            System.out.println(Grade);

//删除
            GradeMapper.deleteGrade(newGrade.getId());
            session.commit();
            System.out.println("print after delete: " + newGrade.getId());
            printById(GradeMapper, newGrade.getId());

            session.close();
        } catch (Exception e) {
            System.out.println("读取配置文件失败");
            e.printStackTrace();
        }
    }

    public static void printtop(GradeMapper GradeMapper) {
        List<Grade> Grades = GradeMapper.getGradePagination(10, 0);
        for (Grade score : Grades) {
            System.out.println(score);
        }
    }

    public static void printById(GradeMapper GradeMapper, long id) {
        Grade Grade = GradeMapper.getGrade(id);
        if (Grade == null) {
            System.out.println("id: " + id + " not found");
        } else {
            System.out.println(Grade);
        }
    }
}
