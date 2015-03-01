package com.cinglevue.announcement.domain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// TODO: Auto-generated Javadoc
/**
 * The Class Announcement.
 */
@Document(collection = "announcements")
public class Announcement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1488794405860665812L;

	/** The id. */
	@Id
	private String id;
	
	/** The title. */
	private String title;
	
	/** The body. */
	private String body;
	
	/** The start date. */
	private Date startDate;
	
	/** The expiry date. */
	private Date expiryDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@XmlElement
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@XmlElement
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	@XmlElement
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body.
	 *
	 * @param body the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	@XmlElement
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the expiry date.
	 *
	 * @return the expiry date
	 */
	@XmlElement
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Sets the expiry date.
	 *
	 * @param expiryDate the new expiry date
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Instantiates a new announcement.
	 *
	 * @param title the title
	 * @param body the body
	 * @param startDate the start date
	 * @param expiryDate the expiry date
	 */
	public Announcement(String title, String body, Date startDate,
			Date expiryDate) {
		super();
		this.title = title;
		this.body = body;
		this.startDate = startDate;
		this.expiryDate = expiryDate;
	}

	
	
	
}
