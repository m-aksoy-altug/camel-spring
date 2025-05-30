package com.camel.spring.entity;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@Entity
@Table(name="course")
//@XmlType
//@XmlRootElement(name="course")
@JacksonXmlRootElement(localName="course")
public class Course {
	@Id
	@Column(name="course_id")
	@JacksonXmlProperty(localName="courseid")
	private int courseId;
	
	@Column(name="course_name")
	@JacksonXmlProperty(localName="coursename")
	private String courseName;
	
	@Column(name="duration")
	@JacksonXmlProperty(localName="duration")
	private int duration;
	
	public int getCourseId() {
		return courseId;
	}
	
	@XmlElement(name="course_id")
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	@XmlElement(name="course_name")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getDuration() {
		return duration;
	}
	
	@XmlElement(name="duration")
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + "]";
	}
	
	public Course() {
		super();
	}
	
}
