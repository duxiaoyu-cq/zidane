package com.dxy.zidane.web.controllers.home;

import com.dxy.zidane.home.service.PhotoAnalysis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
@RequestMapping("/home/photo")
public class PhotoController {

    @Autowired
    PhotoAnalysis photoAnalysis;

    @RequestMapping("/index")
    @ResponseBody
    public void index(String dirPath) {
        if (StringUtils.isBlank(dirPath)) {

        }

        photoAnalysis.analysisRepeate(new File(dirPath));
    }


}
