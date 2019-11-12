package com.qf.Controller;

import com.qf.pojo.StudentAndClass;
import com.qf.service.HeadTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("HeadTeacher")
public class HeadTeacherController {
    @Autowired
    private HeadTeacherService headTeacherService;
//    @Autowired
//    private SecurityManager securityManager;
    //返回主页
    @RequestMapping("index")
    public String index(){

        return "index";
    }
    @RequestMapping("weeklyShow")
    public String weeklyShow(Model model){
        List<StudentAndClass> studentAndClass = headTeacherService.getStudentAndClass();
        model.addAttribute("studentAndClass",studentAndClass);
        System.out.println(studentAndClass.toString());
        return "headTeacherWeeklyShow";
    }
    @RequestMapping("forms")
    public String forms(){
        return "forms";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("tables")
    public String tables(){
        return "tables";
    }
    @RequestMapping("charts")
    public String charts(){
        return "charts";
    }

}
