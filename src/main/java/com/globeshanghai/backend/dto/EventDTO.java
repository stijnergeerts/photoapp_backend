package com.globeshanghai.backend.dto;

import com.globeshanghai.backend.dom.configuration.Config;
import com.globeshanghai.backend.dom.event.EventText;
import com.globeshanghai.backend.dom.layout.DetailLayout;
import com.globeshanghai.backend.dom.layout.OverviewLayout;

import java.util.Date;

/**
 * Created by stijnergeerts on 19/04/17.
 */
public class EventDTO {

    private String eventId;

    private String eventName;

    private String eventLogo;

    private Date eventStartDate;

    private Date eventEndDate;

    private String eventLocation;

    private String eventAddress;

    private String company;

    private String companyAddress;

    private String contact;

    private String contactPhone;

    private Config config;

    private DetailLayout detailLayout;

    private OverviewLayout overviewLayout;

    private EventText eventText;

    public EventDTO(String eventName, String eventLogo, Date eventStartDate, Date eventEndDate, String eventLocation,
                    String eventAddress, String company, String companyAddress, String contact,
                    String contactPhone, Config config, DetailLayout detailLayout, OverviewLayout overviewLayout, EventText eventText) {
        this.eventName = eventName;
        this.eventLogo = eventLogo;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventLocation = eventLocation;
        this.eventAddress = eventAddress;
        this.company = company;
        this.companyAddress = companyAddress;
        this.contact = contact;
        this.contactPhone = contactPhone;
        this.config = config;
        this.detailLayout = detailLayout;
        this.overviewLayout = overviewLayout;
        this.eventText = eventText;
    }

    public EventDTO(String eventId, String eventName, String eventLogo, Date eventStartDate, Date eventEndDate, String eventLocation,
                    String eventAddress, String company, String companyAddress, String contact, String contactPhone,
                    Config config, DetailLayout detailLayout, OverviewLayout overviewLayout, EventText eventText) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventLogo = eventLogo;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventLocation = eventLocation;
        this.eventAddress = eventAddress;
        this.company = company;
        this.companyAddress = companyAddress;
        this.contact = contact;
        this.contactPhone = contactPhone;
        this.config = config;
        this.detailLayout = detailLayout;
        this.overviewLayout = overviewLayout;
        this.eventText = eventText;
    }

    public EventDTO() {
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLogo() {
        return eventLogo;
    }

    public void setEventLogo(String eventLogo) {
        this.eventLogo = eventLogo;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public DetailLayout getDetailLayout() {
        return detailLayout;
    }

    public void setDetailLayout(DetailLayout detailLayout) {
        this.detailLayout = detailLayout;
    }

    public OverviewLayout getOverviewLayout() {
        return overviewLayout;
    }

    public void setOverviewLayout(OverviewLayout overviewLayout) {
        this.overviewLayout = overviewLayout;
    }

    public EventText getEventText() {
        return eventText;
    }

    public void setEventText(EventText eventText) {
        this.eventText = eventText;
    }
}
