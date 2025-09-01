package vn.id.thongdanghoang;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category extends PanacheEntity {
    public String name;

    @ManyToMany(mappedBy = "categories")
    public Set<Product> products = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "parent_id")
    public Category parent;
}
