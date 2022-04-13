package com.courzelo.espace_formateur.course.entities;

import java.io.InputStream;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Document(collection="Course")
@Getter
@Setter
public class Course {
	
	@Transient
    public static final String SEQUENCE_NAME = "courses_sequence";

	@Id
	private long idCourse;
	
	@Field(value = "Title")
    private String title;

    @Field(value = "Price")
    private float price;
    @Field(value = "Auteur")
    private String auteur;
    
    @Field(value = "Description")
    private String courseDescription;
    
    @Field(value = "Test")
    private InputStream test;
    
    @Field(value = "TitleStream")
    private String titleStrem;
    
    @Field(value="Introduction")
    private List<List<MultipartFile>> introduction;
    
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
  
   
}
