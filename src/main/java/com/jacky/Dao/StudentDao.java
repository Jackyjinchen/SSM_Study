package com.jacky.Dao;

import com.jacky.Entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
}
