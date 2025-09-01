package vn.id.thongdanghoang.model;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import vn.id.thongdanghoang.repository.CategoryRepository;
import vn.id.thongdanghoang.repository.ProductRepository;
import vn.id.thongdanghoang.repository.VariantRepository;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ProductEntityTest {

    @Inject
    ProductRepository productRepository;

    @Inject
    VariantRepository variantRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Test
    @Transactional
    void testProductMappings() {
        long initialProductCount = productRepository.count();
        long initialVariantCount = variantRepository.count();
        long initialCategoryCount = categoryRepository.count();

        Category parent = new Category();
        parent.name = "Electronics";
        categoryRepository.persist(parent);

        Category child = new Category();
        child.name = "Phones";
        child.parent = parent;
        parent.children.add(child);
        categoryRepository.persist(child);

        Product product = new Product();
        product.name = "Phone";
        product.categories.add(child);

        Variant variant = new Variant();
        variant.sku = "PHONE-BLACK";
        variant.product = product;
        product.variants.add(variant);

        productRepository.persist(product);

        assertEquals(initialProductCount + 1, productRepository.count());
        assertEquals(initialVariantCount + 1, variantRepository.count());
        assertEquals(initialCategoryCount + 2, categoryRepository.count());

        Product persisted = productRepository.findById(product.id);
        assertNotNull(persisted);
        assertEquals(1, persisted.categories.size());
        assertEquals(1, persisted.variants.size());

        Category persistedChild = categoryRepository.findById(child.id);
        assertEquals(parent.id, persistedChild.parent.id);

        Category persistedParent = categoryRepository.findById(parent.id);
        assertEquals(1, persistedParent.children.size());
    }
}
