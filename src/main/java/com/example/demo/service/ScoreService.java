package com.example.demo.service;

import com.example.demo.domain.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author TAO
* @description 针对表【score】的数据库操作Service
* @createDate 2022-10-03 17:04:00
*/
@Transactional(rollbackFor = Exception.class)
public interface ScoreService extends IService<Score> {

}
