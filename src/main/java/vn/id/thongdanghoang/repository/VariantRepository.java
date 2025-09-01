package vn.id.thongdanghoang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import vn.id.thongdanghoang.model.Variant;

@ApplicationScoped
public class VariantRepository implements PanacheRepository<Variant> {
}

