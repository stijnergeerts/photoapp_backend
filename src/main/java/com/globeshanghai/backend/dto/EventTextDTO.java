package com.globeshanghai.backend.dto;

/**
 * Created by stijnergeerts on 8/05/17.
 */
public class EventTextDTO {
    private String textUpper;

    private String textUnderPhoto;

    private String textBottom;

    public EventTextDTO(String textUpper, String textUnderPhoto, String textBottom) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
        this.textBottom = textBottom;
    }

    public EventTextDTO(String textUpper, String textUnderPhoto) {
        this.textUpper = textUpper;
        this.textUnderPhoto = textUnderPhoto;
    }

    public EventTextDTO(String textUpper) {
        this.textUpper = textUpper;
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
}
