package com.courzelo.espace_formateur.course.entities.dtos;

import java.util.List;
import com.courzelo.espace_formateur.course.entities.CustomerExtremCourse;
import com.courzelo.espace_formateur.course.entities.ExtremCourse;
import com.courzelo.espace_formateur.course.entities.intrConcluExtremCourse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseDTO {
	
	private String id;
	private long idUser;
	private String title;
	private String language;
	private String category;
	private List<String> outcomes;
	private String description;
	private String details;
	private List<String> skillsRequired;
    private intrConcluExtremCourse introduction;
    private List<ExtremCourse> sections;
    private List<CustomerExtremCourse> customerSections;
    private intrConcluExtremCourse conclusion;
	private String audience;
	private List<String> preRequisites;
	private String instructorInfo;
	private String courseImage;
	private String courseVideo;
	private float price;
	private int progress;
	private String status;
	private String finalQuizz;
	
}
