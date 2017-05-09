package com.globeshanghai;

import com.globeshanghai.backend.dom.configuration.Config;
import com.globeshanghai.backend.dom.configuration.PhotoQuality;
import com.globeshanghai.backend.dom.event.Event;
import com.globeshanghai.backend.dom.event.EventText;
import com.globeshanghai.backend.dom.layout.DetailLayout;
import com.globeshanghai.backend.dom.layout.OverviewLayout;
import com.globeshanghai.backend.repositories.EventRepository;
import com.globeshanghai.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class PhotoappBackendApplication implements CommandLineRunner{// implements //CommandLineRunner{

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PhotoappBackendApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {

		//List<ShortEvent> events = new LinkedList<>();


		/*Config config = new Config("MEDIASTORAGE", PhotoQuality.HIGH,"ftpIpAddress","ftpPort","ftpUsername","ftpPassword","printername",true,false,34,true,false,"JES");
		Event event = new Event("eventName",new Date(2014,12,3),new Date(2014,12,4),"eventLoc","eventAdd","comp","compAdd","contact","contactPhone",config);*/


		// save a couple of customers
		//configurationRepository.save(new Config("MEDIASTORAGE", PhotoQuality.HIGH,"ftpIpAddress","ftpPort","ftpUsername","ftpPassword","printername",true,false,34,true,false,"JES"));

		/*configurationRepository.save(new Config("MEDIASTORAGE", PhotoQuality.HIGH,"ftpIpAddress","ftpPort",
				"ftpUsername","ftpPassword","printername",true,
				false,34,true,false,"JES"));

		*/eventRepository.save(new Event("Rolls Royce","EventLogo",new Date(2014,12,3),
				new Date(2014,12,4),"eventLoc","eventAdd","comp",
				"compAdd","contact","contactPhone",
				new Config("MEDIASTORAGE", PhotoQuality.HIGH,"ftpIpAddress","ftpPort",
						"ftpUsername","ftpPassword","printername",true,
						false,34,true,false,"JES"),
				new DetailLayout("backgroundColorTEST","backgroundImage","btnColor",
						"btnPressedColor","printBtnImage","shareBtnImage","backBtnImage","finishBtnImage"),
				new OverviewLayout("backgroundColorOverv","backgroundImageOverv","btnColorOverv",
						"btnPressedColorOverv","selectBtnImage","selectionColor"),
				new EventText("Title", "Follow on social media","Links","#a48e7c")));
		//userRepository.save(new User("stijnergeerts", "", "Stijn", "Ergeerts",events));
		};
		}



	/*
	String backgroundColor, String backgroundImage, String btnColor, String btnPressedColor, String detailLayoutId, String printBtnImage, String shareBtnImage, String backBtnImage, String finishBtnImage) {
        super(backgroundColor, backgroundImage, btnColor, btnPressedColor
	 */



