package com.courzelo.espace_formateur.course.apiRest;
import org.springframework.http.MediaType;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.courzelo.espace_formateur.course.entities.dtos.CourseDTO;
import com.courzelo.espace_formateur.course.iserviceRest.IServiceCourse;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping( "/course" )
@RestController
public class CourseRest {
	@Autowired
	private IServiceCourse iCourse;

	@PostMapping(path = "/addCourse"
			/*,consumes = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE}*/)
    public CourseDTO addCourse(
    		/*@RequestPart("title") String title,
    		@RequestPart("file") MultipartFile file,*/
    		@RequestBody  @Valid  CourseDTO courseDTO
    		) throws IOException {
        return iCourse.addCourse(courseDTO/*,title,file*/);
    }
	
	@GetMapping(path = "/getAllCourses")
	public List<CourseDTO> getAllCourses() {
		return iCourse.getAllCourses(); 
	}

	@GetMapping(path = "/getById/{idCourse}")
	public CourseDTO getCourseById(@PathVariable(name = "idCourse") Long idCourse) {
		return iCourse.getCourseById(idCourse); 
	}
	
	@PutMapping(path = "/updateCourse/{idCourse}")
    public CourseDTO updateCourse(@PathVariable(name = "idCourse") Long idCourse, @RequestBody  @Valid  CourseDTO courseDTO) {
        return iCourse.updateCourse(idCourse,courseDTO);
    }
	
	@DeleteMapping(path = "/delete/{idCourse}")
	public void deleteCourse(@PathVariable(name = "idCourse") Long idCourse) {
		iCourse.deleteCourse(idCourse);
		
	}


	
}
