package com.sararoepe.courseenrollment2.models;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="semesters")
public class Semester {
	@Id
    @GeneratedValue
    private Long id;
	
    private String semester;
    
    private int year;
    
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date startDate;
    
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date endDate;
      
   	@Column(updatable=false)
    @DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    
    @DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    
    @PreUpdate
    protected void onUpdate() {
    	this.updatedAt = new Date();
    }
    
    @ManyToMany(mappedBy = "semesters")
    private List<Course> courses;

    public Semester() {	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
