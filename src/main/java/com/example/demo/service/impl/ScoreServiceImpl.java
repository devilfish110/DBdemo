package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.domain.Score;
import com.example.demo.service.ScoreService;
import com.example.demo.mapper.ScoreMapper;
import org.springframework.stereotype.Service;

/**
* @author TAO
* @description 针对表【score】的数据库操作Service实现
* @createDate 2022-10-03 17:04:00
*/
@Service("scoreService")
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService{

}




