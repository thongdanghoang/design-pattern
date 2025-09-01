package vn.id.thongdanghoang.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Category {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "parent_id")
    public Category parent;
}
