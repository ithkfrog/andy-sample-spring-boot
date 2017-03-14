package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Andy Chau on 14/03/17.
 */
@Entity
@Table(name="ps_supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 2748387217880170337L;

    @Id
    @Column(name = "supp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long supplierId;

    @Column(name = "supp_name")
    private String supplierName;

    protected Supplier() {
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return String.format("Supplier[id=%d, supplierName='%s']", supplierId, supplierName);
    }
}
