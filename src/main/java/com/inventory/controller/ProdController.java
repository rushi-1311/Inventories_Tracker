package com.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Product;
import com.inventory.services.ProductService;

@RestController
@SuppressWarnings( value = {"unchecked", "rawtypes"})
public class ProdController {
	@Autowired
	ProductService prodserv;

	
	@GetMapping ("/products")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List products = prodserv.findAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping ("/product/{id}")
	public ResponseEntity getProductById(@PathVariable Integer id)
	{
		Optional prod = prodserv.getById(id);
		if (prod.isPresent()) {
		    return new ResponseEntity (prod, HttpStatus.OK);
		} else {
		    return new ResponseEntity (HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping("/addproducts")
	public ResponseEntity addProducts(@RequestBody Product prod)
	{
		prodserv.addProduct(prod);
		return new ResponseEntity<Product> (HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delprod")
	public ResponseEntity deleteProduct(@PathVariable Integer id)
	{
		prodserv.deleteProduct(id);
		return new ResponseEntity (HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity updateProducts(@PathVariable Integer id , @RequestBody Product prod)
	{
		Optional product =prodserv.getById(id);
		if (product.isPresent())
		{
			prodserv.updateProduct(id, prod);
			return new ResponseEntity (HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity (HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
