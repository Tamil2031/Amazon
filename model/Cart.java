package model;

public class Cart {
    private final int cartId;
    private int quantity;
    private double productPrice;
    private double totalAmount;

    public Cart(final int cartId, final int quantity, final double productPrice) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalAmount = totalAmount;
    }

    public final int getCartId() {
        return cartId;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final double getProductPrice() {
        return productPrice;
    }

    public final void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public final double getTotalAmount() {
        return totalAmount = quantity * productPrice;
    }

    public final void setProductPrice(final double productPrice) {
        this.productPrice = productPrice;
    }

    public final void setTotalAmount(final double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public final String toString(){
       return String.format("product id: %s | quantity: %d | product price: %f | product total Amount %f",
               getCartId(), getQuantity(), getProductPrice(), getTotalAmount());
    }
}