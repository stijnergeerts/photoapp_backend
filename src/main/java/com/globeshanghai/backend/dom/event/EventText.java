package com.globeshanghai.backend.dom.event;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by stijnergeerts on 8/05/17.
 */
@Document(collection = "eventtext")
public final class EventText {

    private String logo;

    private String tabTitle;

    private String textUpper;

    private String textAbovePhoto;

    private String textUnderPhoto;

    private String textBottom;

    private String textColor;

    private String backgroundColor;

    private String backgroundImage;

    private boolean backgroundImageToggle;

    private String cloudinaryDirectory;

    private String qrCodeImage;

    public EventText(String logo, String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String backgroundImage, boolean backgroundImageToggle, String cloudinaryDirectory, String qrCodeImage) {
        this.logo = logo;
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.backgroundImageToggle = backgroundImageToggle;
        this.cloudinaryDirectory = cloudinaryDirectory;
        this.qrCodeImage = qrCodeImage;
    }

    public EventText(String logo, String tabTitle, String textUpper, String textAbovePhoto, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String backgroundImage, boolean backgroundImageToggle, String cloudinaryDirectory, String qrCodeImage) {
        this.logo = logo;
        this.tabTitle = tabTitle;
        this.textUpper = textUpper;
        this.textAbovePhoto = textAbovePhoto;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.backgroundImageToggle = backgroundImageToggle;
        this.cloudinaryDirectory = cloudinaryDirectory;
        this.qrCodeImage = qrCodeImage;
    }

    public EventText() {
    }

    public boolean isBackgroundImageToggle() {
        return backgroundImageToggle;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public String getTextUpper() {
        return textUpper;
    }

    public void setTextUpper(String textUpper) {
        this.textUpper = textUpper;
    }

    public String getTextAbovePhoto() {
        return textAbovePhoto;
    }

    public void setTextAbovePhoto(String textAbovePhoto) {
        this.textAbovePhoto = textAbovePhoto;
    }

    public String getTextUnderPhoto() {
        return textUnderPhoto;
    }

    public void setTextUnderPhoto(String textUnderPhoto) {
        this.textUnderPhoto = textUnderPhoto;
    }

    public String getTextBottom() {
        return textBottom;
    }

    public void setTextBottom(String textBottom) {
        this.textBottom = textBottom;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
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

    public boolean getBackgroundImageToggle() {
        return backgroundImageToggle;
    }

    public void setBackgroundImageToggle(boolean backgroundImageToggle) {
        this.backgroundImageToggle = backgroundImageToggle;
    }

    public String getCloudinaryDirectory() {
        return cloudinaryDirectory;
    }

    public void setCloudinaryDirectory(String cloudinaryDirectory) {
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public String getQrCodeImage() {
        return qrCodeImage;
    }

    public void setQrCodeImage(String qrCodeImage) {
        this.qrCodeImage = qrCodeImage;
    }
}
