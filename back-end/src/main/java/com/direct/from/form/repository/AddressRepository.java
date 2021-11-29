package com.direct.from.form.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.direct.from.form.model.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
