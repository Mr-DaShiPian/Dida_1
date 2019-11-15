package com.qf.Controller;

import com.qf.pojo.*;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("HeadTeacher")
public class HeadTeacherController {
    @Autowired
    private HeadTeacherService headTeacherService;

    //    @Autowired
//    private SecurityManager securityManager;
    @RequestMapping("importExcle")
    public String importExcle() {
        return "forms";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("forms")
    public String forms() {
        return "forms";
    }

    @RequestMapping("tables")
    public String tables() {
        return "tables";
    }

    @RequestMapping("charts")
    public String charts() {
        return "charts";
    }

    //返回主页
    @RequestMapping("index")
    public String index() {

        return "index";
    }

    //学生周报管理
    @RequestMapping("weeklyShow")
    public String weeklyShow(Model model) {
        List<StudentAndClass> studentAndClass = headTeacherService.getStudentAndClass();
        model.addAttribute("studentAndClass", studentAndClass);
        return "headTeacherWeeklyShow";
    }

    @RequestMapping("headTeacherStudentShow")
    public String headTeacherStudentShow(@RequestParam(defaultValue = "1") int myClass, Model model) {
        //根据班级查看学生
        List<StudentAndClass> studentAndClass = headTeacherService.getStudentAndClass();
        model.addAttribute("studentAndClass", studentAndClass);
        return "StudentMessageManager";
    }

    //跳转到管理学生页面
    @RequestMapping("headTeacherModifyStudent")
    public String headTeacherModifyStudent(String stuName, Model model) {
        //查到当前修改学生的信息

        Student student = headTeacherService.getStudentByStuName(stuName);
        model.addAttribute("student", student);
        //查询当前学生所在班级
        MyClass myClassByCid = headTeacherService.getMyClassByCid(student.getCid());
        model.addAttribute("myClassByCid", myClassByCid);
        return "headTeacherModifyStudent";
    }

    //周报查看
    @RequestMapping("weeklyShowFull")
    public String weeklyShowFull(String stuName, Model model) {
        List<Weekly> weeklyList = headTeacherService.getWeeklyByStuName(stuName);
        model.addAttribute("weeklyList", weeklyList);
        return "headTeacherWeeklyShowFull";
    }

    //    从编辑页面传过来的数据进行保存
    @RequestMapping("headTeacherSaveStudent")
    public String headTeacherSaveStudent(Student student, RedirectAttributes redirectAttributes) {
        int i = headTeacherService.updateStudent(student);
        redirectAttributes.addAttribute("stuName", student.getStuName());
        if (i > 0) {
            return "redirect:headTeacherStudentShow";
        }
        return "redirect:headTeacherModifyStudent";
    }

    //删除学生
    @RequestMapping("headTeacherDeleteStudent")
    @ResponseBody
    public String headTeacherDeleteStudent(int stuId) {
        int i = headTeacherService.deleteStudent(stuId);
        System.out.println(i);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }

    //全部学生导出
    @RequestMapping("ExportToExcelByAll")
    public void ExportToExcelByAll(String cid, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<Student> classmateList = headTeacherService.getStudentList();
        String fileName = "studentAll" + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = {"排序", "姓名", "年龄", "岁数", "性别", "出生年月", "电话"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for (int i = 0; i < headers.length; i++) {
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
    public void ExportToExcel(String cid, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<Student> classmateList = headTeacherService.getStudentByCid(cid);
        MyClass myClassByCid = headTeacherService.getMyClassByCid(cid);
        String fileName = "grade" + myClassByCid.getcName() + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = {"排序", "姓名", "用户名", "年龄", "岁数", "性别", "出生年月", "电话", "班级Id"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for (int i = 0; i < headers.length; i++) {
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
                student.setStuId(Integer.valueOf((row.getCell(0).getStringCellValue())));
                student.setStuName(row.getCell(1).getStringCellValue());
                student.setUserName(row.getCell(2).getStringCellValue());
                student.setStuAge(Integer.valueOf((row.getCell(3).getStringCellValue())));
                student.setStuSex(row.getCell(4).getStringCellValue());
                student.setStuBirthday(row.getCell(5).getStringCellValue());
                student.setStuTel(row.getCell(6).getStringCellValue());
                student.setCid(row.getCell(7).getStringCellValue());
                StudentList.add(student);
            }
            for (Student student : StudentList) {
                headTeacherService.addStudent(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "<script>alert('导入成功');window.location.href='/HeadTeacher/headTeacherStudentShow';</script>";
    }
//数据表
    @RequestMapping("studentGradeChart")
    public String studentGradeChart(String cid, String weekDate, Model model,String stuName) {
//        返回到学生每个阶段的成绩表
        if (stuName!=null){
            List<Weekly> weeklyByStuNameList = headTeacherService.getWeeklyByStuName(stuName);
            List<String> jieduanList = new ArrayList<>();
            String a = "第一阶段";
            String b = "第一阶段";
            String c = "第一阶段";
            String d = "第一阶段";
            jieduanList.add(a);
            jieduanList.add(b);
            jieduanList.add(c);
            jieduanList.add(d);
            List<Double> doublesList = new ArrayList<>();
            for (Weekly weekly:weeklyByStuNameList
                 ) {
                doublesList.add(weekly.getScore());
            }
            model.addAttribute("jieduanList",jieduanList);
            model.addAttribute("doublesList",doublesList);
            return "headTeacherChart";
        }
//返回到阶段对应成绩表
        int weekDate1 = Integer.parseInt(weekDate);
        String week1 = "2019-11-01";
        String week2 = "2019-11-08";
        String week3 = "2019-10-23";
        String week4 = "2019-10-16";
        List<String> week1_4= new ArrayList<>();
        week1_4.add(week1);
        week1_4.add(week2);
        week1_4.add(week3);
        week1_4.add(week4);
        List<Student> studentByCidList = headTeacherService.getStudentByCid(cid);
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> mapAll = new HashMap<String, Object>();
        List<Weekly> WeeklyList = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                map.put("weekDate", week1_4.get(i-1));
                map.put("studentByCidList", studentByCidList);
                WeeklyList = headTeacherService.getGradeByDate(map);
                mapAll.put("WeeklyList" + i, WeeklyList);
                List<Double> gradeList = new ArrayList<>();
                List<String> nameList = new ArrayList<>();
            }
            List<String> nameList = new ArrayList<>();
            List<Double> gradeList = new ArrayList<>();
        if (weekDate1 == 1) {
                List<Weekly> weeklyList = (List) mapAll.get("WeeklyList" + 1);
                for (Weekly week : weeklyList
                ) {
                    nameList.add(week.getStuName());
                    gradeList.add(week.getScore());

                }
            model.addAttribute("nameList", nameList);
            model.addAttribute("gradeList", gradeList);
            return "headTeacherChart";
            }
        if (weekDate1 == 2) {
            List<Weekly> weeklyList = (List) mapAll.get("WeeklyList" + 2);
            for (Weekly week : weeklyList
            ) {
                nameList.add(week.getStuName());
                gradeList.add(week.getScore());

            }
            model.addAttribute("nameList", nameList);
            model.addAttribute("gradeList", gradeList);
            return "headTeacherChart";
        }
        if (weekDate1 == 3) {
            List<Weekly> weeklyList = (List) mapAll.get("WeeklyList" + 3);
            for (Weekly week : weeklyList
            ) {
                nameList.add(week.getStuName());
                gradeList.add(week.getScore());

            }
            model.addAttribute("nameList", nameList);
            model.addAttribute("gradeList", gradeList);
            return "headTeacherChart";
        }
        if (weekDate1 == 4) {
            List<Weekly> weeklyList = (List) mapAll.get("WeeklyList" + 4);
            for (Weekly week : weeklyList
            ) {
                nameList.add(week.getStuName());
                gradeList.add(week.getScore());

            }
            model.addAttribute("nameList", nameList);
            model.addAttribute("gradeList", gradeList);
            return "headTeacherChart";
        }
        return null;
    }
//////
    @RequestMapping("getLeave")
    public String getLeave(HttpServletRequest request){
        List<Leaves> stuLeaves = headTeacherService.getLeaveByLecture();
        request.setAttribute("stuLeaves",stuLeaves);
        return "headteacherPJ";

    }
    @RequestMapping("agreeLeaves")
    @ResponseBody
    public String agreeLeaves(int lid){
        Leaves leaveDate = headTeacherService.getLeaveDateById(lid);
        String instanceId = headTeacherService.getInstanceId(lid);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = simpleDateFormat.parse(leaveDate.getStartDate());
            end = simpleDateFormat.parse(leaveDate.getEndDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long daysTime = end.getTime() - start.getTime();
        int days = (int)daysTime/(24*60*60*1000);
        if (days>=3) {
            headTeacherService.agreeLeaves(instanceId, lid);
        }else {
            headTeacherService.endLeaves(instanceId,lid);
        }
        return "ok";
    }
    @RequestMapping("myLeaves")
    public String myLeaves(HttpServletRequest request){
        String boosName = headTeacherService.getboosByRole();
        String userName = (String) request.getSession().getAttribute("userName");
        User user = headTeacherService.getUserByUserName(userName);
//        int i = headTeacherService.selectProcess(user.getName());
//        if (i==0){
        request.setAttribute("user",user);
        request.setAttribute("boos",boosName);
        return "hTeacherLeave";
//        }else {
//            return "leaveFailure";
//        }
    }
    @RequestMapping("saveLeave")
    public String saveLeave(Leaves leaves){
        headTeacherService.addLeave(leaves);
        return "homePage";
    }

}
