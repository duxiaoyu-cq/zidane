package com.dxy.zidane.common.jpeg;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.dxy.zidane.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片信息读取
 */
public class PhotoPropertiesUtil {

    public static Map<PropertiesEnum, Object> read(File photo) throws JpegProcessingException, IOException {
        if (!photo.exists()) {
            return null;
        }

        Map<PropertiesEnum, Object> propValueMap = new HashMap<>();
        Metadata metadata = JpegMetadataReader.readMetadata(photo);

        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                PropertiesEnum jpe = PropertiesEnum.parse(tag.getTagName());
                if (jpe != null) {
                    if (propValueMap.containsKey(jpe)) {
                        if (propValueMap.get(jpe) == null || StringUtils.isBlank(propValueMap.get(jpe).toString())) {
                            propValueMap.put(jpe, tag.getDescription());
                        }
                    } else {
                        propValueMap.put(jpe, tag.getDescription());
                    }
                }
            }
        }

        for (PropertiesEnum jpe : propValueMap.keySet()) {
            if (PropertiesEnum.FILE_SIZE.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.FILE_SIZE, convertFILE_SIZE(propValueMap.get(PropertiesEnum.FILE_SIZE)));
            } else if (PropertiesEnum.IMAGE_WIDTH.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.IMAGE_WIDTH, convertPixels(propValueMap.get(PropertiesEnum.IMAGE_WIDTH)));
            } else if (PropertiesEnum.IMAGE_HEIGHT.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.IMAGE_HEIGHT, convertPixels(propValueMap.get(PropertiesEnum.IMAGE_HEIGHT)));
            } else if (PropertiesEnum.GPS_ALTITUDE.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.GPS_ALTITUDE, convertSeaLevel(propValueMap.get(PropertiesEnum.GPS_ALTITUDE)));
            } else if (PropertiesEnum.GPS_LATITUDE.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.GPS_LATITUDE, convertLatLng(propValueMap.get(PropertiesEnum.GPS_LATITUDE)));
            } else if (PropertiesEnum.GPS_LONGITUDE.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.GPS_LONGITUDE, convertLatLng(propValueMap.get(PropertiesEnum.GPS_LONGITUDE)));
            } else if (PropertiesEnum.DATE_TIME_ORIGINAL.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.DATE_TIME_ORIGINAL, convertDATE_TIME_ORIGINAL(propValueMap.get(PropertiesEnum.DATE_TIME_ORIGINAL)));
            } else if (PropertiesEnum.FILE_MODIFIED_DATE.getTag().equals(jpe.getTag())) {
                propValueMap.put(PropertiesEnum.FILE_MODIFIED_DATE, convertFILE_MODIFIED_DATE(propValueMap.get(PropertiesEnum.FILE_MODIFIED_DATE)));
            }
        }

        return propValueMap;
    }

    private static Integer convertFILE_SIZE(Object val) {
        if (val == null || StringUtils.isBlank(val.toString())) {
            return null;
        }
        return Integer.parseInt(StringUtils.replaceIgnoreCase(val.toString(), "bytes", "").trim());
    }


    private static Integer convertPixels(Object val) {
        if (val == null || StringUtils.isBlank(val.toString())) {
            return null;
        }
        return Integer.parseInt(StringUtils.replaceIgnoreCase(val.toString(), "pixels", "").trim());
    }


    private static Double convertSeaLevel(Object val) {
        if (val == null || StringUtils.isBlank(val.toString())) {
            return null;
        }
        return Double.parseDouble(StringUtils.replaceIgnoreCase(val.toString(), "metres", "").trim());
    }

    private static Double convertLatLng(Object val) {
        if (val == null || StringUtils.isBlank(val.toString())) {
            return null;
        }
        String point = val.toString();
        Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());
        Double fen = Double.parseDouble(point.substring(point.indexOf("°") + 1, point.indexOf("'")).trim());
        Double miao = Double.parseDouble(point.substring(point.indexOf("'") + 1, point.indexOf("\"")).trim());
        Double duStr = du + fen / 60 + miao / 60 / 60;
        return duStr;
    }

    private static Date convertDATE_TIME_ORIGINAL(Object val) {
        if (val == null || StringUtils.isBlank(val.toString())) {
            return null;
        }

        return DateUtil.parse(val.toString(), "yyyy:MM:dd HH:mm:ss");
    }

    private static Date convertFILE_MODIFIED_DATE(Object val) {
        if (val == null || StringUtils.isBlank(val.toString())) {
            return null;
        }

        String[] arrs = val.toString().split(" ");
        if (arrs.length != 6) {
            return null;
        }

        Integer y = Integer.parseInt(arrs[5]);
        String month = arrs[1].replace("月", "");
        Integer m = null;
        if ("一".equals(month)) {
            m = 1;
        } else if ("二".equals(month)) {
            m = 2;
        } else if ("三".equals(month)) {
            m = 3;
        } else if ("四".equals(month)) {
            m = 4;
        } else if ("五".equals(month)) {
            m = 5;
        } else if ("六".equals(month)) {
            m = 6;
        } else if ("七".equals(month)) {
            m = 7;
        } else if ("八".equals(month)) {
            m = 8;
        } else if ("九".equals(month)) {
            m = 9;
        } else if ("十".equals(month)) {
            m = 10;
        } else if ("十一".equals(month)) {
            m = 11;
        } else if ("十二".equals(month)) {
            m = 12;
        }
        Integer d = Integer.parseInt(arrs[2]);
        return DateUtil.parse(y + "-" + m + "-" + d + " " + arrs[3], "yyyy-MM-dd HH:mm:ss");
    }

    public enum PropertiesEnum {

        /*============================说明============================*/
        IMAGE_DESCRIPTION("Image Description", "标题"),
        //UNKNOW("--", "主题"),
        //UNKNOW("--", "分级"),
        //UNKNOW("--", "标记"),
        //UNKNOW("--", "备注"),

        /*============================来源=============================*/
        //UNKNOW("--", "作者"),
        DATE_TIME_ORIGINAL("Date/Time Original", "拍摄日期"),
        SOFTWARE("Software", "程序名称"),
        //UNKNOW("--", "获取日期"),
        //UNKNOW("--", "版权"),

        /*============================图像=============================*/
        //UNKNOW("--", "图像ID"),
        //UNKNOW("--", "分辨率"),
        IMAGE_WIDTH("Image Width", "宽度"),
        IMAGE_HEIGHT("Image Height", "高度"),
        X_RESOLUTION("X Resolution", "水平分辨率"),
        Y_RESOLUTION("Y Resolution", "垂直分辨率"),
        //UNKNOW("--", "位深度"),
        //UNKNOW("--", "压缩"),
        RESOLUTION_UNITS("Resolution Units", "分辨率单位"),
        COLOR_SPACE("Color_Space", "颜色表示"),
        //UNKNOW("--", "压缩的位/像素"),

        /*============================照相机=============================*/
        MAKE("Make", "照相机制造商"),
        MODEL("Model", "照相机型号"),
        F_NUMBER("F-Number", "光圈值"),
        //UNKNOW("--", "曝光时间"),
        ISO_SPEED_RATINGS("ISO Speed Ratings", "ISO速度"),
        //UNKNOW("--", "曝光补偿"),
        FOCAL_LENGTH("Focal Length", "焦距"),
        //UNKNOW("--", "最大光圈"),
        //UNKNOW("--", "测光模式"),
        //UNKNOW("--", "目标距离"),
        //UNKNOW("--", "闪光灯模式"),
        //UNKNOW("--", "闪光灯能量"),
        //UNKNOW("--", "35mm焦距"),

        /*============================高级照片=============================*/
        //UNKNOW("--", "镜头制造商"),
        //UNKNOW("--", "镜头型号"),
        //UNKNOW("--", "闪光灯制造商"),
        //UNKNOW("--", "闪光灯型号"),
        //UNKNOW("--", "照相机序列号"),
        CONTRAST("Contrast", "对比度"), //None-正常
        BRIGHTNESS_VALUE("Brightness Value", "亮度"),
        //UNKNOW("--", "光源"),
        //UNKNOW("--", "曝光程度"),
        SATURATION("Saturation", "饱和度"), //None-正常
        SHARPNESS("Sharpness", "清晰度"), //None-正常
        WHITE_BALANCE_MODE("White Balance Mode", "白平衡"), //Auto white balance-自动
        //UNKNOW("--", "光度解释"),
        //UNKNOW("--", "数字缩放"),
        //UNKNOW("--", "EXIF版本"),

        /*============================GPS=============================*/
        GPS_LATITUDE_REF("GPS Latitude Ref", "纬度类型"),// N-北纬  S-南纬
        GPS_LONGITUDE_REF("GPS Longitude Ref", "经度类型"),// N-东经  S-西经
        GPS_ALTITUDE_REF("GPS Altitude Ref", "高度类型"),  //海拔
        GPS_LATITUDE("GPS Latitude", "纬度"),
        GPS_LONGITUDE("GPS Longitude", "经度"),
        GPS_ALTITUDE("GPS Altitude", "海拔"),

        /*============================文件=============================*/
        FILE_NAME("File Name", "名称"),
        //UNKNOW("--", "项目类型"),
        //UNKNOW("--", "文件夹路径"),
        //UNKNOW("--", "创建时间"),
        FILE_MODIFIED_DATE("File Modified Date", "修改时间"),
        FILE_SIZE("File Size", "大小");

        private final String tag;
        private final String caption;

        PropertiesEnum(String tag, String caption) {
            this.tag = tag;
            this.caption = caption;
        }

        public static PropertiesEnum parse(String tag) {
            for (PropertiesEnum pe : PropertiesEnum.values()) {
                if (pe.getTag().equals(tag)) {
                    return pe;
                }
            }
            return null;
        }

        public String getTag() {
            return tag;
        }

        public String getCaption() {
            return caption;
        }
    }


}
