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

    private boolean qrPrinting;

    private String qrImage;

    private ImageWatermark printWatermark;

    private ImageWatermark webWatermark;

    private boolean watermarkSharing;

    private Config(Builder builder) {
        this.mediaStorage = builder.mediaStorage;
        this.photoQuality = builder.photoQuality;
        this.printerName = builder.printerName;
        this.printerCopies = builder.printerCopies;
        this.watermarkPrinting = builder.watermarkPrinting;
        this.qrPrinting = builder.qrPrinting;
        this.qrImage = builder.qrImage;
        this.printWatermark = builder.printWatermark;
        this.webWatermark = builder.webWatermark;
        this.watermarkSharing = builder.watermarkSharing;
    }

    public Config() {
    }

    public Config(String mediaStorage, PhotoQuality photoQuality, String printerName, int printerCopies, boolean watermarkPrinting, boolean qrPrinting, String qrImage, ImageWatermark printWatermark, ImageWatermark webWatermark, boolean watermarkSharing) {
        this.mediaStorage = mediaStorage;
        this.photoQuality = photoQuality;
        this.printerName = printerName;
        this.printerCopies = printerCopies;
        this.watermarkPrinting = watermarkPrinting;
        this.qrPrinting = qrPrinting;
        this.qrImage = qrImage;
        this.printWatermark = printWatermark;
        this.webWatermark = webWatermark;
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

    public boolean isWatermarkPrinting() {
        return watermarkPrinting;
    }

    public void setWatermarkPrinting(boolean watermarkPrinting) {
        this.watermarkPrinting = watermarkPrinting;
    }

    public boolean isQrPrinting() {
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

    public ImageWatermark getPrintWatermark() {
        return printWatermark;
    }

    public void setPrintWatermark(ImageWatermark printWatermark) {
        this.printWatermark = printWatermark;
    }

    public ImageWatermark getWebWatermark() {
        return webWatermark;
    }

    public boolean isWatermarkSharing() {
        return watermarkSharing;
    }

    public void setWatermarkSharing(boolean watermarkSharing) {
        this.watermarkSharing = watermarkSharing;
    }

    public void update(String mediaStorage, PhotoQuality photoQuality, String printerName, int printerCopies, boolean watermarkPrinting, boolean qrPrinting, String qrImage, ImageWatermark printWatermark, ImageWatermark webWatermark, boolean watermarkSharing) {
        checkAll(mediaStorage, photoQuality, printerName, printerCopies, watermarkPrinting, qrPrinting, qrImage, printWatermark, webWatermark, watermarkSharing);

        this.mediaStorage = mediaStorage;
        this.photoQuality = photoQuality;
        this.printerName = printerName;
        this.printerCopies = printerCopies;
        this.watermarkPrinting = watermarkPrinting;
        this.qrPrinting = qrPrinting;
        this.qrImage = qrImage;
        this.printWatermark = printWatermark;
        this.webWatermark = webWatermark;
        this.watermarkSharing = watermarkSharing;
    }

    /**
     * Using the builder pattern because we are creating a complex object.
     * This makes the code clearer and easier to read.
     */
    public static class Builder {

        private String mediaStorage;

        private PhotoQuality photoQuality;

        private String printerName;

        private int printerCopies;

        private boolean watermarkPrinting;

        private boolean qrPrinting;

        private String qrImage;

        private boolean watermarkSharing;

        private ImageWatermark printWatermark;

        private ImageWatermark webWatermark;

        private Builder() {
        }

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

        public Builder printWatermark(ImageWatermark printWatermark) {
            this.printWatermark = printWatermark;
            return this;
        }

        public Builder webWatermark(ImageWatermark webWatermark) {
            this.webWatermark = webWatermark;
            return this;
        }

        /**
         * Building the actual {@link com.globeshanghai.backend.dom.configuration.Config} object.
         * @return {@link com.globeshanghai.backend.dom.configuration.Config}
         */
        public Config build() {
            Config build = new Config(this);
            build.checkAll(build.mediaStorage, build.photoQuality, build.printerName, build.printerCopies, build.watermarkPrinting, build.qrPrinting, build.qrImage, build.printWatermark, build.webWatermark, build.watermarkSharing);

            return build;
        }
    }

    /**
     * If there are variables that can't be empty or null, it can be checked in this method using the
     * {@link com.globeshanghai.frontend.util.PreCondition} notNull and notEmpty methods
     */
    private void checkAll(String mediaStorage, PhotoQuality photoQuality, String printerName, int printerCopies, boolean watermarkPrinting, boolean qrPrinting, String qrImage, ImageWatermark printWatermark, ImageWatermark webWatermark, boolean watermarkSharing) {
        //TODO
    }
}
