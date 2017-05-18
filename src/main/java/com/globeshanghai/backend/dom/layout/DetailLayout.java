package com.globeshanghai.backend.dom.layout;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.globeshanghai.frontend.util.PreCondition.notEmpty;
import static com.globeshanghai.frontend.util.PreCondition.notNull;


/**
 * Created by stijnergeerts on 14/04/17.
 */

@Document
public final class DetailLayout extends Layout {

    @Id
    private String detailLayoutId;

    private String printBtnImage;
    private String printBtnText;
    private String printBtnColor;
    private String printBtnBorderColor;
    private int printBtnBorderWidth;

    private String shareBtnImage;
    private String shareBtnText;
    private String shareBtnColor;
    private String shareBtnBorderColor;
    private int shareBtnBorderWidth;

    private String backBtnImage;
    private String backBtnText;
    private String backBtnColor;
    private String backBtnBorderColor;
    private int backBtnBorderWidth;

    private String finishBtnImage;
    private String finishBtnText;
    private String finishBtnColor;
    private String finishBtnBorderColor;
    private int finishBtnBorderWidth;

    private String printMessageImage;
    private String printMessageText;
    private String printMessageColor;
    private String printMessageBorderColor;
    private int printMessageBorderWidth;

    private DetailLayout(DetailLayout.Builder builder) {
        this.printBtnImage = builder.printBtnImage;
        this.printBtnText = builder.printBtnText;
        this.printBtnColor = builder.printBtnColor;
        this.printBtnBorderColor = builder.printBtnBorderColor;
        this.printBtnBorderWidth = builder.printBtnBorderWidth;
        this.shareBtnImage = builder.shareBtnImage;
        this.shareBtnText = builder.shareBtnText;
        this.shareBtnColor = builder.shareBtnColor;
        this.shareBtnBorderColor = builder.shareBtnBorderColor;
        this.shareBtnBorderWidth = builder.shareBtnBorderWidth;
        this.backBtnImage = builder.backBtnImage;
        this.backBtnText = builder.backBtnText;
        this.backBtnColor = builder.backBtnColor;
        this.backBtnBorderColor = builder.backBtnBorderColor;
        this.backBtnBorderWidth = builder.backBtnBorderWidth;
        this.finishBtnImage = builder.finishBtnImage;
        this.finishBtnText = builder.finishBtnText;
        this.finishBtnColor = builder.finishBtnColor;
        this.finishBtnBorderColor = builder.finishBtnBorderColor;
        this.finishBtnBorderWidth = builder.finishBtnBorderWidth;
        this.printMessageImage = builder.printMessageImage;
        this.printMessageText = builder.printMessageText;
        this.printMessageColor = builder.printMessageColor;
        this.printMessageBorderColor = builder.printMessageBorderColor;
        this.printMessageBorderWidth = builder.printMessageBorderWidth;
        super.backgroundColor = builder.backgroundColor;
        super.backgroundImage = builder.backgroundImage;
    }


    public DetailLayout() {

    }

    public DetailLayout(int number, String logo, Position logoPosition, String backgroundColor, String backgroundImage, String imageBorderColor, int imageBorderWidth, String detailLayoutId, String printBtnImage, String printBtnText, String printBtnColor, String printBtnBorderColor, int printBtnBorderWidth, String shareBtnImage, String shareBtnText, String shareBtnColor, String shareBtnBorderColor, int shareBtnBorderWidth, String backBtnImage, String backBtnText, String backBtnColor, String backBtnBorderColor, int backBtnBorderWidth, String finishBtnImage, String finishBtnText, String finishBtnColor, String finishBtnBorderColor, int finishBtnBorderWidth, String printMessageImage, String printMessageText, String printMessageColor, String printMessageBorderColor, int printMessageBorderWidth) {
        super(number, logo, logoPosition, backgroundColor, backgroundImage, imageBorderColor, imageBorderWidth);
        this.detailLayoutId = detailLayoutId;
        this.printBtnImage = printBtnImage;
        this.printBtnText = printBtnText;
        this.printBtnColor = printBtnColor;
        this.printBtnBorderColor = printBtnBorderColor;
        this.printBtnBorderWidth = printBtnBorderWidth;
        this.shareBtnImage = shareBtnImage;
        this.shareBtnText = shareBtnText;
        this.shareBtnColor = shareBtnColor;
        this.shareBtnBorderColor = shareBtnBorderColor;
        this.shareBtnBorderWidth = shareBtnBorderWidth;
        this.backBtnImage = backBtnImage;
        this.backBtnText = backBtnText;
        this.backBtnColor = backBtnColor;
        this.backBtnBorderColor = backBtnBorderColor;
        this.backBtnBorderWidth = backBtnBorderWidth;
        this.finishBtnImage = finishBtnImage;
        this.finishBtnText = finishBtnText;
        this.finishBtnColor = finishBtnColor;
        this.finishBtnBorderColor = finishBtnBorderColor;
        this.finishBtnBorderWidth = finishBtnBorderWidth;
        this.printMessageImage = printMessageImage;
        this.printMessageText = printMessageText;
        this.printMessageColor = printMessageColor;
        this.printMessageBorderColor = printMessageBorderColor;
        this.printMessageBorderWidth = printMessageBorderWidth;
    }

    public DetailLayout(int number, String logo, Position logoPosition, String backgroundColor, String backgroundImage, String imageBorderColor, int imageBorderWidth, String printBtnImage, String printBtnText, String printBtnColor, String printBtnBorderColor, int printBtnBorderWidth, String shareBtnImage, String shareBtnText, String shareBtnColor, String shareBtnBorderColor, int shareBtnBorderWidth, String backBtnImage, String backBtnText, String backBtnColor, String backBtnBorderColor, int backBtnBorderWidth, String finishBtnImage, String finishBtnText, String finishBtnColor, String finishBtnBorderColor, int finishBtnBorderWidth, String printMessageImage, String printMessageText, String printMessageColor, String printMessageBorderColor, int printMessageBorderWidth) {
        super(number, logo, logoPosition, backgroundColor, backgroundImage, imageBorderColor, imageBorderWidth);
        this.printBtnImage = printBtnImage;
        this.printBtnText = printBtnText;
        this.printBtnColor = printBtnColor;
        this.printBtnBorderColor = printBtnBorderColor;
        this.printBtnBorderWidth = printBtnBorderWidth;
        this.shareBtnImage = shareBtnImage;
        this.shareBtnText = shareBtnText;
        this.shareBtnColor = shareBtnColor;
        this.shareBtnBorderColor = shareBtnBorderColor;
        this.shareBtnBorderWidth = shareBtnBorderWidth;
        this.backBtnImage = backBtnImage;
        this.backBtnText = backBtnText;
        this.backBtnColor = backBtnColor;
        this.backBtnBorderColor = backBtnBorderColor;
        this.backBtnBorderWidth = backBtnBorderWidth;
        this.finishBtnImage = finishBtnImage;
        this.finishBtnText = finishBtnText;
        this.finishBtnColor = finishBtnColor;
        this.finishBtnBorderColor = finishBtnBorderColor;
        this.finishBtnBorderWidth = finishBtnBorderWidth;
        this.printMessageImage = printMessageImage;
        this.printMessageText = printMessageText;
        this.printMessageColor = printMessageColor;
        this.printMessageBorderColor = printMessageBorderColor;
        this.printMessageBorderWidth = printMessageBorderWidth;
    }

    public String getDetailLayoutId() {
        return detailLayoutId;
    }

    public void setDetailLayoutId(String detailLayoutId) {
        this.detailLayoutId = detailLayoutId;
    }

    public String getPrintBtnImage() {
        return printBtnImage;
    }

    public void setPrintBtnImage(String printBtnImage) {
        this.printBtnImage = printBtnImage;
    }

    public String getPrintBtnText() {
        return printBtnText;
    }

    public void setPrintBtnText(String printBtnText) {
        this.printBtnText = printBtnText;
    }

    public String getPrintBtnColor() {
        return printBtnColor;
    }

    public void setPrintBtnColor(String printBtnColor) {
        this.printBtnColor = printBtnColor;
    }

    public String getPrintBtnBorderColor() {
        return printBtnBorderColor;
    }

    public void setPrintBtnBorderColor(String printBtnBorderColor) {
        this.printBtnBorderColor = printBtnBorderColor;
    }

    public int getPrintBtnBorderWidth() {
        return printBtnBorderWidth;
    }

    public void setPrintBtnBorderWidth(int printBtnBorderWidth) {
        this.printBtnBorderWidth = printBtnBorderWidth;
    }

    public String getShareBtnImage() {
        return shareBtnImage;
    }

    public void setShareBtnImage(String shareBtnImage) {
        this.shareBtnImage = shareBtnImage;
    }

    public String getShareBtnText() {
        return shareBtnText;
    }

    public void setShareBtnText(String shareBtnText) {
        this.shareBtnText = shareBtnText;
    }

    public String getShareBtnColor() {
        return shareBtnColor;
    }

    public void setShareBtnColor(String shareBtnColor) {
        this.shareBtnColor = shareBtnColor;
    }

    public String getShareBtnBorderColor() {
        return shareBtnBorderColor;
    }

    public void setShareBtnBorderColor(String shareBtnBorderColor) {
        this.shareBtnBorderColor = shareBtnBorderColor;
    }

    public int getShareBtnBorderWidth() {
        return shareBtnBorderWidth;
    }

    public void setShareBtnBorderWidth(int shareBtnBorderWidth) {
        this.shareBtnBorderWidth = shareBtnBorderWidth;
    }

    public String getBackBtnImage() {
        return backBtnImage;
    }

    public void setBackBtnImage(String backBtnImage) {
        this.backBtnImage = backBtnImage;
    }

    public String getBackBtnText() {
        return backBtnText;
    }

    public void setBackBtnText(String backBtnText) {
        this.backBtnText = backBtnText;
    }

    public String getBackBtnColor() {
        return backBtnColor;
    }

    public void setBackBtnColor(String backBtnColor) {
        this.backBtnColor = backBtnColor;
    }

    public String getBackBtnBorderColor() {
        return backBtnBorderColor;
    }

    public void setBackBtnBorderColor(String backBtnBorderColor) {
        this.backBtnBorderColor = backBtnBorderColor;
    }

    public int getBackBtnBorderWidth() {
        return backBtnBorderWidth;
    }

    public void setBackBtnBorderWidth(int backBtnBorderWidth) {
        this.backBtnBorderWidth = backBtnBorderWidth;
    }

    public String getFinishBtnImage() {
        return finishBtnImage;
    }

    public void setFinishBtnImage(String finishBtnImage) {
        this.finishBtnImage = finishBtnImage;
    }

    public String getFinishBtnText() {
        return finishBtnText;
    }

    public void setFinishBtnText(String finishBtnText) {
        this.finishBtnText = finishBtnText;
    }

    public String getFinishBtnColor() {
        return finishBtnColor;
    }

    public void setFinishBtnColor(String finishBtnColor) {
        this.finishBtnColor = finishBtnColor;
    }

    public String getFinishBtnBorderColor() {
        return finishBtnBorderColor;
    }

    public void setFinishBtnBorderColor(String finishBtnBorderColor) {
        this.finishBtnBorderColor = finishBtnBorderColor;
    }

    public int getFinishBtnBorderWidth() {
        return finishBtnBorderWidth;
    }

    public void setFinishBtnBorderWidth(int finishBtnBorderWidth) {
        this.finishBtnBorderWidth = finishBtnBorderWidth;
    }

    public String getPrintMessageImage() {
        return printMessageImage;
    }

    public void setPrintMessageImage(String printMessageImage) {
        this.printMessageImage = printMessageImage;
    }

    public String getPrintMessageText() {
        return printMessageText;
    }

    public void setPrintMessageText(String printMessageText) {
        this.printMessageText = printMessageText;
    }

    public String getPrintMessageColor() {
        return printMessageColor;
    }

    public void setPrintMessageColor(String printMessageColor) {
        this.printMessageColor = printMessageColor;
    }

    public String getPrintMessageBorderColor() {
        return printMessageBorderColor;
    }

    public void setPrintMessageBorderColor(String printMessageBorderColor) {
        this.printMessageBorderColor = printMessageBorderColor;
    }

    public int getPrintMessageBorderWidth() {
        return printMessageBorderWidth;
    }

    public void setPrintMessageBorderWidth(int printMessageBorderWidth) {
        this.printMessageBorderWidth = printMessageBorderWidth;
    }


    public static class Builder extends Layout {

        private String printBtnImage;
        private String printBtnText;
        private String printBtnColor;
        private String printBtnBorderColor;
        private int printBtnBorderWidth;

        private String shareBtnImage;
        private String shareBtnText;
        private String shareBtnColor;
        private String shareBtnBorderColor;
        private int shareBtnBorderWidth;

        private String backBtnImage;
        private String backBtnText;
        private String backBtnColor;
        private String backBtnBorderColor;
        private int backBtnBorderWidth;

        private String finishBtnImage;
        private String finishBtnText;
        private String finishBtnColor;
        private String finishBtnBorderColor;
        private int finishBtnBorderWidth;

        private String printMessageImage;
        private String printMessageText;
        private String printMessageColor;
        private String printMessageBorderColor;
        private int printMessageBorderWidth;


        private Builder() {
        }

        public DetailLayout.Builder printBtnImage(String printBtnImage) {
            this.printBtnImage = printBtnImage;
            return this;
        }

        public DetailLayout.Builder printBtnText(String printBtnText) {
            this.printBtnText = printBtnText;
            return this;
        }

        public DetailLayout.Builder printBtnColor(String printBtnColor) {
            this.printBtnColor = printBtnColor;
            return this;
        }

        public DetailLayout.Builder printBtnBorderColor(String printBtnBorderColor) {
            this.printBtnBorderColor = printBtnBorderColor;
            return this;
        }

        public DetailLayout.Builder printBtnBorderWidth(int printBtnBorderWidth) {
            this.printBtnBorderWidth = printBtnBorderWidth;
            return this;
        }

        //

        public DetailLayout.Builder shareBtnImage(String shareBtnImage) {
            this.shareBtnImage = shareBtnImage;
            return this;
        }

        public DetailLayout.Builder shareBtnText(String shareBtnText) {
            this.shareBtnText = shareBtnText;
            return this;
        }

        public DetailLayout.Builder shareBtnColor(String shareBtnColor) {
            this.shareBtnColor = shareBtnColor;
            return this;
        }

        public DetailLayout.Builder shareBtnBorderColor(String shareBtnBorderColor) {
            this.shareBtnBorderColor = shareBtnBorderColor;
            return this;
        }

        public DetailLayout.Builder shareBtnBorderWidth(int shareBtnBorderWidth) {
            this.shareBtnBorderWidth = shareBtnBorderWidth;
            return this;
        }

        //

        public DetailLayout.Builder backBtnImage(String backBtnImage) {
            this.backBtnImage = backBtnImage;
            return this;
        }

        public DetailLayout.Builder backBtnText(String backBtnText) {
            this.backBtnText = backBtnText;
            return this;
        }

        public DetailLayout.Builder backBtnColor(String backBtnColor) {
            this.backBtnColor = backBtnColor;
            return this;
        }

        public DetailLayout.Builder backBtnBorderColor(String backBtnBorderColor) {
            this.backBtnBorderColor = backBtnBorderColor;
            return this;
        }

        public DetailLayout.Builder backBtnBorderWidth(int backBtnBorderWidth) {
            this.backBtnBorderWidth = backBtnBorderWidth;
            return this;
        }

        //

        public DetailLayout.Builder finishBtnEvent(String finishBtnImage) {
            this.finishBtnImage = finishBtnImage;
            return this;
        }

        public DetailLayout.Builder finishBtnText(String finishBtnText) {
            this.finishBtnText = finishBtnText;
            return this;
        }

        public DetailLayout.Builder finishBtnColor(String finishBtnColor) {
            this.finishBtnColor = finishBtnColor;
            return this;
        }

        public DetailLayout.Builder finishBtnBorderColor(String finishBtnBorderColor) {
            this.finishBtnBorderColor = finishBtnBorderColor;
            return this;
        }

        public DetailLayout.Builder finishBtnBorderWidth(int finishBtnBorderWidth) {
            this.finishBtnBorderWidth = finishBtnBorderWidth;
            return this;
        }

        //

        public DetailLayout.Builder backgroundColor(String backgroundColor) {
            super.backgroundColor = backgroundColor;
            return this;
        }

        public DetailLayout.Builder backGroundImage(String backgroundImage) {
            super.backgroundImage = backgroundImage;
            return this;
        }

        //

        public DetailLayout.Builder printMessageImage(String printMessageImage) {
            this.printMessageImage = printMessageImage;
            return this;
        }

        public DetailLayout.Builder printMessageText(String printMessageText) {
            this.printMessageText = printMessageText;
            return this;
        }

        public DetailLayout.Builder printMessageColor(String printMessageColor) {
            this.printMessageColor = printMessageColor;
            return this;
        }

        public DetailLayout.Builder printMessageBorderColor(String printMessageBorderColor) {
            this.printMessageBorderColor = printMessageBorderColor;
            return this;
        }

        public DetailLayout.Builder printMessageBorderWidth(int printMessageBorderWidth) {
            this.printMessageBorderWidth = printMessageBorderWidth;
            return this;
        }


        public DetailLayout build() {
            DetailLayout build = new DetailLayout(this);

            build.checkAll(build.getLogoPosition(), build.getBackgroundColor(), build.getImageBorderColor(), build.getImageBorderWidth(), build.getPrintBtnText(),
                    build.getPrintBtnColor(), build.getPrintBtnBorderColor(), build.getPrintBtnBorderWidth(), build.getShareBtnText(),
                    build.getShareBtnColor(), build.getShareBtnBorderColor(), build.getShareBtnBorderWidth(), build.getBackBtnText(), build.getBackBtnColor(),
                    build.getBackBtnBorderColor(), build.getBackBtnBorderWidth(), build.getFinishBtnText(), build.getFinishBtnBorderColor(), build.getFinishBtnColor(),
                    build.getFinishBtnBorderWidth(), build.getPrintMessageText(), build.getPrintMessageColor(), build.getPrintMessageBorderColor(), build.getPrintMessageBorderWidth());

            return build;
        }
    }

    private void checkAll(Position logoPosition, String backgroundColor,
                          String imageBorderColor, int imageBorderWidth, String printBtnText,
                          String printBtnColor, String printBtnBorderColor, int printBtnBorderWidth,
                          String shareBtnText, String shareBtnColor, String shareBtnBorderColor,
                          int shareBtnBorderWidth, String backBtnText, String backBtnColor,
                          String backBtnBorderColor, int backBtnBorderWidth, String finishBtnText,
                          String finishBtnBorderColor, String finishBtnColor, int finishBtnBorderWidth,
                          String printMessageText, String printMessageColor, String printMessageBorderColor,
                          int printMessageBorderWidth) {
        notNull(logoPosition, "logoPosition cannot be null");

        notNull(backgroundColor, "backgroundColor cannot be null");
        notEmpty(backgroundColor, "backgroundColor cannot be empty");




            }
    }

