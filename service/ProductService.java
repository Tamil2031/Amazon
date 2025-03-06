package service;

import model.Product;

public interface ProductService {
    boolean addProduct(Product product);
    void viewProduct();
    boolean updateProduct(int id, String newName, double newPrice);
    boolean deleteProduct(int id);
}
