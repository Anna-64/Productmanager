package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book coreJava = new Book(1, "core", 200, "first");
    private Book master = new Book(2, "master", 3000, "first");
    private Book fang = new Book(3, "fang", 5050, "three");
    private Smartphone one = new Smartphone(1, "one", 5000, "phone");

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava); //сохраняем книгу

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();//запросим все продукты в репозитории, и вернется массив и внутри будет книга
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSaveOneItem1() {

        repository.save(master);

        Product[] expected = new Product[]{master};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem2() {

        repository.save(one);

        Product[] expected = new Product[]{one};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem3() {

        repository.save(fang);

        Product[] expected = new Product[]{fang};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindAllItems() {

        repository.save(coreJava);
        repository.save(master);
        repository.save(one);
        repository.save(fang);

        Product[] expected = new Product[]{coreJava, master, one, fang};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString() {

        repository.save(coreJava);
        repository.save(master);
        repository.save(one);
        repository.save(fang);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.searchBy("core");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString2() {

        repository.save(coreJava);
        repository.save(master);
        repository.save(one);
        repository.save(fang);

        Product[] expected = new Product[]{one};
        Product[] actual = manager.searchBy("one");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString3() {

        repository.save(coreJava);
        repository.save(master);
        repository.save(one);
        repository.save(fang);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("two");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString4() {

        repository.save(coreJava);
        repository.save(master);
        repository.save(one);
        repository.save(fang);

        Product[] expected = new Product[]{fang};
        Product[] actual = manager.searchBy("fang");

        assertArrayEquals(expected, actual);
    }
}

