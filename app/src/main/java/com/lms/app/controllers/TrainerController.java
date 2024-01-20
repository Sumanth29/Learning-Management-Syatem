package com.lms.app.controllers;


import com.lms.app.entities.UserEntity;
import com.lms.app.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/trainer")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping("/signup")
    public ResponseEntity<?> trainerSignUp(@RequestBody UserEntity trainer){
        return trainerService.trainerSignUp(trainer);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updatePassword(@RequestBody UserEntity trainer){
        return trainerService.updatePassword(trainer);
    }

}
