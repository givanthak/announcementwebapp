package com.cinglevue.announcement.test;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cinglevue.announcement.domain.Announcement;
import com.cinglevue.announcement.service.AnnouncementService;

// TODO: Auto-generated Javadoc
/**
 * The Class AnnouncementFunctionIT.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:test-spring-context.xml",
		"classpath:application-context.xml" })
public class AnnouncemenIntegrationTest {

	/** The Constant BASE_URI. */
	private static final String BASE_URI = "/announcements";

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The announcement service. */
	@Autowired
	private AnnouncementService announcementService;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		reset(announcementService);

		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).build();
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.OCTOBER, 9, 8, 00, 00);
		Date date = cal.getTime();
		when(announcementService.getAllAnnouncements())
				.thenReturn(
						new Announcement[] {
								new Announcement(
										"There Is No Way To Protect Yourself If US Treasuries Default",
										"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
										date, date),
								new Announcement(
										"States keep watch on school deals",
										"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
										date, date) });

		when(announcementService.getAnnouncement("525ca3d65f9bb2e6b3b12ab5"))
				.thenReturn(
						new Announcement(
								"There Is No Way To Protect Yourself If US Treasuries Default",
								"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
								date, date));
	}

//	/**
//	 * Gets the all announcements.
//	 * 
//	 * @return the all announcements
//	 * @throws Exception
//	 *             the exception
//	 */
//	@Test
//	public void getAllAnnouncements() throws Exception {
//		Calendar cal = Calendar.getInstance();
//		cal.set(2013, Calendar.OCTOBER, 9, 8, 00, 00);
//		Date date = cal.getTime();
//		mockMvc.perform(get(BASE_URI).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(
//						content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$", hasSize(2)))
//				.andExpect(
//						jsonPath(
//								"$[0].title",
//								is("There Is No Way To Protect Yourself If US Treasuries Default")))
//				.andExpect(
//						jsonPath(
//								"$[0].body",
//								is("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.")))
//				.andExpect(jsonPath("$[0].startDate", is(date)))
//				.andExpect(jsonPath("$[1].expiryDate", is(date.getTime())))
//				.andExpect(
//						jsonPath(
//								"$[0].title",
//								is("There Is No Way To Protect Yourself If US Treasuries Default")))
//				.andExpect(
//						jsonPath(
//								"$[0].body",
//								is("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.")))
//				.andExpect(jsonPath("$[0].startDate", is(date)))
//				.andExpect(jsonPath("$[1].expiryDate", is(date)));
//
//		verify(announcementService, times(1)).getAllAnnouncements();
//		verifyZeroInteractions(announcementService);
//	}
//
//	/**
//	 * Gets the announcement.
//	 * 
//	 * @return the announcement
//	 * @throws Exception
//	 *             the exception
//	 */
//	@Test
//	public void getAnnouncement() throws Exception {
//		Calendar cal = Calendar.getInstance();
//		cal.set(2013, Calendar.OCTOBER, 9, 8, 00, 00);
//		Date date = cal.getTime();
//		mockMvc.perform(
//				get(BASE_URI + "/{announcementId}", "525ca3d65f9bb2e6b3b12ab5")
//						.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(
//						content().contentType("application/json;charset=UTF-8"))
//				.andExpect(
//						jsonPath(
//								"$.title",
//								is("There Is No Way To Protect Yourself If US Treasuries Default")))
//				.andExpect(
//						jsonPath(
//								"$.body",
//								is("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.")))
//				.andExpect(jsonPath("$.startDate", is(date)))
//				.andExpect(jsonPath("$.expiryDate", is(date)));
//
//		verify(announcementService, times(1)).getAnnouncement(
//				"525ca3d65f9bb2e6b3b12ab5");
//		verifyZeroInteractions(announcementService);
//	}

	/**
	 * Insert announcement.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void insertAnnouncement() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.OCTOBER, 9, 8, 00, 00);
		Date date = cal.getTime();
		
		
		mockMvc.perform(post(BASE_URI.concat("/add"))
				
				.content("{ \"title\": \"mySeries\", \"body\": \"England\", \"startDate\": \"" + date.toString()+"\",\"startDate\": \"" + date.toString()+"\" } }")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", endsWith("/announcements/3")));
		
		

		verify(announcementService, times(1)).insertAnnouncement(
				any(Announcement.class));
		verifyZeroInteractions(announcementService);
	}

}
