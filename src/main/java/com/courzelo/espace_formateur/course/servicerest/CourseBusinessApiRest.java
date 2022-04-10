package com.courzelo.espace_formateur.course.servicerest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.courzelo.espace_formateur.course.entities.Course;
import com.courzelo.espace_formateur.course.entities.dtos.CourseDTO;
import com.courzelo.espace_formateur.course.iserviceRest.IServiceCourse;
import com.courzelo.espace_formateur.course.repositories.CourseRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Service
public class CourseBusinessApiRest  implements IServiceCourse{
	
	    @Autowired
		private CourseRepository reposCourse;
	    
	    @Autowired
	    private  SequenceGeneratorService sequenceGeneratorService;
	    
	    @Autowired
	    private ModelMapper mapper;
	    
	    @Autowired
	    private GridFsTemplate gridFsTemplate;

	    @Autowired
	    private GridFsOperations operations;
	    
		@Override
		public CourseDTO addCourse(CourseDTO courseDTO/*,String title, MultipartFile file*/)throws IOException {
			Course course = mapper.map(courseDTO, Course.class);
			course.setIdCourse(sequenceGeneratorService.generateSequence(Course.SEQUENCE_NAME));
			/* DBObject metaData = new BasicDBObject(); 
		        metaData.put("type", "video"); 
		        metaData.put("title", title); 
		        ObjectId id = gridFsTemplate.store(
		          file.getInputStream(), file.getName(), file.getContentType(), metaData);*/
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
		public CourseDTO getCourseById(Long idCourse) {
			Course course =reposCourse.findByIdCourse(idCourse);
			return mapper.map(course,CourseDTO.class);
		}
		@Override
		public CourseDTO updateCourse(long idCourse, CourseDTO courseDTO) {
	       Course course = mapper.map(courseDTO, Course.class);
			Course thecourse = reposCourse.findByIdCourse(idCourse);
			if(courseDTO.getPrice()!= 0)
				thecourse.setPrice(course.getPrice());
			
			if(courseDTO.getTitle()!= null)
				thecourse.setTitle(course.getTitle());
			
			if(courseDTO.getAuteur()!= null)
				thecourse.setAuteur(course.getAuteur());
			
			if(courseDTO.getCourseDescription()!= null)
				thecourse.setCourseDescription(course.getCourseDescription());
			Course newCourse = reposCourse.save(thecourse);
			return  mapper.map(newCourse, CourseDTO.class);
		}
		@Override
		public void deleteCourse(long idCourse) {
			Course course = reposCourse.findByIdCourse(idCourse); 
			reposCourse.delete(course);
		}
		
		
		
		

}
