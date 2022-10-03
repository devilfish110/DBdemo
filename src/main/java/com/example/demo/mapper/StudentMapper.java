package com.example.demo.mapper;

import com.example.demo.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author TAO
* @description 针对表【student】的数据库操作Mapper
* @createDate 2022-10-03 17:04:00
* @Entity com.excel_write_read.domain.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




