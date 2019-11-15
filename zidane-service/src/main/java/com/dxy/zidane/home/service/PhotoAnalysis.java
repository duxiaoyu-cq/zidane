package com.dxy.zidane.home.service;

import com.dxy.zidane.home.bo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dxy
 * @date 2019/11/15 15:51
 */
@Service
public class PhotoAnalysis {

    @Autowired
    PhotoScanner photoScanner;

    public Map<String, List<Photo>> analysisRepeate(File rootDir) {
        if (!rootDir.exists()) {
            return null;
        }

        if (!rootDir.isDirectory()) {
            return null;
        }

        List<Photo> photoList = photoScanner.iteratorFiles(rootDir);
        Map<String, List<Photo>> md5PhotosMap = photoList.stream().sorted(Comparator.comparing(Photo::getDateTimeOriginal).thenComparing(Photo::getCreateTime)).collect(Collectors.groupingBy(Photo::getMd5));
        return md5PhotosMap;
    }

}
