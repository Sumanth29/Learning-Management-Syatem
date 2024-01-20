package com.lms.app.repositories;

import com.lms.app.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("select s from UserEntity s where s.username = ?1")
    UserEntity findByUsername(String username);
}
