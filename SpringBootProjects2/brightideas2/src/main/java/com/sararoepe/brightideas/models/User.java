package com.sararoepe.brightideas.models;

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
import javax.persistence.OneToMany;
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
	
    @Pattern(regexp="^[a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*$", message="Please enter a first and last name separated by a space.")
    private String name;
    
    @Size(min=6, message="Your alias must be 6 or more alphanumeric characters. No spaces or special characters")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Your alias must be 6 or more alphanumeric characters. No spaces or special characters")
    private String alias;
    
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
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "likes",
    	joinColumns = @JoinColumn(name = "user_id"),
    	inverseJoinColumns = @JoinColumn(name = "idea_id")
    )
    private List<Idea> ideasLiked;
    
		@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Idea> ideas;
	
	
    public User() {
    }
    
    public User(String name, String alias, String email, String password) {
    	this.name = name;
    	this.alias = alias;
    	this.email = email;
    	this.password = password;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	public List<Idea> getIdeasLiked() {
		return ideasLiked;
	}

	public void setIdeasLiked(List<Idea> ideasLiked) {
		this.ideasLiked = ideasLiked;
	}





    
}
