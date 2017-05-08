package com.globeshanghai.backend.dom.layout;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.globeshanghai.frontend.util.PreCondition.notEmpty;
import static com.globeshanghai.frontend.util.PreCondition.notNull;

/**
 * Created by stijnergeerts on 14/04/17.
 */
@Document
public final class OverviewLayout extends Layout {

    @Id
    private String overviewLayoutId;

    private String selectBtnImage;

    private String selectionColor;

    private OverviewLayout(OverviewLayout.Builder builder) {
        this.selectBtnImage = builder.selectBtnImage;
        this.selectionColor = builder.selectionColor;
        super.backgroundColor = builder.backgroundColor;
        super.backgroundImage = builder.backgroundImage;
        super.btnColor = builder.btnColor;
        super.btnPressedColor = builder.btnPressedColor;
    }

    public OverviewLayout(String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor, String overviewLayoutId, String selectBtnImage, String selectionColor) {
        super(backgroundColor, backgroundImage, btnColor, btnPressedColor);
        this.overviewLayoutId = overviewLayoutId;
        this.selectBtnImage = selectBtnImage;
        this.selectionColor = selectionColor;
    }

    public OverviewLayout(String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor, String selectBtnImage, String selectionColor) {
        super(backgroundColor, backgroundImage, btnColor, btnPressedColor);
        this.selectBtnImage = selectBtnImage;
        this.selectionColor = selectionColor;
    }

    public OverviewLayout(String selectBtnImage, String selectionColor) {
        this.selectBtnImage = selectBtnImage;
        this.selectionColor = selectionColor;
    }

    public OverviewLayout() {

    }

    public String getOverviewLayoutId() {
        return overviewLayoutId;
    }

    public void setOverviewLayoutId(String overviewLayoutId) {
        this.overviewLayoutId = overviewLayoutId;
    }

    public String getSelectBtnImage() {
        return selectBtnImage;
    }

    public void setSelectBtnImage(String selectBtnImage) {
        this.selectBtnImage = selectBtnImage;
    }

    public String getSelectionColor() {
        return selectionColor;
    }

    public void setSelectionColor(String selectionColor) {
        this.selectionColor = selectionColor;
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

    public static class Builder extends Layout {


        private String selectBtnImage;

        private String selectionColor;


        private Builder() {
        }

        public OverviewLayout.Builder selectBtnImage(String selectBtnImage) {
            this.selectBtnImage = selectBtnImage;
            return this;
        }

        public OverviewLayout.Builder selectionColor(String selectionColor) {
            this.selectionColor = selectionColor;
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

        public OverviewLayout.Builder btnColor(String btnColor) {
            super.btnColor = btnColor;
            return this;
        }

        public OverviewLayout.Builder btnPressedColor(String btnPressedColor) {
            super.btnPressedColor = btnPressedColor;
            return this;
        }


        public OverviewLayout build() {
            OverviewLayout build = new OverviewLayout(this);

            build.checkAll(build.getBackgroundColor(), build.getBackgroundImage(), build.getBtnColor(),
                    build.getBtnPressedColor(), build.getSelectBtnImage(), build.getSelectionColor());

            return build;
        }
    }

    private void checkAll(String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor,
                          String selectBtnImage, String selectionColor) {
        {
            notNull(backgroundColor, "backgroundColor cannot be null");
            notEmpty(backgroundColor, "backgroundColor cannot be empty");

            notNull(backgroundImage, "backgroundImage cannot be null");
            notEmpty(backgroundImage, "backgroundColor cannot be empty");

            notNull(btnColor, "btnColor cannot be null");
            notEmpty(btnColor, "btnColor cannot be empty");

            notNull(btnPressedColor, "btnPressedColor cannot be null");
            notEmpty(btnPressedColor, "btnPressedColor cannot be empty");

            notNull(selectBtnImage, "selectBtnImage cannot be null");
            notEmpty(selectBtnImage, "selectBtnImage cannot be empty");

            notNull(selectionColor, "selectionColor cannot be null");
            notEmpty(selectionColor, "selectionColor cannot be empty");

        }

    }
}
