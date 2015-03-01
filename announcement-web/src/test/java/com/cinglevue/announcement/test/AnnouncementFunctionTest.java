package com.cinglevue.announcement.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.cinglevue.announcement.domain.Announcement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml",
		"classpath:application-context.xml" })
public class AnnouncementFunctionTest {
	private static final String BASE_URI = "http://localhost:8080/announcement-web/api/announcement";
	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private MongoOperations mongoOperations;

	@Before
	public void setup() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new StringHttpMessageConverter());
		converters.add(new Jaxb2RootElementHttpMessageConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(converters);
		initializeDatabase();
		System.out.println("test");

	}

	private void initializeDatabase() {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.OCTOBER, 9, 8, 00, 00); 
		Date date = cal.getTime();
		try {
			mongoOperations.dropCollection("announcements");
			mongoOperations
					.insert(new Announcement(
							"There Is No Way To Protect Yourself If US Treasuries Default",
							"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
							date,
							date));
			mongoOperations
					.insert(new Announcement(
							"States keep watch on school deals",
							"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
							date, date));
							
		} catch (DataAccessResourceFailureException e) {
			fail("MongoDB instance is not running");
		}
	}

	@Test
	public void getAllAnnouncements() {
		// Announcement[] announcements = restTemplate.getForObject(BASE_URI,
		// Announcement[].class);
		// assertNotNull(announcements);
		// assertEquals(3, announcements.length);
		// assertEquals("525ca3d65f9bb2e6b3b12ab5", announcements[0].getId());
		// assertEquals("There Is No Way To Protect Yourself If US Treasuries Default",
		// announcements[0].getTitle());
		// System.out.println("test");

	}
}
