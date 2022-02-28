package models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="Content")
	private String content;
	
	@Column(name="CommentDate")
	@Temporal(TemporalType.DATE)
	Date commentDate;
	
	@ManyToOne
	@JoinColumn(name="videoID")
	Video video;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
