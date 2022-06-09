package com.courzelo.espace_formateur.course.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.courzelo.espace_formateur.course.entities.Course;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
	
}
