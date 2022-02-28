package models;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="SHARE")
public class Share {
	@Id
	@Column(name="ShareID")
	private String shareID;
	
	@Column(name="Emails")
	private String email;
	@Column(name="ShareDate")
	private Date shareDate;
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="videoID")
	private Video video;

	public String getShareID() {
		return shareID;
	}

	public void setShareID(String shareID) {
		this.shareID = shareID;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getShareDate() {
		return shareDate;
	}
	
	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	
	
	
}
