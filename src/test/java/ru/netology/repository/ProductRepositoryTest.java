package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product shorts = new Product(1, " shorts", 1001);
    private Book harryPotter = new Book(10, "HarryPotter", 511, "Роулинг");
    private Smartphone iphone = new Smartphone(30, "Iphone", 5000, "Apple");

    @Test
    void addProduct() {
        repository.save(shorts);
        repository.save(harryPotter);
        repository.save(iphone);

        Product[] actual = repository.findAll();
        Product[] expected = {shorts, harryPotter, iphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add1Product() {
        ProductRepository repo = new ProductRepository();
        repo.save(shorts);
        repo.save(harryPotter);

        Product[] actual = repo.findAll();
        Product[] expected = {shorts, harryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2Product() {
        repository.save(iphone);

        Product[] actual = repository.findAll();
        Product[] expected = {iphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        Product[] actual = repository.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }


    @Test
    void removeById() {
        repository.save(shorts);
        repository.save(harryPotter);
        repository.save(iphone);

        repository.removeById(10);
        repository.removeById(1);
        repository.removeById(30);

        Product[] actual = repository.findAll();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdOneProduct() {
        repository.save(shorts);
        repository.save(harryPotter);
        repository.save(iphone);

        repository.removeById(30);

        Product[] actual = repository.findAll();
        Product[] expected = {shorts, harryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdNotFound() {
        repository.save(shorts);
        repository.save(harryPotter);
        repository.save(iphone);

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(55));
    }



}