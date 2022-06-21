package com.courzelo.espace_formateur.course.iservicerest;

import java.util.List;
import com.courzelo.espace_formateur.course.entities.dtos.CourseDTO;

public interface IServiceCourse {
	public CourseDTO addCourse(CourseDTO courseDTO);
	public List<CourseDTO> getAllCourses();
	public CourseDTO getCourseById(String  idCourse); 
	public CourseDTO putCourseById(String  idCourse , CourseDTO requestCourse); 
	public void deleteCourse(String  idCourse);
}
