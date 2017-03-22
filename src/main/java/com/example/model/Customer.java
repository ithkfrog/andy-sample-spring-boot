package com.example.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

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
    private Long id;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_creation_date")
    private Calendar creationDate;


    protected Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, name='%s']", id, name);
    }
}
