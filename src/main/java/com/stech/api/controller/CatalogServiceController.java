package com.stech.api.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stech.api.model.MstProduct;
import com.stech.api.service.ProductService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/order")
public class CatalogServiceController {
	
	@Autowired
	ProductService productService;
	
	@PostConstruct
	public void initProductTable() {
	productService.saveProductList(Stream.of(
			new MstProduct(101,"LED TV", "Electronics",48000.5),
			new MstProduct(102,"Refigarator", "Electronics",25000),
			new MstProduct(103,"Mobile Phone", "Electronics",18000),
			new MstProduct(104,"Sports Shoes", "Foot wear",4500),
			new MstProduct(105,"ParleG", "Confectionary",25),
			new MstProduct(106,"Alpenlibe", "Confectionary",95),
			new MstProduct(107,"Nike Sliper", "Foot wear",500)
			).collect(Collectors.toList()));
	}
	
	@GetMapping
	public List<MstProduct> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productType}")
	public List<MstProduct> getProductByCategory(@PathVariable("productType") String productType) {
		return productService.findByProductType(productType);
	}
}
