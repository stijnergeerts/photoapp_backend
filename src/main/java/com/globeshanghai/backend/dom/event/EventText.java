package com.globeshanghai.backend.dom.event;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by stijnergeerts on 8/05/17.
 */
@Document(collection = "eventtext")
public final class EventText {

    private String textUpper;

    private String textUnderPhoto;

    private String textBottom;

    private String textColor;

    private String cloudinaryDirectory;

    public EventText(String textUpper) {
        this.textUpper = textUpper;
    }

    public EventText(String textUpper, String textUnderPhoto, String textBottom) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;

    }

    public EventText(String textUnderPhoto, String textBottom) {
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
    }

    public EventText(String textUpper, String textUnderPhoto, String textBottom, String textColor, String cloudinaryDirectory) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
        this.cloudinaryDirectory = cloudinaryDirectory;
    }

    public EventText(String textUpper, String textUnderPhoto, String textBottom, String textColor) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
        this.textColor = textColor;
    }

    public EventText() {
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

    public String getCloudinaryDirectory() {
        return cloudinaryDirectory;
    }

    public void setCloudinaryDirectory(String cloudinaryDirectory) {
        this.cloudinaryDirectory = cloudinaryDirectory;
    }
}
