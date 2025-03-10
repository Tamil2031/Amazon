package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

public final class ProductController {
    private static final ProductService service = new ProductServiceImpl();

    public boolean addProduct(Product product){
        return service.addProduct(product);
    }

    public boolean updateProduct(final int id, final String newName, final double newPrice){
        return service.updateProduct(id, newName,newPrice);
    }

    public boolean deleteProduct(final int id){
        return service.deleteProduct(id);
    }

    public void viewProduct(){
        service.viewProduct();
    }
}
