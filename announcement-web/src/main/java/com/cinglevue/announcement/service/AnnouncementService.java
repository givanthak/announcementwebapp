package com.cinglevue.announcement.service;

import com.cinglevue.announcement.domain.Announcement;

// TODO: Auto-generated Javadoc
/**
 * The Class AnnouncementService.
 */
public interface AnnouncementService {

	/**
	 * Gets the all announcements.
	 *
	 * @return the all announcements
	 */
	Announcement[] getAllAnnouncements();
	
	/**
	 * Gets the announcement.
	 *
	 * @return the announcement
	 */
	Announcement getAnnouncement(String id);
	
	/**
	 * Insert announcement.
	 *
	 * @param announcement the announcement
	 */
	void insertAnnouncement(Announcement announcement);
	
	/**
	 * Delete announcement.
	 *
	 * @param id the id
	 */
	void deleteAnnouncement(String id);

}
