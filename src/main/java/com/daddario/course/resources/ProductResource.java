package com.daddario.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daddario.course.entities.Product;
import com.daddario.course.services.ProductService;

/* 
 * Famosa Classe de APRESENTAÇÃO (GER -> NEG -> DAD)
 */

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){

		List<Product> list = service.listAll();
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
