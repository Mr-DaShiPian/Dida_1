package com.qf.Controller;

import com.qf.pojo.Student;
import com.qf.pojo.Weekly;
import com.qf.service.StudentService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

    @RequestMapping("homePage")
    public String homePage(HttpServletRequest request){
        request.getSession().setAttribute("userName","xiaoming");
        return "homePage";
    }

    //个人资料管理
    @RequestMapping("studentInfor")
    public String myInfor() {
        return "studentInfor";
    }

    //根据用户名查到Student信息传到修改页面
    @RequestMapping("getStudent")
    public String getStudent(HttpServletRequest request) {
        if (request.getSession().getAttribute("student") == null) {
            String userName = (String) request.getSession().getAttribute("userName");
            Student student = studentService.getStudentByUserName(userName);
            request.getSession().setAttribute("student", student);
        }
        return "studentUpdateUser";
    }

    //保存修改信息内容，跳转
    @RequestMapping("saveStudent")
    public String saveStudent(Student student, HttpServletRequest request, HttpServletResponse response) {
        studentService.updateStudent(student);
        String userName = (String) request.getSession().getAttribute("userName");
        Student student2 = studentService.getStudentByUserName(userName);
        request.getSession().setAttribute("student", student2);
        try {
            PrintWriter writer = response.getWriter();
            writer.write("修改成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "studentInfor";
    }

    //跳转修改密码页面
    @RequestMapping("getUser")
    public String getUser() {
        return "studentUpdateUser";
    }

    //保存新密码
    @RequestMapping("saveUser")
    public String saveUser(String password, String password2, HttpServletRequest request, HttpServletResponse response) {
        if (password.equals(password2)) {
            Md5Hash md5Hash = new Md5Hash("password");
            String userName = (String) request.getSession().getAttribute("userName");
            //缺少user的方法调用
            try {
                PrintWriter writer = response.getWriter();
                writer.write("密码修改成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "studentInfor";
        }
        try {
            PrintWriter writer = response.getWriter();
            writer.write("两次密码不一致，请重新操作！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "studentInfor";
    }

    //获取学生周报列表
    @RequestMapping("studentWeekly")
    public String studentWeekly(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute("student");
        List<Weekly> weeklyList = studentService.getWeeklyByName(student.getStuName());
        request.getSession().setAttribute("weeklyList",weeklyList);
        return "studentWeekly";

    }
}
