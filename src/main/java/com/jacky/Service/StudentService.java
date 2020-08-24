package com.jacky.Service;

import com.jacky.Entity.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> findStudents();

}
