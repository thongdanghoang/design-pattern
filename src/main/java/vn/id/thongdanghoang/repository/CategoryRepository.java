package vn.id.thongdanghoang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import vn.id.thongdanghoang.model.Category;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {
}

