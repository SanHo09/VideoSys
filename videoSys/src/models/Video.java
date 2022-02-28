package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Video")
public class Video {
	@Id
	@Column(name="VideoID")
	private String videoID;
	@Column(name="Title")
	private String title;
	@Column(name="Poster")
	private String poster;
	@Column(name="Views")
	private int views;
	@Column(name="Description")
	private String description;
	@Column(name="Active")
	private boolean active;
	@Column(name="link")
	private String link;
	
	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites;
	
	@OneToMany(mappedBy="video")
	private List<Share> shares;
	
	@OneToMany(mappedBy="video")
	private List<Comment> comment;
	
	public String getVideoID() {
		return videoID;
	}
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	public List<Share> getShares() {
		return shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
	public List<Comment> getComment() {
		return comment;
	}
	
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
}
