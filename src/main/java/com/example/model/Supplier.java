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
    private Long id;

    @Column(name = "supp_name")
    private String name;

    @Column(name = "supp_creation_date")
    private String creationDate;

    public Supplier() {
    }

    public Long getSupplierId() {
        return id;
    }

    public void setSupplierId(Long supplierId) {
        this.id = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return String.format("Supplier[id=%d, name='%s']", id, name);
    }
}
