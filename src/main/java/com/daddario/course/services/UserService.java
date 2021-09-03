package com.daddario.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daddario.course.entities.User;
import com.daddario.course.repositories.UserRepository;

/* 
 * Famosa Classe de Negócio (GER -> NEG -> DAD)
 */

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> listAll()
	{
		return repository.findAll();
	}
	
	public User findByID(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
}
