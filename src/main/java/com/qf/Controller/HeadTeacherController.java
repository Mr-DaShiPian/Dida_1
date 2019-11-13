package com.qf.Controller;

import com.qf.pojo.MyClass;
import com.qf.pojo.Student;
import com.qf.pojo.StudentAndClass;
import com.qf.service.HeadTeacherService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("HeadTeacher")
public class HeadTeacherController {
    @Autowired
    private HeadTeacherService headTeacherService;
//    @Autowired
//    private SecurityManager securityManager;
@RequestMapping("importExcle")
public String importExcle(){
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
    //返回主页
    @RequestMapping("index")
    public String index(){

        return "index";
    }
    //学生周报管理
    @RequestMapping("weeklyShow")
    public String weeklyShow(Model model){
        List<StudentAndClass> studentAndClass = headTeacherService.getStudentAndClass();
        model.addAttribute("studentAndClass",studentAndClass);
        return "headTeacherWeeklyShow";
    }
   @RequestMapping("headTeacherStudentShow")
    public String headTeacherStudentShow(@RequestParam(defaultValue = "1")int myClass, Model model){
    //根据班级查看学生
       List<StudentAndClass> studentAndClass = headTeacherService.getStudentAndClass();
       model.addAttribute("studentAndClass",studentAndClass);
       return "StudentMessageManager";
   }
   //跳转到管理学生页面
    @RequestMapping("headTeacherModifyStudent")
    public String headTeacherModifyStudent(String  stuName,Model model){
    //查到当前修改学生的信息

        Student student = headTeacherService.getStudentByStuName(stuName);
        model.addAttribute("student",student);
        //查询当前学生所在班级
        MyClass myClassByCid = headTeacherService.getMyClassByCid(student.getCid());
        model.addAttribute("myClassByCid",myClassByCid);
        return "headTeacherModifyStudent";
    }
//    从编辑页面传过来的数据进行保存
    @RequestMapping("headTeacherSaveStudent")
    public String headTeacherSaveStudent(Student student, RedirectAttributes redirectAttributes){
        int i = headTeacherService.updateStudent(student);
        redirectAttributes.addAttribute("stuName",student.getStuName());
        if (i>0){
            return "redirect:headTeacherStudentShow";
        }
        return "redirect:headTeacherModifyStudent";
    }
    //删除学生
    @RequestMapping("headTeacherDeleteStudent")
    @ResponseBody
    public String headTeacherDeleteStudent(int stuId){
        int i = headTeacherService.deleteStudent(stuId);
        if(i > 0){
            return "success";
        }
        return "fail";
    }
    //全部学生导出
    @RequestMapping("ExportToExcelByAll")
    public void ExportToExcelByAll(String cid,HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<Student> classmateList = headTeacherService.getStudentList();
        String fileName = "studentAll"+".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "排序", "姓名", "年龄", "岁数","性别","出生年月","电话"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (Student student : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(student.getCid());
            row1.createCell(1).setCellValue(student.getStuName());
            row1.createCell(2).setCellValue(student.getStuAge());
            row1.createCell(3).setCellValue(student.getStuSex());
            row1.createCell(4).setCellValue(student.getStuBirthday());
            row1.createCell(5).setCellValue(student.getStuTel());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    //根据班级导出
    @RequestMapping("ExportToExcel")
    public void ExportToExcel(String cid ,HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<Student> classmateList = headTeacherService.getStudentByCid(cid);
        MyClass myClassByCid = headTeacherService.getMyClassByCid(cid);
        String fileName = "grade"+myClassByCid.getcName()+".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "排序", "姓名","用户名", "年龄", "岁数","性别","出生年月","电话","班级Id"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (Student student : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(student.getCid());
            row1.createCell(1).setCellValue(student.getStuName());
            row1.createCell(2).setCellValue(student.getUserName());
            row1.createCell(3).setCellValue(student.getStuAge());
            row1.createCell(4).setCellValue(student.getStuSex());
            row1.createCell(5).setCellValue(student.getStuBirthday());
            row1.createCell(6).setCellValue(student.getStuTel());
            row1.createCell(7).setCellValue(student.getCid());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    //导入excel
    //处理文件上传
    @ResponseBody//返回json数据
    @RequestMapping("excelImport")
    public String excelImport(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            return "文件为空！";
        }
        try {
//根据路径获取这个操作excel的实例
            HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream());            //根据页面index 获取sheet页
            HSSFSheet sheet = wb.getSheetAt(0);
//实体类集合
            List<Student> StudentList = new ArrayList<Student>();
            HSSFRow row = null;
//循环sesheet页中数据从第二行开始，第一行是标题
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            //获取每一行数据
                Student student = new Student();
                row = sheet.getRow(i);
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                student.setStuId(Integer.valueOf((row.getCell(0).getStringCellValue()) ));
                student.setStuName(row.getCell(1).getStringCellValue());
                student.setUserName(row.getCell(2).getStringCellValue());
                student.setStuAge(Integer.valueOf((row.getCell(3).getStringCellValue()) ));
                student.setStuSex(row.getCell(4).getStringCellValue());
                student.setStuBirthday(row.getCell(5).getStringCellValue());
                student.setStuTel(row.getCell(6).getStringCellValue());
                student.setCid(row.getCell(7).getStringCellValue());
                StudentList.add(student);
            }
            for (Student student : StudentList) {
//                今天从写一个mapper开始写添加学生数据,注意参数里获取cid,根据班级导入学生
                    headTeacherService.addStudent(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<script>alert('导入成功');window.location.href='/HeadTeacher/headTeacherStudentShow';</script>";


    }
}
