package com.daddario.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daddario.course.entities.User;

/* 
 * Famosa Classe de Dados (GER -> NEG -> DAD)
 */

@Repository // não é necessário porque já esta herdando do JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
