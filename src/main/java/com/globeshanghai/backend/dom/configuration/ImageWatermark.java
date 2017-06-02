package com.globeshanghai.backend.dom.configuration;

import static com.globeshanghai.frontend.util.PreCondition.notNull;

/**
 * Created by jellemannaerts on 30/05/17.
 */
public final class ImageWatermark {
    private boolean print;
    private int height;
    private int width;
    private String logoLocation;
    private int logoX;
    private int logoY;
    private int logoScale;
    private String overlayLocation;
    private int overlayX;
    private int overlayY;
    private int overlayScale;
    private int imageWidth;
    private int imageHeight;
    private int imageX;
    private int imageY;
    private int imageScale;

    private ImageWatermark(Builder builder) {
        this.print = builder.print;
        this.height = builder.height;
        this.width = builder.width;
        this.logoLocation = builder.logoLocation;
        this.logoX = builder.logoX;
        this.logoY = builder.logoY;
        this.logoScale = builder.logoScale;
        this.overlayLocation = builder.overlayLocation;
        this.overlayX = builder.overlayX;
        this.overlayY = builder.overlayY;
        this.overlayScale = builder.overlayScale;
        this.imageWidth = builder.imageWidth;
        this.imageHeight = builder.imageHeight;
        this.imageX = builder.imageX;
        this.imageY = builder.imageY;
        this.imageScale = builder.imageScale;
    }

    public ImageWatermark(boolean print, int height, int width, String logoLocation, int logoX, int logoY, int logoScale, String overlayLocation, int overlayX, int overlayY, int overlayScale, int imageWidth, int imageHeight, int imageX, int imageY, int imageScale) {
        this.print = print;
        this.height = height;
        this.width = width;
        this.logoLocation = logoLocation;
        this.logoX = logoX;
        this.logoY = logoY;
        this.logoScale = logoScale;
        this.overlayLocation = overlayLocation;
        this.overlayX = overlayX;
        this.overlayY = overlayY;
        this.overlayScale = overlayScale;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageX = imageX;
        this.imageY = imageY;
        this.imageScale = imageScale;
    }

    public ImageWatermark() {
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getLogoLocation() {
        return logoLocation;
    }

    public void setLogoLocation(String logoLocation) {
        this.logoLocation = logoLocation;
    }

    public int getLogoX() {
        return logoX;
    }

    public void setLogoX(int logoX) {
        this.logoX = logoX;
    }

    public int getLogoY() {
        return logoY;
    }

    public void setLogoY(int logoY) {
        this.logoY = logoY;
    }

    public int getLogoScale() {
        return logoScale;
    }

    public void setLogoScale(int logoScale) {
        this.logoScale = logoScale;
    }

    public String getOverlayLocation() {
        return overlayLocation;
    }

    public void setOverlayLocation(String overlayLocation) {
        this.overlayLocation = overlayLocation;
    }

    public int getOverlayX() {
        return overlayX;
    }

    public void setOverlayX(int overlayX) {
        this.overlayX = overlayX;
    }

    public int getOverlayY() {
        return overlayY;
    }

    public void setOverlayY(int overlayY) {
        this.overlayY = overlayY;
    }

    public int getOverlayScale() {
        return overlayScale;
    }

    public void setOverlayScale(int overlayScale) {
        this.overlayScale = overlayScale;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageX() {
        return imageX;
    }

    public void setImageX(int imageX) {
        this.imageX = imageX;
    }

    public int getImageY() {
        return imageY;
    }

    public void setImageY(int imageY) {
        this.imageY = imageY;
    }

    public int getImageScale() {
        return imageScale;
    }

    public void setImageScale(int imageScale) {
        this.imageScale = imageScale;
    }

    public void update(boolean print, int height, int width, String logoLocation, int logoX, int logoY, int logoScale, String overlayLocation, int overlayX, int overlayY, int overlayScale, int imageWidth, int imageHeight, int imageX, int imageY, int imageScale) {
        checkAll(print, height, width, imageWidth, imageHeight, imageX, imageY, imageScale);

        this.print = print;
        this.height = height;
        this.width = width;
        this.logoLocation = logoLocation;
        this.logoX = logoX;
        this.logoY = logoY;
        this.logoScale = logoScale;
        this.overlayLocation = overlayLocation;
        this.overlayX = overlayX;
        this.overlayY = overlayY;
        this.overlayScale = overlayScale;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageX = imageX;
        this.imageY = imageY;
        this.imageScale = imageScale;
    }


    /**
     * Using the builder pattern because we are creating a complex object.
     * This makes the code clearer and easier to read.
     */
    public static class Builder {
        private boolean print;
        private int height;
        private int width;
        private String logoLocation;
        private int logoX;
        private int logoY;
        private int logoScale;
        private String overlayLocation;
        private int overlayX;
        private int overlayY;
        private int overlayScale;
        private int imageWidth;
        private int imageHeight;
        private int imageX;
        private int imageY;
        private int imageScale;

        private Builder() {
        }

        public Builder print(boolean print) {
            this.print = print;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder logoLocation(String logoLocation) {
            this.logoLocation = logoLocation;
            return this;
        }

        public Builder logoX(int logoX) {
            this.logoX = logoX;
            return this;
        }

        public Builder setLogoY(int logoY) {
            this.logoY = logoY;
            return this;
        }

        public Builder logoScale(int logoScale) {
            this.logoScale = logoScale;
            return this;
        }

        public Builder overlayLocation(String overlayLocation) {
            this.overlayLocation = overlayLocation;
            return this;
        }

        public Builder overlayX(int overlayX) {
            this.overlayX = overlayX;
            return this;
        }

        public Builder overlayY(int overlayY) {
            this.overlayY = overlayY;
            return this;
        }

        public Builder overlayScale(int overlayScale) {
            this.overlayScale = overlayScale;
            return this;
        }

        public Builder imageWidth(int imageWidth) {
            this.imageWidth = imageWidth;
            return this;
        }

        public Builder imageHeight(int imageHeight) {
            this.imageHeight = imageHeight;
            return this;
        }

        public Builder imageX(int imageX) {
            this.imageX = imageX;
            return this;
        }

        public Builder imageY(int imageY) {
            this.imageY = imageY;
            return this;
        }

        public Builder imageScale(int imageScale) {
            this.imageScale = imageScale;
            return this;
        }

        /**
         * Building the actual {@link com.globeshanghai.backend.dom.configuration.ImageWatermark} object.
         * @return {@link com.globeshanghai.backend.dom.configuration.ImageWatermark}
         */
        public ImageWatermark build() {
            ImageWatermark build = new ImageWatermark(this);

            build.checkAll(build.print, build.height, build.width, build.imageWidth, build.imageHeight, build.imageX, build.imageY, build.imageScale);

            return build;
        }
    }

    /**
     * If there are variables that can't be empty or null, it can be checked in this method using the
     * {@link com.globeshanghai.frontend.util.PreCondition} notNull and notEmpty methods
     */
    private void checkAll(boolean print, int height, int width, int imageWidth, int imageHeight, int imageX, int imageY, int imageScale) {
        notNull(print, "print cannot be null");

        notNull(height, "height cannot be null");
        notNull(width, "width cannot be null");

        notNull(imageHeight, "imageHeight cannot be null");
        notNull(imageWidth, "imageWidth cannot be null");
        notNull(imageX, "imageX cannot be null");
        notNull(imageY, "imageY cannot be null");
        notNull(imageScale, "imageScale cannot be null");
    }


}
