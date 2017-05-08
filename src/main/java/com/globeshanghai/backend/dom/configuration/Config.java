package com.globeshanghai.backend.dom.configuration;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.globeshanghai.frontend.util.PreCondition.notEmpty;
import static com.globeshanghai.frontend.util.PreCondition.notNull;


/**
 * Created by stijnergeerts on 14/04/17.
 */

@Document(collection = "configuration")
 public final class Config {

    @Id
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

    private Config(Builder builder) {
        this.mediaStorage = builder.mediaStorage;
        this.photoQuality = builder.photoQuality;
        this.ftpIPAddress = builder.ftpIPAddress;
        this.ftpPort = builder.ftpPort;
        this.ftpUsername = builder.ftpUsername;
        this.ftpPassword = builder.ftpPassword;
        this.printerName = builder.printerName;
        this.printerEnabled = builder.printerEnabled;
        this.automaticPrinting = builder.automaticPrinting;
        this.printerCopies = builder.printerCopies;
        this.watermark = builder.watermark;
        this.qrPrinting = builder.qrPrinting;
        this.watermarkImage = builder.watermarkImage;
    }

    public Config(){
    };

    public Config(String mediaStorage, PhotoQuality photoQuality, String ftpIPAddress, String ftpPort, String ftpUsername, String ftpPassword, String printerName, boolean printerEnabled, boolean automaticPrinting, int printerCopies, boolean watermark, boolean qrPrinting, String watermarkImage) {
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

    public static Builder getBuilder() {
        return new Builder();
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

    public void update(String mediaStorage, PhotoQuality photoQuality, String ftpIPAddress,String ftpPort,String ftpUsername,
                       String ftpPassword, String printerName, boolean printerEnabled, boolean automaticPrinting, int printerCopies,
                       boolean watermark, boolean qrPrinting, String watermarkImage) {

        checkAll(mediaStorage, photoQuality, ftpIPAddress, ftpPort, ftpUsername,
                ftpPassword,  printerName,  printerEnabled,  automaticPrinting,  printerCopies,
                watermark,  qrPrinting,  watermarkImage);

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


    public static class Builder {

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


        private Builder() {}

        public Builder mediaStorage(String mediaStorage) {
            this.mediaStorage = mediaStorage;
            return this;
        }

        public Builder photoQuality(PhotoQuality photoQuality) {
            this.photoQuality = photoQuality;
            return this;
        }

        public Builder ftpIPAddress(String ftpIPAddress) {
            this.ftpIPAddress = ftpIPAddress;
            return this;
        }
        public Builder ftpPort(String ftpPort) {
            this.ftpPort = ftpPort;
            return this;
        }
        public Builder ftpUsername(String ftpUsername) {
            this.ftpUsername = ftpUsername;
            return this;
        }
        public Builder ftpPassword(String ftpPassword) {
            this.ftpPassword = ftpPassword;
            return this;
        }
        public Builder printerName(String printerName) {
            this.printerName = printerName;
            return this;
        }
        public Builder printerEnabled(boolean printerEnabled) {
            this.printerEnabled = printerEnabled;
            return this;
        }
        public Builder automaticPrinting(boolean automaticPrinting) {
            this.automaticPrinting = automaticPrinting;
            return this;
        }
        public Builder printerCopies(int printerCopies) {
            this.printerCopies = printerCopies;
            return this;
        }
        public Builder watermark(boolean watermark) {
            this.watermark = watermark;
            return this;
        }
        public Builder qrPrinting(boolean qrPrinting) {
            this.qrPrinting = qrPrinting;
            return this;
        }
        public Builder waterMarkImage(String watermarkImage) {
            this.watermarkImage = watermarkImage;
            return this;
        }



        public Config build() {
            Config build = new Config(this);

            build.checkAll(build.getMediaStorage(), build.getPhotoQuality(),
                    build.getFtpIPAddress(), build.getFtpPort(),build.getFtpUsername(),build.getFtpPassword(),
                    build.getPrinterName(),build.isPrinterEnabled(),build.isAutomaticPrinting(),build.getPrinterCopies(),
                    build.isWatermark(), build.isQrPrinting(),build.getWatermarkImage());

            return build;
        }
    }

    private void checkAll(String mediaStorage, PhotoQuality photoQuality, String ftpIPAddress,String ftpPort,String ftpUsername,
                          String ftpPassword, String printerName, boolean printerEnabled, boolean automaticPrinting, int printerCopies,
                          boolean watermark, boolean qrPrinting, String watermarkImage) {
        notNull(mediaStorage, "mediaStorage cannot be null");
        notEmpty(mediaStorage, "mediaStorage cannot be empty");

        notNull(photoQuality, "photoquality cannot be null");
        
        notNull(ftpIPAddress, "ftpIPAddress cannot be null");
        notEmpty(ftpIPAddress, "ftpIPAddress cannot be empty");
        
        notNull(ftpPort, "ftpPort cannot be null");
        notEmpty(ftpPort, "ftpPort cannot be empty");

        notNull(ftpUsername, "ftpUsername cannot be null");
        notEmpty(ftpUsername, "ftpUsername cannot be empty");
        
        notNull(ftpPassword, "ftpPassword cannot be null");
        notEmpty(ftpPassword, "ftpPassword cannot be empty");
        
        notNull(printerName, "printerName cannot be null");
        notEmpty(printerName, "printerName cannot be empty");
        
        notNull(printerEnabled, "printerEnabled cannot be null");
        
        notNull(automaticPrinting, "automaticPrinting cannot be null");
        
        notNull(printerCopies, "printerCopies cannot be null");
        
        notNull(watermark, "watermark cannot be null");
        
        notNull(qrPrinting, "qrPrinting cannot be null");
        
        notNull(watermarkImage, "watermarkImage cannot be null");
        notEmpty(watermarkImage, "watermarkImage cannot be empty");


    }
}
