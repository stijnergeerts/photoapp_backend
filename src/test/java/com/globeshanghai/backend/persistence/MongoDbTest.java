package com.globeshanghai.backend.persistence;

import com.globeshanghai.backend.dom.configuration.Config;
import com.globeshanghai.backend.dom.configuration.PhotoQuality;
import com.globeshanghai.backend.dom.event.Event;
import com.globeshanghai.backend.dom.layout.DetailLayout;
import com.globeshanghai.backend.dom.layout.OverviewLayout;
import com.globeshanghai.backend.dom.user.User;
import com.globeshanghai.backend.repositories.EventRepository;
import com.globeshanghai.backend.repositories.UserRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by stijnergeerts on 2/05/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDbTest.class)
@ComponentScan("com.globeshanghai")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MongoDbTest {

    @Value("TestID")
    private String userId;
    @Value("Test")
    private String userFirstName;
    @Value("UpdatedUsername")
    private String updatedUsername;
    @Value("Tester")
    private String userLastName;
    @Value("Test123")
    private String username;
    @Value("fakeAuthId")
    private String authId;
    @Value("12345")
    private String eventId;
    @Value("TestEvent")
    private String eventName;
    @Value("TestLogo")
    private String eventLogo;
    @Value("TestLogoUpdate")
    private String updatedTestLogo;
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
    @Value("127.0.0.1")
    private String ftpIPAddress;
    @Value("8080")
    private String ftpPort;
    @Value("TestUser")
    private String ftpUsername;
    @Value("TestPassword")
    private String ftpPassword;
    @Value("TestPrinterName")
    private String printerName;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;


    @Test
    public void aCreateUser()
    {

        User u = new User();
        u.setUserId(userId);
        u.setUsername(username);
        u.setAuthId(authId);
        u.setFirstname(userFirstName);
        u.setLastname(userLastName);

        userRepository.save(u);

        assertEquals((userRepository.findUserByAuthId(authId).getFirstname() + userRepository.findUserByAuthId(authId).getLastname()), (u.getFirstname() + u.getLastname()));
    }

    @Test
    public void bUpdateUser()
    {
        User u = userRepository.findUserByAuthId(authId);
        u.setFirstname(updatedUsername);
        userRepository.save(u);
        assertEquals(userRepository.findUserByAuthId(authId).getFirstname(), u.getFirstname());
    }

    @Test
    public void cDeleteUser()
    {
        User u = userRepository.findUserByAuthId(authId);
        userRepository.delete(u);
        assertNull(userRepository.findUserByAuthId(authId));
    }

    @Test
    public void dCreateEvent()
    {
        Event e = new Event(eventName, eventLogo, new Date(2014,12,3),
                new Date(2014,12,4),eventLocation,eventAddress,company,
                companyAddress,contact,contactPhone,
                new Config(mediaStorage, PhotoQuality.HIGH,ftpIPAddress,ftpPort,
                        ftpUsername,ftpPassword,printerName,true,
                        false,34,true,false,watermarkImage),
                new DetailLayout(detailBackgroundColor,detailBackgroundImage,detailBtnColor,
                        detailBtnPressedColor,printBtnImage,shareBtnImage,backBtnImage,finishBtnImage),
                new OverviewLayout(overviewBackgroundColor,overviewBackgroundImage,overviewBtnColor,
                        overviewBtnPressedColor,selectBtnImage,selectionColor));
        eventRepository.save(e);
        assertEquals((eventRepository.findEventByEventName(eventName).getEventName() + eventRepository.findEventByEventName(eventName).getEventLogo()), (e.getEventName() + e.getEventLogo()));
    }

    @Test
    public void eUpdateEvent()
    {
        Event e = eventRepository.findEventByEventName(eventName);
        e.setEventLogo(updatedTestLogo);
        eventRepository.save(e);
        assertEquals(eventRepository.findEventByEventName(eventName).getEventName(), e.getEventName());
    }

    @Test
    public void fDeleteEvent()
    {
        Event e = eventRepository.findEventByEventName(eventName);
        eventRepository.delete(e);
        Event testEvent = eventRepository.findEventByEventName(eventName);
        assertNull(eventRepository.findEventByEventName(eventName));
    }
}