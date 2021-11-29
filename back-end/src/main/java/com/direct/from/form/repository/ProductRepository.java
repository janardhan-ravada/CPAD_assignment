package com.direct.from.form.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.direct.from.form.model.Farmer;
import com.direct.from.form.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	public List<Product> findAll();
	
	List<Product> findByFarmer(Farmer farmer);
}
