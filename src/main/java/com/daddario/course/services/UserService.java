package com.daddario.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.daddario.course.entities.User;
import com.daddario.course.repositories.UserRepository;
import com.daddario.course.services.exceptions.DatabaseException;
import com.daddario.course.services.exceptions.ResourceNotFoundException;

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
		Optional<User> obj = repository.findById(id); // vai no banco e traz o objeto
		/* return obj.get();	// .get dá erro padrão */
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {		//RuntimeException é a mais generica e dá pra descobrir outras
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		
		// getById prepara o objeto monitorado pra vc mexer e depois fazer algo no banco
		
		try {
			User entity = repository.getById(id);
			updateData(entity,obj);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}
	
}
