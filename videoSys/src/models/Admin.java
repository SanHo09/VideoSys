package models;


import javax.persistence.*;

@Entity
@Table(name="ADMINS")
public class Admin {
	@Id
	@Column(name="AdminID")
	private String adminID;
	@Column(name="passwords")
	private String password;
	@Column(name="Emails")
	private String email;
	@Column(name="fullName")
	private String fullName;
	@Column(name="Active")
	private boolean active;
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
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
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
