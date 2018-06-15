package com.sararoepe.courseenrollment3.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
    @Size(min=6)
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Your username must be 6 or more alphanumeric characters. No spaces or special characters")
    private String username;
    
    @Pattern(regexp="^(.+)@(.+)$", message="You must enter a valid email.  Example: abc@abc.com")
    private String email;
       
    @Size(min=8, message="Your password must be 8 or more characters.")
    private String password;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    
    private Date updatedAt;
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
    
    public User() {
    }
    
    public User(String username, String email, String password) {
    	this.username = username;
    	this.email = email;
    	this.password = password;
    }

    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
		name = "users_courses",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private List<Course> courses;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


    
}
