package com.stech.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stech.api.model.MstProduct;

public interface ProductRepository extends JpaRepository<MstProduct, Integer>{

	List<MstProduct> getByProductType(String productType);

}
