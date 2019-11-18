package com.dxy.zidane.web.controllers.home;

import com.dxy.zidane.common.web.response.CodeEnum;
import com.dxy.zidane.common.web.response.JSONResponse;
import com.dxy.zidane.home.bo.Photo;
import com.dxy.zidane.home.service.PhotoAnalysis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home/photo")
public class PhotoController {

    @Autowired
    PhotoAnalysis photoAnalysis;

    @RequestMapping("/index")
    public void index() {

    }

    @RequestMapping("/dirAnalysis")
    @ResponseBody
    public Object dirAnalysis(String dirPath) {
        if (StringUtils.isBlank(dirPath)) {
            return JSONResponse.build().failure(CodeEnum.INVALID_PARAM);
        }

        File dir = new File(dirPath);
        if (dir == null || !dir.exists()) {
            return JSONResponse.build().failure("路径不存在");
        }
        if (!dir.isDirectory()) {
            return JSONResponse.build().failure("不是有效文件夹");
        }

        Map<String, List<Photo>> photoGroupsMap = photoAnalysis.analysisRepeate(dir);
        return JSONResponse.build().successful(photoGroupsMap);
    }


}
