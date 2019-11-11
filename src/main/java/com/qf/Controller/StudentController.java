package com.qf.Controller;

import com.qf.pojo.Student;
import com.qf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("getStudent")
    public String getStudent(HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("userName");
        Student student = studentService.getStudentByUserName(userName);
        request.setAttribute("student",student);
        return "updataStudent";
    }
}
