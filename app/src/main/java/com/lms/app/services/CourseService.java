package com.lms.app.services;

import com.lms.app.entities.Course;
import com.lms.app.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public ResponseEntity<?> addCourse(Course course){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        course.setTrainerName(auth.getName());
        courseRepository.save(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
