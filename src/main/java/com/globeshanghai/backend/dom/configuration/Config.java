package com.globeshanghai.backend.dom.configuration;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by stijnergeerts on 14/04/17.
 */

@Document(collection = "configuration")
 public final class Config {

    @Id
    private String configurationId;

    private String mediaStorage;

    private PhotoQuality photoQuality;

    private String printerName;

    private int printerCopies;

    private boolean watermarkPrinting;

    private String watermarkImage;

    private boolean qrPrinting;

    private String qrImage;

    private boolean watermarkSharing;

    private Config(Builder builder) {
        this.mediaStorage = builder.mediaStorage;
        this.photoQuality = builder.photoQuality;
        this.printerName = builder.printerName;
        this.printerCopies = builder.printerCopies;
        this.watermarkPrinting = builder.watermarkPrinting;
        this.watermarkImage = builder.watermarkImage;
        this.qrPrinting = builder.qrPrinting;
        this.qrImage = builder.qrImage;
        this.watermarkSharing = builder.watermarkSharing;
    }

    public Config(){
    };

    public Config(String mediaStorage, PhotoQuality photoQuality, String printerName, int printerCopies, boolean watermarkPrinting, String watermarkImage, boolean qrPrinting, String qrImage, boolean watermarkSharing) {
        this.mediaStorage = mediaStorage;
        this.photoQuality = photoQuality;
        this.printerName = printerName;
        this.printerCopies = printerCopies;
        this.watermarkPrinting = watermarkPrinting;
        this.watermarkImage = watermarkImage;
        this.qrPrinting = qrPrinting;
        this.qrImage = qrImage;
        this.watermarkSharing = watermarkSharing;
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


    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }


    public int getPrinterCopies() {
        return printerCopies;
    }

    public void setPrinterCopies(int printerCopies) {
        this.printerCopies = printerCopies;
    }

    public boolean getWatermarkPrinting() {
        return watermarkPrinting;
    }

    public void setWatermarkPrinting(boolean watermarkPrinting) {
        this.watermarkPrinting = watermarkPrinting;
    }

    public String getWatermarkImage() {
        return watermarkImage;
    }

    public void setWatermarkImage(String watermarkImage) {
        this.watermarkImage = watermarkImage;
    }

    public boolean getQrPrinting() {
        return qrPrinting;
    }

    public void setQrPrinting(boolean qrPrinting) {
        this.qrPrinting = qrPrinting;
    }

    public String getQrImage() {
        return qrImage;
    }

    public void setQrImage(String qrImage) {
        this.qrImage = qrImage;
    }

    public boolean getWatermarkSharing() {
        return watermarkSharing;
    }

    public void setWatermarkSharing(boolean watermarkSharing) {
        this.watermarkSharing = watermarkSharing;
    }

    public void update(String mediaStorage, PhotoQuality photoQuality, String printerName, int printerCopies,
                       boolean watermarkPrinting, String watermarkImage, boolean qrPrinting, String qrImage, boolean watermarkSharing) {

        checkAll(mediaStorage, photoQuality, printerName, printerCopies, watermarkPrinting,
                watermarkImage,  qrPrinting, qrImage, watermarkSharing);

        this.mediaStorage = mediaStorage;
        this.photoQuality = photoQuality;
        this.printerName = printerName;
        this.printerCopies = printerCopies;
        this.watermarkPrinting = watermarkPrinting;
        this.watermarkImage = watermarkImage;
        this.qrPrinting = qrPrinting;
        this.qrImage = qrImage;
        this.watermarkSharing = watermarkSharing;
    }


    public static class Builder {

        private String mediaStorage;

        private PhotoQuality photoQuality;

        private String printerName;

        private int printerCopies;

        private boolean watermarkPrinting;

        private String watermarkImage;

        private boolean qrPrinting;

        private String qrImage;

        private boolean watermarkSharing;

        private Builder() {}

        public Builder mediaStorage(String mediaStorage) {
            this.mediaStorage = mediaStorage;
            return this;
        }

        public Builder photoQuality(PhotoQuality photoQuality) {
            this.photoQuality = photoQuality;
            return this;
        }

        public Builder printerName(String printerName) {
            this.printerName = printerName;
            return this;
        }

        public Builder printerCopies(int printerCopies) {
            this.printerCopies = printerCopies;
            return this;
        }

        public Builder watermarkPrinting(boolean watermarkPrinting) {
            this.watermarkPrinting = watermarkPrinting;
            return this;
        }

        public Builder waterMarkImage(String watermarkImage) {
            this.watermarkImage = watermarkImage;
            return this;
        }

        public Builder qrPrinting(boolean qrPrinting) {
            this.qrPrinting = qrPrinting;
            return this;
        }

        public Builder qrImage(String qrImage) {
            this.qrImage = qrImage;
            return this;
        }

        public Builder watermarkSharing(boolean watermarkSharing) {
            this.watermarkSharing = watermarkSharing;
            return this;
        }



        public Config build() {
            Config build = new Config(this);

            build.checkAll(build.getMediaStorage(), build.getPhotoQuality(),
                    build.getPrinterName(), build.getPrinterCopies(),build.getWatermarkPrinting(),build.getWatermarkImage(),
                    build.getQrPrinting(),build.getQrImage(),build.getWatermarkSharing());

            return build;
        }
    }

    private void checkAll(String mediaStorage, PhotoQuality photoQuality, String printerName, int printerCopies,
                          boolean watermarkPrinting, String watermarkImage, boolean qrPrinting, String qrImage, boolean watermarkSharing) {

        /*notNull(mediaStorage, "mediaStorage cannot be null");
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

        notEmpty(qrImage, "qrPrinting cannot be empty");
        notNull(qrImage, "qrPrinting cannot be null");

        notNull(watermarkImage, "watermarkImage cannot be null");
        notEmpty(watermarkImage, "watermarkImage cannot be empty");*/


    }
}
