package com.dk.user.service.UserService.repository;

import com.dk.user.service.UserService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {}
