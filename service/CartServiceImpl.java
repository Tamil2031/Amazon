package service;

import model.Cart;
import model.Product;

import java.util.HashMap;
import java.util.List;

import static service.ProductServiceImpl.productList;
import static service.UserServiceImpl.currentUser;

public class CartServiceImpl implements CartService {
    HashMap<Integer, Cart> cartMap = new HashMap<>();
    private double totalPrice;
    private int count = 0;

    @Override
    public final boolean availableProduct() {

        if (productList.isEmpty()) {
            System.out.println("product is empty");
        }
        List<Product> userProducts = productList.get(currentUser);
            for (Product product : userProducts) {
                System.out.println("product id: " + product.getId() + "| " + "product name: " + product.getName() + "| " + "price: " + product.getPrice());
            }


        return true;
    }

    @Override
    public final boolean addProductToCart( final int productId) {
        if (cartMap.containsKey(productId)) {
            final Cart existingCart = cartMap.get(productId);
            existingCart.setQuantity(existingCart.getQuantity() + 1);
            existingCart.setTotalAmount(existingCart.getQuantity() * existingCart.getProductPrice());
            System.out.println("product quantity:" + existingCart.getQuantity() + ","
                    + "product total price" + existingCart.getTotalAmount());
            return true;
        } else {
            List<Product> userProducts = productList.get(currentUser);
            for (Product product : userProducts) {
                if (product.getId() == productId) {
                    Cart newCart = new Cart(productId, 1, product.getPrice());
                    cartMap.put(productId, newCart);
                    System.out.println(newCart);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean removeCart(final int id){
        if(cartMap.containsKey(id)){
            cartMap.remove(id);
            return true;
        }
        else{
            System.out.println("your product id doesn't match");
        }
       return false;
    }

    public final boolean viewCart(int id){
        if(cartMap.containsKey(id)){
           System.out.println(cartMap.get(id));
        }
        return true;
    }
}