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
}
