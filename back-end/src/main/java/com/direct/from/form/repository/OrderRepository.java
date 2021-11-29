package com.direct.from.form.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.direct.from.form.model.Consumer;
import com.direct.from.form.model.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

	List<Order> findByConsumerAndStatus(Consumer consumer, String status);

	List<Order> findByConsumerAndStatusNot(Consumer consumer, String status);

}
