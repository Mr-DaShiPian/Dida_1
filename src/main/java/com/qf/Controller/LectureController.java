package com.qf.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Student;

import com.qf.pojo.User;
import com.qf.service.LectureService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("Lecture")
public class LectureController {
   @Autowired
    private LectureService lectureService;
    @Autowired
    private SecurityManager securityManager;
    //学生信息查看分页
    @RequestMapping("lectureindex")
    public String index(@RequestParam(defaultValue = "1") int pageNum, Model model){
        PageHelper.startPage(pageNum,5);
        List<Student> StudentList = lectureService.getStudentList();
        PageInfo<Student> pageInfo = new PageInfo<Student>(StudentList);
        model.addAttribute("pageInfo",pageInfo);
        return "lectureindex";
    }

    //学生数据导出
    @RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        List<Student> classmateList = lectureService.getStudentList();

        String fileName = "userinf"+"信息表"+".xls";//设置要导出的文件的名字
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


}
