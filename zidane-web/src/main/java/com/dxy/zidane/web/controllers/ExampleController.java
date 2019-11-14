package com.dxy.zidane.web.controllers;

import com.dxy.zidane.dao.pojo.Job;
import com.dxy.zidane.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    JobService jobService;

    @RequestMapping("/show")
    public void show(Long id, ModelMap modelMap) {
        Job job = jobService.findById(id);
        System.out.println(job.getName() + "\t" + job.getDescription());
        modelMap.put("job", job);
    }

    @RequestMapping("/show2")
    @ResponseBody
    public String show2(Long id, ModelMap modelMap) {
        Job job = jobService.findById(id);
        return "hello " + (job == null ? "" : job.getName()) + " !!!<br>" + job.getDescription();
    }

}
