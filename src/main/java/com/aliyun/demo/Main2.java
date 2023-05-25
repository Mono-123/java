package com.aliyun.demo;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStreamReader;
import java.io.Reader;
import com.aliyun.demo.Entity.Score;
import com.aliyun.demo.Mapper.ScoreMapper;

public class Main2 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(
                    Main2.class.getClassLoader().getResourceAsStream("config.properties"));

            // JDBC连接的URL, 不同数据库有不同的格式:
            String JDBC_URL = properties.getProperty("JDBC_URL");
            String JDBC_USER = properties.getProperty("JDBC_USER");
            String JDBC_PASSWORD = properties.getProperty("JDBC_PASSWORD");

            System.out.println("读取了数据库配置如下：");
            System.out.println(JDBC_URL);
            System.out.println(JDBC_USER);
            System.out.println(JDBC_PASSWORD);

            Reader reader = new InputStreamReader(
                    Main2.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader, properties);

            SqlSession session = factory.openSession();
            ScoreMapper ScoreMapper = session.getMapper(ScoreMapper.class);

//查询
            System.out.println("printtop");
            printtop (ScoreMapper);
            System.out.println("print id = 2");
            printById(ScoreMapper, 2);
            System.out.println("print id = 99");
            printById(ScoreMapper, 99);
//插入
            Score newScore = new Score(4, 72, 68, 96);
            ScoreMapper.insertScore(newScore);
            session.commit();
            System.out.println("print after insert: " + newScore.getId());
//输出插入的数据
            Score Score = ScoreMapper.getScore(newScore.getId());
            System.out.println(Score);

//更新 语文加十分
            Score.setchinese(Score.getchinese() + 10);
            System.out.println("add 10 for chinese: ");
            System.out.println(Score);
            ScoreMapper.updateChinese(Score);
            session.commit();
            System.out.println("print after update: " + newScore.getId());
            printById(ScoreMapper, newScore.getId());
//删除
            ScoreMapper.deleteScore(newScore.getId());
            session.commit();
            System.out.println("print after delete: " + newScore.getId());
            printById(ScoreMapper, newScore.getId());

            session.close();
        } catch (Exception e) {
            System.out.println("读取配置文件失败");
            e.printStackTrace();
        }
    }

    public static void printtop(ScoreMapper ScoreMapper) {
        List<Score> Scores = ScoreMapper.getScorePagination(10, 0);
        for (Score score : Scores) {
            System.out.println(score);
        }
    }

    public static void printById(ScoreMapper ScoreMapper, long id) {
        Score Score = ScoreMapper.getScore(id);
        if (Score == null) {
            System.out.println("id: " + id + " not found");
        } else {
            System.out.println(Score);
        }
    }
}
