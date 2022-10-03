package com.example.demo.mapper;

import com.example.demo.domain.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author TAO
* @description 针对表【score】的数据库操作Mapper
* @createDate 2022-10-03 17:04:00
* @Entity com.excel_write_read.domain.Score
*/
@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

}




