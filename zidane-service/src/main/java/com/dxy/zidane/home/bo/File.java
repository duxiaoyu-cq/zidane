package com.dxy.zidane.home.bo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

/**
 * 文件
 *
 * @author dxy
 * @date 2019/11/12 10:21
 */
public class File {
    private final String name;
    private final String path;
    private final String extension;

    private Long size;
    private String md5;

    private Date createTime;
    private Date modifyTime;
    private Date visiteTime;


    public File(java.io.File file) throws IOException {
        this(file, false);
    }

    public File(java.io.File file, boolean readable) throws IOException {
        if (file == null) {
            throw new IOException("file can't be null");
        }

        this.name = file.getName();
        this.path = file.getPath();
        this.extension = FilenameUtils.getExtension(file.getName());
        if (readable) {
            BasicFileAttributes bfa = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            this.size = file.length();
            this.md5 = DigestUtils.md5Hex(new FileInputStream(file.getPath()));
            this.createTime = new Date(bfa.creationTime().toMillis());
            this.modifyTime = new Date(bfa.lastModifiedTime().toMillis());
            this.visiteTime = new Date(bfa.lastAccessTime().toMillis());
        }
    }


    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public Long getSize() {
        return size;
    }


    public String getMd5() {
        return md5;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public Date getVisiteTime() {
        return visiteTime;
    }
}
