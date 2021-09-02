package com.daddario.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daddario.course.entities.Order;
import com.daddario.course.repositories.OrderRepository;

/* 
 * Famosa Classe de Negócio (GER -> NEG -> DAD)
 */

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> listAll()
	{
		return repository.findAll();
	}
	
	public Order findByID(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
