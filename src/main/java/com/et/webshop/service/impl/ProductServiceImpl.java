package com.et.webshop.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.webshop.domain.Product;
import com.et.webshop.domain.repository.ProductRepository;
import com.et.webshop.domain.repository.impl.InMemoryProductRepository;
import com.et.webshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private InMemoryProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.getAllProducts();
	}

	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}

	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	public void addProduct(Product product) {
		productRepository.addProduct(product);		
	}
	
}
