package com.direct.from.form.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.direct.from.form.model.Farmer;
import com.direct.from.form.model.User;

@Repository
public interface FarmerRepository extends PagingAndSortingRepository<Farmer, Long> {

	Farmer findByUser(User user);

}
