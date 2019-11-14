package com.dxy.zidane.service;

import com.dxy.zidane.dao.mapper.JobMapper;
import com.dxy.zidane.dao.pojo.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    JobMapper jobMapper;

    public Job findById(Long id) {
        return jobMapper.selectByPrimaryKey(id);
    }

}
