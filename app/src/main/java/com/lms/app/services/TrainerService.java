package com.lms.app.services;

import com.lms.app.entities.UserEntity;
import com.lms.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> trainerSignUp(UserEntity trainer) {
        UserEntity user = new UserEntity(trainer.getUsername(),trainer.getPassword(),"ROLE_TRAINER");
        userRepository.save(user);
        return new ResponseEntity<>("Trainer Added", HttpStatus.CREATED);
    }

    public ResponseEntity<?> updatePassword(UserEntity trainer) {
        UserEntity existingUser = userRepository.findByUsername(trainer.getUsername());
        if (existingUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        existingUser.setPassword(trainer.getPassword());
        userRepository.save(existingUser);

        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }
}
