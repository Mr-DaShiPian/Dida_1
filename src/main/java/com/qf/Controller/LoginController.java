package com.qf.Controller;

import com.qf.service.HeadTeacherService;
import com.qf.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private HeadTeacherService headTeacherService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private SecurityManager securityManager;
    //跳转到修改密码页面
    @RequestMapping("passwordEdit")
    public String passwordEdit(Model model){
        return "passwordEdit";
    }
    //保存需要修改的密码
    @RequestMapping("passwordSave")
    public String passwordSave(String password,String userName){
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        int i = loginService.updatePassword(md5Password,userName);
        if (i>0){
            return "redirect:/HeadTeacher/weeklyShow";
        }
        return "redirect:passwordEdit";
    }
    @RequestMapping("loginPage")
    public String loginPage(){
        return "userLogin";
    }
    @RequestMapping("login")
    public String login(String userName,String password){
        SecurityUtils.setSecurityManager(securityManager);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()){
                //添加到session里面
                Session session = subject.getSession();
                session.setAttribute("userName",userName);
                return "redirect:/HeadTeacher/weeklyShow";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:loginPage";
    }

}
