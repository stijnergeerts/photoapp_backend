package com.globeshanghai.backend.dto;

/**
 * Created by stijnergeerts on 8/05/17.
 */
public class EventTextDTO {
    private String logo;

    private String textUpper;

    private String textUnderPhoto;

    private String textBottom;

    private String textColor;

    private String backgroundColor;

    private String backgroundImage;

    private String cloudinaryDirectory;

    public EventTextDTO(String textUpper, String textUnderPhoto, String textBottom, String textColor, String cloudinaryDirectory) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public EventTextDTO(String textUpper, String textUnderPhoto, String textBottom, String textColor) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
    }

    public EventTextDTO(String textUpper, String textUnderPhoto) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
    }

    public EventTextDTO(String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String cloudinaryDirectory) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public EventTextDTO(String textUpper, String textUnderPhoto, String textBottom) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
    }

    public EventTextDTO(String logo, String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String cloudinaryDirectory) {
        this.logo = logo;
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public EventTextDTO(String logo, String textUpper, String textUnderPhoto, String textBottom, String textColor, String backgroundColor, String backgroundImage, String cloudinaryDirectory) {
        this.logo = logo;
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.backgroundImage = backgroundImage;
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public EventTextDTO(String textUpper) {
        this.textUpper = textUpper;
    }
    public EventTextDTO() {
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTextUpper() {
        return textUpper;
    }

    public void setTextUpper(String textUpper) {
        this.textUpper = textUpper;
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

    public String getCloudinaryDirectory() {
        return cloudinaryDirectory;
    }

    public void setCloudinaryDirectory(String cloudinaryDirectory) {
        this.cloudinaryDirectory = cloudinaryDirectory;
    }


}
