package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;


public class ProductManager {


    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }


//    public Product[] removeByIdProducts(int id) {
//        return repository.removeById(id);
//    }


//    public Product[] findAllProducts() {
//        return repository.findAll();
//    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = {product};
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}







