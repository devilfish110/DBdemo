package com.example.demo.service;

import com.example.demo.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author TAO
* @description 针对表【student】的数据库操作Service
* @createDate 2022-10-03 17:04:00
*/
@Transactional(rollbackFor = Exception.class)
public interface StudentService extends IService<Student> {

}
