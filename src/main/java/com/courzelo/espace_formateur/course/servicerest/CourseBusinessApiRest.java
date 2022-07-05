package com.courzelo.espace_formateur.course.servicerest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import com.courzelo.espace_formateur.course.entities.Course;
import com.courzelo.espace_formateur.course.entities.User;
import com.courzelo.espace_formateur.course.entities.dtos.CourseDTO;
import com.courzelo.espace_formateur.course.iservicerest.IServiceCourse;
import com.courzelo.espace_formateur.course.repositories.CourseRepository;

@Service
public class CourseBusinessApiRest  implements IServiceCourse{
	
	    @Autowired
		private CourseRepository reposCourse;
	  
	    @Autowired
	    private ModelMapper mapper;
	    
	    @Autowired
	    RestTemplateBuilder restTemplateBuilder;
	    private static final String GET_USER_BY_ID_API = "https://auth-herokuu.herokuapp.com/api/auth/getUser/{id}";
	    
	    public User getUserByRestTemplate(long id){
			Map<String, Long> param = new HashMap<>();
			param.put("id", id);
			return restTemplateBuilder.build().getForObject(GET_USER_BY_ID_API, User.class, param);
	}
	   
		@Override
		public CourseDTO addCourse(CourseDTO courseDTO){
			Course course = mapper.map(courseDTO, Course.class);
			Course newcourse=reposCourse.save(course);	
			return mapper.map(newcourse,CourseDTO.class);
		}
		@Override
		public List<CourseDTO> getAllCourses() {
			List<Course> lstCourse=reposCourse.findAll();
			return lstCourse.stream().map(e -> mapper.map(e, CourseDTO.class))
					.collect(Collectors.toList());
			
		}
		@Override
		public CourseDTO getCourseById(String  idCourse) {
			  Course course = reposCourse.findById(idCourse).orElseGet(Course::new);
			
			
			return mapper.map(course,CourseDTO.class);
		}
		@Override
		public CourseDTO putCourseById(String  idCourse, CourseDTO courseDTO) {
	       Course course = mapper.map(courseDTO, Course.class);
	       Course thecourse = reposCourse.findById(idCourse).orElseGet(Course::new);
				thecourse.setTitle(course.getTitle());
				thecourse.setLanguage(course.getLanguage());
				thecourse.setCategory(course.getCategory());
				thecourse.setOutcomes(course.getOutcomes());
				thecourse.setDescription(course.getDescription());
				thecourse.setDetails(course.getDetails());
			    thecourse.setSkillsRequired(course.getSkillsRequired());
				thecourse.setIntroduction(course.getIntroduction());
				thecourse.setSections(course.getSections());
				thecourse.setCustomerSections(course.getCustomerSections());
				thecourse.setConclusion(course.getConclusion());
				thecourse.setAudience(course.getAudience());
				thecourse.setPreRequisites(course.getPreRequisites());
				thecourse.setInstructorInfo(course.getInstructorInfo());
				thecourse.setCourseImage(course.getCourseImage());
				thecourse.setCourseVideo(course.getCourseVideo());
				thecourse.setPrice(course.getPrice());
				thecourse.setProgress(course.getProgress());
				thecourse.setStatus(course.getStatus());
			Course newCourse = reposCourse.save(thecourse);
			return  mapper.map(newCourse, CourseDTO.class);
		}
		@Override
		public void deleteCourse(String  idCourse) {
			Course course = reposCourse.findById(idCourse).orElseGet(Course::new);
			reposCourse.delete(course);
		}
	
		
		
	
		
		

}
