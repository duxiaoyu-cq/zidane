package com.dxy.zidane.home;

import com.dxy.zidane.common.utils.DateUtil;
import com.dxy.zidane.home.bo.Photo;
import com.dxy.zidane.home.service.PhotoScanner;

import java.io.File;
import java.util.List;

/**
 * @author dxy
 * @date 2019/11/15 17:31
 */
public class Test {
    public static void main(String[] args) {
        PhotoScanner sd = new PhotoScanner();
        List<Photo> photoList = sd.iteratorFiles(new File("E:\\pics"));
        for (Photo photo : photoList) {
            if (photo.getPath().equals("E:\\pics\\carnoe\\IMG_20170608_165801.jpg")) {
                System.out.println("getDateTimeOriginal\t" + DateUtil.format(photo.getDateTimeOriginal()));
                System.out.println("getFileModifiedDate\t" +DateUtil.format(photo.getFileModifiedDate()));
                System.out.println("getCreateTime\t" +DateUtil.format(photo.getCreateTime()));
                System.out.println("getModifyTime\t" +DateUtil.format(photo.getModifyTime()));
                System.out.println("getVisiteTime\t" +DateUtil.format(photo.getVisiteTime()));
            }
        }
    }
}
