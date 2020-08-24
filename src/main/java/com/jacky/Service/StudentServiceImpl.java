package com.jacky.Service;

import com.jacky.Dao.StudentDao;
import com.jacky.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {

        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> findStudents() {

        return studentDao.selectStudents();
    }
}
