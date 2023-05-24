package com.aliyun.demo;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStreamReader;
import java.io.Reader;
import com.aliyun.demo.Entity.Student;
import com.aliyun.demo.Mapper.StudentMapper;
import com.aliyun.demo.Util.Pagination;

public class Main {
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

            Reader reader = new InputStreamReader(
                    Main.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader, properties);

            SqlSession session = factory.openSession();
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);

            System.out.println("printAllByPagination");
            printAllByPagination(studentMapper);
            System.out.println("printAll");
            printAll(studentMapper);
            System.out.println("print id = 4");
            printById(studentMapper, 4);
            System.out.println("print id = 9999");
            printById(studentMapper, 9999);

            Student newStudent = new Student("Bob", 0, 0, 0);
            studentMapper.insert(newStudent);
            session.commit();
            System.out.println("print after insert: " + newStudent.getId());
            Student student = studentMapper.getById(newStudent.getId());
            System.out.println(student);
            student.setScore(student.getScore() + 10);
            System.out.println("add 10 for student: ");
            System.out.println(student);
            studentMapper.updateScore(student);
            session.commit();
            System.out.println("print after update: " + newStudent.getId());
            printById(studentMapper, newStudent.getId());
            studentMapper.deleteById(newStudent.getId());
            session.commit();
            System.out.println("print after delete: " + newStudent.getId());
            printById(studentMapper, newStudent.getId());
            
            session.close();
        } catch (Exception e) {
            System.out.println("执行发生错误");
            e.printStackTrace();
        }
    }

    public static void printAllByPagination(StudentMapper studentMapper) {
        List<Student> students = studentMapper.getAllByPagination(new Pagination(10, 0));
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    public static void printAll(StudentMapper studentMapper) {
        List<Student> students = studentMapper.getAll(10, 0);
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    public static void printById(StudentMapper studentMapper, long id) {
        Student student = studentMapper.getById(id);
        if (student == null) {
            System.out.println("id: " + id + " not found");
        } else {
            System.out.println(student);
        }
    }
}
