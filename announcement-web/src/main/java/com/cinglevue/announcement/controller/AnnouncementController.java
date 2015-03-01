package com.cinglevue.announcement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cinglevue.announcement.domain.Announcement;
import com.cinglevue.announcement.service.AnnouncementService;

/**
 * The Class AnnouncementController.
 */
@RestController
@RequestMapping(value="/announcements")
public class AnnouncementController {

	/** The announcement service. */
	@Autowired
	private AnnouncementService announcementService;

	/**
	 * Gets the all announcements.
	 * 
	 * @return the all announcements
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Announcement[] getAllAnnouncements() {
		return announcementService.getAllAnnouncements();
	}

	/**
	 * Gets the announcement.
	 * 
	 * @param id
	 *            the id
	 * @return the announcement
	 */
	@RequestMapping(value = "/{announcementId}", method = RequestMethod.GET)
	public ResponseEntity<Announcement> getAnnouncement(
			@PathVariable("announcementId") String id) {
		Announcement announcement = announcementService.getAnnouncement(id);

		if (announcement == null) {
			return new ResponseEntity<Announcement>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Announcement>(announcement, HttpStatus.OK);
	}

	/**
	 * Insert announcement.
	 * 
	 * @param announcement
	 *            the announcement
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertAnnouncement(@RequestBody Announcement announcement,
			HttpServletRequest request, HttpServletResponse response) {
		announcementService.insertAnnouncement(announcement);
		response.setHeader("Location", request.getRequestURL().append("/")
				.append(announcement.getId()).toString());
	}

	/**
	 * Delete announcement.
	 * 
	 * @param id
	 *            the id
	 */
	@RequestMapping(value = "/{announcementId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAnnouncement(@PathVariable("announcementId") String id) {
		announcementService.deleteAnnouncement(id);
	}
}
