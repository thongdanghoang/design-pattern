package vn.id.thongdanghoang;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Variant extends PanacheEntity {
    public String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;
}
