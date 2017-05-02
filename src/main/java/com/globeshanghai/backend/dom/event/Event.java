package com.globeshanghai.backend.dom.event;

import com.globeshanghai.backend.dom.configuration.Config;
import com.globeshanghai.backend.dom.layout.DetailLayout;
import com.globeshanghai.backend.dom.layout.OverviewLayout;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

import static com.globeshanghai.frontend.util.PreCondition.notEmpty;
import static com.globeshanghai.frontend.util.PreCondition.notNull;

/**
 * Created by stijnergeerts on 14/04/17.
 */

@Document(collection = "event")
public final class Event implements Serializable {

    @Id
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

    private Event(Builder builder) {
        this.eventName = builder.eventName;
        this.eventLogo = builder.eventLogo;
        this.eventStartDate = builder.eventStartDate;
        this.eventEndDate = builder.eventEndDate;
        this.eventLocation = builder.eventLocation;
        this.eventAddress = builder.eventAddress;
        this.company = builder.company;
        this.companyAddress = builder.companyAddress;
        this.contact = builder.contact;
        this.contactPhone = builder.contactPhone;
        this.config = builder.config;
        this.detailLayout = builder.detailLayout;
        this.overviewLayout = builder.overviewLayout;
    }
    public Event() {
    }


    public Event(String eventName, String eventLogo, Date eventStartDate, Date eventEndDate, String eventLocation, String eventAddress,
                 String company, String companyAddress, String contact, String contactPhone, Config config,
                 DetailLayout detailLayout, OverviewLayout overviewLayout) {
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
    }


    public static Builder getBuilder() {
        return new Builder();
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

    public void update(String eventName, String eventLogo, Date eventStartDate, Date eventEndDate, String eventLocation, String eventAddress,
                       String company, String companyAddress, String contact, String contactPhone, Config config,
                       DetailLayout detailLayout, OverviewLayout overviewLayout) {

        checkAll(eventName, eventLogo, eventStartDate, eventEndDate, eventLocation, eventAddress,
                company,  companyAddress,  contact,  contactPhone,  config,
                detailLayout,  overviewLayout);

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
    }


    public static class Builder {

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


        private Builder() {}

        public Event.Builder eventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Event.Builder eventLogo(String eventLogo) {
            this.eventLogo = eventLogo;
            return this;
        }

        public Event.Builder eventStartDate(Date eventStartDate) {
            this.eventStartDate = eventStartDate;
            return this;
        }

        public Event.Builder eventEndDate(Date eventEndDate) {
            this.eventEndDate = eventEndDate;
            return this;
        }

        public Event.Builder eventLocation(String eventLocation) {
            this.eventLocation = eventLocation;
            return this;
        }
        public Event.Builder eventAddress(String eventAddress) {
            this.eventAddress = eventAddress;
            return this;
        }
        public Event.Builder company(String company) {
            this.company = company;
            return this;
        }
        public Event.Builder companyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
            return this;
        }
        public Event.Builder contact(String contact) {
            this.contact = contact;
            return this;
        }
        public Event.Builder contactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }
        public Event.Builder config(Config config) {
            this.config = config;
            return this;
        }
        public Event.Builder detailLayout(DetailLayout detailLayout) {
            this.detailLayout = detailLayout;
            return this;
        }
        public Event.Builder overviewLayout(OverviewLayout overviewLayout) {
            this.overviewLayout = overviewLayout;
            return this;
        }



        public Event build() {
            Event build = new Event(this);

            build.checkAll(build.getEventName(), build.getEventLogo(), build.getEventStartDate(), build.getEventEndDate(),
                    build.getEventLocation(), build.getEventAddress(),build.getCompany(),build.getCompanyAddress(),
                    build.getContact(),build.getContactPhone(),build.getConfig(), build.getDetailLayout(), build.getOverviewLayout());

            return build;
        }
    }

    private void checkAll(String eventName, String eventLogo, Date eventStartDate,  Date eventEndDate, String eventLocation,String eventAddress,String company,
                          String companyAddress, String contact, String contactPhone, Config config, DetailLayout detailLayout,
                          OverviewLayout overviewLayout) {
        notNull(eventName, "eventName cannot be null");
        notEmpty(eventName, "eventName cannot be empty");

        notNull(eventLogo, "eventLogo cannot be null");
        notEmpty(eventLogo, "eventLogo cannot be empty");

        notNull(eventStartDate, "eventStartDate cannot be null");

        notNull(eventEndDate, "eventEndDate cannot be null");

        notNull(eventLocation, "eventLocation cannot be null");
        notEmpty(eventLocation, "eventLocation cannot be empty");

        notNull(eventAddress, "eventAddress cannot be null");
        notEmpty(eventAddress, "eventAddress cannot be empty");

        notNull(company, "company cannot be null");
        notEmpty(company, "company cannot be empty");

        notNull(companyAddress, "companyAddress cannot be null");
        notEmpty(companyAddress, "companyAddress cannot be empty");

        notNull(contact, "contact cannot be null");
        notEmpty(contact, "contact cannot be empty");

        notNull(contactPhone, "contactPhone cannot be null");
        notEmpty(contactPhone, "contactPhone cannot be empty");

        notNull(config, "config cannot be null");

        notNull(detailLayout, "detailLayout cannot be null");

        notNull(overviewLayout, "overviewLayout cannot be null");
    }
}
