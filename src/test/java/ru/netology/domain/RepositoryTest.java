package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepo;

public class RepositoryTest {
    ProductRepo repo = new ProductRepo();

    Product product1 = new Product(3, "Книга 1", 120);
    Product product2 = new Product(8, "Книга 2", 110);
    Product product3 = new Product(11, "Книга 3", 115);
    Product product4 = new Product(12, "Книга 4", 120);
    Product product5 = new Product(16, "Книга 5", 95);

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
    }

    @Test
    public void shouldRemoveBiId() {
        repo.removeById(12);

        Product[] expected = {product1, product2, product3, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}