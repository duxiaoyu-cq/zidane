package com.dxy.zidane.home.service;

import com.dxy.zidane.home.bo.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 文件扫描器
 *
 * @author dxy
 * @date 2019/11/12 15:28
 */
@Service
public class FileScanner extends AbstractFileScanner<File> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileScanner.class);

    @Override
    public String[] includeExtensions() {
        //null为所有文件
        return null;
    }

    @Override
    public File fileConverter(java.io.File file) {
        try {
            return new File(file, false);
        } catch (IOException e) {
            LOGGER.error("", e);
        }
        return null;
    }
}
