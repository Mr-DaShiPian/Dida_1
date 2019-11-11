package com.qf.Controller;

import com.qf.pojo.Student;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("Student")
public class StudentController {
 @Autowired
    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("myInfor")
    public String myInfor(){
        return "myInfor";
    }

    //根据用户名查到Student信息传到修改页面
    @RequestMapping("getStudent")
    public String getStudent(HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userName");
        Student student = studentService.getStudentByUserName(userName);
        request.setAttribute("student",student);
        return "updataStudent";
    }

    //保存修改内容，跳转
    @RequestMapping("saveStudent")
    public String saveStudent(Student student, HttpServletResponse response){
        studentService.updateStudent(student);
        try {
            PrintWriter writer = response.getWriter();
            writer.write("修改成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "myInfor";
    }
}
