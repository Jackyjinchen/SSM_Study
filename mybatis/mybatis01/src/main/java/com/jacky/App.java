package com.jacky;

import com.jacky.dao.StudentDao;
import com.jacky.entity.Student;
import com.jacky.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //执行语句
        List<Student> studentList = dao.selectStudent();

        //获取list
        for (Student stu : studentList) {
            System.out.println(stu);
        }
        //关闭session
        sqlSession.close();
        System.out.println( "Hello World!" );
    }
}
