package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    int matches;

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) { this.repository = repository; }

    public void add(Product product) {repository.save(product);}

    public void removeById(int id){ repository.removeById(id);}

//    public Product[] getAll(){
//        Product[] items = repository.findAll();
//        Product[] result = new Product[items.length];
//        for (int i = 0; i < result.length; i++){
//            int index = items.length - i -1;
//            result[i] = items[index];
//        }
//    return result;
//    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                int index = items.length - i -1;
                result[i] = items[index];
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
        // или в одну строку:
        // return product.getName().contains(search);
    }
}


