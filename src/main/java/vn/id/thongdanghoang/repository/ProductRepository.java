package vn.id.thongdanghoang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import vn.id.thongdanghoang.model.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}

