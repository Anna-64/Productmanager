package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private Product shorts = new Product(1, "Shorts", 1001);
    private Book harryPotter = new Book(12, "HarryPotter", 211, "Дж. Роулинг");
    private Smartphone iphone = new Smartphone(32, "Iphone", 1500, "Apple");
    ProductManager manager = new ProductManager(repository);

    @Test
    void add3Product() {
        manager.add(shorts);
        manager.add(harryPotter);
        manager.add(iphone);

        Product[] actual = repository.findAll();
        Product[] expected = {shorts, harryPotter, iphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2Product() {
        manager.add(shorts);
        manager.add(harryPotter);

        Product[] actual = repository.findAll();
        Product[] expected = {shorts, harryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add1Product() {
        manager.add(harryPotter);

        Product[] actual = repository.findAll();
        Product[] expected = {harryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        manager.add(shorts);
        manager.add(harryPotter);
        manager.add(iphone);


        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {iphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWhenInTheRepoOneProduct() {
        manager.add(shorts);


        Product[] actual = manager.searchBy("Shorts");
        Product[] expected = {shorts};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProductWhichIsNotOnTheList() {
        manager.add(shorts);
        manager.add(harryPotter);
        manager.add(iphone);


        Product[] actual = manager.searchBy("oblaco");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookHarryPotter() {
        manager.add(shorts);
        manager.add(harryPotter);
        manager.add(iphone);


        Product[] actual = manager.searchBy("HarryPotter");
        Product[] expected = {harryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProductWhenTwoItemsMatchTheRequest() {
        Smartphone iphone64Gb = new Smartphone(10, "Iphone4", 15000, "Apple");
        Smartphone iphone128Gb = new Smartphone(20, "Iphone4", 20000, "Apple");
        manager.add(shorts);
        manager.add(harryPotter);
        manager.add(iphone64Gb);
        manager.add(iphone);
        manager.add(iphone128Gb);


        Product[] actual = manager.searchBy("Iphone4");
        Product[] expected = {iphone64Gb, iphone128Gb};

        assertArrayEquals(expected, actual);
    }

}


