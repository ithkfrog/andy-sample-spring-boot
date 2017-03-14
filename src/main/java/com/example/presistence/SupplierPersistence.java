package com.example.presistence;

import com.example.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Andy Chau on 14/03/17.
 */
public interface SupplierPersistence extends CrudRepository<Supplier, Long> {

    List<Supplier> findAll();

    List<Supplier> findBySupplierNameContainsAllIgnoreCase(String supplierName);

    Supplier findBySupplierId(Long supplierId);
}
