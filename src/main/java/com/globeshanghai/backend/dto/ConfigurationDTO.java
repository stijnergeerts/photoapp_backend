package com.globeshanghai.backend.dto;

import com.globeshanghai.backend.dom.configuration.PhotoQuality;

/**
 * Created by stijnergeerts on 17/04/17.
 */
public class ConfigurationDTO {

    private String configurationId;

    private String mediaStorage;

    private PhotoQuality photoQuality;

    private String ftpIPAddress;

    private String ftpPort;

    private String ftpUsername;

    private String ftpPassword;

    private String printerName;

    private boolean printerEnabled;

    private boolean automaticPrinting;

    private int printerCopies;

    private boolean watermark;

    private boolean qrPrinting;

    private String watermarkImage;


    public ConfigurationDTO(String configurationId, String mediaStorage, PhotoQuality photoQuality, String ftpIPAddress,
                            String ftpPort, String ftpUsername, String ftpPassword, String printerName,
                            boolean printerEnabled, boolean automaticPrinting, int printerCopies, boolean watermark,
                            boolean qrPrinting, String watermarkImage) {
        this.configurationId = configurationId;
        this.mediaStorage = mediaStorage;
        this.photoQuality = photoQuality;
        this.ftpIPAddress = ftpIPAddress;
        this.ftpPort = ftpPort;
        this.ftpUsername = ftpUsername;
        this.ftpPassword = ftpPassword;
        this.printerName = printerName;
        this.printerEnabled = printerEnabled;
        this.automaticPrinting = automaticPrinting;
        this.printerCopies = printerCopies;
        this.watermark = watermark;
        this.qrPrinting = qrPrinting;
        this.watermarkImage = watermarkImage;

    }

    public ConfigurationDTO(String mediaStorage, PhotoQuality photoQuality, String ftpIPAddress, String ftpPort,
                            String ftpUsername, String ftpPassword, String printerName, boolean printerEnabled,
                            boolean automaticPrinting, int printerCopies, boolean watermark,
                            boolean qrPrinting, String watermarkImage) {
        this.mediaStorage = mediaStorage;
        this.photoQuality = photoQuality;
        this.ftpIPAddress = ftpIPAddress;
        this.ftpPort = ftpPort;
        this.ftpUsername = ftpUsername;
        this.ftpPassword = ftpPassword;
        this.printerName = printerName;
        this.printerEnabled = printerEnabled;
        this.automaticPrinting = automaticPrinting;
        this.printerCopies = printerCopies;
        this.watermark = watermark;
        this.qrPrinting = qrPrinting;
        this.watermarkImage = watermarkImage;

    }

    public ConfigurationDTO() {
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getMediaStorage() {
        return mediaStorage;
    }

    public void setMediaStorage(String mediaStorage) {
        this.mediaStorage = mediaStorage;
    }

    public PhotoQuality getPhotoQuality() {
        return photoQuality;
    }

    public void setPhotoQuality(PhotoQuality photoQuality) {
        this.photoQuality = photoQuality;
    }

    public String getFtpIPAddress() {
        return ftpIPAddress;
    }

    public void setFtpIPAddress(String ftpIPAddress) {
        this.ftpIPAddress = ftpIPAddress;
    }

    public String getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(String ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUsername() {
        return ftpUsername;
    }

    public void setFtpUsername(String ftpUsername) {
        this.ftpUsername = ftpUsername;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public boolean isPrinterEnabled() {
        return printerEnabled;
    }

    public void setPrinterEnabled(boolean printerEnabled) {
        this.printerEnabled = printerEnabled;
    }

    public boolean isAutomaticPrinting() {
        return automaticPrinting;
    }

    public void setAutomaticPrinting(boolean automaticPrinting) {
        this.automaticPrinting = automaticPrinting;
    }

    public int getPrinterCopies() {
        return printerCopies;
    }

    public void setPrinterCopies(int printerCopies) {
        this.printerCopies = printerCopies;
    }

    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public boolean isQrPrinting() {
        return qrPrinting;
    }

    public void setQrPrinting(boolean qrPrinting) {
        this.qrPrinting = qrPrinting;
    }

    public String getWatermarkImage() {
        return watermarkImage;
    }

    public void setWatermarkImage(String watermarkImage) {
        this.watermarkImage = watermarkImage;
    }
}
