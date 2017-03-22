package com.example.presistence;

import com.example.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Andy Chau on 14/03/17.
 */
public interface CustomerCrudRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    Customer findById(Long id);
}
