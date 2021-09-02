package com.daddario.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daddario.course.entities.Product;
import com.daddario.course.repositories.ProductRepository;

/* 
 * Famosa Classe de Negócio (GER -> NEG -> DAD)
 */

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> listAll()
	{
		return repository.findAll();
	}
	
	public Product findByID(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
