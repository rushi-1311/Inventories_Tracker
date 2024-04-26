package com.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Product;
import com.inventory.repository.ProductRepository;

@Service
public class ProductImpl implements ProductService{

	@Autowired
	ProductRepository prodrepo;
	
	@Override
	public List<Product> findAllProducts() {
		
		return prodrepo.findAll();
	}

//	@Override
//	public Product findByName(String name) {
//		
//		return prodrepo.;
//	}

	@Override
	public Optional<Product> getById(Integer id) {
		
		return prodrepo.findById(id);
	}

	@Override
	public void addProduct(Product prod) {
		prodrepo.save(prod);	
	}

	@Override
	public void deleteProduct(Integer id) {	
		prodrepo.deleteById(id);	
	}

	@Override
	public void updateProduct(Integer id, Product prod) {
		
		Product existing = prodrepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
		if (existing != null)
		{
		// existing.setId(prod.getId());
		 existing.setName(prod.getName());
		 existing.setPrice(prod.getPrice());
		 existing.setQuantity(prod.getQuantity());
		 prodrepo.save(existing);
		}
	}

}
