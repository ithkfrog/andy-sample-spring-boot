package com.example.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Andy Chau on 14/03/17.
 */
@Entity
@Table(name="ps_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 2832416744639252618L;

    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @Column(name = "cust_name")
    private String customerName;

    protected Customer() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, customerName='%s']", customerId, customerName);
    }
}
