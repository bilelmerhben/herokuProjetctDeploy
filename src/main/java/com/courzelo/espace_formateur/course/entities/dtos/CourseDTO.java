package com.courzelo.espace_formateur.course.entities.dtos;

import java.io.InputStream;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CourseDTO {
	
	private long idCourse;
	private String title;
    private float price;
    private String auteur;
    private String courseDescription;
    private InputStream test;
    private String titleStrem;
	
}
