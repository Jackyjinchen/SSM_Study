package com.jacky.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacky.Entity.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class MyController {

    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doGet(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","Welcome!GET方式");
        mv.addObject("age","欢迎使用SpringMVC");

        //配置了视图解析器，可以直接用逻辑名称指定方式
        mv.setViewName("show");

        return mv;
    }

    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doPost(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        
        //配置了视图解析器，可以直接用逻辑名称指定方式
        mv.setViewName("other");

        return mv;
    }

    @RequestMapping(value = "/object.do",method = RequestMethod.POST)
    public ModelAndView doObject(Student student){
        ModelAndView mv = new ModelAndView();
        System.out.println(student.toString());
        mv.addObject("name",student.getName());
        mv.addObject("age",student.getAge());

        //配置了视图解析器，可以直接用逻辑名称指定方式
        mv.setViewName("object");

        return mv;
    }

    @RequestMapping(value = "/returnstring.do",method = RequestMethod.POST)
    public String doStringReturn(){

        return "returnString";
    }

    @RequestMapping(value = "/returnvoid.do")
    public void doVoidReturn(HttpServletResponse response,Student student) throws IOException {
        String json="";
        //service 已经调用完了
        //json
        if(student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("获得了" + json);
        }
        response.setContentType("application/json;charset=uft-8");
//        PrintWriter pw = response.getWriter();
//        pw.write(json);
    }

    @RequestMapping(value = "/returnobject.do")
    @ResponseBody
    public Student doObjectReturn(HttpServletResponse response,Student student) throws IOException {
        //service 已经调用完了
        return student;

    }

    @RequestMapping(value = "/returnlist.do")
    @ResponseBody
    public List<Student> dolistReturn(HttpServletResponse response, Student student) throws IOException {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student();
        student1.setAge(25);
        student1.setName("jacky");
        list.add(student);
        list.add(student1);
        return list;

    }

}
