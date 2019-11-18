package com.dxy.zidane.home.service;

import com.dxy.zidane.home.bo.File;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 文件扫描器
 *
 * @author dxy
 * @date 2019/11/11 13:59
 */
@Service
public abstract class AbstractFileScanner<T extends File> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFileScanner.class);

    /**
     * 扫描的文件类型
     *
     * @return
     */
    public abstract String[] includeExtensions();

    /**
     * 文件转换器
     *
     * @param file
     * @return
     */
    public abstract T fileConverter(java.io.File file);


    public void reporter(java.io.File file) {
        LOGGER.info("processing " + file.getPath());
    }

    public List<T> iteratorFiles(java.io.File dir) {
        List<T> ret = new ArrayList<>();
        Collection<java.io.File> fileCollection = FileUtils.listFiles(dir, includeExtensions(), true);
        fileCollection.forEach(file -> {
            reporter(file);
            ret.add(fileConverter(file));
        });

        return ret;
    }


}
