package vn.id.thongdanghoang;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

@QuarkusTest
public class ProductPersistenceTest {

    @Test
    @Transactional
    void persistProductVariantAndCategory() {
        Category category = new Category();
        category.name = "Electronics";
        category.persist();

        Product product = new Product();
        product.name = "Phone";
        product.categories = new HashSet<>();
        product.categories.add(category);
        product.persist();

        Variant variant = new Variant();
        variant.name = "Phone 64GB";
        variant.product = product;
        variant.persist();

        assertEquals(1, Product.count());
        assertEquals(1, Variant.count());
        assertEquals(1, Category.count());
    }
}
