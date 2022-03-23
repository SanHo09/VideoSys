package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
	@Id
	@Column(name="UserID")
	private String userID;
	@Column(name="passwords")
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name="Fullname")
	private String fullName;
	@Column(name="images")
	private String image;
	@Column(name="Active")
	private Boolean active=true;
	
	@OneToMany(mappedBy="user")
	private List<Favorite> favorites;
	
	@OneToMany(mappedBy="user")
	private List<Share> shares;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comment;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public List<Comment> getComment() {
		return comment;
	}
	
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
	
		
	

	
	
	
}
