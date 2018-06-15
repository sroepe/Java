package com.sararoepe.courseenrollment.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
    @GeneratedValue
    private Long id;
	
    private String name;
    
    private String instructor;
    
    private String days;
    
    private String times;
    
    @Size(max = 15)
    private int capacity;
    
    private String semesters;

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
    
    @ManyToMany(mappedBy = "courses")
    private List<User> users;
    
    public Course() {
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

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getSemesters() {
		return semesters;
	}

	public void setSemesters(String semesters) {
		this.semesters = semesters;
	}


    
    
}
