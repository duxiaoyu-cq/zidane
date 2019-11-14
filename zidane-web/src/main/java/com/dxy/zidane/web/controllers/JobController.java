package com.dxy.zidane.web.controllers;


import com.dxy.zidane.common.utils.DateUtil;
import com.dxy.zidane.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @RequestMapping("/list")
    public void list(Long jobId, ModelMap modelMap) {
        modelMap.put("date", DateUtil.format());
        modelMap.put("job", jobService.findById(jobId));
    }
}
