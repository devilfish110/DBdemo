package com.example.demo;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import com.example.demo.util.DateToString;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class student_read_write {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(student_read_write.class);
        StudentService studentService = context.getBean("studentService", StudentService.class);
        //Scanner反应键盘操作
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入操作指令:    1.导入数据         2.导出数据");
        int num = sc.nextInt();
        if (num == 1) {
            //导入:
            //1.1读取excel中的数据
            //需要导入的excel表路径:D:\Desktop\学生信息表.xlsx
            /*System.out.println("请输入需要导入的excel路径(不能有空格):");
            String path = sc.next();//接收键盘操作*/
            List<Student> StudentList = read("D:\\Desktop\\学生信息表.xlsx");
            //1.2把Excel的数据存出到数据库里
            System.out.println("====================================================");
            StudentList.forEach(System.out::println);
            System.out.println("====================================================");
            studentService.saveBatch(StudentList);
            System.out.println("Excel已存入数据库！！");
        } else if (num == 2) {
            //导出:
            // 2.1从数据库获取数据
            List<Student> list = studentService.list();
            // 2.2把得到的数据写入Excel,导出到桌面上
            write(list, "D:\\Desktop\\学生信息表.xlsx");
            System.out.println("已经成功导出Excel表!");
        } else {
            System.out.println("指令错误请重试！！");
        }

    }

    //构造Excel读取方法
    public static List<Student> read(String path) {
        //1.读取excel数据
        ArrayList<Student> StudentList = new ArrayList<>();//创建一个StudentList存储所有获得的excel数据
        try {
            XSSFWorkbook Workbook = new XSSFWorkbook(path);
            XSSFSheet sheet1 = Workbook.getSheetAt(0);//第一张sheet表
            int LastRowNum = sheet1.getLastRowNum();//得到最后一行的索引
            for (int i = 1; i <= LastRowNum; i++) {//从第一行（i）迭代至最后一行
                XSSFRow row = sheet1.getRow(i);//得到第i行
                if (row != null) {
                    List<String> list = new ArrayList<>();
                    for (Cell cell : row) {//循环嵌套，遍历每个单元格
                        if (cell != null) {
                            String value = getCellValue(cell);
                            list.add(value);
                        }
                    }
                    if (list.size() > 0) {//list里有东西则封装
                        Student student = new Student();
                        student.setStudentId(Integer.valueOf(list.get(0)));
                        student.setStudentName(list.get(1));
                        student.setGender(Integer.valueOf(list.get(2)));
                        student.setBirthday(DateToString.toDate(list.get(3)));
                        student.setAddress(list.get(4));
                        student.setProfessionalId(Integer.valueOf(list.get(5)));
                        student.setTotalCredits(Integer.valueOf(list.get(6)));
                        student.setRemark(list.get(7));
                        student.setDeleted(Integer.valueOf(list.get(8)));
                        student.setVersion(Integer.valueOf(list.get(9)));
                        StudentList.add(student);
                    }
                }
            }
            Workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StudentList;
    }


    //构造Excel写入方法
    public static void write(List<Student> Student, String path2) throws IOException {
        //创建一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个sheet表,并设置表名
        XSSFSheet sheet = workbook.createSheet("学生表");

        //创建行
        XSSFRow row = sheet.createRow(0);//创建第1行
        XSSFCell cell = row.createCell(0);//第1个单元格
        cell.setCellValue("学号");

        XSSFCell cell1 = row.createCell(1);//第2个单元格
        cell1.setCellValue("姓名");

        XSSFCell cell2 = row.createCell(2);//第3个单元格
        cell2.setCellValue("性别");

        XSSFCell cell3 = row.createCell(3);//第4个单元格
        cell3.setCellValue("出生时间");

        XSSFCell cell4 = row.createCell(4);//第5个单元格
        cell4.setCellValue("住址");

        XSSFCell cell5 = row.createCell(5);//第6个单元格
        cell5.setCellValue("专业id");

        XSSFCell cell6 = row.createCell(6);//第7个单元格
        cell6.setCellValue("总学分");

        XSSFCell cell7 = row.createCell(7);//第8个单元格
        cell7.setCellValue("备注");

        XSSFCell cell8 = row.createCell(8);//第9个单元格
        cell8.setCellValue("deleted");

        XSSFCell cell9 = row.createCell(9);//第9个单元格
        cell9.setCellValue("Version");

        //遍历写入每个单元格
        for (int i = 0; i < Student.size(); i++) {
            Student j = Student.get(i);
            XSSFRow row1 = sheet.createRow(i + 1);//每次写完就在创建一行
            row1.createCell(0).setCellValue(j.getStudentId());
            row1.createCell(1).setCellValue(j.getStudentName());
            row1.createCell(2).setCellValue(j.getGender());
            row1.createCell(3).setCellValue(j.getBirthday());
            row1.createCell(4).setCellValue(j.getAddress());
            row1.createCell(5).setCellValue(j.getProfessionalId());
            row1.createCell(6).setCellValue(j.getTotalCredits());
            row1.createCell(7).setCellValue(j.getRemark());
            row1.createCell(8).setCellValue(j.getDeleted());
            row1.createCell(9).setCellValue(j.getVersion());
        }
        //文件写入
        FileOutputStream fileOutputStream = new FileOutputStream(path2);
        workbook.write(fileOutputStream);
        //刷新
        fileOutputStream.flush();
        //释放资源
        fileOutputStream.close();
        workbook.close();
    }

    //获取cellValue
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        // 判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                cellValue = null;
                break;
            case Cell.CELL_TYPE_ERROR:
                cellValue = "非法字符串";
                break;
            case Cell.CELL_TYPE_NUMERIC: // 数值类型
                short format = cell.getCellStyle().getDataFormat();
                if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    // 验证short值
                    if (format == 14 || format == 31 || format == 57 || format == 58
                            || (176<=format && format<=178) || (182<=format && format<=196)
                            || (210<=format && format<=213) || (208==format )) {
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    } else if (format == 20 || format == 32 || format==183 || (200<=format && format<=209)) {
                        sdf = new SimpleDateFormat("HH:mm:ss");
                    } else {
                        cellValue = "为知字符";
                        break;
                    }
                    Date date = cell.getDateCellValue();
                    cellValue = sdf.format(date);
                    break;
                } else if (format == 0) {//处理数值格式
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cellValue = String.valueOf(cell.getRichStringCellValue().getString());
                    break;
                }
        }
        return cellValue;
    }
}
