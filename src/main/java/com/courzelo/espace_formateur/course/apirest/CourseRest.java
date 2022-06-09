package com.courzelo.espace_formateur.course.apirest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.courzelo.espace_formateur.course.entities.dtos.CourseDTO;
import com.courzelo.espace_formateur.course.iservicerest.IServiceCourse;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping( "/course" )
@RestController
public class CourseRest {
	@Autowired
	private IServiceCourse iCourse;

	@PostMapping(path = "/addCourse/{idUser}")
    public CourseDTO addCourse(@RequestBody @Valid  CourseDTO courseDTO ,@PathVariable("idUser") Long idUser) {
        return iCourse.addCourse(courseDTO,idUser);
    }
	@PutMapping(path = "/addCourseListQuizz/{courseId}/{quizzId}")
    public CourseDTO addCourseListQuizz(@PathVariable(name = "courseId") @Valid  String courseId, @PathVariable(name = "quizzId") String quizzId)  {
        return iCourse.addCourseWithQuizz(courseId, quizzId);
    }
	@PutMapping(path = "/addCourseFinalQuizz/{courseId}/{quizzId}")
    public CourseDTO addCourseFinalQuizz(@PathVariable(name = "courseId") @Valid  String courseId, @PathVariable(name = "quizzId") String quizzId)  {
        return iCourse.addFinalQuizz(courseId, quizzId);
    }
	@GetMapping(path = "/getAllCourses")
	public List<CourseDTO> getAllCourses() {
		return iCourse.getAllCourses(); 
	}

	@GetMapping(path = "/getById/{id}")
	public CourseDTO getCourseById(@PathVariable(name = "id") String  id) {
		return iCourse.getCourseById(id); 
	}
	
	@PutMapping(path = "/updateCourse/{id}")
    public CourseDTO updateCourse(@PathVariable(name = "id") String  id, @RequestBody  @Valid  CourseDTO courseDTO) {
        return iCourse.putCourseById(id,courseDTO);
    }
	
	@DeleteMapping(path = "/delete/{id}")
	public void deleteCourse(@PathVariable(name = "id") String  id) {
			iCourse.deleteCourse(id);
		
	}

	
	
}
