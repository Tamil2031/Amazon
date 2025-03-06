package service;


public class CashOnDelivery implements Payment {
    private static final CartService service = new CartServiceImpl();



    @Override
    public boolean calculateTotalAmount() {

        System.out.println("your should pay ");
        return true;
    }
}
