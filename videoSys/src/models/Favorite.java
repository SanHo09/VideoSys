package models;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="FAVORITE")
public class Favorite {
	@Id
	@Column(name="FavoriteID")
	private String favoriteID;

	@Column(name="LikeDate")
	@Temporal(TemporalType.DATE)
	private Date likeDate = new Date();
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="videoID")
	private Video video;

	public String getFavoriteID() {
		return favoriteID;
	}

	public void setFavoriteID(String favoriteID) {
		this.favoriteID = favoriteID;
	}


	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
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
