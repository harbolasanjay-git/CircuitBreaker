package com.stech.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stech.api.model.MstProduct;
import com.stech.api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public void saveProductList(List<MstProduct> productStream){
		repository.saveAll(productStream);
	}

	public List<MstProduct> getAllProducts() {
		return repository.findAll();
	}

	public List<MstProduct> findByProductType(String productType) {
		return repository.getByProductType(productType);
	}

}
