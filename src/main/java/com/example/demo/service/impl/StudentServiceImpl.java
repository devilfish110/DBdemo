package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import com.example.demo.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author TAO
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-10-03 17:04:00
*/
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

}




