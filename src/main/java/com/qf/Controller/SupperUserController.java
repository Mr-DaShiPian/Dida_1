package com.qf.Controller;

import com.qf.pojo.MyClass;
import com.qf.pojo.User;
import com.qf.service.SupperUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("SupperUser")
public class SupperUserController {
    @Autowired
    private SupperUserService supperUserService;

    public SupperUserService getSupperUserService() {
        return supperUserService;
    }

    public void setSupperUserService(SupperUserService supperUserService) {
        this.supperUserService = supperUserService;
    }
    /**
     * 课程管理,从主页跳转
     */
    @RequestMapping("selectClass")
    public String selectClass(){
        return "redirect:seeClass";
    }
    //展示课程
    @RequestMapping("seeClass")
    public String seeClass(Model model){
        List<MyClass> classList = supperUserService.selectClass();
        model.addAttribute("classList",classList);
        //查询到的角色信息
        List<User> roleList = supperUserService.selectRoleList();
        model.addAttribute("roleList",roleList);
        return "supperClassPage";
    }
    @RequestMapping("saveClass")
    public String saveClass(){
        return "superAddClass";
    }
    @RequestMapping("addClass")
    public String addClass(String cName,String tName){
        System.out.println(cName);
        MyClass myClass = new MyClass(cName,tName);
        int i = supperUserService.insertClass(myClass);
        if(i>0){
            return "redirect:seeClass";
        }
        return "saveClass";
    }

    /**
     * 修改课程信息
     * @return
     */
    @RequestMapping("editClass")
    public String editClass(int id,Model model){
        List<MyClass> classList = supperUserService.selectClassById(id);
        model.addAttribute("classList",classList);
        model.addAttribute("id",id);
        return "superEditClass";
    }

    @RequestMapping("modifyClass")
    public String modifyClass(int id,String cName,String tName){
        MyClass myClass = new MyClass(id,cName,tName);
        int i = supperUserService.updateClassById(myClass);
        if(i>0){
            return "redirect:seeClass";
        }
        return "editClass";
    }

    @RequestMapping("deleteClass")
    public String deleteClass(int id){
        int i = supperUserService.deleteClass(id);
        if(i>0){
            return "redirect:seeClass";
        }
        return "redirect:seeClass";
    }
    //角色管理
//    @RequestMapping("selectRole")
//   public String selectRole(Model model){
//       List<User> roleList = supperUserService.selectRoleList();
//       model.addAttribute("roleList",roleList);
//       return "supperClassPage";
//   }
    //增加角色?需要吗
    @RequestMapping("addRole")
    public String addRole(){
        return "superAddRole";
    }
    //修改用户角色
    @RequestMapping("editRole")
    public String editRole(int userId,Model model){
        User user = new User(userId);
        model.addAttribute("userId",userId);
        return "supermodifyRole";
    }
    @RequestMapping("modifyRole")
    public String modifyRole(){
        return "";
    }
}
