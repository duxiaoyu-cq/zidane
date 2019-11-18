package com.dxy.zidane.home.service;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.dxy.zidane.common.jpeg.PhotoPropertiesUtil;
import com.dxy.zidane.home.bo.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 照片扫描器
 *
 * @author dxy
 * @date 2019/11/12 17:39
 */
@Service
public class PhotoScanner extends AbstractFileScanner<Photo> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoScanner.class);

    public static final String[] EXTS = {"jpg", "jpeg", "png", "gif"};

    @Override
    public String[] includeExtensions() {
        return EXTS;
    }

    @Override
    public Photo fileConverter(File file) {
        try {
            Photo photo = new Photo(file, true);

            Map<PhotoPropertiesUtil.PropertiesEnum, Object> jpeValMap = PhotoPropertiesUtil.read(file);
            photo.setImageDescription((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.IMAGE_DESCRIPTION));
            photo.setDateTimeOriginal((Date) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.DATE_TIME_ORIGINAL));
            photo.setSoftware((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.SOFTWARE));
            photo.setImageWidth((Integer) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.IMAGE_WIDTH));
            photo.setImageHeight((Integer) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.IMAGE_HEIGHT));
            photo.setxResolution((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.X_RESOLUTION));
            photo.setyResolution((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.Y_RESOLUTION));

            photo.setResolutionUnits((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.RESOLUTION_UNITS));
            photo.setColorSpace((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.COLOR_SPACE));
            photo.setMake((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.MAKE));
            photo.setModel((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.MODEL));
            photo.setfNumber((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.F_NUMBER));
            photo.setIsoSpeedRatings((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.ISO_SPEED_RATINGS));
            photo.setFocalLength((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.FOCAL_LENGTH));

            photo.setContrast((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.CONTRAST));
            photo.setBrightnessValue((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.BRIGHTNESS_VALUE));
            photo.setSaturation((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.SATURATION));
            photo.setSharpness((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.SHARPNESS));
            photo.setWhiteBalanceMode((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.WHITE_BALANCE_MODE));
            photo.setGpsLatitudeRef((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.GPS_LATITUDE_REF));
            photo.setGpsLongitudeRef((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.GPS_LONGITUDE_REF));
            photo.setGpsAltitudeRef((String) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.GPS_ALTITUDE_REF));

            photo.setGpsLatitude((Double) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.GPS_LATITUDE));
            photo.setGpsLongitude((Double) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.GPS_LONGITUDE));
            photo.setGpsLatitude((Double) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.GPS_ALTITUDE));
            photo.setFileModifiedDate((Date) jpeValMap.get(PhotoPropertiesUtil.PropertiesEnum.FILE_MODIFIED_DATE));

            return photo;
        } catch (JpegProcessingException e) {
            LOGGER.error("", e);
        } catch (IOException e) {
            LOGGER.error("", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void reporter(File file) {
        super.reporter(file);
    }
}
