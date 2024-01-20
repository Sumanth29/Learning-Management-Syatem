package com.lms.app.controllers;

import com.lms.app.entities.Student;
import com.lms.app.models.StudentRequestDto;
import com.lms.app.models.StudentResponseDto;
import com.lms.app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id){
        return studentService.getCoursebyId(id);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses(){
        return studentService.getAllCourses();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnrollement(@PathVariable Integer id){
        return studentService.deleteEnrollment(id);
    }

    @PostMapping("/enroll")
    public ResponseEntity<?> postStudent(@RequestBody StudentRequestDto studentDto){
        return studentService.enrollToCourse(studentDto);
    }

    @GetMapping("/enrollments")
    public ResponseEntity<?> getALlEnrollments(){
        return studentService.getAllEnrollments();
    }
}
