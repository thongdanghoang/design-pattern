package vn.id.thongdanghoang.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Category parent;

    @OneToMany(mappedBy = "parent")
    public Set<Category> children = new HashSet<>();
}
