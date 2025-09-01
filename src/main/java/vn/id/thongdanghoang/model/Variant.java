package vn.id.thongdanghoang.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Variant {

    @Id
    @GeneratedValue
    public Long id;

    public String sku;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;
}
