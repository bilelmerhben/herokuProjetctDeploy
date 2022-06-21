package com.courzelo.espace_formateur.course;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.courzelo.espace_formateur.course.entities.dtos.CourseDTO;
import com.courzelo.espace_formateur.course.iservicerest.IServiceCourse;
@RunWith(SpringRunner.class)
@SpringBootTest
class CourseApplicationTests {

	@Autowired
	private IServiceCourse iCourse;
	
	@Test
	 void testCreateCourse() {
		
		CourseDTO CourseDTO =new CourseDTO();
		CourseDTO.setId("62598adc87d8e5558e8655ca");
		CourseDTO.setPrice(150);
		CourseDTO.setTitle("Test course javascript");
		assertNotNull(iCourse.getCourseById("62598adc87d8e5558e8655ca").getId());
	
	

	}
	
	@Test
	 void testReacdAll() {
		List<CourseDTO> listCourses= iCourse.getAllCourses();
		assertThat(listCourses).size().isPositive();
	}
	@Test
	 void testgetCourse() {
		CourseDTO CourseDTO=iCourse.getCourseById("62598adc87d8e5558e8655ca");
		 assertThat(CourseDTO.getPrice()).isEqualTo(150);
		 assertThat(CourseDTO.getTitle()).isEqualTo("Test course javascript");
		
	}
}
