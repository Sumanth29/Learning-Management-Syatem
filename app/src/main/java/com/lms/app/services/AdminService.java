package com.lms.app.services;

import com.lms.app.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class AdminService {

    @Autowired
    CourseRepository courseRepository;


    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<?> getCoursebyId(Integer id){
        if(courseRepository.existsById(id))
            return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);

        return new ResponseEntity<>("Course Not Found",HttpStatus.BAD_REQUEST);
    }
}
