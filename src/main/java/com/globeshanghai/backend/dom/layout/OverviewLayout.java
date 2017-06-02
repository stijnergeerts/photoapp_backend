package com.globeshanghai.backend.dom.layout;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.globeshanghai.frontend.util.PreCondition.notNull;

/**
 * Created by stijnergeerts on 14/04/17.
 */
@Document
public final class OverviewLayout extends Layout {

    @Id
    private String overviewLayoutId;

    private boolean imageContainer;

    private String imageContainerColor;
    
    private String imageContainerBorderColor;

    private int imageContainerBorderWidth;

    private String selectionIcon;

    private boolean selectionContainer;

    private String selectionContainerColor;

    private String selectionContainerBorderColor;

    private int selectionContainerBorderWidth;

    private String selectBtnText;

    private String selectBtnColor;

    private String selectBtnImage;

    private String selectBtnBorderColor;

    private int selectBtnBorderWidth;

    private OverviewLayout(OverviewLayout.Builder builder) {
        this.imageContainer = builder.imageContainer;
        this.imageContainerColor = builder.imageContainerColor;
        this.imageContainerBorderColor = builder.imageContainerBorderColor;
        this.imageContainerBorderWidth = builder.imageContainerBorderWidth;
        this.selectionIcon = builder.selectionIcon;
        this.selectionContainer = builder.selectionContainer;
        this.selectionContainerColor = builder.selectionContainerColor;
        this.selectionContainerBorderColor = builder.selectionContainerBorderColor;
        this.selectionContainerBorderWidth = builder.selectionContainerBorderWidth;
        this.selectBtnText = builder.selectBtnText;
        this.selectBtnColor = builder.selectBtnColor;
        this.selectBtnImage = builder.selectBtnImage;
        this.selectBtnBorderColor = builder.selectBtnBorderColor;
        this.selectBtnBorderWidth = builder.selectBtnBorderWidth;
        super.backgroundColor = builder.backgroundColor;
        super.backgroundImage = builder.backgroundImage;
    }

    public OverviewLayout(int number, String logo, Position logoPosition, String backgroundColor, String backgroundImage, String imageBorderColor, int imageBorderWidth, boolean imageContainer, String imageContainerColor, String imageContainerBorderColor, int imageContainerBorderWidth, String selectionIcon, boolean selectionContainer, String selectionContainerColor, String selectionContainerBorderColor, int selectionContainerBorderWidth, String selectBtnText, String selectBtnColor, String selectBtnImage, String selectBtnBorderColor, int selectBtnBorderWidth) {
        super(number, logo, logoPosition, backgroundColor, backgroundImage, imageBorderColor, imageBorderWidth);
        this.imageContainer = imageContainer;
        this.imageContainerColor = imageContainerColor;
        this.imageContainerBorderColor = imageContainerBorderColor;
        this.imageContainerBorderWidth = imageContainerBorderWidth;
        this.selectionIcon = selectionIcon;
        this.selectionContainer = selectionContainer;
        this.selectionContainerColor = selectionContainerColor;
        this.selectionContainerBorderColor = selectionContainerBorderColor;
        this.selectionContainerBorderWidth = selectionContainerBorderWidth;
        this.selectBtnText = selectBtnText;
        this.selectBtnColor = selectBtnColor;
        this.selectBtnImage = selectBtnImage;
        this.selectBtnBorderColor = selectBtnBorderColor;
        this.selectBtnBorderWidth = selectBtnBorderWidth;
    }

    public OverviewLayout() {

    }

    public String getOverviewLayoutId() {
        return overviewLayoutId;
    }

    public void setOverviewLayoutId(String overviewLayoutId) {
        this.overviewLayoutId = overviewLayoutId;
    }

    public boolean isImageContainer() {
        return imageContainer;
    }

    public void setImageContainer(boolean imageContainer) {
        this.imageContainer = imageContainer;
    }

    public String getImageContainerColor() {
        return imageContainerColor;
    }

    public void setImageContainerColor(String imageContainerColor) {
        this.imageContainerColor = imageContainerColor;
    }

    public String getImageContainerBorderColor() {
        return imageContainerBorderColor;
    }

    public void setImageContainerBorderColor(String imageContainerBorderColor) {
        this.imageContainerBorderColor = imageContainerBorderColor;
    }

    public int getImageContainerBorderWidth() {
        return imageContainerBorderWidth;
    }

    public void setImageContainerBorderWidth(int imageContainerBorderWidth) {
        this.imageContainerBorderWidth = imageContainerBorderWidth;
    }

    public String getSelectionIcon() {
        return selectionIcon;
    }

    public void setSelectionIcon(String selectionIcon) {
        this.selectionIcon = selectionIcon;
    }

    public boolean isSelectionContainer() {
        return selectionContainer;
    }

    public void setSelectionContainer(boolean selectionContainer) {
        this.selectionContainer = selectionContainer;
    }

    public String getSelectionContainerColor() {
        return selectionContainerColor;
    }

    public void setSelectionContainerColor(String selectionContainerColor) {
        this.selectionContainerColor = selectionContainerColor;
    }

    public String getSelectionContainerBorderColor() {
        return selectionContainerBorderColor;
    }

    public void setSelectionContainerBorderColor(String selectionContainerBorderColor) {
        this.selectionContainerBorderColor = selectionContainerBorderColor;
    }

    public int getSelectionContainerBorderWidth() {
        return selectionContainerBorderWidth;
    }

    public void setSelectionContainerBorderWidth(int selectionContainerBorderWidth) {
        this.selectionContainerBorderWidth = selectionContainerBorderWidth;
    }

    public String getSelectBtnText() {
        return selectBtnText;
    }

    public void setSelectBtnText(String selectBtnText) {
        this.selectBtnText = selectBtnText;
    }

    public String getSelectBtnColor() {
        return selectBtnColor;
    }

    public void setSelectBtnColor(String selectBtnColor) {
        this.selectBtnColor = selectBtnColor;
    }

    public String getSelectBtnImage() {
        return selectBtnImage;
    }

    public void setSelectBtnImage(String selectBtnImage) {
        this.selectBtnImage = selectBtnImage;
    }

    public String getSelectBtnBorderColor() {
        return selectBtnBorderColor;
    }

    public void setSelectBtnBorderColor(String selectBtnBorderColor) {
        this.selectBtnBorderColor = selectBtnBorderColor;
    }

    public int getSelectBtnBorderWidth() {
        return selectBtnBorderWidth;
    }

    public void setSelectBtnBorderWidth(int selectBtnBorderWidth) {
        this.selectBtnBorderWidth = selectBtnBorderWidth;
    }

    /**
     * Using the builder pattern because we are creating a complex object.
     * This makes the code clearer and easier to read.
     */
    public static class Builder extends Layout {

        private boolean imageContainer;

        private String imageContainerColor;

        private String imageContainerBorderColor;

        private int imageContainerBorderWidth;

        private String selectionIcon;

        private boolean selectionContainer;

        private String selectionContainerColor;

        private String selectionContainerBorderColor;

        private int selectionContainerBorderWidth;

        private String selectBtnText;

        private String selectBtnColor;

        private String selectBtnImage;

        private String selectBtnBorderColor;

        private int selectBtnBorderWidth;

        private Builder() {
        }

        public OverviewLayout.Builder imageContainer(boolean selectBtnImage) {
            this.imageContainer = imageContainer;
            return this;
        }

        public OverviewLayout.Builder imageContainerColor(String imageContainerColor) {
            this.imageContainerColor = imageContainerColor;
            return this;
        }

        public OverviewLayout.Builder imageContainerBorderColor(String imageContainerBorderColor) {
            this.imageContainerBorderColor = imageContainerBorderColor;
            return this;
        }

        public OverviewLayout.Builder imageContainerBorderWidth(int imageContainerBorderWidth) {
            this.imageContainerBorderWidth = imageContainerBorderWidth;
            return this;
        }

        public OverviewLayout.Builder selectionIcon(String selectionIcon) {
            this.selectionIcon = selectionIcon;
            return this;
        }

        public OverviewLayout.Builder selectionContainer(boolean selectionContainer) {
            this.selectionContainer = selectionContainer;
            return this;
        }

        public OverviewLayout.Builder selectionContainerColor(String selectionContainerColor) {
            this.selectionContainerColor = selectionContainerColor;
            return this;
        }

        public OverviewLayout.Builder selectionContainerBorderColor(String selectionContainerBorderColor) {
            this.selectionContainerBorderColor = selectionContainerBorderColor;
            return this;
        }

        public OverviewLayout.Builder selectionContainerBorderWidth(int selectionContainerBorderWidth) {
            this.selectionContainerBorderWidth = selectionContainerBorderWidth;
            return this;
        }

        public OverviewLayout.Builder selectBtnText(String selectBtnText) {
            this.selectBtnText = selectBtnText;
            return this;
        }

        public OverviewLayout.Builder selectBtnColor(String selectBtnColor) {
            this.selectBtnColor = selectBtnColor;
            return this;
        }

        public OverviewLayout.Builder selectBtnImage(String selectBtnImage) {
            this.selectBtnImage = selectBtnImage;
            return this;
        }

        public OverviewLayout.Builder selectBtnBorderColor(String selectBtnBorderColor) {
            this.selectBtnBorderColor = selectBtnBorderColor;
            return this;
        }

        public OverviewLayout.Builder selectBtnBorderWidth(int selectBtnBorderWidth) {
            this.selectBtnBorderWidth = selectBtnBorderWidth;
            return this;
        }

        public OverviewLayout.Builder backgroundColor(String backgroundColor) {
            super.backgroundColor = backgroundColor;
            return this;
        }

        public OverviewLayout.Builder backGroundImage(String backgroundImage) {
            super.backgroundImage = backgroundImage;
            return this;
        }

        /**
         * Building the actual {@link com.globeshanghai.backend.dom.layout.OverviewLayout} object.
         * @return {@link com.globeshanghai.backend.dom.layout.OverviewLayout}
         */
        public OverviewLayout build() {
            OverviewLayout build = new OverviewLayout(this);

            build.checkAll(build.getLogoPosition(), build.getBackgroundColor(), build.getImageBorderColor(), build.getImageBorderWidth(), build.isImageContainer(), build.getImageContainerBorderColor(), build.getImageContainerBorderColor(), build.getImageContainerBorderWidth(), build.isSelectionContainer(), build.getSelectionContainerBorderColor(), build.getSelectionContainerColor(), build.getSelectionContainerBorderWidth(), build.getSelectBtnText(), build.getSelectBtnColor(), build.getSelectBtnBorderColor(), build.getSelectBtnBorderWidth());

            return build;
        }
    }

    /**
     * If there are variables that can't be empty or null, it can be checked in this method using the
     * {@link com.globeshanghai.frontend.util.PreCondition} notNull and notEmpty methods
     */
    private void checkAll(Position logoPosition, String backgroundColor, String imageBorderColor, int imageBorderWidth,
                          boolean imageContainer, String imageContainerColor, String imageContainerBorderColor,
                          int imageContainerBorderWidth, boolean selectionContainer,
                          String selectionContainerColor, String selectionContainerBorderColor,
                          int selectionContainerBorderWidth, String selectBtnText, String selectBtnColor,
                          String selectBtnBorderColor, int selectBtnBorderWidth) {
        {
            notNull(logoPosition, "logoPosition cannot be null");

            notNull(backgroundColor, "backgroundColor cannot be null");

        }

    }
}
