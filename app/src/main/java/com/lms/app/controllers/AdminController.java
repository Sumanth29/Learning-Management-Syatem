package com.lms.app.controllers;

import com.lms.app.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;

@Controller
@RequestMapping("/api/admin/courses")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public ResponseEntity<?> getAllCourses(){
        return adminService.getAllCourses();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id){
        return adminService.getCoursebyId(id);
    }

}
