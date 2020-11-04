package com.jacky;

import com.jacky.entity.Student;
import com.jacky.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.io.IOException;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testinsert() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //指定sql语句标识
        String sqlId="com.jacky.dao.StudentDao"+"."+"insertStudent";
        //执行语句
        Student student = new Student();
        student.setAge(26);
        student.setEmail("zhangxiangyu@163.com");
        student.setId(4);
        student.setName("zhangxiangyu");

        Integer studentList = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        System.out.println("影响了"+studentList+"行");
        //关闭session
        sqlSession.close();
        System.out.println( "Hello World!" );
    }
}
