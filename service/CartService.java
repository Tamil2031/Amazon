package service;

public interface CartService {
     boolean  availableProduct();
     boolean addProductToCart( final int id);
     boolean viewCart(int id);

}