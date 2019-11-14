package com.qf.Controller;

import com.qf.pojo.MyClass;
import com.qf.pojo.User;
import com.qf.service.SupperUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
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
//        @RequestMapping("testHtml")
//        public String test(){
//        return "superIncreaseclass";
//   }
    /**
     * 课程管理,从主页跳转
     * 其他页面跳转的 链接 : /SupperUser/selectClass
     *
     *
     */
    @RequestMapping("selectClass")
    public String selectClass(){
        return "redirect:seeClass";
    }
    //展示课程
    @RequestMapping("seeClass")
    public String seeClass(Model model,String name){
        List<MyClass> classList = supperUserService.selectClass();
        model.addAttribute("classList",classList);
        //查询到的角色信息
        List<User> roleList = supperUserService.selectRoleList();
        model.addAttribute("roleList",roleList);
        //查询到的员工信息
        String role = "'学生'";
        User user = new User(name,role);
        List<User> staffList = supperUserService.selectStaffByUname(user);
        model.addAttribute("staffList",staffList);
        //查询到的班级信息
        List<MyClass> classList1 = supperUserService.selectClassByCid();
        model.addAttribute("classList1",classList1);
        return "supperClassPage";
    }
    @RequestMapping("saveClass")
    public String saveClass(){
        return "superAddClass";
    }
    @RequestMapping("addClass")
    public String addClass(String cName,String tName){
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
    //增加角色
    @RequestMapping("addRole")
    public String addRole(){
        return "superAddRole";
    }
    @RequestMapping("saveRole")
    public String saveRole(String role){
        User user = new User(role);
        int i = supperUserService.insertRoleByUser(user);
        if(i>0){
            return "redirect:seeClass";
        }
            return "addRole";
    }
    //修改用户角色
    @RequestMapping("editRole")
    public String editRole(int userId,Model model){
        List<User> roleList = supperUserService.selectRoleListById(userId);
        List<User> roles = supperUserService.selectRoles();
        model.addAttribute("roles",roles);
        model.addAttribute("roleList",roleList);
        model.addAttribute("userId",userId);
        return "supermodifyRole";
    }
    @RequestMapping("modifyRole")
    public String modifyRole(int userId,String role){
        User user = new User(userId,role);
        int i = supperUserService.updateRoleById(user);
        if(i>0){
            return "redirect:selectClass";
        }
        return "supermodifyRole";
    }
    //删除角色,测试sql语句,未用ajax
    @RequestMapping("deleteRole")
    public String deleteRole(int userId){
        int i = supperUserService.deleteRole(userId);
        if(i>0){
            return "redirect:seeClass";
        }
        return "redirect:seeClass";
    }
    //员工管理
    //页面展示在第一条
    //新增员工
    @RequestMapping("addStaff")
    public String addStaff(){
        return "superAddStaff";
    }

    @RequestMapping("saveStaff")
    public String saveStaff(String name,String role){
        User user = new User(name,role);
        int i = supperUserService.insertStaff(user);
        if(i>0){
            return "redirect:selectClass";
        }
        return "addStaff";
    }
    //修改
    @RequestMapping("editStaff")
    public String editStaff(int userId,Model model){
        List<User> staffList = supperUserService.selectStaffByUserId(userId);
        model.addAttribute("userId",userId);
        model.addAttribute("staffList",staffList);
        return "supperModifyStaff";
    }

    @RequestMapping("editSaveStaff")
    public String saveStaff(int userId,String name,String role){
        User user = new User(userId,name,role);
        int i = supperUserService.updateStaff(user);
        if(i>0){
            return "redirect:selectselectClass";
        }
        return "redirect:editStaff";
    }
    //搜索员工
//    @RequestMapping("searchStaff")
//    public String searchStaff(String name,Model model){
//        List<User> staffLikeList = supperUserService.selectStaffByUname(name);
//        model.addAttribute("staffLikeList",staffLikeList);
//        return "";
//    }
    //班级管理
    @RequestMapping("Increaseclass")
    public String Increaseclass(){
        return "superIncreaseclass";
    }
    @RequestMapping("saveIncreaseclass")
    public String saveIncreaseclass(String cid,String cName,String tName,String bName){
        MyClass myClass = new MyClass(cid,cName,tName,bName);
        int i = supperUserService.insertClass2(myClass);
        if(i>0){
            return "redirect:selectClass";
        }
        return "superIncreaseclass";
    }
}
