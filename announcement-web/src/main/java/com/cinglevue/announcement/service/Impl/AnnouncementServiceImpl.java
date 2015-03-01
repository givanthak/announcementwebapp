package com.cinglevue.announcement.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cinglevue.announcement.domain.Announcement;
import com.cinglevue.announcement.service.AnnouncementService;

/**
 * The Class AnnouncementServiceImpl.
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	/** The mongo operations. */
	@Autowired
	MongoOperations mongoOperations;

	/* (non-Javadoc)
	 * @see com.cinglevue.announcement.service.AnnouncementService#getAllAnnouncements()
	 */
	@Override
	public Announcement[] getAllAnnouncements() {
		List<Announcement> announcementList = mongoOperations
				.findAll(Announcement.class);
		return announcementList.toArray(new Announcement[0]);
	}

	/* (non-Javadoc)
	 * @see com.cinglevue.announcement.service.AnnouncementService#getAnnouncement(long)
	 */
	@Override
	public Announcement getAnnouncement(String id) {
		return mongoOperations.findById(id, Announcement.class);
	}

	/* (non-Javadoc)
	 * @see com.cinglevue.announcement.service.AnnouncementService#insertAnnouncement(com.cinglevue.announcement.domain.Announcement)
	 */
	@Override
	public void insertAnnouncement(Announcement announcement) {
		mongoOperations.insert(announcement);
	}

	/* (non-Javadoc)
	 * @see com.cinglevue.announcement.service.AnnouncementService#deleteAnnouncement(long)
	 */
	@Override
	public void deleteAnnouncement(String id) {
		Query query = new Query();
		Criteria criteria = new Criteria("_id").is(id);
		query.addCriteria(criteria);

		mongoOperations.remove(query, Announcement.class);
	}

}
