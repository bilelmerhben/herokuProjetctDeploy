package com.courzelo.espace_formateur.course.iserviceRest;

import java.io.IOException;
import java.util.List;
import com.courzelo.espace_formateur.course.entities.dtos.CourseDTO;

public interface IServiceCourse {
	public CourseDTO addCourse(CourseDTO courseDTO)throws IOException;
	public List<CourseDTO> getAllCourses();
	public CourseDTO getCourseById(Long idCourse); 
	public CourseDTO updateCourse(long idCourse , CourseDTO requestCourse); 
	public void deleteCourse(long idCourse);

}
