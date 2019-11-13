package com.qf.Controller;

import com.qf.pojo.User;
import com.qf.service.BoosService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("Boos")
public class BoosController {
        @Autowired
    private BoosService boosService;

    public BoosService getBoosService() {
        return boosService;
    }

    public void setBoosService(BoosService boosService) {
        this.boosService = boosService;
    }

    @RequestMapping("homePage")
    public String homePage(HttpServletRequest request) {
        //仅测试用，正式版要删除
        if (request.getSession().getAttribute("userName")==null){
            request.getSession().setAttribute("userName", "xiaozhang");
        }
        return "homePage";
    }
//跳转修改密码
    @RequestMapping("boosUpdateUser")
    public String boosUpdateUser() {
        return "boosUpdateUser";
    }

    //保存新密码
    @RequestMapping("saveUser")
    public String saveUser(String password, String password2, HttpServletRequest request, HttpServletResponse response) {
        if (password.equals(password2)) {
            Md5Hash md5Hash = new Md5Hash("password");
            String userName = (String) request.getSession().getAttribute("userName");
            boosService.updateUserByName(userName, md5Hash.toString());
            try {
                PrintWriter writer = response.getWriter();
                writer.write("密码修改成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "homePage";
        }
        try {
            PrintWriter writer = response.getWriter();
            writer.write("两次密码不一致，请重新操作！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "homePage";
    }
}
