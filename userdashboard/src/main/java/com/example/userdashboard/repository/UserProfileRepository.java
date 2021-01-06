package com.example.userdashboard.repository;

import com.example.userdashboard.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserId(int userId);
}

