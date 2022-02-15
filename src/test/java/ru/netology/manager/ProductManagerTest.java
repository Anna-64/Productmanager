package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private Product Shorts = new Product(1, "Shorts", 101);
    private Book HarryPotter = new Book(12, "HarryPotter", 211, "Дж. Роулинг");
    private Smartphone Iphone = new Smartphone(35, "Iphone", 1500, "Apple");
    ProductManager manager = new ProductManager(repository);


    @Test
    void add3Product() {
        manager.add(Shorts);
        manager.add(HarryPotter);
        manager.add(Iphone);

        Product[] actual = repository.findAll();
        Product[] expected = {Shorts, HarryPotter, Iphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2Product() {
        manager.add(Shorts);
        manager.add(HarryPotter);

        Product[] actual = repository.findAll();
        Product[] expected = {Shorts, HarryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add1Product() {
        manager.add(HarryPotter);

        Product[] actual = repository.findAll();
        Product[] expected = {HarryPotter};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        manager.add(Shorts);
        manager.add(HarryPotter);
        manager.add(Iphone);


        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {Iphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWhenInTheRepoOneProduct() {
        manager.add(Shorts);


        Product[] actual = manager.searchBy("Shorts");
        Product[] expected = {Shorts};

        assertArrayEquals(expected, actual);
    }

}

