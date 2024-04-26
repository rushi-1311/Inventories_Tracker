package com.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.inventory.model.Product;

public interface ProductService {

public List<Product> findAllProducts();
//public Product findByName( String name) ;
public Optional<Product> getById (Integer id);
public void addProduct(Product prod);
public void deleteProduct (Integer id);
public void updateProduct (Integer id , Product prod);
}
