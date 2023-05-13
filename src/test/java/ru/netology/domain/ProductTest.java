package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ProductManager;
import ru.netology.repository.ProductRepo;

public class ProductTest {
    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(3, "Книга 1", 120);
    Product product2 = new Product(8, "Книга 2", 110);
    Product product3 = new Product(11, "Книга 3", 115);
    Product product4 = new Product(12, "Книга 4", 120);
    Product product5 = new Product(16, "Книга 5", 95);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void shouldFindAll() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneProduct() {
        manager.add(product4);
        manager.add(product5);

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Книга 4");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMultipleProduct() {
        manager.add(product4);
        manager.add(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenNull() {
        manager.add(product4);
        manager.add(product5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }
}