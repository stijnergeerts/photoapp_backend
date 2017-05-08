package com.globeshanghai.backend.dom.layout;

/**
 * Created by stijnergeerts on 14/04/17.
 */

public class Layout {

    protected String backgroundColor;

    protected String backgroundImage;

    protected String btnColor;

    protected String btnPressedColor;

    public Layout(String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor) {
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.btnColor = btnColor;
        this.btnPressedColor = btnPressedColor;
    }

    public Layout() {
    }


    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(String btnColor) {
        this.btnColor = btnColor;
    }

    public String getBtnPressedColor() {
        return btnPressedColor;
    }

    public void setBtnPressedColor(String btnPressedColor) {
        this.btnPressedColor = btnPressedColor;
    }
}
