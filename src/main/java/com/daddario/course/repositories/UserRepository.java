package com.daddario.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daddario.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
