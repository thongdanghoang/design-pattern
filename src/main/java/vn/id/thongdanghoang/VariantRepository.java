package vn.id.thongdanghoang;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VariantRepository implements PanacheRepository<Variant> {
}
