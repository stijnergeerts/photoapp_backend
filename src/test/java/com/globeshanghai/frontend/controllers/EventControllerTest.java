package com.globeshanghai.frontend.controllers;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globeshanghai.backend.dom.configuration.Config;
import com.globeshanghai.backend.dom.configuration.PhotoQuality;
import com.globeshanghai.backend.dom.event.Event;
import com.globeshanghai.backend.dom.event.EventText;
import com.globeshanghai.backend.dom.layout.DetailLayout;
import com.globeshanghai.backend.dom.layout.OverviewLayout;
import com.globeshanghai.backend.dom.user.User;
import com.globeshanghai.backend.repositories.EventRepository;
import com.globeshanghai.backend.repositories.UserRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by stijnergeerts on 2/05/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EventControllerTest.class)
@ComponentScan("com.globeshanghai")
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EventControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    private MockMvc mockMvc;
    private ObjectMapper mapper;

    @Value("12345")
    private String eventId;
    @Value("TestEvent")
    private String eventName;
    @Value("TestLogo")
    private String eventLogo;
    @Value("TestLogoUpdate")
    private String updatedTestLogo;
    @Value("2017/05/09")
    private String eventStartDate;
    @Value("2017/05/11")
    private String eventEndDate;
    @Value("TestLocation")
    private String eventLocation;
    @Value("TestAddress")
    private String eventAddress;
    @Value("TestCompany")
    private String company;
    @Value("TestCompanyAddress")
    private String companyAddress;
    @Value("TestContact")
    private String contact;
    @Value("0498736478")
    private String contactPhone;
    @Value("56789")
    private String configurationId;
    @Value("MediaStorage")
    private String mediaStorage;
    @Value("TestPrinterName")
    private String printerName;
    @Value("TestQrImage")
    private String qrImage;
    @Value("TestWatermarkImage")
    private String watermarkImage;
    @Value("11223344")
    private String detailLayoutId;
    @Value("TestprintBtnImage")
    private String printBtnImage;
    @Value("TestShareBtnImage")
    private String shareBtnImage;
    @Value("TestBackBtnImage")
    private String backBtnImage;
    @Value("TestFinishBtnImage")
    private String finishBtnImage;
    @Value("TestDetailBGC")
    private String detailBackgroundColor;
    @Value("TestDetailBGI")
    private String detailBackgroundImage;
    @Value("TestDetailBtnGC")
    private String detailBtnColor;
    @Value("TestDetailBPI")
    private String detailBtnPressedColor;
    @Value("556677")
    private String overviewLayoutId;
    @Value("TestSelectBtnImage")
    private String selectBtnImage;
    @Value("TestSelectionColor")
    private String selectionColor;
    @Value("TestOverviewBGC")
    private String overviewBackgroundColor;
    @Value("TestOverviewBGI")
    private String overviewBackgroundImage;
    @Value("TestOverviewBtnGC")
    private String overviewBtnColor;
    @Value("TestOverviewBPI")
    private String overviewBtnPressedColor;
    @Value("TestLogo")
    private String logo;
    @Value("Title")
    private String textUpper;
    @Value("Follow on social media")
    private String textUnderPhoto;
    @Value("Links")
    private String textBottom;
    @Value("#000000")
    private String textColor;
    @Value("#ffffff")
    private String backgroundColor;
    @Value("TestBGImage")
    private String backgroundImage;
    @Value("TestDirectory")
    private String cloudinaryDirectory;

    private String testToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZXIiLCJpYXQiOjE0ODY" +
            "3MzE5MzgsImV4cCI6MTUxODI2NzkzOCwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoidGVz" +
            "dDYifQ.X8l82QUd7sXLuqNxiTJaQZDhU9V7_4fIi3MKNxYHOQU";

    @Before
    public void setup(){
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        this.mapper = new ObjectMapper();
    }

    @Test
    public void aCreateEvent() throws Exception {
        User testUser = new User();
        testUser.setAuthId(JWT.decode(testToken).getSubject());
        testUser.setFirstname("Test");
        testUser.setLastname("User");
        testUser.setUsername("TestUser");

        Event testEvent = new Event(eventName, eventLogo, eventStartDate,
                eventEndDate, eventLocation, eventAddress, company,
                companyAddress, contact, contactPhone,
                new Config(mediaStorage, PhotoQuality.HIGH,printerName,34,
                        true,watermarkImage,true,qrImage,
                        true),
                new DetailLayout(detailBackgroundColor, detailBackgroundImage, detailBtnColor,
                        detailBtnPressedColor, printBtnImage, shareBtnImage, backBtnImage, finishBtnImage),
                new OverviewLayout(overviewBackgroundColor, overviewBackgroundImage, overviewBtnColor,
                        overviewBtnPressedColor, selectBtnImage, selectionColor),
                new EventText(logo,textUpper,textUnderPhoto,textBottom,textColor,backgroundColor,backgroundImage,false,cloudinaryDirectory));

        Event testEvent2 = new Event("TestEvent2", eventLogo, eventStartDate,
                eventEndDate, eventLocation, eventAddress, company,
                companyAddress, contact, contactPhone,
                new Config(mediaStorage, PhotoQuality.HIGH,printerName,34,
                        true,watermarkImage,true,qrImage,
                        true),
                new DetailLayout(detailBackgroundColor, detailBackgroundImage, detailBtnColor,
                        detailBtnPressedColor, printBtnImage, shareBtnImage, backBtnImage, finishBtnImage),
                new OverviewLayout(overviewBackgroundColor, overviewBackgroundImage, overviewBtnColor,
                        overviewBtnPressedColor, selectBtnImage, selectionColor),
                new EventText(logo,textUpper,textUnderPhoto,textBottom,textColor,backgroundColor,backgroundImage,false,cloudinaryDirectory));

        this.mockMvc.perform(post("/api/user/createUser").content(mapper.writeValueAsString(testUser)).header("token", testToken).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("TestUser")));

        this.mockMvc.perform(post("/api/event/createEvent").content(mapper.writeValueAsString(testEvent)).header("token", testToken).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("TestEvent")));

        this.mockMvc.perform(post("/api/event/createEvent").content(mapper.writeValueAsString(testEvent2)).header("token", testToken).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("TestEvent2")));

    }

    @Test
    public void bTestCreateAlreadyExistingEvent() throws Exception {
        Event testEvent = new Event(eventName, eventLogo, eventStartDate,
                eventEndDate, eventLocation, eventAddress, company,
                companyAddress, contact, contactPhone,
                new Config(mediaStorage, PhotoQuality.HIGH,printerName,34,
                        true,watermarkImage,true,qrImage,
                        true),
                new DetailLayout(detailBackgroundColor, detailBackgroundImage, detailBtnColor,
                        detailBtnPressedColor, printBtnImage, shareBtnImage, backBtnImage, finishBtnImage),
                new OverviewLayout(overviewBackgroundColor, overviewBackgroundImage, overviewBtnColor,
                        overviewBtnPressedColor, selectBtnImage, selectionColor),
                new EventText(logo,textUpper,textUnderPhoto,textBottom,textColor,backgroundColor,backgroundImage,false,cloudinaryDirectory));

        this.mockMvc.perform(post("/api/event/createEvent").header("token", testToken).content(mapper.writeValueAsString(testEvent)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }


    @Test
    public void bCheckIfUserHasEvent() throws Exception {
        this.mockMvc.perform(get("/api/user/getUser").header("token", testToken))
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.userEvents", hasSize(2) ))
                .andExpect(status().isOk());
    }

    @Test
    public void cTestGetAllEvents() throws Exception {
        this.mockMvc.perform(get("/api/event/getEvents").header("token", testToken).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void eTestGetEventByName() throws Exception {
        this.mockMvc.perform(get("/api/event/getEventByName/"+eventName).header("token", testToken))
                .andDo(print())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("TestEvent")))
                .andExpect(status().isOk());
    }


    @Test
    public void fTestUpdateEvent() throws Exception {
        Event updateTestEvent = eventRepository.findEventByEventName(eventName);
        updateTestEvent.setEventName("TestEvent3");

        System.err.println("\n" + mapper.writeValueAsString(updateTestEvent) + "\n");

        this.mockMvc.perform(put("/api/event/updateEvent").header("token", testToken).content(mapper.writeValueAsString(updateTestEvent)).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.eventName", is("TestEvent3")));
    }

    @Test
    public void fTestUpdateToAlreadyExcistingEvent() throws Exception {
        Event updateTestEvent = eventRepository.findEventByEventName("TestEvent3");
        updateTestEvent.setEventName("TestEvent2");

        System.err.println("\n" + mapper.writeValueAsString(updateTestEvent) + "\n");

        this.mockMvc.perform(put("/api/event/updateEvent").header("token", testToken).content(mapper.writeValueAsString(updateTestEvent)).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    public void gTestDeleteEvent() throws Exception {
        this.mockMvc.perform(delete("/api/event/deleteEventByName/TestEvent2").header("token", testToken))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/api/event/deleteEventByName/TestEvent3").header("token", testToken))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void hCheckIfUserHasNoEventAndDeleteUser() throws Exception {
        this.mockMvc.perform(get("/api/user/getUser").header("token", testToken))
                .andDo(print())
                .andExpect((ResultMatcher) jsonPath("$.userEvents", hasSize(0) ))
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/api/user/deleteUser").header("token", testToken).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
