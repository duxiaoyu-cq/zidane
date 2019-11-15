package com.dxy.zidane.home.bo;

import java.util.Date;

/**
 * 照片
 *
 * @author dxy
 * @date 2019/11/15 15:39
 */
public class Photo extends File {
    private String imageDescription;
    private Date dateTimeOriginal;
    private String software;
    private Integer imageWidth;
    private Integer imageHeight;
    private String xResolution;
    private String yResolution;
    private String resolutionUnits;
    private String colorSpace;
    private String make;
    private String model;
    private String fNumber;
    private String isoSpeedRatings;
    private String focalLength;
    private String contrast;
    private String brightnessValue;
    private String saturation;
    private String sharpness;
    private String whiteBalanceMode;
    private String gpsLatitudeRef;
    private String gpsLongitudeRef;
    private String gpsAltitudeRef;
    private Double gpsLatitude;
    private Double gpsLongitude;
    private Integer gpsAltitude;
    private Date fileModifiedDate;

    public Photo(java.io.File file) throws Exception {
        super(file);
    }

    public Photo(java.io.File file, boolean readable) throws Exception {
        super(file, readable);
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public Date getDateTimeOriginal() {
        return dateTimeOriginal;
    }

    public void setDateTimeOriginal(Date dateTimeOriginal) {
        this.dateTimeOriginal = dateTimeOriginal;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getxResolution() {
        return xResolution;
    }

    public void setxResolution(String xResolution) {
        this.xResolution = xResolution;
    }

    public String getyResolution() {
        return yResolution;
    }

    public void setyResolution(String yResolution) {
        this.yResolution = yResolution;
    }

    public String getResolutionUnits() {
        return resolutionUnits;
    }

    public void setResolutionUnits(String resolutionUnits) {
        this.resolutionUnits = resolutionUnits;
    }

    public String getColorSpace() {
        return colorSpace;
    }

    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public String getIsoSpeedRatings() {
        return isoSpeedRatings;
    }

    public void setIsoSpeedRatings(String isoSpeedRatings) {
        this.isoSpeedRatings = isoSpeedRatings;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getContrast() {
        return contrast;
    }

    public void setContrast(String contrast) {
        this.contrast = contrast;
    }

    public String getBrightnessValue() {
        return brightnessValue;
    }

    public void setBrightnessValue(String brightnessValue) {
        this.brightnessValue = brightnessValue;
    }

    public String getSaturation() {
        return saturation;
    }

    public void setSaturation(String saturation) {
        this.saturation = saturation;
    }

    public String getSharpness() {
        return sharpness;
    }

    public void setSharpness(String sharpness) {
        this.sharpness = sharpness;
    }

    public String getWhiteBalanceMode() {
        return whiteBalanceMode;
    }

    public void setWhiteBalanceMode(String whiteBalanceMode) {
        this.whiteBalanceMode = whiteBalanceMode;
    }

    public String getGpsLatitudeRef() {
        return gpsLatitudeRef;
    }

    public void setGpsLatitudeRef(String gpsLatitudeRef) {
        this.gpsLatitudeRef = gpsLatitudeRef;
    }

    public String getGpsLongitudeRef() {
        return gpsLongitudeRef;
    }

    public void setGpsLongitudeRef(String gpsLongitudeRef) {
        this.gpsLongitudeRef = gpsLongitudeRef;
    }

    public String getGpsAltitudeRef() {
        return gpsAltitudeRef;
    }

    public void setGpsAltitudeRef(String gpsAltitudeRef) {
        this.gpsAltitudeRef = gpsAltitudeRef;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Integer getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(Integer gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
    }

    public Date getFileModifiedDate() {
        return fileModifiedDate;
    }

    public void setFileModifiedDate(Date fileModifiedDate) {
        this.fileModifiedDate = fileModifiedDate;
    }
}
