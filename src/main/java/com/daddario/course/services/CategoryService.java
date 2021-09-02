package com.daddario.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daddario.course.entities.Category;
import com.daddario.course.repositories.CategoryRepository;

/* 
 * Famosa Classe de Negócio (GER -> NEG -> DAD)
 */

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> listAll()
	{
		return repository.findAll();
	}
	
	public Category findByID(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
