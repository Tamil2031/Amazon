package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static service.UserServiceImpl.currentUser;

public class ProductServiceImpl implements ProductService {
    public static final Map <String, List<Product>> productList = new HashMap<>();


    public boolean addProduct(Product product) {
            productList.putIfAbsent(currentUser, new ArrayList<>());
        productList.get(currentUser).add(product);
        System.out.println("product added successfully");
        return true;
    }

    @Override
    public void viewProduct() {
        List<Product> userProducts = productList.get(currentUser);
        if(userProducts == null || userProducts.isEmpty()){
            System.out.println("no product found for this user");
        }
        else {
             for(Product product : userProducts){
                 System.out.println(product);
             }
            }
    }

    public boolean updateProduct(final int id, final String newName, final double newPrice) {
        List<Product> userProducts = productList.get(currentUser);
        if(userProducts == null || userProducts.isEmpty()){
            System.out.println("no product found for this user");
            return false;
        }

        for (Product products : userProducts) {
            if (products.getId() == id) {
                products.setName(newName);
                products.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(final int id) {
        if(currentUser == null){
            System.out.println("you must signIn to delete product");
            return false;
        }
        List<Product> userProducts = productList.get(currentUser);

        for (final Product product : userProducts ) {
            if (product.getId() == id) {
                userProducts.remove(product);
                productList.put(currentUser,userProducts);
                return true;
            }
        }
        return false;
    }
}
