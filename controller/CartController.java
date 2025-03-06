package controller;

import service.*;

public class CartController {
    private static CartService service = new CartServiceImpl();
    private static final Payment payment = new PaypalPayment();
    private static final Payment deliveryPayment = new CashOnDelivery();

    public boolean availableProduct(){
        return service.availableProduct();
    }

    public boolean addProductToCart(final int id){
        return service.addProductToCart(id);
    }

    public boolean checkPayment(){
       return payment.calculateTotalAmount();
    }

    public void makePayment(){
        deliveryPayment.calculateTotalAmount();
    }

    public boolean viewCart(int id){
        return service.viewCart(id);
    }
}