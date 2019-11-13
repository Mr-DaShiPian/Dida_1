package com.qf.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Score;
import com.qf.pojo.Student;

import com.qf.pojo.Weekly;
import com.qf.service.LectureService;
import org.apache.poi.hssf.usermodel.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Lecture")
public class LectureController {
    @Autowired
    private LectureService lectureService;

    //学生信息查看--分页
    @RequestMapping("lectureindex")
    public String index(@RequestParam(defaultValue = "1") int pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Student> studentList = lectureService.getStudentList();
        PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
        model.addAttribute("pageInfo", pageInfo);
        return "lectureindex";
    }

    //学生数据导出
    @RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<Student> classmateList = lectureService.getStudentList();
        String fileName = "userinf" + "信息表" + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = {"序号", "姓名", "年龄", "岁数", "性别", "出生年月", "电话"};
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

    //学生成绩走势图
    @RequestMapping("studentchart")
    public String echarts(Model model,String stuName) {
        List<String> names = new ArrayList<String>();
        List datas = lectureService.StudentChart(stuName );
        names.add("一回合");
        names.add("二回合");
        names.add("三回合");
        model.addAttribute("names", names);
        model.addAttribute("datas", datas);
        return "studentchart";
    }
    //班级学生成绩柱状图
    @RequestMapping("classchart")
    public String classecharts(Model model , Score score) {
        List datas = new ArrayList();
        List<Score> chart = lectureService.ClassChart(score);
        int one = 0;
        int two = 0;
        int three=0;
        int fore = 0;
        for (Score i :chart) {
          one += i.getStageA();
           two += i.getStageB()/chart.size();
            three += i.getStageC()/chart.size();
             fore += i.getStageD()/chart.size();
        }
        datas.add(one/chart.size());
        datas.add(two/chart.size());
        datas.add(three/chart.size());
        datas.add(fore/chart.size());
        List<String> names = new ArrayList<String>();
        names.add("一阶段");
        names.add("二阶段");
        names.add("三阶段");
        names.add("四阶段");
        model.addAttribute("names", names);
        model.addAttribute("datas", datas);
        return "classchart";
    }

    //学生信息查看--分页
    @RequestMapping("lectureweekly")
    public String lectureweekly(@RequestParam(defaultValue = "1") int pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Weekly> weeklyList = lectureService.getWeeklyList();
        PageInfo<Weekly> pageInfo = new PageInfo<Weekly>(weeklyList);
        model.addAttribute("pageInfo", pageInfo);
        return "lectureweekly";
    }
//修改学生成绩
    @RequestMapping("lectureweeklyscore")
    public String lectureweeklyscore(int wkId,int score) {
        lectureService.updatelectureweeklyscore(wkId,score);

            return "redirect:lectureweekly";
     }
     //学生姓名去重周报
    @RequestMapping("lecturestudentchart")
    public String studentList(Model model){
        List<Weekly> studentnameList = lectureService.getWeeklyListchart();
        model.addAttribute("studentnameList",studentnameList);
        return "lecturestudentchart";
    }
}
