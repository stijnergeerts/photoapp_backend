package com.globeshanghai.backend.dom.layout;

/**
 * Created by stijnergeerts on 14/04/17.
 */

public class Layout {

    protected int number;

    protected String logo;

    protected Position logoPosition;

    protected String backgroundColor;

    protected String backgroundImage;

    protected String imageBorderColor;

    protected int imageBorderWidth;

    public Layout(int number, String logo, Position logoPosition, String backgroundColor, String backgroundImage, String imageBorderColor, int imageBorderWidth) {
        this.number = number;
        this.logo = logo;
        this.logoPosition = logoPosition;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.imageBorderColor = imageBorderColor;
        this.imageBorderWidth = imageBorderWidth;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Position getLogoPosition() {
        return logoPosition;
    }

    public void setLogoPosition(Position logoPosition) {
        this.logoPosition = logoPosition;
    }

    public String getImageBorderColor() {
        return imageBorderColor;
    }

    public void setImageBorderColor(String imageBorderColor) {
        this.imageBorderColor = imageBorderColor;
    }

    public int getImageBorderWidth() {
        return imageBorderWidth;
    }

    public void setImageBorderWidth(int imageBorderWidth) {
        this.imageBorderWidth = imageBorderWidth;
    }
}
