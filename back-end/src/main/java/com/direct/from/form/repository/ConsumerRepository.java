package com.direct.from.form.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.direct.from.form.model.Consumer;
import com.direct.from.form.model.User;

@Repository
public interface ConsumerRepository extends PagingAndSortingRepository<Consumer, Long> {
	
	Consumer findByUser(User user);

}
