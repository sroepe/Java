package com.sararoepe.courseenrollment2.models;

import java.util.Date;
import java.util.List;

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
    
    private String startTime;
    
    private String endTime;
    
    @Size(max = 15)
    int capacity;
    
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
	    name = "users_courses", 
	    joinColumns = @JoinColumn(name = "course_id"), 
	    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "courses_semesters", 
        joinColumns = @JoinColumn(name = "course_id"), 
        inverseJoinColumns = @JoinColumn(name = "semester_id"))
    private List<Semester> semesters;
    
    public Course() {
    }
    
    public Course(String name, String instructor, String days, String startTime, String endTime) {
    	this.name = name;
    	this.instructor = instructor;
    	this.days = days;
    	this.startTime = startTime;
    	this.endTime = endTime;
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


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
    
}
