package com.jacky.Controller;

import com.jacky.Entity.Student;
import com.jacky.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips="注册成功";
        //调用service处理Student
        int nums = service.addStudent(student);
        if(nums>0){
            tips="学生"+student.getName()+"注册成功";
        }
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/listStudent.do")
    @ResponseBody
    public List<Student> listStudent(Student student){

        List<Student> students = service.findStudents();
        return students;

    }

    @RequestMapping("/redirect.do")
    public ModelAndView listStudent(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:http://baidu.com");

        return mv;

    }

}
