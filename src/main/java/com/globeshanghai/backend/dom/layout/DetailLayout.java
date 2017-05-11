package com.globeshanghai.backend.dom.layout;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by stijnergeerts on 14/04/17.
 */

@Document
public final class DetailLayout extends Layout {

    @Id
    private String detailLayoutId;

    private String printBtnImage;

    private String shareBtnImage;

    private String backBtnImage;

    private String finishBtnImage;

    private DetailLayout(DetailLayout.Builder builder) {
        this.printBtnImage = builder.printBtnImage;
        this.shareBtnImage = builder.shareBtnImage;
        this.backBtnImage = builder.backBtnImage;
        this.finishBtnImage = builder.finishBtnImage;
        super.backgroundColor = builder.backgroundColor;
        super.backgroundImage = builder.backgroundImage;
        super.btnColor = builder.btnColor;
        super.btnPressedColor = builder.btnPressedColor;
    }
    public DetailLayout(){

    }
    public DetailLayout(String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor, String detailLayoutId, String printBtnImage, String shareBtnImage, String backBtnImage, String finishBtnImage) {
        super(backgroundColor, backgroundImage, btnColor, btnPressedColor);
        this.detailLayoutId = detailLayoutId;
        this.printBtnImage = printBtnImage;
        this.shareBtnImage = shareBtnImage;
        this.backBtnImage = backBtnImage;
        this.finishBtnImage = finishBtnImage;
    }


    public DetailLayout(String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor, String printBtnImage, String shareBtnImage, String backBtnImage, String finishBtnImage) {
        super(backgroundColor, backgroundImage, btnColor, btnPressedColor);
        this.printBtnImage = printBtnImage;
        this.shareBtnImage = shareBtnImage;
        this.backBtnImage = backBtnImage;
        this.finishBtnImage = finishBtnImage;
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

    public String getShareBtnImage() {
        return shareBtnImage;
    }

    public void setShareBtnImage(String shareBtnImage) {
        this.shareBtnImage = shareBtnImage;
    }

    public String getBackBtnImage() {
        return backBtnImage;
    }

    public void setBackBtnImage(String backBtnImage) {
        this.backBtnImage = backBtnImage;
    }

    public String getFinishBtnImage() {
        return finishBtnImage;
    }

    public void setFinishBtnImage(String finishBtnImage) {
        this.finishBtnImage = finishBtnImage;

    }

    public String getBackgroundColor() {
        return super.getBackgroundColor();
    }

    public void setBackgroundColor(String backgroundColor) {
        super.setBackgroundColor(backgroundColor);
    }

    public String getBackgroundImage() {
        return super.getBackgroundImage();
    }

    public void setBackgroundImage(String backgroundImage) {
        super.setBackgroundImage(backgroundImage);
    }

    public String getBtnColor() {
        return super.getBtnColor();
    }

    public void setBtnColor(String btnColor) {
        super.setBtnColor(btnColor);
    }

    public String getBtnPressedColor() {
        return super.getBtnPressedColor();
    }

    public void setBtnPressedColor(String btnPressedColor) {
        super.setBtnPressedColor(btnPressedColor);
    }



    public static class Builder extends Layout{


        private String printBtnImage;

        private String shareBtnImage;

        private String backBtnImage;

        private String finishBtnImage;


        private Builder() {
        }

        public DetailLayout.Builder printBtnImage(String printBtnImage) {
            this.printBtnImage = printBtnImage;
            return this;
        }

        public DetailLayout.Builder shareBtnImage(String shareBtnImage) {
            this.shareBtnImage = shareBtnImage;
            return this;
        }

        public DetailLayout.Builder backBtnImage(String backBtnImage) {
            this.backBtnImage = backBtnImage;
            return this;
        }

        public DetailLayout.Builder finishBtnEvent(String finishBtnImage) {
            this.finishBtnImage = finishBtnImage;
            return this;
        }

        public DetailLayout.Builder backgroundColor(String backgroundColor) {
            super.backgroundColor = backgroundColor;
            return this;
        }

        public DetailLayout.Builder backGroundImage(String backgroundImage) {
            super.backgroundImage=backgroundImage;
            return this;
        }

        public DetailLayout.Builder btnColor(String btnColor) {
            super.btnColor = btnColor;
            return this;
        }

        public DetailLayout.Builder btnPressedColor(String btnPressedColor) {
            super.btnPressedColor = btnPressedColor;
            return this;
        }


        public DetailLayout build() {
            DetailLayout build = new DetailLayout(this);

            build.checkAll(build.getBackgroundColor(), build.getBackgroundImage(), build.getBtnColor(),
                    build.getBtnPressedColor(), build.getPrintBtnImage(), build.getShareBtnImage(), build.getBackBtnImage(),
                    build.getFinishBtnImage());

            return build;
        }
    }

        private void checkAll(String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor, String printBtnImage, String shareBtnImage, String backBtnImage, String finishBtnImage) {
            {
                /*notNull(backgroundColor, "backgroundColor cannot be null");
                notEmpty(backgroundColor, "backgroundColor cannot be empty");

                notNull(backgroundImage, "backgroundImage cannot be null");
                notEmpty(backgroundImage, "backgroundColor cannot be empty");

                notNull(btnColor, "btnColor cannot be null");
                notEmpty(btnColor, "btnColor cannot be empty");

                notNull(btnPressedColor, "btnPressedColor cannot be null");
                notEmpty(btnPressedColor, "btnPressedColor cannot be empty");

                notNull(printBtnImage, "printBtnImage cannot be null");
                notEmpty(printBtnImage, "printBtnImage cannot be empty");

                notNull(shareBtnImage, "shareBtnImage cannot be null");
                notEmpty(shareBtnImage, "shareBtnImage cannot be empty");

                notNull(backBtnImage, "backBtnImage cannot be null");
                notEmpty(backBtnImage, "backBtnImage cannot be empty");

                notNull(finishBtnImage, "finishBtnImage cannot be null");
                notEmpty(finishBtnImage, "finishBtnImage cannot be empty");*/
            }
        }
    }
