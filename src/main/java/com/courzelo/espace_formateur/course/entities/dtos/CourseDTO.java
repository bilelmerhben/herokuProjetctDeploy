package com.courzelo.espace_formateur.course.entities.dtos;

import java.io.InputStream;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.courzelo.espace_formateur.course.models.Chapter;
import com.courzelo.espace_formateur.course.models.Conclusion;
import com.courzelo.espace_formateur.course.models.Introduction;
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
    
    private Introduction introduction;
    private List<Chapter> chapters;
    private Conclusion conclusion;
	
}
